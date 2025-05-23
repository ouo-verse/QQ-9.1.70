package com.tencent.ecommerce.biz.orders.span;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/span/ECOrderSpanScene;", "", "meanings", "", "(Ljava/lang/String;ILjava/lang/String;)V", "OrderSubmit", "OrderList", "OrderSearch", "OrderDetail", "OrderComment", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECOrderSpanScene {
    OrderSubmit("\u8ba2\u5355\u63d0\u4ea4"),
    OrderList("\u8ba2\u5355\u5217\u8868"),
    OrderSearch("\u8ba2\u5355\u641c\u7d22"),
    OrderDetail("\u8ba2\u5355\u8be6\u60c5"),
    OrderComment("\u8ba2\u5355\u8bc4\u4ef7");

    public final String meanings;

    ECOrderSpanScene(String str) {
        this.meanings = str;
    }
}
