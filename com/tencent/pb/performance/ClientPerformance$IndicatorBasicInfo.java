package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes22.dex */
public final class ClientPerformance$IndicatorBasicInfo extends MessageMicro<ClientPerformance$IndicatorBasicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"flag", QCircleAlphaUserReporter.KEY_USER, "test_case", "update_time"}, new Object[]{0, "", "", 0}, ClientPerformance$IndicatorBasicInfo.class);
    public final PBEnumField flag = PBField.initEnum(0);
    public final PBStringField user = PBField.initString("");
    public final PBStringField test_case = PBField.initString("");
    public final PBInt32Field update_time = PBField.initInt32(0);
}
