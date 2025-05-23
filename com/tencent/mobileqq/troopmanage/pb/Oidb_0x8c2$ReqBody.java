package com.tencent.mobileqq.troopmanage.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class Oidb_0x8c2$ReqBody extends MessageMicro<Oidb_0x8c2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_id", "text_msg"}, new Object[]{0L, ""}, Oidb_0x8c2$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBStringField text_msg = PBField.initString("");
}
