package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class StudentPB$VerifyCHSIWebPageRsp extends MessageMicro<StudentPB$VerifyCHSIWebPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"state", "msg"}, new Object[]{0, ""}, StudentPB$VerifyCHSIWebPageRsp.class);
    public final PBEnumField state = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f278709msg = PBField.initString("");
}
