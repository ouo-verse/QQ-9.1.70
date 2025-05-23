package com.tencent.hippykotlin.demo.pages.nearby.follower_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class ComposableSingletons$NBPFollowerListKt {
    public static final ComposableSingletons$NBPFollowerListKt INSTANCE = new ComposableSingletons$NBPFollowerListKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f42lambda1 = ComposableLambdaKt.composableLambdaInstance(-1547236228, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerListKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1547236228, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerListKt.lambda-1.<anonymous> (NBPFollowerList.kt:90)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f43lambda2 = ComposableLambdaKt.composableLambdaInstance(-751449005, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerListKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-751449005, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerListKt.lambda-2.<anonymous> (NBPFollowerList.kt:199)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
