package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$SigninCount extends MessageMicro<GeneralSigninPB$SigninCount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"accumulative_signin_days", "continuous_signin_days"}, new Object[]{0L, 0L}, GeneralSigninPB$SigninCount.class);
    public final PBInt64Field accumulative_signin_days = PBField.initInt64(0);
    public final PBInt64Field continuous_signin_days = PBField.initInt64(0);
}
