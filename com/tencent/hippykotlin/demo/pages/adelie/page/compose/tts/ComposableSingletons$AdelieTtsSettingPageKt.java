package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class ComposableSingletons$AdelieTtsSettingPageKt {
    public static final ComposableSingletons$AdelieTtsSettingPageKt INSTANCE = new ComposableSingletons$AdelieTtsSettingPageKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f16lambda1 = ComposableLambdaKt.composableLambdaInstance(-252021624, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.ComposableSingletons$AdelieTtsSettingPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-252021624, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.ComposableSingletons$AdelieTtsSettingPageKt.lambda-1.<anonymous> (AdelieTtsSettingPage.kt:340)");
                }
                TextKt.a("\u521b\u5efa\u6211\u7684\u58f0\u97f3", null, null, QUIToken.color$default("button_text_primary_default"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601542, 48, 0, 134215590);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f17lambda2 = ComposableLambdaKt.composableLambdaInstance(102862776, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.ComposableSingletons$AdelieTtsSettingPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(102862776, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.ComposableSingletons$AdelieTtsSettingPageKt.lambda-2.<anonymous> (AdelieTtsSettingPage.kt:368)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
