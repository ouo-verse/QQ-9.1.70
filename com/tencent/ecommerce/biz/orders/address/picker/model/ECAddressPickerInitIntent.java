package com.tencent.ecommerce.biz.orders.address.picker.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/c;", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "selectedAddress", "<init>", "(Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.address.picker.model.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAddressPickerInitIntent extends d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> selectedAddress;

    public final List<String> a() {
        return this.selectedAddress;
    }

    public int hashCode() {
        List<String> list = this.selectedAddress;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ECAddressPickerInitIntent(selectedAddress=" + this.selectedAddress + ")";
    }

    public ECAddressPickerInitIntent(List<String> list) {
        super(null);
        this.selectedAddress = list;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ECAddressPickerInitIntent) && Intrinsics.areEqual(this.selectedAddress, ((ECAddressPickerInitIntent) other).selectedAddress);
        }
        return true;
    }
}
