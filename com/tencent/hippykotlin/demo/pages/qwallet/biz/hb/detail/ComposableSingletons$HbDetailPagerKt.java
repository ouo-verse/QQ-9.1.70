package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes33.dex */
public final class ComposableSingletons$HbDetailPagerKt {
    public static final ComposableSingletons$HbDetailPagerKt INSTANCE = new ComposableSingletons$HbDetailPagerKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f158lambda1 = ComposableLambdaKt.composableLambdaInstance(-1365235246, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.ComposableSingletons$HbDetailPagerKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1365235246, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.ComposableSingletons$HbDetailPagerKt.lambda-1.<anonymous> (HbDetailPager.kt:34)");
                }
                HbDetailLayoutKt.HbDetailLayout(null, composer2, 0, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
