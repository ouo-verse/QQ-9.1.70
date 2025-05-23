package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.layout.FlexNode;

/* loaded from: classes33.dex */
public final class MyCouponTabPageAttr extends k {
    public float tabHeight;
    public float tabMarginBottom;

    public final float width() {
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            return flexNode.U();
        }
        return 0.0f;
    }
}
