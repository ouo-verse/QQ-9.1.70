package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponShowStyleInfo extends MessageMicro<ECCouponCommon$CouponShowStyleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 162, 242, 322, 402}, new String[]{"coupon_type_name", "coupon_issuer_name", "coupon_usable_range", "coupon_use_rule", "coupon_time_scope", "coupon_show_discount"}, new Object[]{"", "", "", "", "", null}, ECCouponCommon$CouponShowStyleInfo.class);
    public final PBStringField coupon_type_name = PBField.initString("");
    public final PBStringField coupon_issuer_name = PBField.initString("");
    public final PBStringField coupon_usable_range = PBField.initString("");
    public final PBStringField coupon_use_rule = PBField.initString("");
    public final PBStringField coupon_time_scope = PBField.initString("");
    public ECCouponCommon$ShowDiscount coupon_show_discount = new ECCouponCommon$ShowDiscount();
}
