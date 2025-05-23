package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.t;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$NavBarViewKt {
    public static final ComposableSingletons$NavBarViewKt INSTANCE = new ComposableSingletons$NavBarViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f68lambda1 = ComposableLambdaKt.composableLambdaInstance(-1090396361, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$NavBarViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1090396361, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$NavBarViewKt.lambda-1.<anonymous> (NavBarView.kt:81)");
                }
                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_A3FMftjB0nK.png", null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 20.0f), 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, new h(4281282611L), null, composer2, 262150, 1073741824, 0, 1572830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f69lambda2 = ComposableLambdaKt.composableLambdaInstance(-518429025, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$NavBarViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-518429025, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$NavBarViewKt.lambda-2.<anonymous> (NavBarView.kt:193)");
                }
                float sqrt = (float) (11 / Math.sqrt(2.0d));
                BoxKt.a(ModifiersKt.O(ComposeLayoutPropUpdaterKt.o(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, sqrt), sqrt), QUIToken.color$default("bg_top_dark")), 2.0f, 8.0f), new t(45.0f, 0.0f, 0.0f, 6, null), null, null, null, null, 30, null), null, null, null, composer2, 8, 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f70lambda3 = ComposableLambdaKt.composableLambdaInstance(-1479041720, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$NavBarViewKt$lambda-3$1
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
                    ComposerKt.traceEventStart(-1479041720, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$NavBarViewKt.lambda-3.<anonymous> (NavBarView.kt:210)");
                }
                TextKt.a("\u9080\u8bf7\u597d\u53cb\u5f3a\u52bf\u56f4\u89c2", ComposeLayoutPropUpdaterKt.q(bVar2.a(i.INSTANCE, Alignment.Center), 4.0f), null, h.INSTANCE.m(), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601606, 0, 0, 134217636);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
