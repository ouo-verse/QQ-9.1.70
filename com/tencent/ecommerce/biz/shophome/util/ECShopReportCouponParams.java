package com.tencent.ecommerce.biz.shophome.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\t\u0010\u0014\"\u0004\b\f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/util/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "isCoupon", "b", "Ljava/lang/String;", "couponOwner", "c", "couponIds", "", "d", "J", "()J", "(J)V", "offPrice", "<init>", "(ILjava/lang/String;Ljava/lang/String;J)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.shophome.util.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopReportCouponParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int isCoupon;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String couponOwner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String couponIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long offPrice;

    public ECShopReportCouponParams(int i3, String str, String str2, long j3) {
        this.isCoupon = i3;
        this.couponOwner = str;
        this.couponIds = str2;
        this.offPrice = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getOffPrice() {
        return this.offPrice;
    }

    public final void b(long j3) {
        this.offPrice = j3;
    }

    public int hashCode() {
        int i3 = this.isCoupon * 31;
        String str = this.couponOwner;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.couponIds;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.offPrice);
    }

    public String toString() {
        return "ECShopReportCouponParams(isCoupon=" + this.isCoupon + ", couponOwner=" + this.couponOwner + ", couponIds=" + this.couponIds + ", offPrice=" + this.offPrice + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopReportCouponParams)) {
            return false;
        }
        ECShopReportCouponParams eCShopReportCouponParams = (ECShopReportCouponParams) other;
        return this.isCoupon == eCShopReportCouponParams.isCoupon && Intrinsics.areEqual(this.couponOwner, eCShopReportCouponParams.couponOwner) && Intrinsics.areEqual(this.couponIds, eCShopReportCouponParams.couponIds) && this.offPrice == eCShopReportCouponParams.offPrice;
    }
}
