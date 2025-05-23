package com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sendgift$BatchSendInfo extends MessageMicro<sendgift$BatchSendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"infos", "report_ext", "ext_dict"}, new Object[]{null, "", null}, sendgift$BatchSendInfo.class);
    public sendgift$OrderInfo infos = new sendgift$OrderInfo();
    public final PBStringField report_ext = PBField.initString("");
    public final PBRepeatMessageField<sendgift$ExtData> ext_dict = PBField.initRepeatMessage(sendgift$ExtData.class);
}
