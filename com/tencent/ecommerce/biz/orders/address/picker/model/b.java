package com.tencent.ecommerce.biz.orders.address.picker.model;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/DistrictType;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {
    public static final DistrictType a(DistrictType districtType) {
        DistrictType[] values = DistrictType.values();
        return values[(districtType.ordinal() + 1) % values.length];
    }
}
