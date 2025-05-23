package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "totalPrice", "b", "I", "totalDiscount", "<init>", "(JI)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.h, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OrderSubmitPriceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long totalPrice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int totalDiscount;

    public OrderSubmitPriceInfo(long j3, int i3) {
        this.totalPrice = j3;
        this.totalDiscount = i3;
    }

    public int hashCode() {
        return (com.tencent.ecommerce.biz.commission.forecast.b.a(this.totalPrice) * 31) + this.totalDiscount;
    }

    public String toString() {
        return "OrderSubmitPriceInfo(totalPrice=" + this.totalPrice + ", totalDiscount=" + this.totalDiscount + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderSubmitPriceInfo)) {
            return false;
        }
        OrderSubmitPriceInfo orderSubmitPriceInfo = (OrderSubmitPriceInfo) other;
        return this.totalPrice == orderSubmitPriceInfo.totalPrice && this.totalDiscount == orderSubmitPriceInfo.totalDiscount;
    }
}
