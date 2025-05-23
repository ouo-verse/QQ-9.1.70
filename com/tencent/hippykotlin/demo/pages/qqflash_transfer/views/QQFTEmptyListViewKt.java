package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTEmptyListViewKt {
    public static final void QQFTEmptyListView(final String str, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-972062573);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-972062573, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTEmptyListView (QQFTEmptyListView.kt:36)");
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m()), 400.0f), 0.0f, 16.0f, 0.0f, 0.0f, 13, null), a.f339245a.b(), Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, 934993226, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTEmptyListViewKt$QQFTEmptyListView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(d dVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(934993226, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTEmptyListView.<anonymous> (QQFTEmptyListView.kt:43)");
                        }
                        i.Companion companion = i.INSTANCE;
                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 80.0f), null, 0, null, null, "data:image/png;base64,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", null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer3, 262144, 1073741830, 0, 1571807);
                        i n3 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 32.0f, 0.0f, 0.0f, 13, null);
                        int a16 = ai.INSTANCE.a();
                        bp3.c e16 = bp3.c.INSTANCE.e();
                        TextKt.a(str, n3, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, e16, null, null, null, ai.f(a16), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, (i16 & 14) | 1601600, 0, 0, 134216612);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 25032, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTEmptyListViewKt$QQFTEmptyListView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTEmptyListViewKt.QQFTEmptyListView(str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
