package com.huawei.hms.support.api.entity.hwid;

import com.huawei.hms.support.api.entity.common.CommonConstant;

/* compiled from: P */
/* loaded from: classes2.dex */
public class QueryShippingAddressResp extends IHwIDRespEntity {

    @Checked(permission = CommonConstant.PERMISSION.SHIPPING_ADDRESS, scope = CommonConstant.SCOPE.SCOPE_ACCOUNT_SHIPPING_ADDRESS, value = CommonConstant.RETKEY.SHIPPING_ADDRESS)
    private ShippingAddressParcelable shippingAddressParcelable;

    public ShippingAddressParcelable getShippingAddressParcelable() {
        return this.shippingAddressParcelable;
    }
}
