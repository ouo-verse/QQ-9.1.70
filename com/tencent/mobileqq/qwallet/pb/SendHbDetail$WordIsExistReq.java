package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$WordIsExistReq extends MessageMicro<SendHbDetail$WordIsExistReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"subchannel", "word"}, new Object[]{0, ""}, SendHbDetail$WordIsExistReq.class);
    public final PBEnumField subchannel = PBField.initEnum(0);
    public final PBStringField word = PBField.initString("");
}
