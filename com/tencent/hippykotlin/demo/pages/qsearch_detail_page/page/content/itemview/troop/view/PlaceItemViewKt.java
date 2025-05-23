package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes32.dex */
public final class PlaceItemViewKt {
    public static final void PlaceItem(ViewContainer<?, ?> viewContainer, Function1<? super PlaceItemView, Unit> function1) {
        viewContainer.addChild(new PlaceItemView(), function1);
    }
}
