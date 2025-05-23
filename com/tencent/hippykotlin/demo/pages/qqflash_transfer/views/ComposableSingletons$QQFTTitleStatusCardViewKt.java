package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.foundation.layout.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFTTitleStatusCardViewKt {
    public static final ComposableSingletons$QQFTTitleStatusCardViewKt INSTANCE = new ComposableSingletons$QQFTTitleStatusCardViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f145lambda1 = ComposableLambdaKt.composableLambdaInstance(1215975719, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTTitleStatusCardViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1215975719, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTTitleStatusCardViewKt.lambda-1.<anonymous> (QQFTTitleStatusCardView.kt:56)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f146lambda2 = ComposableLambdaKt.composableLambdaInstance(-45792112, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTTitleStatusCardViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-45792112, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTTitleStatusCardViewKt.lambda-2.<anonymous> (QQFTTitleStatusCardView.kt:61)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
