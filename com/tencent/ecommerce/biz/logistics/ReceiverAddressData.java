package com.tencent.ecommerce.biz.logistics;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/s;", "Lcom/tencent/ecommerce/biz/logistics/n;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "a", "()I", "type", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "c", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "d", "statusIconResId", "e", "textColorResID", "<init>", "(ILcom/tencent/ecommerce/biz/orders/address/ECAddress;II)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.logistics.s, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ReceiverAddressData extends n {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECAddress address;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int statusIconResId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textColorResID;

    public /* synthetic */ ReceiverAddressData(int i3, ECAddress eCAddress, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 1 : i3, eCAddress, i16, i17);
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
        ECAddress eCAddress = this.address;
        return ((((type + (eCAddress != null ? eCAddress.hashCode() : 0)) * 31) + this.statusIconResId) * 31) + this.textColorResID;
    }

    public String toString() {
        return "ReceiverAddressData(type=" + getType() + ", address=" + this.address + ", statusIconResId=" + this.statusIconResId + ", textColorResID=" + this.textColorResID + ")";
    }

    public ReceiverAddressData(int i3, ECAddress eCAddress, int i16, int i17) {
        super(i3, null);
        this.type = i3;
        this.address = eCAddress;
        this.statusIconResId = i16;
        this.textColorResID = i17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiverAddressData)) {
            return false;
        }
        ReceiverAddressData receiverAddressData = (ReceiverAddressData) other;
        return getType() == receiverAddressData.getType() && Intrinsics.areEqual(this.address, receiverAddressData.address) && this.statusIconResId == receiverAddressData.statusIconResId && this.textColorResID == receiverAddressData.textColorResID;
    }
}
