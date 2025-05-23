package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$GetDefaultCopywriterRsp extends MessageMicro<SendHbDetail$GetDefaultCopywriterRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "message", "copywriter"}, new Object[]{0, "", null}, SendHbDetail$GetDefaultCopywriterRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
    public final PBRepeatMessageField<SendHbDetail$CopyWriter> copywriter = PBField.initRepeatMessage(SendHbDetail$CopyWriter.class);
}
