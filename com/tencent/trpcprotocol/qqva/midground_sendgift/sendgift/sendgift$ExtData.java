package com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sendgift$ExtData extends MessageMicro<sendgift$ExtData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext_key", "ext_value"}, new Object[]{"", ""}, sendgift$ExtData.class);
    public final PBStringField ext_key = PBField.initString("");
    public final PBStringField ext_value = PBField.initString("");
}
