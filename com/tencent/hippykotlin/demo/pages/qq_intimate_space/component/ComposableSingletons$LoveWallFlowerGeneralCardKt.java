package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallFlowerGeneralCardKt {
    public static final ComposableSingletons$LoveWallFlowerGeneralCardKt INSTANCE = new ComposableSingletons$LoveWallFlowerGeneralCardKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f97lambda1 = ComposableLambdaKt.composableLambdaInstance(1809463761, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.ComposableSingletons$LoveWallFlowerGeneralCardKt$lambda-1$1
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
                    ComposerKt.traceEventStart(1809463761, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.ComposableSingletons$LoveWallFlowerGeneralCardKt.lambda-1.<anonymous> (LoveWallFlowerGeneralCard.kt:100)");
                }
                i.Companion companion = i.INSTANCE;
                float f16 = 30;
                i u16 = ComposeLayoutPropUpdaterKt.u(companion, f16);
                Alignment alignment = Alignment.TopEnd;
                float f17 = -15;
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.o(bVar2.a(u16, alignment), f17, f17), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_9lCd5slcpLN.png", null, null, null, null, null, null, null, null, null, null, composer2, 262144, 6, 0, 2096095);
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.p(bVar2.a(ComposeLayoutPropUpdaterKt.u(companion, 19.13f), alignment), 0.0f, 20, 1, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_dx9G8uuLk0i.png", null, null, null, null, null, null, null, null, null, null, composer2, 262144, 6, 0, 2096095);
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.o(bVar2.a(ComposeLayoutPropUpdaterKt.u(companion, f16), Alignment.BottomStart), f17, 15), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_dx9G8uuLk0i.png", null, null, null, null, null, null, null, null, null, null, composer2, 262144, 6, 0, 2096095);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
