package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class cmd0x6d1$ItemInfo extends MessageMicro<cmd0x6d1$ItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "str_id"}, new Object[]{0L, ""}, cmd0x6d1$ItemInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBStringField str_id = PBField.initString("");
}
