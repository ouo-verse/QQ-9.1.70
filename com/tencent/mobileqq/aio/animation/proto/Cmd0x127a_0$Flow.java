package com.tencent.mobileqq.aio.animation.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class Cmd0x127a_0$Flow extends MessageMicro<Cmd0x127a_0$Flow> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"scope", "action", "target", "time", "info"}, new Object[]{"", "", 0L, 0L, null}, Cmd0x127a_0$Flow.class);
    public final PBStringField scope = PBField.initString("");
    public final PBStringField action = PBField.initString("");
    public final PBUInt64Field target = PBField.initUInt64(0);
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBRepeatMessageField<Cmd0x127a_0$Info> info = PBField.initRepeatMessage(Cmd0x127a_0$Info.class);
}
