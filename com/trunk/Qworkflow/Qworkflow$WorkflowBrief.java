package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$WorkflowBrief extends MessageMicro<Qworkflow$WorkflowBrief> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 56}, new String[]{"bytes_workflow_id", "uint64_author_uin", "uint64_last_modify_time", "uint64_create_time", "msg_extend_state", "uint32_data_version", "uint64_recv_time"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0L, 0L, null, 0, 0L}, Qworkflow$WorkflowBrief.class);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_last_modify_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0);
    public Qworkflow$WorkflowExtendState msg_extend_state = new Qworkflow$WorkflowExtendState();
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0);
}
