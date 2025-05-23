package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListScene;", "Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpanScene;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g {
    public static final ECOrderSpanScene a(OrderListScene orderListScene) {
        int i3 = f.f103402a[orderListScene.ordinal()];
        if (i3 == 1) {
            return ECOrderSpanScene.OrderList;
        }
        if (i3 == 2) {
            return ECOrderSpanScene.OrderSearch;
        }
        throw new NoWhenBranchMatchedException();
    }
}
