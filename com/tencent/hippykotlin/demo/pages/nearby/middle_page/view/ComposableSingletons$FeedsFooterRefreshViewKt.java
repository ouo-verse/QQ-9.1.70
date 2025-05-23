package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingIconType;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$FeedsFooterRefreshViewKt {
    public static final ComposableSingletons$FeedsFooterRefreshViewKt INSTANCE = new ComposableSingletons$FeedsFooterRefreshViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f48lambda1 = ComposableLambdaKt.composableLambdaInstance(1441016755, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.ComposableSingletons$FeedsFooterRefreshViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            LoadingIconType loadingIconType;
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1441016755, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.ComposableSingletons$FeedsFooterRefreshViewKt.lambda-1.<anonymous> (FeedsFooterRefreshView.kt:91)");
                }
                if (QUIToken.INSTANCE.isNightMode()) {
                    loadingIconType = LoadingIconType.WHITE;
                } else {
                    loadingIconType = LoadingIconType.GRAY;
                }
                i.Companion companion = i.INSTANCE;
                LoadingKt.Loading(ComposeLayoutPropUpdaterKt.u(companion, 18.0f), loadingIconType, composer2, 8, 0);
                TextKt.a("\u6570\u636e\u52a0\u8f7d\u4e2d...", ComposeLayoutPropUpdaterKt.n(companion, 6.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601606, 0, 0, 134217636);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
