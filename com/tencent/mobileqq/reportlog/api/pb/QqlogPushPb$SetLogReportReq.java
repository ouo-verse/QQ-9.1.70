package com.tencent.mobileqq.reportlog.api.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class QqlogPushPb$SetLogReportReq extends MessageMicro<QqlogPushPb$SetLogReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64}, new String[]{"seq", "product", "platform", "uins", "start_time", "end_time", "xg_log_size", "log_field"}, new Object[]{0, "", "", "", 0L, 0L, 0, 0L}, QqlogPushPb$SetLogReportReq.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBStringField product = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBStringField uins = PBField.initString("");
    public final PBInt64Field start_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
    public final PBInt32Field xg_log_size = PBField.initInt32(0);
    public final PBInt64Field log_field = PBField.initInt64(0);
}
