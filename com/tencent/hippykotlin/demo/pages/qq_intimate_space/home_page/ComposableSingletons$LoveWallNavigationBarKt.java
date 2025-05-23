package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallNavigationBarKt {
    public static final ComposableSingletons$LoveWallNavigationBarKt INSTANCE = new ComposableSingletons$LoveWallNavigationBarKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f104lambda1 = ComposableLambdaKt.composableLambdaInstance(-1691925009, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt$lambda-1$1
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
                    ComposerKt.traceEventStart(-1691925009, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt.lambda-1.<anonymous> (LoveWallNavigationBar.kt:49)");
                }
                ImageKt.a(null, null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 22), Alignment.CenterStart), null, 0, null, null, QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("icon_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f105lambda2 = ComposableLambdaKt.composableLambdaInstance(-1242280983, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1242280983, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt.lambda-2.<anonymous> (LoveWallNavigationBar.kt:48)");
                }
                BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableSingletons$LoveWallNavigationBarKt.f104lambda1, composer2, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f106lambda3 = ComposableLambdaKt.composableLambdaInstance(-1256098979, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt$lambda-3$1
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
                    ComposerKt.traceEventStart(-1256098979, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt.lambda-3.<anonymous> (LoveWallNavigationBar.kt:85)");
                }
                ImageKt.a(null, null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24), Alignment.CenterEnd), null, 0, null, null, QUIToken.INSTANCE.image("files", QUIToken.color$default("icon_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f107lambda4 = ComposableLambdaKt.composableLambdaInstance(2139312727, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2139312727, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt.lambda-4.<anonymous> (LoveWallNavigationBar.kt:84)");
                }
                BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableSingletons$LoveWallNavigationBarKt.f106lambda3, composer2, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f108lambda5 = ComposableLambdaKt.composableLambdaInstance(1659083004, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt$lambda-5$1
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
                    ComposerKt.traceEventStart(1659083004, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt.lambda-5.<anonymous> (LoveWallNavigationBar.kt:102)");
                }
                ImageKt.a(null, null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24), Alignment.CenterEnd), null, 0, null, null, QUIToken.INSTANCE.image("share", QUIToken.color$default("icon_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f109lambda6 = ComposableLambdaKt.composableLambdaInstance(759527414, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(759527414, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.ComposableSingletons$LoveWallNavigationBarKt.lambda-6.<anonymous> (LoveWallNavigationBar.kt:101)");
                }
                BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableSingletons$LoveWallNavigationBarKt.f108lambda5, composer2, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
