package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class SendHbDetail$GetPronReq extends MessageMicro<SendHbDetail$GetPronReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"word"}, new Object[]{""}, SendHbDetail$GetPronReq.class);
    public final PBStringField word = PBField.initString("");
}
