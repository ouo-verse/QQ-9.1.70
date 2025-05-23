package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TimDocSSOMsg$GetTipFlagReqBody extends MessageMicro<TimDocSSOMsg$GetTipFlagReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_appid", "msg_login_info", "uint32_type"}, new Object[]{0, null, 0}, TimDocSSOMsg$GetTipFlagReqBody.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public TimDocSSOMsg$LoginInfo msg_login_info = new TimDocSSOMsg$LoginInfo();
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}
