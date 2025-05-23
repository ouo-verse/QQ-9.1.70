package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$UinRange extends MessageMicro<oidb_0x496$UinRange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start_uin", "end_uin"}, new Object[]{0L, 0L}, oidb_0x496$UinRange.class);
    public final PBUInt64Field start_uin = PBField.initUInt64(0);
    public final PBUInt64Field end_uin = PBField.initUInt64(0);
}
