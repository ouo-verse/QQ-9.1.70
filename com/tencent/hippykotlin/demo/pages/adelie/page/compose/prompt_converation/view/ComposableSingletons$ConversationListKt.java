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
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$ConversationListKt {
    public static final ComposableSingletons$ConversationListKt INSTANCE = new ComposableSingletons$ConversationListKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f14lambda1 = ComposableLambdaKt.composableLambdaInstance(1977808436, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ComposableSingletons$ConversationListKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1977808436, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ComposableSingletons$ConversationListKt.lambda-1.<anonymous> (ConversationList.kt:70)");
                }
                i.Companion companion = i.INSTANCE;
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, 16.0f), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 0, null, null, QUIToken.INSTANCE.image("add_circle", QUIToken.color$default("brand_standard")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                TextKt.a("\u6dfb\u52a0\u5bf9\u8bdd\u8f6e\u6570", ComposeLayoutPropUpdaterKt.n(companion, 12.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("brand_standard"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601606, 0, 0, 134217636);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f15lambda2 = ComposableLambdaKt.composableLambdaInstance(2082158870, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ComposableSingletons$ConversationListKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2082158870, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ComposableSingletons$ConversationListKt.lambda-2.<anonymous> (ConversationList.kt:69)");
                }
                RowKt.a(null, null, Alignment.Vertical.CenterVertically, null, null, ComposableSingletons$ConversationListKt.f14lambda1, composer2, 196992, 27);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
