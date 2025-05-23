package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class ComposableSingletons$QUIDatePickerKt {
    public static final ComposableSingletons$QUIDatePickerKt INSTANCE = new ComposableSingletons$QUIDatePickerKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f29lambda1 = ComposableLambdaKt.composableLambdaInstance(-1621412311, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ComposableSingletons$QUIDatePickerKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1621412311, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ComposableSingletons$QUIDatePickerKt.lambda-1.<anonymous> (QUIDatePicker.kt:219)");
                }
                TextKt.a("\u53d6\u6d88", null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601542, 48, 0, 134215590);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f30lambda2 = ComposableLambdaKt.composableLambdaInstance(-56202350, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ComposableSingletons$QUIDatePickerKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-56202350, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ComposableSingletons$QUIDatePickerKt.lambda-2.<anonymous> (QUIDatePicker.kt:250)");
                }
                TextKt.a("\u786e\u8ba4", null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601542, 48, 0, 134215590);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
