package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$Classify extends MessageMicro<SendHbDetail$Classify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "items"}, new Object[]{"", null}, SendHbDetail$Classify.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<SendHbDetail$ClassifyItem> items = PBField.initRepeatMessage(SendHbDetail$ClassifyItem.class);
}
