package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common;

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
import com.tencent.ntcompose.material.ImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTSwitchModeButtonKt {
    public static final float kSwitchModeButtonHeight = 32;

    public static final void QQFTSwitchModeButton(final i iVar, final boolean z16, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1825065584);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1825065584, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTSwitchModeButton (QQFTSwitchModeButton.kt:15)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.u(iVar, kSwitchModeButtonHeight), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1449598634, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTSwitchModeButtonKt$QQFTSwitchModeButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                String image;
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
                        ComposerKt.traceEventStart(1449598634, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTSwitchModeButton.<anonymous> (QQFTSwitchModeButton.kt:16)");
                    }
                    i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), Alignment.CenterEnd);
                    if (z16) {
                        image = QUIToken.INSTANCE.image("ordered_list_new", QUIToken.color$default("icon_primary"));
                    } else {
                        image = QUIToken.INSTANCE.image("ordered_grid_new", QUIToken.color$default("icon_primary"));
                    }
                    ImageKt.a(image, null, null, null, null, a16, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTSwitchModeButtonKt$QQFTSwitchModeButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTSwitchModeButtonKt.QQFTSwitchModeButton(i.this, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
