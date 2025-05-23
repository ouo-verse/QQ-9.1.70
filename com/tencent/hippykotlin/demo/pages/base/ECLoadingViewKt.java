package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLoadingViewKt {
    public static final void ECLoading(ViewContainer<?, ?> viewContainer, Function1<? super ECLoadingView, Unit> function1) {
        viewContainer.addChild(new ECLoadingView(), function1);
    }
}
