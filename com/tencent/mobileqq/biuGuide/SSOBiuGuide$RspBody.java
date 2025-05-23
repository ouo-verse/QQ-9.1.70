package com.tencent.mobileqq.biuGuide;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class SSOBiuGuide$RspBody extends MessageMicro<SSOBiuGuide$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"ret_info", "uint64_uin", "rpt_msg_uin_info"}, new Object[]{null, 0L, null}, SSOBiuGuide$RspBody.class);
    public SSOBiuGuide$RetInfo ret_info = new SSOBiuGuide$RetInfo();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<SSOBiuGuide$UinInfo> rpt_msg_uin_info = PBField.initRepeatMessage(SSOBiuGuide$UinInfo.class);
}
