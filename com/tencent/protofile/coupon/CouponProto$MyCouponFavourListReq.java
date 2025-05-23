package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class CouponProto$MyCouponFavourListReq extends MessageMicro<CouponProto$MyCouponFavourListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ts", "stype"}, new Object[]{0L, ""}, CouponProto$MyCouponFavourListReq.class);

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f342191ts = PBField.initUInt64(0);
    public final PBStringField stype = PBField.initString("");
}
