package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$ReportMsgReq extends MessageMicro<QunOwnerTaskSvrPB$ReportMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sub_task_ids"}, new Object[]{""}, QunOwnerTaskSvrPB$ReportMsgReq.class);
    public final PBRepeatField<String> sub_task_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
