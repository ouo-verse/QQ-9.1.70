package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ActivityIndicatorKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$ShootResultShareViewKt {
    public static final ComposableSingletons$ShootResultShareViewKt INSTANCE = new ComposableSingletons$ShootResultShareViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f75lambda1 = ComposableLambdaKt.composableLambdaInstance(1969981408, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969981408, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt.lambda-1.<anonymous> (ShootResultShareView.kt:196)");
                }
                TextKt.a("\u53d1\u5e03", null, null, QUIToken.color$default("button_text_primary_default"), Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 28678, 0, 0, 134217702);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f76lambda2 = ComposableLambdaKt.composableLambdaInstance(-382710841, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-382710841, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt.lambda-2.<anonymous> (ShootResultShareView.kt:225)");
                }
                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_8csOTmuk3of.png", null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 48.0f), 48.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer2, 262150, 0, 0, 2097118);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f77lambda3 = ComposableLambdaKt.composableLambdaInstance(768208674, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(768208674, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt.lambda-3.<anonymous> (ShootResultShareView.kt:245)");
                }
                i.Companion companion = i.INSTANCE;
                ActivityIndicatorKt.a(ComposeLayoutPropUpdaterKt.u(companion, 30.0f), false, composer2, 56, 0);
                TextKt.a("\u53d1\u5e03\u4e2d...", ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 13.0f, 0.0f, 0.0f, 13, null), null, h.INSTANCE.e(), Float.valueOf(13.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 28742, 0, 0, 134217700);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f78lambda4 = ComposableLambdaKt.composableLambdaInstance(-324782613, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-324782613, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt.lambda-4.<anonymous> (ShootResultShareView.kt:238)");
                }
                ColumnKt.a(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 100.0f), 100.0f), new h(3425644335L)), 6.0f), a.f339245a.b(), Alignment.INSTANCE.b(), null, ComposableSingletons$ShootResultShareViewKt.f77lambda3, composer2, 24648, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f79lambda5 = ComposableLambdaKt.composableLambdaInstance(-1741838444, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1741838444, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ComposableSingletons$ShootResultShareViewKt.lambda-5.<anonymous> (ShootResultShareView.kt:329)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
