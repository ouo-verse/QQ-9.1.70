package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "b", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "<init>", "(Lcom/tencent/ecommerce/biz/orders/address/ECAddress;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class AddressItemData extends p {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECAddress address;

    public int hashCode() {
        ECAddress eCAddress = this.address;
        if (eCAddress != null) {
            return eCAddress.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AddressItemData(address=" + this.address + ")";
    }

    public AddressItemData(ECAddress eCAddress) {
        super(1, null);
        this.address = eCAddress;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AddressItemData) && Intrinsics.areEqual(this.address, ((AddressItemData) other).address);
        }
        return true;
    }
}
