package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TimDocSSOMsg$BatchGetRspBody extends MessageMicro<TimDocSSOMsg$BatchGetRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_retcode", "rpt_msg_pad_list"}, new Object[]{0, null}, TimDocSSOMsg$BatchGetRspBody.class);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBRepeatMessageField<TimDocSSOMsg$PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg$PadInfo.class);
}
