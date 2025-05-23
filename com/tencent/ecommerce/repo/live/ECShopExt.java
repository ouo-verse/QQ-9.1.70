package com.tencent.ecommerce.repo.live;

import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b!\u0010\"J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\t\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/repo/live/i;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "shopId", "b", "spuId", "c", "skuId", "Lcom/tencent/ecommerce/repo/live/l;", "d", "Lcom/tencent/ecommerce/repo/live/l;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/ecommerce/repo/live/o;", "e", "Lcom/tencent/ecommerce/repo/live/o;", "couponInfo", "Lcom/tencent/ecommerce/repo/live/r;", "f", "Lcom/tencent/ecommerce/repo/live/r;", "liveShowItem", "g", "couponShowItem", tl.h.F, "()Lcom/tencent/ecommerce/repo/live/r;", "normalShowItem", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/live/l;Lcom/tencent/ecommerce/repo/live/o;Lcom/tencent/ecommerce/repo/live/r;Lcom/tencent/ecommerce/repo/live/r;Lcom/tencent/ecommerce/repo/live/r;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.i, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopExt {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String spuId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String skuId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final LiveActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final LiveCouponInfo couponInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final LiveShowItem liveShowItem;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final LiveShowItem couponShowItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final LiveShowItem normalShowItem;

    public ECShopExt(String str, String str2, String str3, LiveActivity liveActivity, LiveCouponInfo liveCouponInfo, LiveShowItem liveShowItem, LiveShowItem liveShowItem2, LiveShowItem liveShowItem3) {
        this.shopId = str;
        this.spuId = str2;
        this.skuId = str3;
        this.activity = liveActivity;
        this.couponInfo = liveCouponInfo;
        this.liveShowItem = liveShowItem;
        this.couponShowItem = liveShowItem2;
        this.normalShowItem = liveShowItem3;
    }

    /* renamed from: a, reason: from getter */
    public final LiveShowItem getNormalShowItem() {
        return this.normalShowItem;
    }

    public int hashCode() {
        int hashCode = ((this.shopId.hashCode() * 31) + this.skuId.hashCode()) * 31;
        LiveActivity liveActivity = this.activity;
        return hashCode + (liveActivity != null ? liveActivity.hashCode() : 0);
    }

    public String toString() {
        return "ECShopExt(shopId=" + this.shopId + ", spuId=" + this.spuId + ", skuId=" + this.skuId + ", activity=" + this.activity + ", couponInfo=" + this.couponInfo + ", liveShowItem=" + this.liveShowItem + ", couponShowItem=" + this.couponShowItem + ", normalShowItem=" + this.normalShowItem + ")";
    }

    public /* synthetic */ ECShopExt(String str, String str2, String str3, LiveActivity liveActivity, LiveCouponInfo liveCouponInfo, LiveShowItem liveShowItem, LiveShowItem liveShowItem2, LiveShowItem liveShowItem3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? null : liveActivity, (i3 & 16) != 0 ? null : liveCouponInfo, (i3 & 32) != 0 ? null : liveShowItem, (i3 & 64) != 0 ? null : liveShowItem2, (i3 & 128) != 0 ? null : liveShowItem3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopExt)) {
            return false;
        }
        ECShopExt eCShopExt = (ECShopExt) other;
        return ((Intrinsics.areEqual(this.shopId, eCShopExt.shopId) ^ true) || (Intrinsics.areEqual(this.skuId, eCShopExt.skuId) ^ true) || (Intrinsics.areEqual(this.activity, eCShopExt.activity) ^ true)) ? false : true;
    }
}
