package com.tencent.mobileqq.zplan.aigc.data;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\tB/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", MiniBoxNoticeInfo.KEY_ICON_URL, "b", "couponName", "", "J", "()J", "goldPrice", "d", "e", "silverPrice", "priceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJJ)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final /* data */ class a {

    /* renamed from: g, reason: collision with root package name */
    private static final String f330135g = "AIGCCouponShoppingBagInfo";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String iconURL;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String couponName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long goldPrice;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long silverPrice;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long priceType;

    public a(String iconURL, String couponName, long j3, long j16, long j17) {
        Intrinsics.checkNotNullParameter(iconURL, "iconURL");
        Intrinsics.checkNotNullParameter(couponName, "couponName");
        this.iconURL = iconURL;
        this.couponName = couponName;
        this.goldPrice = j3;
        this.silverPrice = j16;
        this.priceType = j17;
    }

    /* renamed from: a, reason: from getter */
    public final String getCouponName() {
        return this.couponName;
    }

    /* renamed from: b, reason: from getter */
    public final long getGoldPrice() {
        return this.goldPrice;
    }

    /* renamed from: c, reason: from getter */
    public final String getIconURL() {
        return this.iconURL;
    }

    /* renamed from: d, reason: from getter */
    public final long getPriceType() {
        return this.priceType;
    }

    /* renamed from: e, reason: from getter */
    public final long getSilverPrice() {
        return this.silverPrice;
    }

    public int hashCode() {
        return (((((((this.iconURL.hashCode() * 31) + this.couponName.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.goldPrice)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.silverPrice)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.priceType);
    }

    public String toString() {
        return "iconURL: " + this.iconURL + ", couponName: " + this.couponName + ", goldPrice: " + this.goldPrice + ", silverPrice: " + this.silverPrice + ", priceType: " + this.priceType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return Intrinsics.areEqual(this.iconURL, aVar.iconURL) && Intrinsics.areEqual(this.couponName, aVar.couponName) && this.goldPrice == aVar.goldPrice && this.silverPrice == aVar.silverPrice && this.priceType == aVar.priceType;
    }
}
