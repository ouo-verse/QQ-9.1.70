package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RedDotKt {
    public static final void RedDot(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(192684439);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(192684439, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.RedDot (RedDot.kt:13)");
            }
            SurfaceKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.d(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 8.0f), c.a(8.0f)), QUIToken.color$default("feedback_error")), 0.0f, 0.0f, 8.0f, 0.0f, 11, null), null, null, null, ComposableSingletons$RedDotKt.f8lambda1, startRestartGroup, 24584, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.RedDotKt$RedDot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                RedDotKt.RedDot(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
