package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class CouponProto$MyBusinessFavourListResp extends MessageMicro<CouponProto$MyBusinessFavourListResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"retcode", "businesses", "ts"}, new Object[]{0, null, 0L}, CouponProto$MyBusinessFavourListResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatMessageField<CouponProto$Business> businesses = PBField.initRepeatMessage(CouponProto$Business.class);

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f342190ts = PBField.initUInt64(0);
}
