package com.tencent.hippykotlin.demo.pages.foundation.qui_component;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QActionSheetKt {
    public static final void QActionSheet(ViewContainer<?, ?> viewContainer, Function1<? super QActionSheetView, Unit> function1) {
        viewContainer.addChild(new QActionSheetView(), function1);
    }
}
