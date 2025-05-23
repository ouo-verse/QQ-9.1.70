package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDOrderCardViewAttr extends k {
    public OrderCard orderCard;
    public ASDReportModel reportModel;
    public AfterSalesDetailRspModel rspModel;

    public final OrderCard getOrderCard() {
        OrderCard orderCard = this.orderCard;
        if (orderCard != null) {
            return orderCard;
        }
        Intrinsics.throwUninitializedPropertyAccessException("orderCard");
        return null;
    }
}
