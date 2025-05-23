package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponItem extends MessageMicro<ECCouponCommon$CouponItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 42, 56, 64, 72}, new String[]{"coupon_id", "user_id", "coupon_batch_id", "basic_info", "status", "revc_time", "modify_time"}, new Object[]{"", "", "", null, 0, 0L, 0L}, ECCouponCommon$CouponItem.class);
    public final PBStringField coupon_id = PBField.initString("");
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField coupon_batch_id = PBField.initString("");
    public ECCouponCommon$CouponBasicInfo basic_info = new ECCouponCommon$CouponBasicInfo();
    public final PBEnumField status = PBField.initEnum(0);
    public final PBInt64Field revc_time = PBField.initInt64(0);
    public final PBInt64Field modify_time = PBField.initInt64(0);
}
