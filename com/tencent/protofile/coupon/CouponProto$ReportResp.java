package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class CouponProto$ReportResp extends MessageMicro<CouponProto$ReportResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"retcode"}, new Object[]{0}, CouponProto$ReportResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
}
