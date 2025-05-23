package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$BusSigninDetailEntity extends MessageMicro<GeneralSigninPB$BusSigninDetailEntity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", null}, GeneralSigninPB$BusSigninDetailEntity.class);
    public final PBStringField key = PBField.initString("");
    public GeneralSigninPB$BusSigninDetail value = new GeneralSigninPB$BusSigninDetail();
}
