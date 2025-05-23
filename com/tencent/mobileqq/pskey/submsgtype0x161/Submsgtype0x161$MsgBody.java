package com.tencent.mobileqq.pskey.submsgtype0x161;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class Submsgtype0x161$MsgBody extends MessageMicro<Submsgtype0x161$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"timestamp", "kick_all", "rpt_str_kick_domains"}, new Object[]{0L, Boolean.FALSE, ""}, Submsgtype0x161$MsgBody.class);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public final PBBoolField kick_all = PBField.initBool(false);
    public final PBRepeatField<String> rpt_str_kick_domains = PBField.initRepeat(PBStringField.__repeatHelper__);
}
