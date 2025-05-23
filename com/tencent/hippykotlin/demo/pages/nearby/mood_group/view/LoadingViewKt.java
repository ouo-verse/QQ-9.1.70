package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LoadingViewKt {
    public static final void LoadingView(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(744522903);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(744522903, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.LoadingView (LoadingView.kt:18)");
            }
            a aVar = (a) startRestartGroup.consume(CompositionLocalsKt.d());
            RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), aVar.d() - aVar.i()), com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), Alignment.INSTANCE.c(), null, null, ComposableSingletons$LoadingViewKt.f67lambda1, startRestartGroup, 196680, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.LoadingViewKt$LoadingView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoadingViewKt.LoadingView(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
