package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$ConversationCellKt {
    public static final ComposableSingletons$ConversationCellKt INSTANCE = new ComposableSingletons$ConversationCellKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f12lambda1 = ComposableLambdaKt.composableLambdaInstance(1544779417, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ComposableSingletons$ConversationCellKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1544779417, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ComposableSingletons$ConversationCellKt.lambda-1.<anonymous> (ConversationCell.kt:83)");
                }
                i.Companion companion = i.INSTANCE;
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 14.0f), null, 0, null, null, QUIToken.INSTANCE.image("delete", QUIToken.color$default("icon_secondary")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                TextKt.a("\u5220\u9664", ComposeLayoutPropUpdaterKt.n(companion, 2.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary_light"), Float.valueOf(12.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601606, 0, 0, 134217636);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f13lambda2 = ComposableLambdaKt.composableLambdaInstance(861124475, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ComposableSingletons$ConversationCellKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(861124475, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ComposableSingletons$ConversationCellKt.lambda-2.<anonymous> (ConversationCell.kt:79)");
                }
                RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 17.0f), 0.0f, 6.0f, 0.0f, 0.0f, 13, null), null, null, null, null, ComposableSingletons$ConversationCellKt.f12lambda1, composer2, 196616, 30);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
