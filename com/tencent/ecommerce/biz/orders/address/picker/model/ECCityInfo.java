package com.tencent.ecommerce.biz.orders.address.picker.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "c", "(Z)V", "isCurrentLocation", "Ljava/lang/String;", "province", "()Ljava/lang/String;", "city", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.address.picker.model.g, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECCityInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isCurrentLocation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String province;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String city;

    public ECCityInfo(String str, String str2) {
        this.province = str;
        this.city = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsCurrentLocation() {
        return this.isCurrentLocation;
    }

    public final void c(boolean z16) {
        this.isCurrentLocation = z16;
    }

    public int hashCode() {
        String str = this.province;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.city;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECCityInfo(province=" + this.province + ", city=" + this.city + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECCityInfo)) {
            return false;
        }
        ECCityInfo eCCityInfo = (ECCityInfo) other;
        return Intrinsics.areEqual(this.province, eCCityInfo.province) && Intrinsics.areEqual(this.city, eCCityInfo.city);
    }
}
