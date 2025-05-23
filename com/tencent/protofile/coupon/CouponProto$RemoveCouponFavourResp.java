package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class CouponProto$RemoveCouponFavourResp extends MessageMicro<CouponProto$RemoveCouponFavourResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"retcode", "ts"}, new Object[]{0, 0L}, CouponProto$RemoveCouponFavourResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f342194ts = PBField.initUInt64(0);
}
