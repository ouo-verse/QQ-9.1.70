package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class CouponProto$RemoveBusinessFavourResp extends MessageMicro<CouponProto$RemoveBusinessFavourResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"retcode", "ts"}, new Object[]{0, 0L}, CouponProto$RemoveBusinessFavourResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f342193ts = PBField.initUInt64(0);
}
