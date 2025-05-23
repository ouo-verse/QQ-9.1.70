package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ActivityIndicatorKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LoadingViewKt {
    public static final void LoadingView(final boolean z16, Composer composer, final int i3, final int i16) {
        int i17;
        h l3;
        Composer startRestartGroup = composer.startRestartGroup(431082925);
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(z16) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i17 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i18 != 0) {
                z16 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(431082925, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.LoadingView (LoadingView.kt:20)");
            }
            a aVar = (a) startRestartGroup.consume(CompositionLocalsKt.d());
            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
            Alignment.Vertical c16 = Alignment.INSTANCE.c();
            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), aVar.d());
            if (z16) {
                l3 = QUIToken.color$default("overlay_dark");
            } else {
                l3 = h.INSTANCE.l();
            }
            RowKt.a(ModifiersKt.c(k3, l3), b16, c16, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1199501647, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.LoadingViewKt$LoadingView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    h hVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1199501647, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.LoadingView.<anonymous> (LoadingView.kt:27)");
                        }
                        boolean z17 = !z16;
                        i.Companion companion = i.INSTANCE;
                        ActivityIndicatorKt.a(ComposeLayoutPropUpdaterKt.u(companion, 20.0f), z17, composer3, 8, 0);
                        if (z16) {
                            hVar = h.INSTANCE.m();
                        } else {
                            hVar = new h(9211020L, 1.0f);
                        }
                        TextKt.a("\u52a0\u8f7d\u4e2d,\u8bf7\u7a0d\u540e...", ComposeLayoutPropUpdaterKt.n(companion, 13.0f, 0.0f, 0.0f, 0.0f, 14, null), null, hVar, Float.valueOf(13.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 28742, 0, 0, 134217700);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196680, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.LoadingViewKt$LoadingView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoadingViewKt.LoadingView(z16, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
