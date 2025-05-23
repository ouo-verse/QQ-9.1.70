package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class ComposableSingletons$SharePanelViewKt {
    public static final ComposableSingletons$SharePanelViewKt INSTANCE = new ComposableSingletons$SharePanelViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f115lambda1 = ComposableLambdaKt.composableLambdaInstance(237662613, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ComposableSingletons$SharePanelViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            int i3;
            n nVar2 = nVar;
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 14) == 0) {
                i3 = (composer2.changed(nVar2) ? 4 : 2) | intValue;
            } else {
                i3 = intValue;
            }
            if ((i3 & 91) == 18 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(237662613, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ComposableSingletons$SharePanelViewKt.lambda-1.<anonymous> (SharePanelView.kt:118)");
                }
                ImageKt.a(null, null, null, null, null, nVar2.b(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), Alignment.INSTANCE.c()), null, 0, null, null, QUIToken.INSTANCE.image("close", QUIToken.color$default("icon_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
