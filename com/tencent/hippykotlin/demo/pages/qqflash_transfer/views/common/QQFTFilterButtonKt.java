package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common;

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
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFilterButtonKt {
    public static final float kFilterButtonHeight = 32;

    public static final void QQFTFilterButton(final i iVar, final String str, final boolean z16, final boolean z17, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1627228599);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1627228599, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterButton (QQFTFilterButton.kt:33)");
        }
        float f16 = 8;
        RowKt.a(ModifiersKt.w(ModifiersKt.q(ComposeLayoutPropUpdaterKt.s(ModifiersKt.h(ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(iVar, kFilterButtonHeight)), 1, QUIToken.color$default("border_standard"), null, 4, null), 10, 0.0f, f16, 0.0f, 10, null), c.a(f16)), QUIToken.color$default("overlay_surface_bg")), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 520867819, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterButtonKt$QQFTFilterButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                h color$default;
                bp3.c f17;
                String image;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(520867819, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterButton.<anonymous> (QQFTFilterButton.kt:45)");
                    }
                    if (z16) {
                        color$default = QUIToken.color$default("text_primary");
                    } else {
                        color$default = QUIToken.color$default("brand_standard");
                    }
                    h hVar = color$default;
                    i.Companion companion = i.INSTANCE;
                    i A = ComposeLayoutPropUpdaterKt.A(companion);
                    int a16 = ai.INSTANCE.a();
                    if (z16) {
                        f17 = bp3.c.INSTANCE.e();
                    } else {
                        f17 = bp3.c.INSTANCE.f();
                    }
                    TextKt.a(str, A, null, hVar, Float.valueOf(14.0f), null, f17, null, null, null, ai.f(a16), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 >> 3) & 14) | 28736, 0, 0, 134216612);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, 12.0f), 4, 0.0f, 0.0f, 0.0f, 14, null);
                    if (z17) {
                        image = QUIToken.INSTANCE.image("chevron_up", hVar);
                    } else {
                        image = QUIToken.INSTANCE.image("chevron_down", hVar);
                    }
                    ImageKt.a(image, null, null, null, null, n3, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterButtonKt$QQFTFilterButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterButtonKt.QQFTFilterButton(i.this, str, z16, z17, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
