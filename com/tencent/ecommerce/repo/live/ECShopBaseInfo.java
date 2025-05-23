package com.tencent.ecommerce.repo.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/repo/live/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "shopId", "b", "shopName", "c", "shopLogo", "d", "I", "shopStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.g, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopBaseInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopLogo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int shopStatus;

    public ECShopBaseInfo(String str, String str2, String str3, int i3) {
        this.shopId = str;
        this.shopName = str2;
        this.shopLogo = str3;
        this.shopStatus = i3;
    }

    public int hashCode() {
        String str = this.shopId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.shopName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.shopLogo;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.shopStatus;
    }

    public String toString() {
        return "ECShopBaseInfo(shopId=" + this.shopId + ", shopName=" + this.shopName + ", shopLogo=" + this.shopLogo + ", shopStatus=" + this.shopStatus + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopBaseInfo)) {
            return false;
        }
        ECShopBaseInfo eCShopBaseInfo = (ECShopBaseInfo) other;
        return Intrinsics.areEqual(this.shopId, eCShopBaseInfo.shopId) && Intrinsics.areEqual(this.shopName, eCShopBaseInfo.shopName) && Intrinsics.areEqual(this.shopLogo, eCShopBaseInfo.shopLogo) && this.shopStatus == eCShopBaseInfo.shopStatus;
    }
}
