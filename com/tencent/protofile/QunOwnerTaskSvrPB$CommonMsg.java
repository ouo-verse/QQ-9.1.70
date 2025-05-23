package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$CommonMsg extends MessageMicro<QunOwnerTaskSvrPB$CommonMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{"task_id", "sub_task_id", "title", "content", "publish_time", "jump_url"}, new Object[]{"", "", "", "", 0L, ""}, QunOwnerTaskSvrPB$CommonMsg.class);
    public final PBStringField task_id = PBField.initString("");
    public final PBStringField sub_task_id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBInt64Field publish_time = PBField.initInt64(0);
    public final PBStringField jump_url = PBField.initString("");
}
