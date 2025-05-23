package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFTNavBarKt {
    public static final ComposableSingletons$QQFTNavBarKt INSTANCE = new ComposableSingletons$QQFTNavBarKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f144lambda1 = ComposableLambdaKt.composableLambdaInstance(-2065438333, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTNavBarKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2065438333, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTNavBarKt.lambda-1.<anonymous> (QQFTNavBar.kt:239)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
