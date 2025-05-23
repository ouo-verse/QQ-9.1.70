package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TimDocSSOMsg$UinRightInfo extends MessageMicro<TimDocSSOMsg$UinRightInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_uin_type", "uint64_uin", "uint32_right"}, new Object[]{0, 0L, 0}, TimDocSSOMsg$UinRightInfo.class);
    public final PBUInt32Field uint32_uin_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_right = PBField.initUInt32(0);
}
