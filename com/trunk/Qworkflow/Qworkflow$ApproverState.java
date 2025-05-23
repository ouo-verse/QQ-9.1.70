package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$ApproverState extends MessageMicro<Qworkflow$ApproverState> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint32_state", "uint32_bepushed_times", "bytes_comment", "uint32_last_bepushed_time", "uint64_approve_time"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0, 0L}, Qworkflow$ApproverState.class);
    public final PBUInt32Field uint32_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bepushed_times = PBField.initUInt32(0);
    public final PBBytesField bytes_comment = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_last_bepushed_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_approve_time = PBField.initUInt64(0);
}
