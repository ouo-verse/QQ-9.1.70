package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import yo3.Offset;
import zo3.Shadow;

/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallFlowerCardPageViewKt {
    public static final ComposableSingletons$LoveWallFlowerCardPageViewKt INSTANCE = new ComposableSingletons$LoveWallFlowerCardPageViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f95lambda1 = ComposableLambdaKt.composableLambdaInstance(-833133224, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.ComposableSingletons$LoveWallFlowerCardPageViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-833133224, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.ComposableSingletons$LoveWallFlowerCardPageViewKt.lambda-1.<anonymous> (LoveWallFlowerCardPageView.kt:72)");
                }
                TextKt.a("\u606d\u559c\u89e3\u9501\u65b0\u679c\u5b9e", ModifiersKt.e(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 34), Direction.TO_RIGHT, new j(new h(4294967295L), -0.0048f), new j(new h(4294966249L), 0.4901f), new j(new h(4294967295L), 0.9849f)), null, null, Float.valueOf(28.0f), null, null, new com.tencent.ntcompose.material.n("MFYuanHei"), null, null, null, null, null, null, null, new Shadow(new h(255, 217, 0, 0.5f), new Offset(1.69f, 1.12f), 4.74f), null, null, null, null, null, null, null, null, null, null, false, composer2, (com.tencent.ntcompose.material.n.f339436b << 21) | 24646, 0, 0, 134184812);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
