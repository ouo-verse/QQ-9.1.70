package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$BottomViewKt {
    public static final ComposableSingletons$BottomViewKt INSTANCE = new ComposableSingletons$BottomViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f64lambda1 = ComposableLambdaKt.composableLambdaInstance(-2020358436, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$BottomViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2020358436, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$BottomViewKt.lambda-1.<anonymous> (BottomView.kt:141)");
                }
                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_3Qzi6BEu1qd.png", null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 28.0f), 28.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, new h(4281282611L), null, composer2, 262150, 1073741824, 0, 1572830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f65lambda2 = ComposableLambdaKt.composableLambdaInstance(-613791326, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$BottomViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-613791326, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$BottomViewKt.lambda-2.<anonymous> (BottomView.kt:135)");
                }
                BoxKt.a(ModifiersKt.c(ModifiersKt.p(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 56.0f), 56.0f), 56.0f), new g(0.0f, 2.0f, 16.0f, new h(0L, 0.08f))), new h(3439329279L)), Alignment.Center, null, ComposableSingletons$BottomViewKt.f64lambda1, composer2, 3128, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
