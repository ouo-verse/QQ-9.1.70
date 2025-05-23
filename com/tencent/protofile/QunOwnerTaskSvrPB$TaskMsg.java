package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$TaskMsg extends MessageMicro<QunOwnerTaskSvrPB$TaskMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"task_num", "latest_task_time", "jump_url", "total_task_num", "task_report_info"}, new Object[]{0, 0, "", 0, ""}, QunOwnerTaskSvrPB$TaskMsg.class);
    public final PBUInt32Field task_num = PBField.initUInt32(0);
    public final PBUInt32Field latest_task_time = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field total_task_num = PBField.initUInt32(0);
    public final PBStringField task_report_info = PBField.initString("");
}
