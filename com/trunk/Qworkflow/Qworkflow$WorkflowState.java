package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$WorkflowState extends MessageMicro<Qworkflow$WorkflowState> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_state_num", "bytes_state_userdef"}, new Object[]{0, ByteStringMicro.EMPTY}, Qworkflow$WorkflowState.class);
    public final PBUInt32Field uint32_state_num = PBField.initUInt32(0);
    public final PBBytesField bytes_state_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
}
