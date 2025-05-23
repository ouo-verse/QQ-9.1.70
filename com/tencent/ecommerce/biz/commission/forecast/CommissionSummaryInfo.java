package com.tencent.ecommerce.biz.commission.forecast;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/k;", "Lcom/tencent/ecommerce/biz/commission/forecast/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "b", "J", "commission", "c", "orderCount", "<init>", "(JJ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.commission.forecast.k, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class CommissionSummaryInfo extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long commission;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long orderCount;

    public int hashCode() {
        return (b.a(this.commission) * 31) + b.a(this.orderCount);
    }

    public String toString() {
        return "CommissionSummaryInfo(commission=" + this.commission + ", orderCount=" + this.orderCount + ")";
    }

    public CommissionSummaryInfo(long j3, long j16) {
        super(1, null);
        this.commission = j3;
        this.orderCount = j16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommissionSummaryInfo)) {
            return false;
        }
        CommissionSummaryInfo commissionSummaryInfo = (CommissionSummaryInfo) other;
        return this.commission == commissionSummaryInfo.commission && this.orderCount == commissionSummaryInfo.orderCount;
    }
}
