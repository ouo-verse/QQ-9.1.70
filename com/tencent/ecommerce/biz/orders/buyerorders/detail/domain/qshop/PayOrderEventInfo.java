package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "payParams", "b", "I", "payTypeId", "<init>", "(Ljava/lang/String;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.m, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class PayOrderEventInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String payParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int payTypeId;

    public PayOrderEventInfo(String str, int i3) {
        this.payParams = str;
        this.payTypeId = i3;
    }

    public int hashCode() {
        String str = this.payParams;
        return ((str != null ? str.hashCode() : 0) * 31) + this.payTypeId;
    }

    public String toString() {
        return "PayOrderEventInfo(payParams=" + this.payParams + ", payTypeId=" + this.payTypeId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayOrderEventInfo)) {
            return false;
        }
        PayOrderEventInfo payOrderEventInfo = (PayOrderEventInfo) other;
        return Intrinsics.areEqual(this.payParams, payOrderEventInfo.payParams) && this.payTypeId == payOrderEventInfo.payTypeId;
    }
}
