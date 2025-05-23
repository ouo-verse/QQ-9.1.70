package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$AppID extends MessageMicro<Qworkflow$AppID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_type", "uint64_appid"}, new Object[]{0, 0L}, Qworkflow$AppID.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
}
