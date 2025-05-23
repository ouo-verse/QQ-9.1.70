package com.tencent.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_0xfe1$UserDataInfo extends MessageMicro<oidb_0xfe1$UserDataInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"map_uint64_values", "map_bytes_values"}, new Object[]{null, null}, oidb_0xfe1$UserDataInfo.class);
    public final PBRepeatMessageField<oidb_0xfe1$UserDataInfoIntItem> map_uint64_values = PBField.initRepeatMessage(oidb_0xfe1$UserDataInfoIntItem.class);
    public final PBRepeatMessageField<oidb_0xfe1$UserDataInfoBytesItem> map_bytes_values = PBField.initRepeatMessage(oidb_0xfe1$UserDataInfoBytesItem.class);
}
