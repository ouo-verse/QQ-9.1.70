package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.foundation.layout.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFTDownloadBarViewKt {
    public static final ComposableSingletons$QQFTDownloadBarViewKt INSTANCE = new ComposableSingletons$QQFTDownloadBarViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f126lambda1 = ComposableLambdaKt.composableLambdaInstance(723115036, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTDownloadBarViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(723115036, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTDownloadBarViewKt.lambda-1.<anonymous> (QQFTDownloadBarView.kt:577)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
