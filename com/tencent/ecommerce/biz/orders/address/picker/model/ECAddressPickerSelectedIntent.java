package com.tencent.ecommerce.biz.orders.address.picker.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/e;", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "a", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "()Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "selectedDistrictAddressInfo", "<init>", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.address.picker.model.e, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAddressPickerSelectedIntent extends d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final DistrictAddressInfo selectedDistrictAddressInfo;

    /* renamed from: a, reason: from getter */
    public final DistrictAddressInfo getSelectedDistrictAddressInfo() {
        return this.selectedDistrictAddressInfo;
    }

    public int hashCode() {
        DistrictAddressInfo districtAddressInfo = this.selectedDistrictAddressInfo;
        if (districtAddressInfo != null) {
            return districtAddressInfo.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ECAddressPickerSelectedIntent(selectedDistrictAddressInfo=" + this.selectedDistrictAddressInfo + ")";
    }

    public ECAddressPickerSelectedIntent(DistrictAddressInfo districtAddressInfo) {
        super(null);
        this.selectedDistrictAddressInfo = districtAddressInfo;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ECAddressPickerSelectedIntent) && Intrinsics.areEqual(this.selectedDistrictAddressInfo, ((ECAddressPickerSelectedIntent) other).selectedDistrictAddressInfo);
        }
        return true;
    }
}
