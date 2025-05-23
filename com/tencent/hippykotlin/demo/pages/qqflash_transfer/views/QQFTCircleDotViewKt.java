package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCircleDotViewKt {
    public static final void QQFTCircleDotView(final i iVar, final float f16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1004754563);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1004754563, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCircleDotView (QQFTCircleDotView.kt:27)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.n(iVar, 4.0f, 0.0f, 4.0f, 0.0f, 10, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -516216701, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCircleDotViewKt$QQFTCircleDotView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-516216701, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCircleDotView.<anonymous> (QQFTCircleDotView.kt:31)");
                    }
                    BoxKt.a(bVar2.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 2.0f), f16 / 2), QUIToken.color$default("text_secondary")), Alignment.Center), null, null, null, composer3, 8, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCircleDotViewKt$QQFTCircleDotView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCircleDotViewKt.QQFTCircleDotView(i.this, f16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
