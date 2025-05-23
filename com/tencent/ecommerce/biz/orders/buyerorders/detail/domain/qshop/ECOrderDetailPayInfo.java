package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "payParams", "", "b", "J", "orderPrice", "c", "originalPrice", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "d", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "e", "payTimestampMs", "<init>", "(Ljava/lang/String;JJLcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;J)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.g, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderDetailPayInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String payParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long orderPrice;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long originalPrice;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final PayType payType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final long payTimestampMs;

    public ECOrderDetailPayInfo(String str, long j3, long j16, PayType payType, long j17) {
        this.payParams = str;
        this.orderPrice = j3;
        this.originalPrice = j16;
        this.payType = payType;
        this.payTimestampMs = j17;
    }

    public int hashCode() {
        String str = this.payParams;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.orderPrice)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.originalPrice)) * 31;
        PayType payType = this.payType;
        return ((hashCode + (payType != null ? payType.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.payTimestampMs);
    }

    public String toString() {
        return "ECOrderDetailPayInfo(payParams=" + this.payParams + ", orderPrice=" + this.orderPrice + ", originalPrice=" + this.originalPrice + ", payType=" + this.payType + ", payTimestampMs=" + this.payTimestampMs + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderDetailPayInfo)) {
            return false;
        }
        ECOrderDetailPayInfo eCOrderDetailPayInfo = (ECOrderDetailPayInfo) other;
        return Intrinsics.areEqual(this.payParams, eCOrderDetailPayInfo.payParams) && this.orderPrice == eCOrderDetailPayInfo.orderPrice && this.originalPrice == eCOrderDetailPayInfo.originalPrice && Intrinsics.areEqual(this.payType, eCOrderDetailPayInfo.payType) && this.payTimestampMs == eCOrderDetailPayInfo.payTimestampMs;
    }
}
