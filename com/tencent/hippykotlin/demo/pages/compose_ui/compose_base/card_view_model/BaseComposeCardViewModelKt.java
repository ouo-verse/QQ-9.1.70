package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model;

import androidx.compose.runtime.Composer;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BaseComposeCardViewModelKt {
    public static final void setCardViewBuilder(BaseComposeCardViewModel baseComposeCardViewModel, Function5<? super a, ? super BaseComposeCardViewModel, ? super Integer, ? super Composer, ? super Integer, Unit> function5) {
        baseComposeCardViewModel.cardViewBuilder = function5;
    }
}
