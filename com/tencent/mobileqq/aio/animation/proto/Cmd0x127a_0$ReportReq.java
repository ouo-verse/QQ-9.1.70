package com.tencent.mobileqq.aio.animation.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class Cmd0x127a_0$ReportReq extends MessageMicro<Cmd0x127a_0$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"flows"}, new Object[]{null}, Cmd0x127a_0$ReportReq.class);
    public final PBRepeatMessageField<Cmd0x127a_0$Flow> flows = PBField.initRepeatMessage(Cmd0x127a_0$Flow.class);
}
