package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes31.dex */
public class BaseComposeCardViewModel {
    public Function5<? super a, ? super BaseComposeCardViewModel, ? super Integer, ? super Composer, ? super Integer, Unit> cardViewBuilder;

    public final void buildCardView(final a aVar, final BaseComposeCardViewModel baseComposeCardViewModel, final int i3, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1481965154);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1481965154, i16, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel.buildCardView (BaseComposeCardViewModel.kt:14)");
        }
        Function5<? super a, ? super BaseComposeCardViewModel, ? super Integer, ? super Composer, ? super Integer, Unit> function5 = this.cardViewBuilder;
        if (function5 != null) {
            function5.invoke(aVar, baseComposeCardViewModel, Integer.valueOf(i3), startRestartGroup, Integer.valueOf((i16 & 896) | 72));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel$buildCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BaseComposeCardViewModel.this.buildCardView(aVar, baseComposeCardViewModel, i3, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
