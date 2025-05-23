package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPHalfScreenModalViewKt {
    public static final void NBPHalfScreenModal(ViewContainer<?, ?> viewContainer, Function1<? super NBPHalfScreenModalView, Unit> function1) {
        viewContainer.addChild(new NBPHalfScreenModalView(), function1);
    }
}
