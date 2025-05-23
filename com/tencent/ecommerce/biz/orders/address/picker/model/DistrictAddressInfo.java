package com.tencent.ecommerce.biz.orders.address.picker.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/DistrictType;", "type", "", "name", "", "id", "pingYin", "a", "toString", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/DistrictType;", "b", "Ljava/lang/String;", "c", "I", "()I", "setId", "(I)V", "d", "()Ljava/lang/String;", "<init>", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/DistrictType;Ljava/lang/String;ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.address.picker.model.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class DistrictAddressInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final DistrictType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int id;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String pingYin;

    public DistrictAddressInfo(DistrictType districtType, String str, int i3, String str2) {
        this.type = districtType;
        this.name = str;
        this.id = i3;
        this.pingYin = str2;
    }

    public final DistrictAddressInfo a(DistrictType type, String name, int id5, String pingYin) {
        return new DistrictAddressInfo(type, name, id5, pingYin);
    }

    /* renamed from: c, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final String getPingYin() {
        return this.pingYin;
    }

    public int hashCode() {
        DistrictType districtType = this.type;
        int hashCode = (districtType != null ? districtType.hashCode() : 0) * 31;
        String str = this.name;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.id) * 31;
        String str2 = this.pingYin;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DistrictAddressInfo(type=" + this.type + ", name=" + this.name + ", id=" + this.id + ", pingYin=" + this.pingYin + ")";
    }

    public /* synthetic */ DistrictAddressInfo(DistrictType districtType, String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(districtType, str, (i16 & 4) != 0 ? -1 : i3, (i16 & 8) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DistrictAddressInfo)) {
            return false;
        }
        DistrictAddressInfo districtAddressInfo = (DistrictAddressInfo) other;
        return Intrinsics.areEqual(this.type, districtAddressInfo.type) && Intrinsics.areEqual(this.name, districtAddressInfo.name) && this.id == districtAddressInfo.id && Intrinsics.areEqual(this.pingYin, districtAddressInfo.pingYin);
    }

    public static /* synthetic */ DistrictAddressInfo b(DistrictAddressInfo districtAddressInfo, DistrictType districtType, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            districtType = districtAddressInfo.type;
        }
        if ((i16 & 2) != 0) {
            str = districtAddressInfo.name;
        }
        if ((i16 & 4) != 0) {
            i3 = districtAddressInfo.id;
        }
        if ((i16 & 8) != 0) {
            str2 = districtAddressInfo.pingYin;
        }
        return districtAddressInfo.a(districtType, str, i3, str2);
    }
}
