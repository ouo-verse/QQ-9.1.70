package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$SigninReq extends MessageMicro<GeneralSigninPB$SigninReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bus_id", "target", "sub_bus_id", "source"}, new Object[]{"", "", "", ""}, GeneralSigninPB$SigninReq.class);
    public final PBStringField bus_id = PBField.initString("");
    public final PBStringField target = PBField.initString("");
    public final PBStringField sub_bus_id = PBField.initString("");
    public final PBStringField source = PBField.initString("");
}
