package com.tencent.ecommerce.biz.logistics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/t;", "Lcom/tencent/ecommerce/biz/logistics/n;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "a", "()I", "type", "c", "Ljava/lang/String;", "acceptTime", "d", "acceptStation", "e", "statusDesc", "f", "statusIconResId", "g", "textColorResID", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.logistics.t, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ShipDetailItemData extends n {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String acceptTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String acceptStation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String statusDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final int statusIconResId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textColorResID;

    public /* synthetic */ ShipDetailItemData(int i3, String str, String str2, String str3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 2 : i3, str, str2, str3, i16, i17);
    }

    @Override // com.tencent.ecommerce.biz.logistics.n
    /* renamed from: a, reason: from getter */
    public int getType() {
        return this.type;
    }

    /* renamed from: b, reason: from getter */
    public final int getTextColorResID() {
        return this.textColorResID;
    }

    public int hashCode() {
        int type = getType() * 31;
        String str = this.acceptTime;
        int hashCode = (type + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.acceptStation;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.statusDesc;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.statusIconResId) * 31) + this.textColorResID;
    }

    public String toString() {
        return "ShipDetailItemData(type=" + getType() + ", acceptTime=" + this.acceptTime + ", acceptStation=" + this.acceptStation + ", statusDesc=" + this.statusDesc + ", statusIconResId=" + this.statusIconResId + ", textColorResID=" + this.textColorResID + ")";
    }

    public ShipDetailItemData(int i3, String str, String str2, String str3, int i16, int i17) {
        super(i3, null);
        this.type = i3;
        this.acceptTime = str;
        this.acceptStation = str2;
        this.statusDesc = str3;
        this.statusIconResId = i16;
        this.textColorResID = i17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipDetailItemData)) {
            return false;
        }
        ShipDetailItemData shipDetailItemData = (ShipDetailItemData) other;
        return getType() == shipDetailItemData.getType() && Intrinsics.areEqual(this.acceptTime, shipDetailItemData.acceptTime) && Intrinsics.areEqual(this.acceptStation, shipDetailItemData.acceptStation) && Intrinsics.areEqual(this.statusDesc, shipDetailItemData.statusDesc) && this.statusIconResId == shipDetailItemData.statusIconResId && this.textColorResID == shipDetailItemData.textColorResID;
    }
}
