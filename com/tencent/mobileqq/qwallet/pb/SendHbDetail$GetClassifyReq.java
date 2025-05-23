package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$GetClassifyReq extends MessageMicro<SendHbDetail$GetClassifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"subchannel", "ver"}, new Object[]{0, 0}, SendHbDetail$GetClassifyReq.class);
    public final PBEnumField subchannel = PBField.initEnum(0);
    public final PBInt32Field ver = PBField.initInt32(0);
}
