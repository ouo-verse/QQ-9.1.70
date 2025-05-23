package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$SettingEntity extends MessageMicro<GeneralSigninPB$SettingEntity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, GeneralSigninPB$SettingEntity.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
