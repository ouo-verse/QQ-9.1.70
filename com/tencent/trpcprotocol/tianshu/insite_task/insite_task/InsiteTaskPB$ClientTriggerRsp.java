package com.tencent.trpcprotocol.tianshu.insite_task.insite_task;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class InsiteTaskPB$ClientTriggerRsp extends MessageMicro<InsiteTaskPB$ClientTriggerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"trigger_interval_sec"}, new Object[]{0L}, InsiteTaskPB$ClientTriggerRsp.class);
    public final PBUInt64Field trigger_interval_sec = PBField.initUInt64(0);
}
