package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class APNGViewKt {
    public static final void APNG(ViewContainer<?, ?> viewContainer, Function1<? super APNGVView, Unit> function1) {
        viewContainer.addChild(new APNGVView(), function1);
    }
}
