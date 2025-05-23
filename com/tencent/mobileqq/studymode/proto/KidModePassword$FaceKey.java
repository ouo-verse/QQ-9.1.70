package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes18.dex */
public final class KidModePassword$FaceKey extends MessageMicro<KidModePassword$FaceKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"nonce", "id_key"}, new Object[]{"", ""}, KidModePassword$FaceKey.class);
    public final PBStringField nonce = PBField.initString("");
    public final PBStringField id_key = PBField.initString("");
}
