package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TimDocSSOMsg$BatchGetReqBody extends MessageMicro<TimDocSSOMsg$BatchGetReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_appid", "msg_login_info", "rpt_msg_padid_list"}, new Object[]{0, null, null}, TimDocSSOMsg$BatchGetReqBody.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public TimDocSSOMsg$LoginInfo msg_login_info = new TimDocSSOMsg$LoginInfo();
    public final PBRepeatMessageField<TimDocSSOMsg$PadId> rpt_msg_padid_list = PBField.initRepeatMessage(TimDocSSOMsg$PadId.class);
}
