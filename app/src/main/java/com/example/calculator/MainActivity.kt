package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(children: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.White) {
            children()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = LayoutPadding(24.dp))
}

@Composable
fun MyScreenContent(
    names: List<String> = listOf("Android", "demo"),
    counterState: CounterState = CounterState(),
    formState: FormState = FormState(false)
) {
    Column {
        Row {
            Greeting(name = "kyle")
            Greeting(name = "kyle row 2")
        }
        Divider(color = Color.Black)
        Greeting(name = "there")

        Divider(color = Color.Black)
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, height = 32.dp)
        Counter(counterState)
        Form(formState)
    }
}

@Composable
fun Counter(state: CounterState) {
    Button(onClick = { state.count += 1 }) {
        Text("I've been clicked ${state.count} times")
    }
}

@Model
class CounterState(var count: Int = 0) {

}

@Preview("MyScreen Preview")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}

@Model
class FormState(var optionChecked: Boolean)

@Composable
fun Form(formState: FormState) {
    Checkbox(
        checked = formState.optionChecked,
        onCheckedChange = { newState -> formState.optionChecked = newState })
}