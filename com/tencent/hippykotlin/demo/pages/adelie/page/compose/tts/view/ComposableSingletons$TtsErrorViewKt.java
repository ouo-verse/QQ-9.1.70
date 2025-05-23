package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$TtsErrorViewKt {
    public static final ComposableSingletons$TtsErrorViewKt INSTANCE = new ComposableSingletons$TtsErrorViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f20lambda1 = ComposableLambdaKt.composableLambdaInstance(1314599153, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsErrorViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314599153, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsErrorViewKt.lambda-1.<anonymous> (TtsErrorView.kt:71)");
                }
                TextKt.a("\u91cd\u65b0\u52a0\u8f7d", null, null, QUIToken.color$default("button_text_primary_default"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601542, 48, 0, 134215590);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
