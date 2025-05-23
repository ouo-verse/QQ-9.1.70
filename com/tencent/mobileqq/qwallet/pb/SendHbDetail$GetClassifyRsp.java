package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$GetClassifyRsp extends MessageMicro<SendHbDetail$GetClassifyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"code", "message", "ver", "classify"}, new Object[]{0, "", 0, null}, SendHbDetail$GetClassifyRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
    public final PBInt32Field ver = PBField.initInt32(0);
    public final PBRepeatMessageField<SendHbDetail$Classify> classify = PBField.initRepeatMessage(SendHbDetail$Classify.class);
}
