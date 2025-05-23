package com.tencent.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_0xfe1$RspBody extends MessageMicro<oidb_0xfe1$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_userdata", "rpt_uint64_unfinished_uin"}, new Object[]{null, 0L}, oidb_0xfe1$RspBody.class);
    public final PBRepeatMessageField<oidb_0xfe1$UserData> rpt_msg_userdata = PBField.initRepeatMessage(oidb_0xfe1$UserData.class);
    public final PBRepeatField<Long> rpt_uint64_unfinished_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
