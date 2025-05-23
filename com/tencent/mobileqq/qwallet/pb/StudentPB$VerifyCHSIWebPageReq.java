package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class StudentPB$VerifyCHSIWebPageReq extends MessageMicro<StudentPB$VerifyCHSIWebPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"token", "source_code"}, new Object[]{"", ""}, StudentPB$VerifyCHSIWebPageReq.class);
    public final PBStringField token = PBField.initString("");
    public final PBStringField source_code = PBField.initString("");
}
