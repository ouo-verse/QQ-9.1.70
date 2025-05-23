package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ComposableSingletons$HbDetailHeaderItemKt {
    public static final ComposableSingletons$HbDetailHeaderItemKt INSTANCE = new ComposableSingletons$HbDetailHeaderItemKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f159lambda1 = ComposableLambdaKt.composableLambdaInstance(-1047852203, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.ComposableSingletons$HbDetailHeaderItemKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1047852203, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.ComposableSingletons$HbDetailHeaderItemKt.lambda-1.<anonymous> (HbDetailHeaderItem.kt:204)");
                }
                i.Companion companion = i.INSTANCE;
                TextKt.a("\u6536\u5230\u7684\u7ea2\u5305\u5df2\u5b58\u5165\u4f59\u989d", ComposeLayoutPropUpdaterKt.A(companion), null, new h(4292057401L), Float.valueOf(16.0f), null, null, null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 28742, 0, 0, 134216676);
                ImageKt.a("https://kuikly.qianbao.qq.com/hb/detail//qwallet_hb_receive_hint_arrow.png", null, null, null, null, ModifiersKt.r(ComposeLayoutPropUpdaterKt.u(companion, 16.0f), true), null, com.tencent.ntcompose.material.h.INSTANCE.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer2, 12845062, 0, 0, 2096990);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
