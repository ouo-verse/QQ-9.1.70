package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$AuditExtra extends MessageMicro<ClientPerformance$AuditExtra> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"comment", "bug_url"}, new Object[]{"", ""}, ClientPerformance$AuditExtra.class);
    public final PBStringField comment = PBField.initString("");
    public final PBStringField bug_url = PBField.initString("");
}
