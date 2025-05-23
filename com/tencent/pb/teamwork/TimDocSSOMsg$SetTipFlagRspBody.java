package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TimDocSSOMsg$SetTipFlagRspBody extends MessageMicro<TimDocSSOMsg$SetTipFlagRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_retcode"}, new Object[]{0}, TimDocSSOMsg$SetTipFlagRspBody.class);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
}
