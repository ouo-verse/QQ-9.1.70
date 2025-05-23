package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$Observer extends MessageMicro<Qworkflow$Observer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "msg_observer_source"}, new Object[]{0L, null}, Qworkflow$Observer.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public Qworkflow$UserSource msg_observer_source = new Qworkflow$UserSource();
}
