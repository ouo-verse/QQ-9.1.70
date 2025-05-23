package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class SigninPB$SignInInfo extends MessageMicro<SigninPB$SignInInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"mark_id", "siginin_detail", "detail_url"}, new Object[]{0L, null, ""}, SigninPB$SignInInfo.class);
    public final PBUInt64Field mark_id = PBField.initUInt64(0);
    public GeneralSigninPB$BusSigninDetail siginin_detail = new GeneralSigninPB$BusSigninDetail();
    public final PBStringField detail_url = PBField.initString("");
}
