package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class StudentPB$ConfirmAuthRsp extends MessageMicro<StudentPB$ConfirmAuthRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"result"}, new Object[]{""}, StudentPB$ConfirmAuthRsp.class);
    public final PBStringField result = PBField.initString("");
}
