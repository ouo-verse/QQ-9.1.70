package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class PAGViewKt {
    public static final void PAG(ViewContainer<?, ?> viewContainer, Function1<? super PAGView, Unit> function1) {
        viewContainer.addChild(new PAGView(), function1);
    }
}
