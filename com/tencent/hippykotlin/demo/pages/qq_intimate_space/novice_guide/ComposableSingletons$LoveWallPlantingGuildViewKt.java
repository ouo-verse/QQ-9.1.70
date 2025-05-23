package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallPlantingGuildViewKt {
    public static final ComposableSingletons$LoveWallPlantingGuildViewKt INSTANCE = new ComposableSingletons$LoveWallPlantingGuildViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f111lambda1 = ComposableLambdaKt.composableLambdaInstance(-836440456, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.ComposableSingletons$LoveWallPlantingGuildViewKt$lambda-1$1
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
                    ComposerKt.traceEventStart(-836440456, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.ComposableSingletons$LoveWallPlantingGuildViewKt.lambda-1.<anonymous> (LoveWallPlantingGuildView.kt:132)");
                }
                ImageKt.a(null, null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, (float) 202.39d, (float) 99.07d), Alignment.Center), null, h.INSTANCE.c(), null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_t_ad-Exd6qr.png", null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 6, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f112lambda2 = ComposableLambdaKt.composableLambdaInstance(-931013195, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.ComposableSingletons$LoveWallPlantingGuildViewKt$lambda-2$1
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
                    ComposerKt.traceEventStart(-931013195, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.ComposableSingletons$LoveWallPlantingGuildViewKt.lambda-2.<anonymous> (LoveWallPlantingGuildView.kt:167)");
                }
                i.Companion companion = i.INSTANCE;
                i v3 = ComposeLayoutPropUpdaterKt.v(companion, 210, 59);
                Alignment alignment = Alignment.TopCenter;
                APNGKt.a(bVar2.a(v3, alignment), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_9qj1TmwGs42.png", 0, null, null, null, null, composer2, 3464, 242);
                APNGKt.a(ComposeLayoutPropUpdaterKt.o(bVar2.a(ComposeLayoutPropUpdaterKt.v(companion, (float) 118.81d, 120), alignment), 70, 8), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_mSbOXa9EB79.png", 0, null, null, null, null, composer2, 3464, 242);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
