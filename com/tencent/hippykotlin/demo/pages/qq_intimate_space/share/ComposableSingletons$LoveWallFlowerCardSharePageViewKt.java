package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallFlowerCardSharePageViewKt {
    public static final ComposableSingletons$LoveWallFlowerCardSharePageViewKt INSTANCE = new ComposableSingletons$LoveWallFlowerCardSharePageViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f113lambda1 = ComposableLambdaKt.composableLambdaInstance(-807378708, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ComposableSingletons$LoveWallFlowerCardSharePageViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-807378708, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ComposableSingletons$LoveWallFlowerCardSharePageViewKt.lambda-1.<anonymous> (LoveWallFlowerCardSharePageView.kt:138)");
                }
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 95.19f, 14), (float) 12.81d, 12.0f, 0.0f, 0.0f, 12, null), null, h.INSTANCE.c(), null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_RfjyLjzaeyK.png", null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 6, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
