package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class InteractiveTimeViewKt {
    public static final void InteractiveTime(ViewContainer<?, ?> viewContainer, Function1<? super InteractiveTimeView, Unit> function1) {
        viewContainer.addChild(new InteractiveTimeView(), function1);
    }
}
