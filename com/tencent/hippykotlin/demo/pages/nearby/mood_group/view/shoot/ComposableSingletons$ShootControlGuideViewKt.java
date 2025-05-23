package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$ShootControlGuideViewKt {
    public static final ComposableSingletons$ShootControlGuideViewKt INSTANCE = new ComposableSingletons$ShootControlGuideViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f80lambda1 = ComposableLambdaKt.composableLambdaInstance(-499457012, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ComposableSingletons$ShootControlGuideViewKt$lambda-1$1
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
                    ComposerKt.traceEventStart(-499457012, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ComposableSingletons$ShootControlGuideViewKt.lambda-1.<anonymous> (ShootControlGuideView.kt:27)");
                }
                i.Companion companion = i.INSTANCE;
                Alignment alignment = Alignment.TopCenter;
                i v3 = ComposeLayoutPropUpdaterKt.v(ComposeLayoutPropUpdaterKt.p(bVar2.a(companion, alignment), 0.0f, 47.5f, 1, null), 155.59f, 30.79f);
                h.Companion companion2 = h.INSTANCE;
                ImageKt.a("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/s6g3wOVJ.png", null, null, null, null, v3, null, companion2.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer2, 12845062, 0, 0, 2096990);
                ImageKt.a("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/ugMJnFzg.png", null, null, null, null, ComposeLayoutPropUpdaterKt.v(ComposeLayoutPropUpdaterKt.p(bVar2.a(companion, alignment), 0.0f, 68.25f, 1, null), 308.0f, 242.7373f), null, companion2.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer2, 12845062, 0, 0, 2096990);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
