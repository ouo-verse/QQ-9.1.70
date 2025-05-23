package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayAccountPB$UIN extends MessageMicro<PayAccountPB$UIN> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"uin", "salt", "version", "signature"}, new Object[]{"", "", "", ""}, PayAccountPB$UIN.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField salt = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
}
