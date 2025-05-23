package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class CouponProto$IsValidCouponsResp extends MessageMicro<CouponProto$IsValidCouponsResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", "coupons"}, new Object[]{0, null}, CouponProto$IsValidCouponsResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatMessageField<CouponProto$Coupon> coupons = PBField.initRepeatMessage(CouponProto$Coupon.class);
}
