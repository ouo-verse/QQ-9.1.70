package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$OpenQZoneSheetKt {
    public static final ComposableSingletons$OpenQZoneSheetKt INSTANCE = new ComposableSingletons$OpenQZoneSheetKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f10lambda1 = ComposableLambdaKt.composableLambdaInstance(-2083773304, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.ComposableSingletons$OpenQZoneSheetKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2083773304, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.ComposableSingletons$OpenQZoneSheetKt.lambda-1.<anonymous> (OpenQZoneSheet.kt:84)");
                }
                SpacerKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 36.0f), 5.0f), c.a(3.0f)), 0.0f, 4.0f, 0.0f, 0.0f, 13, null), QUIToken.color$default("icon_tertiary")), composer2, 8, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f11lambda2 = ComposableLambdaKt.composableLambdaInstance(1553376334, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.ComposableSingletons$OpenQZoneSheetKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1553376334, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.ComposableSingletons$OpenQZoneSheetKt.lambda-2.<anonymous> (OpenQZoneSheet.kt:80)");
                }
                BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 14.0f), QUIToken.color$default("bg_middle_light")), Alignment.Center, null, ComposableSingletons$OpenQZoneSheetKt.f10lambda1, composer2, 3128, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
