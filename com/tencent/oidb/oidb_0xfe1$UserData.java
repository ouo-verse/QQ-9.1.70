package com.tencent.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_0xfe1$UserData extends MessageMicro<oidb_0xfe1$UserData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_fuin", "msg_data"}, new Object[]{0L, null}, oidb_0xfe1$UserData.class);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0);
    public oidb_0xfe1$UserDataInfo msg_data = new oidb_0xfe1$UserDataInfo();
}
