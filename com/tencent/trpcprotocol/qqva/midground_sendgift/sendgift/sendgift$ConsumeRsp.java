package com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sendgift$ConsumeRsp extends MessageMicro<sendgift$ConsumeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "msg"}, new Object[]{0L, ""}, sendgift$ConsumeRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381637msg = PBField.initString("");
}
