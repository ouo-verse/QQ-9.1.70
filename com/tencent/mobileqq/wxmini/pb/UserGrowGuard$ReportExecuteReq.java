package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class UserGrowGuard$ReportExecuteReq extends MessageMicro<UserGrowGuard$ReportExecuteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"appid", "instr_trace_id", "exec_time", "rule_name"}, new Object[]{"", "", 0L, ""}, UserGrowGuard$ReportExecuteReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField instr_trace_id = PBField.initString("");
    public final PBInt64Field exec_time = PBField.initInt64(0);
    public final PBStringField rule_name = PBField.initString("");
}
