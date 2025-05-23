package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$ShowDiscount extends MessageMicro<ECCouponCommon$ShowDiscount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 122, 160}, new String[]{"discount_amount", "discount_threshold", "discount_simple_lable", "type"}, new Object[]{"", "", "", 0}, ECCouponCommon$ShowDiscount.class);
    public final PBStringField discount_amount = PBField.initString("");
    public final PBStringField discount_threshold = PBField.initString("");
    public final PBStringField discount_simple_lable = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
}
