package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class KidModePassword$VerifySignatureReq extends MessageMicro<KidModePassword$VerifySignatureReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"acct_type", "account", "scene_id", "signature", "login_sig"}, new Object[]{0, "", 0, "", null}, KidModePassword$VerifySignatureReq.class);
    public final PBEnumField acct_type = PBField.initEnum(0);
    public final PBStringField account = PBField.initString("");
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBStringField signature = PBField.initString("");
    public KidModePassword$LoginSig login_sig = new KidModePassword$LoginSig();
}
