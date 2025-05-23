package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class ComposableSingletons$TtsListCellMyOPKt {
    public static final ComposableSingletons$TtsListCellMyOPKt INSTANCE = new ComposableSingletons$TtsListCellMyOPKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f21lambda1 = ComposableLambdaKt.composableLambdaInstance(-942721057, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsListCellMyOPKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-942721057, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsListCellMyOPKt.lambda-1.<anonymous> (TtsListCellMyOP.kt:119)");
                }
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 6.0f, 0.0f, 0.0f, 0.0f, 14, null), null, h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("more", QUIToken.color$default("icon_secondary")), null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 0, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f22lambda2 = ComposableLambdaKt.composableLambdaInstance(300607555, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsListCellMyOPKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(300607555, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsListCellMyOPKt.lambda-2.<anonymous> (TtsListCellMyOP.kt:136)");
                }
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("refresh", QUIToken.color$default("brand_standard")), null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 0, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
