package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTBlankItemViewKt {
    public static final void QQFTBlankItemView(final QQFTFileDetailItemVM qQFTFileDetailItemVM, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-983316385);
        if ((i3 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-983316385, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTBlankItemView (QQFTBlankItemView.kt:12)");
            }
            BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, ((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) - 3) - 8.0f) / 3.0f), QUIToken.color$default("bg_bottom_light")), null, null, ComposableSingletons$QQFTBlankItemViewKt.f125lambda1, startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTBlankItemViewKt$QQFTBlankItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTBlankItemViewKt.QQFTBlankItemView(QQFTFileDetailItemVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
