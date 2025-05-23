package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TimDocSSOMsg$GetTipFlagRspBody extends MessageMicro<TimDocSSOMsg$GetTipFlagRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_retcode", "uint32_flag"}, new Object[]{0, 0}, TimDocSSOMsg$GetTipFlagRspBody.class);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
}
