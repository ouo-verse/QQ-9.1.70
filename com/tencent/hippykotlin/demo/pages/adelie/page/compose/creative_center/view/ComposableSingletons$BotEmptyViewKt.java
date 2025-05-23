package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$BotEmptyViewKt {
    public static final ComposableSingletons$BotEmptyViewKt INSTANCE = new ComposableSingletons$BotEmptyViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f6lambda1 = ComposableLambdaKt.composableLambdaInstance(-180829160, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ComposableSingletons$BotEmptyViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180829160, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ComposableSingletons$BotEmptyViewKt.lambda-1.<anonymous> (BotEmptyView.kt:30)");
                }
                i.Companion companion = i.INSTANCE;
                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 114.0f), composer2, 8, 0);
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.v(companion, 80.0f, 80.0f), null, 0, null, null, "data:image/png;base64,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", null, null, null, null, null, null, null, null, null, null, composer2, 262144, 6, 0, 2096095);
                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 24.0f), composer2, 8, 0);
                TextKt.a("\u8bd5\u8bd5\u70b9\u4e0b\u65b9\u52a0\u53f7\u521b\u5efa\u667a\u80fd\u4f53\u5427", null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601542, 48, 0, 134215590);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f7lambda2 = ComposableLambdaKt.composableLambdaInstance(1457933615, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ComposableSingletons$BotEmptyViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1457933615, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ComposableSingletons$BotEmptyViewKt.lambda-2.<anonymous> (BotEmptyView.kt:26)");
                }
                ColumnKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, Alignment.INSTANCE.b(), null, ComposableSingletons$BotEmptyViewKt.f6lambda1, composer2, 24584, 10);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
