package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TimDocSSOMsg$SetTipFlagReqBody extends MessageMicro<TimDocSSOMsg$SetTipFlagReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_appid", "msg_login_info", "uint32_type", "uint32_flag"}, new Object[]{0, null, 0, 0}, TimDocSSOMsg$SetTipFlagReqBody.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public TimDocSSOMsg$LoginInfo msg_login_info = new TimDocSSOMsg$LoginInfo();
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
}
