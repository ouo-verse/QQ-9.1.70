package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards;

import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.layout.FlexNode;

/* loaded from: classes31.dex */
public final class QPDetailPieChartViewAttr extends k {
    public final float height() {
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            return flexNode.K();
        }
        return 0.0f;
    }

    public final float width() {
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            return flexNode.U();
        }
        return 0.0f;
    }
}
