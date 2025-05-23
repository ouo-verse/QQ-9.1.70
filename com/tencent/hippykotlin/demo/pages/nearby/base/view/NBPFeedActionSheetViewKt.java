package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPFeedActionSheetViewKt {
    public static final void NBPFeedActionSheet(ViewContainer<?, ?> viewContainer, Function1<? super NBPFeedActionSheetView, Unit> function1) {
        viewContainer.addChild(new NBPFeedActionSheetView(), function1);
    }
}
