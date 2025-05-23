package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class CouponProto$MyCouponFavourListResp extends MessageMicro<CouponProto$MyCouponFavourListResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"retcode", "coupons", "ts"}, new Object[]{0, null, 0L}, CouponProto$MyCouponFavourListResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatMessageField<CouponProto$Coupon> coupons = PBField.initRepeatMessage(CouponProto$Coupon.class);

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f342192ts = PBField.initUInt64(0);
}
