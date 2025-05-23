package com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sendgift$BatchErrInfo extends MessageMicro<sendgift$BatchErrInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"receiver_open_id"}, new Object[]{""}, sendgift$BatchErrInfo.class);
    public final PBStringField receiver_open_id = PBField.initString("");
}
