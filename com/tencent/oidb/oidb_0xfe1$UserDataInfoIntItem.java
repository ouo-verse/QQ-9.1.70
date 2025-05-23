package com.tencent.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_0xfe1$UserDataInfoIntItem extends MessageMicro<oidb_0xfe1$UserDataInfoIntItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_key", "uint64_value"}, new Object[]{0, 0L}, oidb_0xfe1$UserDataInfoIntItem.class);
    public final PBUInt32Field uint32_key = PBField.initUInt32(0);
    public final PBUInt64Field uint64_value = PBField.initUInt64(0);
}
