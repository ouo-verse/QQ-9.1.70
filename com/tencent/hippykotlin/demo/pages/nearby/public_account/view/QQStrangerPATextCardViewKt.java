package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class QQStrangerPATextCardViewKt {
    public static final void QQStrangerPATextCardView(final String str, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(931500762);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(931500762, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPATextCardView (QQStrangerPATextCardView.kt:20)");
            }
            RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) - (2 * 6.0f)), 22.0f), a.f339245a.g(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -258027652, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPATextCardViewKt$QQStrangerPATextCardView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-258027652, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPATextCardView.<anonymous> (QQStrangerPATextCardView.kt:28)");
                        }
                        TextKt.a(str, null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, (i16 & 14) | 1601536, 48, 0, 134215590);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPATextCardViewKt$QQStrangerPATextCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerPATextCardViewKt.QQStrangerPATextCardView(str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
