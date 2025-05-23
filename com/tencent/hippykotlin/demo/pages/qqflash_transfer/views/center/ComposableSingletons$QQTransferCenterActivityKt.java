package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.views.FooterRefreshState;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQTransferCenterActivityKt {
    public static final ComposableSingletons$QQTransferCenterActivityKt INSTANCE = new ComposableSingletons$QQTransferCenterActivityKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<FooterRefreshState, Composer, Integer, Unit> f156lambda1 = ComposableLambdaKt.composableLambdaInstance(64403521, false, new Function3<FooterRefreshState, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQTransferCenterActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(FooterRefreshState footerRefreshState, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(64403521, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQTransferCenterActivityKt.lambda-1.<anonymous> (QQTransferCenterActivity.kt:199)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
