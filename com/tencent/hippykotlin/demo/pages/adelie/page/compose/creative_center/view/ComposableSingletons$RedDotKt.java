package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$RedDotKt {
    public static final ComposableSingletons$RedDotKt INSTANCE = new ComposableSingletons$RedDotKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f8lambda1 = ComposableLambdaKt.composableLambdaInstance(910978453, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ComposableSingletons$RedDotKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(910978453, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ComposableSingletons$RedDotKt.lambda-1.<anonymous> (RedDot.kt:20)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
