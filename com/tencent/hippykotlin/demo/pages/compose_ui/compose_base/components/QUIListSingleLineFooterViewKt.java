package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIListSingleLineFooterViewKt {
    public static final void QUIListSingleLineFooterDescView(final String str, Composer composer, final int i3) {
        int i16;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-623247933);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-623247933, i16, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineFooterDescView (QUIListSingleLineFooterView.kt:18)");
            }
            composer2 = startRestartGroup;
            TextKt.a(str, ModifiersKt.a(ComposeLayoutPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 16.0f, 6.0f, 16.0f, 6.0f), str), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, 15868, null), null, null, null, null, null, false, composer2, (i16 & 14) | 64, 0, k.f28903n, 133169148);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineFooterViewKt$QUIListSingleLineFooterDescView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                QUIListSingleLineFooterViewKt.QUIListSingleLineFooterDescView(str, composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
