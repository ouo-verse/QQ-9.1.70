package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$Timespan extends MessageMicro<Qworkflow$Timespan> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_start_time", "uint64_end_time"}, new Object[]{0L, 0L}, Qworkflow$Timespan.class);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
}
