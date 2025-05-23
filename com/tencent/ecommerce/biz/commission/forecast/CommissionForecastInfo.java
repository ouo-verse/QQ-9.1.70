package com.tencent.ecommerce.biz.commission.forecast;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/c;", "Lcom/tencent/ecommerce/biz/commission/forecast/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "id", "c", "productName", "", "d", "J", "forecastAmount", "e", "orderCreateTime", "f", "payAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.commission.forecast.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class CommissionForecastInfo extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final long forecastAmount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderCreateTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final long payAmount;

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.productName;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + b.a(this.forecastAmount)) * 31;
        String str3 = this.orderCreateTime;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + b.a(this.payAmount);
    }

    public String toString() {
        return "CommissionForecastInfo(id=" + this.id + ", productName=" + this.productName + ", forecastAmount=" + this.forecastAmount + ", orderCreateTime=" + this.orderCreateTime + ", payAmount=" + this.payAmount + ")";
    }

    public CommissionForecastInfo(String str, String str2, long j3, String str3, long j16) {
        super(2, null);
        this.id = str;
        this.productName = str2;
        this.forecastAmount = j3;
        this.orderCreateTime = str3;
        this.payAmount = j16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommissionForecastInfo)) {
            return false;
        }
        CommissionForecastInfo commissionForecastInfo = (CommissionForecastInfo) other;
        return Intrinsics.areEqual(this.id, commissionForecastInfo.id) && Intrinsics.areEqual(this.productName, commissionForecastInfo.productName) && this.forecastAmount == commissionForecastInfo.forecastAmount && Intrinsics.areEqual(this.orderCreateTime, commissionForecastInfo.orderCreateTime) && this.payAmount == commissionForecastInfo.payAmount;
    }
}
