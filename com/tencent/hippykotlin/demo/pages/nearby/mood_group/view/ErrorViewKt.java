package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ErrorViewKt {
    public static final void ErrorView(final Function0<Unit> function0, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-500883567);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-500883567, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ErrorView (ErrorView.kt:20)");
            }
            a aVar = (a) startRestartGroup.consume(CompositionLocalsKt.d());
            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
            Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), aVar.d() - aVar.i());
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ErrorViewKt$ErrorView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        function0.invoke();
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ColumnKt.a(ViewEventPropUpdaterKt.d(k3, false, null, (Function1) rememberedValue, 3, null), b16, horizontal, null, ComposableSingletons$ErrorViewKt.f66lambda1, startRestartGroup, 25032, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ErrorViewKt$ErrorView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ErrorViewKt.ErrorView(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
