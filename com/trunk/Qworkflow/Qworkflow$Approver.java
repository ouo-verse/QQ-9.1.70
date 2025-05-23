package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$Approver extends MessageMicro<Qworkflow$Approver> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"uint64_uin", "msg_approver_source", "msg_approver_state", "bytes_userdef", "uint64_recv_time"}, new Object[]{0L, null, null, ByteStringMicro.EMPTY, 0L}, Qworkflow$Approver.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public Qworkflow$UserSource msg_approver_source = new Qworkflow$UserSource();
    public Qworkflow$ApproverState msg_approver_state = new Qworkflow$ApproverState();
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0);
}
