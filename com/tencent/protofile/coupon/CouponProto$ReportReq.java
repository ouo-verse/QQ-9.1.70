package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class CouponProto$ReportReq extends MessageMicro<CouponProto$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "data"}, new Object[]{0, ""}, CouponProto$ReportReq.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField data = PBField.initString("");
}
