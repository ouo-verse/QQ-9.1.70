package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$ShootGuideTipViewKt {
    public static final ComposableSingletons$ShootGuideTipViewKt INSTANCE = new ComposableSingletons$ShootGuideTipViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f81lambda1 = ComposableLambdaKt.composableLambdaInstance(1228874573, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ComposableSingletons$ShootGuideTipViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1228874573, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ComposableSingletons$ShootGuideTipViewKt.lambda-1.<anonymous> (ShootGuideTipView.kt:33)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f82lambda2 = ComposableLambdaKt.composableLambdaInstance(180661651, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ComposableSingletons$ShootGuideTipViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(180661651, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ComposableSingletons$ShootGuideTipViewKt.lambda-2.<anonymous> (ShootGuideTipView.kt:31)");
                }
                BoxKt.a(ComposeLayoutPropUpdaterKt.p(ModifiersKt.G(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 8.0f), h.INSTANCE.a(0.7f)), 45.0f, null, 2, null), 0.0f, -4.0f, 1, null), null, null, ComposableSingletons$ShootGuideTipViewKt.f81lambda1, composer2, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
