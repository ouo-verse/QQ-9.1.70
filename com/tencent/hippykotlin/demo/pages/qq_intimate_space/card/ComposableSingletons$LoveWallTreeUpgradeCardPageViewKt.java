package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.APNGKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallTreeUpgradeCardPageViewKt {
    public static final ComposableSingletons$LoveWallTreeUpgradeCardPageViewKt INSTANCE = new ComposableSingletons$LoveWallTreeUpgradeCardPageViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f96lambda1 = ComposableLambdaKt.composableLambdaInstance(-469348199, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.ComposableSingletons$LoveWallTreeUpgradeCardPageViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            int i3;
            b bVar2 = bVar;
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 14) == 0) {
                i3 = (composer2.changed(bVar2) ? 4 : 2) | intValue;
            } else {
                i3 = intValue;
            }
            if ((i3 & 91) == 18 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-469348199, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.ComposableSingletons$LoveWallTreeUpgradeCardPageViewKt.lambda-1.<anonymous> (LoveWallTreeUpgradeCardPageView.kt:59)");
                }
                APNGKt.a(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), (com.tencent.ntcompose.activity.b.a().getPageData().m() * 407.0f) / 188.0f), Alignment.Center), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_5cAgmr-WmMg.png", 0, null, null, null, null, composer2, 3464, 242);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
