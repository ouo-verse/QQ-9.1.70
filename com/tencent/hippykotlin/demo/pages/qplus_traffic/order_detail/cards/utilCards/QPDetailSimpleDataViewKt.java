package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPDetailSimpleDataViewKt {
    public static final void QPDetailSimpleDataView(ViewContainer<?, ?> viewContainer, String str, String str2, Function1<? super QPDetailSimpleDataView, Unit> function1) {
        viewContainer.addChild(new QPDetailSimpleDataView(str, str2), function1);
    }
}
