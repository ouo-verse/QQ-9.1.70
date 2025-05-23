package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrder$SellerOrderOptions extends MessageMicro<ECOrder$SellerOrderOptions> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 80, 88, 160, 242, 320}, new String[]{"keyword", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", "state", "saas_type", "settlement_state"}, new Object[]{"", 0L, 0L, 0, "", 0}, ECOrder$SellerOrderOptions.class);
    public final PBStringField keyword = PBField.initString("");
    public final PBInt64Field begin_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
    public final PBRepeatField<Integer> state = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatField<String> saas_type = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field settlement_state = PBField.initInt32(0);
}
