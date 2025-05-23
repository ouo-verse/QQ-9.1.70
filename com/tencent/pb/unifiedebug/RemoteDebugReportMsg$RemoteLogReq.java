package com.tencent.pb.unifiedebug;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class RemoteDebugReportMsg$RemoteLogReq extends MessageMicro<RemoteDebugReportMsg$RemoteLogReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_seq", "str_data"}, new Object[]{"", ""}, RemoteDebugReportMsg$RemoteLogReq.class);
    public final PBStringField str_seq = PBField.initString("");
    public final PBStringField str_data = PBField.initString("");
}
