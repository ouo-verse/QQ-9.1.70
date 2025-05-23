package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIFooterRefreshViewKt;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$AppScreenKt {
    public static final ComposableSingletons$AppScreenKt INSTANCE = new ComposableSingletons$AppScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<FooterRefreshState, Composer, Integer, Unit> f88lambda1 = ComposableLambdaKt.composableLambdaInstance(1624313117, false, new Function3<FooterRefreshState, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.ComposableSingletons$AppScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(FooterRefreshState footerRefreshState, Composer composer, Integer num) {
            FooterRefreshState footerRefreshState2 = footerRefreshState;
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 14) == 0) {
                intValue |= composer2.changed(footerRefreshState2) ? 4 : 2;
            }
            if ((intValue & 91) == 18 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1624313117, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.ComposableSingletons$AppScreenKt.lambda-1.<anonymous> (AppScreen.kt:126)");
                }
                QUIFooterRefreshViewKt.QUIFooterRefreshView(footerRefreshState2, composer2, intValue & 14);
                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, ((a) composer2.consume(CompositionLocalsKt.d())).f().getBottom()), composer2, 8, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
