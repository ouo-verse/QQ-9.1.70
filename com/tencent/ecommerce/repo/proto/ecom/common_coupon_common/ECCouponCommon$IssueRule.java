package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$IssueRule extends MessageMicro<ECCouponCommon$IssueRule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"max_coupons", "max_coupon_per_user", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time"}, new Object[]{0, 0, 0L, 0L}, ECCouponCommon$IssueRule.class);
    public final PBInt32Field max_coupons = PBField.initInt32(0);
    public final PBInt32Field max_coupon_per_user = PBField.initInt32(0);
    public final PBInt64Field begin_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
}
