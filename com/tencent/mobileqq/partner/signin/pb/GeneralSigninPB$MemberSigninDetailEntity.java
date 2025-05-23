package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$MemberSigninDetailEntity extends MessageMicro<GeneralSigninPB$MemberSigninDetailEntity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", null}, GeneralSigninPB$MemberSigninDetailEntity.class);
    public final PBStringField key = PBField.initString("");
    public GeneralSigninPB$MemberSigninDetail value = new GeneralSigninPB$MemberSigninDetail();
}
