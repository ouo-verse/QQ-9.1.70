package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public class IQPOrderDetailCardView extends ComposeView<QPOrderDetailCardAttr, l> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QPOrderDetailCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
