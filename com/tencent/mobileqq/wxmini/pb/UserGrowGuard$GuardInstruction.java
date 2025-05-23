package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class UserGrowGuard$GuardInstruction extends MessageMicro<UserGrowGuard$GuardInstruction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 66, 74, 80, 90, 98, 104}, new String[]{"type", "title", "msg", "url", "modal", "data", "rule_name", "rule_family", "logout_time", "instr_trace_id", "btn_text", "report_scene"}, new Object[]{0, "", "", "", 0, "", "", "", 0L, "", "", 0}, UserGrowGuard$GuardInstruction.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f327804msg = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field modal = PBField.initInt32(0);
    public final PBStringField data = PBField.initString("");
    public final PBStringField rule_name = PBField.initString("");
    public final PBStringField rule_family = PBField.initString("");
    public final PBInt64Field logout_time = PBField.initInt64(0);
    public final PBStringField instr_trace_id = PBField.initString("");
    public final PBStringField btn_text = PBField.initString("");
    public final PBInt32Field report_scene = PBField.initInt32(0);
}
