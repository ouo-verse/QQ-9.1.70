package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class VasDynamicViewKt {
    public static final void VasDynamicImg(ViewContainer<?, ?> viewContainer, Function1<? super VasDynamicView, Unit> function1) {
        viewContainer.addChild(new VasDynamicView(), function1);
    }
}
