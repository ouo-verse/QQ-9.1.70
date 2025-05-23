package com.tencent.protofile.source;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class QunSourceSvrPB$ApplyReportReq extends MessageMicro<QunSourceSvrPB$ApplyReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_id", "src_id"}, new Object[]{0L, ""}, QunSourceSvrPB$ApplyReportReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBStringField src_id = PBField.initString("");
}
