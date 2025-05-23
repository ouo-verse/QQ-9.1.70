package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Crm$QidianGroupMsg extends MessageMicro<Crm$QidianGroupMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_group_task_id", "uint32_group_msg_type", "uint64_kfuin", "uint32_show_tip", "str_tip_text"}, new Object[]{0, 0, 0L, 0, ""}, Crm$QidianGroupMsg.class);
    public final PBUInt32Field uint32_group_task_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_show_tip = PBField.initUInt32(0);
    public final PBStringField str_tip_text = PBField.initString("");
}
