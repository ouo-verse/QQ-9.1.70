package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponPrice extends MessageMicro<ECCouponCommon$CouponPrice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"origin_price", "coupon_price"}, new Object[]{0L, 0L}, ECCouponCommon$CouponPrice.class);
    public final PBUInt64Field origin_price = PBField.initUInt64(0);
    public final PBUInt64Field coupon_price = PBField.initUInt64(0);
}
