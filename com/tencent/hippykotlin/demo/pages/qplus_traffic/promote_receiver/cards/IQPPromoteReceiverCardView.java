package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;

/* loaded from: classes31.dex */
public class IQPPromoteReceiverCardView extends ComposeView<QPPromoteReceiverViewAttr, l> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QPPromoteReceiverViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
