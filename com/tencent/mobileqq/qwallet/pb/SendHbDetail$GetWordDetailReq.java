package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$GetWordDetailReq extends MessageMicro<SendHbDetail$GetWordDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"word"}, new Object[]{""}, SendHbDetail$GetWordDetailReq.class);
    public final PBStringField word = PBField.initString("");
}
