package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$MemberSigninDetail extends MessageMicro<GeneralSigninPB$MemberSigninDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"count", "list", "status_list"}, new Object[]{null, null, ""}, GeneralSigninPB$MemberSigninDetail.class);
    public GeneralSigninPB$SigninCount count = new GeneralSigninPB$SigninCount();
    public final PBRepeatMessageField<GeneralSigninPB$SigninDataEntity> list = PBField.initRepeatMessage(GeneralSigninPB$SigninDataEntity.class);
    public final PBStringField status_list = PBField.initString("");
}
