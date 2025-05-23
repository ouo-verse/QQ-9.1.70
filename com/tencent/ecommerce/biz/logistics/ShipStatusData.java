package com.tencent.ecommerce.biz.logistics;

import com.tencent.ecommerce.biz.orders.common.PackageInfo;
import com.tencent.ecommerce.biz.orders.common.ShipperCompany;
import com.tencent.ecommerce.biz.orders.common.TrailStatusInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\n\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/u;", "Lcom/tencent/ecommerce/biz/logistics/n;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "a", "()I", "type", "c", "Ljava/lang/String;", "shipCode", "Lcom/tencent/ecommerce/biz/orders/common/l;", "d", "Lcom/tencent/ecommerce/biz/orders/common/l;", "shipperCompany", "Lcom/tencent/ecommerce/biz/orders/common/h;", "e", "Lcom/tencent/ecommerce/biz/orders/common/h;", "packageInfo", "Lcom/tencent/ecommerce/biz/orders/common/m;", "f", "Lcom/tencent/ecommerce/biz/orders/common/m;", "()Lcom/tencent/ecommerce/biz/orders/common/m;", "currentStatus", "<init>", "(ILjava/lang/String;Lcom/tencent/ecommerce/biz/orders/common/l;Lcom/tencent/ecommerce/biz/orders/common/h;Lcom/tencent/ecommerce/biz/orders/common/m;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.logistics.u, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ShipStatusData extends n {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shipCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final ShipperCompany shipperCompany;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final PackageInfo packageInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final TrailStatusInfo currentStatus;

    public /* synthetic */ ShipStatusData(int i3, String str, ShipperCompany shipperCompany, PackageInfo packageInfo, TrailStatusInfo trailStatusInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, str, shipperCompany, packageInfo, trailStatusInfo);
    }

    @Override // com.tencent.ecommerce.biz.logistics.n
    /* renamed from: a, reason: from getter */
    public int getType() {
        return this.type;
    }

    /* renamed from: b, reason: from getter */
    public final TrailStatusInfo getCurrentStatus() {
        return this.currentStatus;
    }

    public int hashCode() {
        int type = getType() * 31;
        String str = this.shipCode;
        int hashCode = (type + (str != null ? str.hashCode() : 0)) * 31;
        ShipperCompany shipperCompany = this.shipperCompany;
        int hashCode2 = (hashCode + (shipperCompany != null ? shipperCompany.hashCode() : 0)) * 31;
        PackageInfo packageInfo = this.packageInfo;
        int hashCode3 = (hashCode2 + (packageInfo != null ? packageInfo.hashCode() : 0)) * 31;
        TrailStatusInfo trailStatusInfo = this.currentStatus;
        return hashCode3 + (trailStatusInfo != null ? trailStatusInfo.hashCode() : 0);
    }

    public String toString() {
        return "ShipStatusData(type=" + getType() + ", shipCode=" + this.shipCode + ", shipperCompany=" + this.shipperCompany + ", packageInfo=" + this.packageInfo + ", currentStatus=" + this.currentStatus + ")";
    }

    public ShipStatusData(int i3, String str, ShipperCompany shipperCompany, PackageInfo packageInfo, TrailStatusInfo trailStatusInfo) {
        super(i3, null);
        this.type = i3;
        this.shipCode = str;
        this.shipperCompany = shipperCompany;
        this.packageInfo = packageInfo;
        this.currentStatus = trailStatusInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipStatusData)) {
            return false;
        }
        ShipStatusData shipStatusData = (ShipStatusData) other;
        return getType() == shipStatusData.getType() && Intrinsics.areEqual(this.shipCode, shipStatusData.shipCode) && Intrinsics.areEqual(this.shipperCompany, shipStatusData.shipperCompany) && Intrinsics.areEqual(this.packageInfo, shipStatusData.packageInfo) && Intrinsics.areEqual(this.currentStatus, shipStatusData.currentStatus);
    }
}
