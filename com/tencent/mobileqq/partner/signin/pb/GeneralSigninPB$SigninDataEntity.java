package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$SigninDataEntity extends MessageMicro<GeneralSigninPB$SigninDataEntity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", null}, GeneralSigninPB$SigninDataEntity.class);
    public final PBStringField key = PBField.initString("");
    public GeneralSigninPB$SigninData value = new GeneralSigninPB$SigninData();
}
