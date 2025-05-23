package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$WorkflowExtendState extends MessageMicro<Qworkflow$WorkflowExtendState> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_read_state", "uint32_delete_state", "rpt_msg_delete_timespan"}, new Object[]{0, 0, null}, Qworkflow$WorkflowExtendState.class);
    public final PBUInt32Field uint32_read_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_delete_state = PBField.initUInt32(0);
    public final PBRepeatMessageField<Qworkflow$Timespan> rpt_msg_delete_timespan = PBField.initRepeatMessage(Qworkflow$Timespan.class);
}
