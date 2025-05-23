package com.tencent.ecommerce.repo.proto.ecom.coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponPrivilege extends MessageMicro<ECCouponCommon$CouponPrivilege> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"type", "cash_threshold", "discount_precent", "cash_discount"}, new Object[]{0, 0, 0, 0}, ECCouponCommon$CouponPrivilege.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBInt32Field cash_threshold = PBField.initInt32(0);
    public final PBInt32Field discount_precent = PBField.initInt32(0);
    public final PBInt32Field cash_discount = PBField.initInt32(0);
}
