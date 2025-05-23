package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterEmptyCardVM;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCenterEmptyCardViewKt {
    public static final void QQFTCenterEmptyCardView(final QQFTCenterEmptyCardVM qQFTCenterEmptyCardVM, final boolean z16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1641458066);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1641458066, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterEmptyCardView (QQFTCenterEmptyCardView.kt:37)");
        }
        if (z16) {
            startRestartGroup.startReplaceableGroup(363171481);
            bottomEmptyCardView(qQFTCenterEmptyCardVM, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(363171530);
            topEmptyCardView(qQFTCenterEmptyCardVM, startRestartGroup, 8);
            startRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterEmptyCardViewKt$QQFTCenterEmptyCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterEmptyCardViewKt.QQFTCenterEmptyCardView(QQFTCenterEmptyCardVM.this, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void bottomEmptyCardView(final QQFTCenterEmptyCardVM qQFTCenterEmptyCardVM, Composer composer, final int i3) {
        float m3;
        Composer startRestartGroup = composer.startRestartGroup(1188714734);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1188714734, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.bottomEmptyCardView (QQFTCenterEmptyCardView.kt:47)");
        }
        boolean booleanValue = qQFTCenterEmptyCardVM.f114261vm.getFilterCardVM().listGridMode.getValue().booleanValue();
        if (booleanValue) {
            m3 = c.f117352a.g().getPageData().m() - 32.0f;
        } else {
            m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a);
        }
        float f16 = booleanValue ? 0.0f : 16.0f;
        ColumnKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, m3), 500), f16, 0.0f, f16, 0.0f, 10, null), a.f339245a.b(), Alignment.Horizontal.CenterHorizontally, null, ComposableSingletons$QQFTCenterEmptyCardViewKt.f150lambda1, startRestartGroup, 25032, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterEmptyCardViewKt$bottomEmptyCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterEmptyCardViewKt.bottomEmptyCardView(QQFTCenterEmptyCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void topEmptyCardView(final QQFTCenterEmptyCardVM qQFTCenterEmptyCardVM, Composer composer, final int i3) {
        float m3;
        Composer startRestartGroup = composer.startRestartGroup(-2003352096);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2003352096, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.topEmptyCardView (QQFTCenterEmptyCardView.kt:75)");
        }
        final boolean booleanValue = qQFTCenterEmptyCardVM.f114261vm.getFilterCardVM().listGridMode.getValue().booleanValue();
        if (booleanValue) {
            m3 = c.f117352a.g().getPageData().m() - 32.0f;
        } else {
            m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a);
        }
        float f16 = booleanValue ? 0.0f : 16.0f;
        BoxKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, m3), booleanValue ? 88 : 92), f16, 0.0f, f16, 0.0f, 10, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 568159514, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterEmptyCardViewKt$topEmptyCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(568159514, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.topEmptyCardView.<anonymous> (QQFTCenterEmptyCardView.kt:82)");
                    }
                    SurfaceKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 72), 0.0f, 16, 0.0f, booleanValue ? 0.0f : 4, 5, null), QUIToken.color$default("fill_standard_primary")), uo3.c.a(14), null, null, ComposableSingletons$QQFTCenterEmptyCardViewKt.f151lambda2, composer3, 24584, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterEmptyCardViewKt$topEmptyCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterEmptyCardViewKt.topEmptyCardView(QQFTCenterEmptyCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
