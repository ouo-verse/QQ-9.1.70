package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes18.dex */
public final class KidModePassword$SHA256Rounds2Params extends MessageMicro<KidModePassword$SHA256Rounds2Params> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"salt"}, new Object[]{""}, KidModePassword$SHA256Rounds2Params.class);
    public final PBStringField salt = PBField.initString("");
}
