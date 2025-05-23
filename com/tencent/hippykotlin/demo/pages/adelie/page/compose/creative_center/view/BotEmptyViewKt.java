package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.SurfaceKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BotEmptyViewKt {
    public static final void BotEmptyView(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-617738703);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617738703, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotEmptyView (BotEmptyView.kt:20)");
            }
            SurfaceKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), c.f117352a.g().getPageData().m() / 0.9236453f), null, null, h.INSTANCE.j(), ComposableSingletons$BotEmptyViewKt.f7lambda2, startRestartGroup, 28680, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotEmptyViewKt$BotEmptyView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BotEmptyViewKt.BotEmptyView(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
