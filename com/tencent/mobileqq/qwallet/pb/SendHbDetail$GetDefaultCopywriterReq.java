package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$GetDefaultCopywriterReq extends MessageMicro<SendHbDetail$GetDefaultCopywriterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"subchannel", "fromtype"}, new Object[]{0, 0}, SendHbDetail$GetDefaultCopywriterReq.class);
    public final PBEnumField subchannel = PBField.initEnum(0);
    public final PBInt32Field fromtype = PBField.initInt32(0);
}
