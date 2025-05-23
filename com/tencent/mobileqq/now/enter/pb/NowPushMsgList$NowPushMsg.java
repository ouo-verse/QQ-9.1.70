package com.tencent.mobileqq.now.enter.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowPushMsgList$NowPushMsg extends MessageMicro<NowPushMsgList$NowPushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint32_type", "uint32_switch", "uint32_task_id", "uint64_start_time", "uint64_end_time", "uint32_version"}, new Object[]{0, 0, 0, 0L, 0L, 0L}, NowPushMsgList$NowPushMsg.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_task_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
    public final PBUInt64Field uint32_version = PBField.initUInt64(0);
}
