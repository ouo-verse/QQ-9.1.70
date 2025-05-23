package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$UseTimeRule extends MessageMicro<ECCouponCommon$UseTimeRule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", "day_after_receive"}, new Object[]{0L, 0L, 0}, ECCouponCommon$UseTimeRule.class);
    public final PBInt64Field begin_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
    public final PBInt32Field day_after_receive = PBField.initInt32(0);
}
