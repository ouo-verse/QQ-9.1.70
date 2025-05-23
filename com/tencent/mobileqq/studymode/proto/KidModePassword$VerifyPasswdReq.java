package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class KidModePassword$VerifyPasswdReq extends MessageMicro<KidModePassword$VerifyPasswdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 56, 64, 74}, new String[]{"acct_type", "account", "scene_id", "passwd_hash", "client_info", "timestamp", "nonce", "login_sig"}, new Object[]{0, "", 0, "", null, 0L, 0L, null}, KidModePassword$VerifyPasswdReq.class);
    public final PBEnumField acct_type = PBField.initEnum(0);
    public final PBStringField account = PBField.initString("");
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBStringField passwd_hash = PBField.initString("");
    public KidModePassword$ClientInfo client_info = new KidModePassword$ClientInfo();
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBInt64Field nonce = PBField.initInt64(0);
    public KidModePassword$LoginSig login_sig = new KidModePassword$LoginSig();
}
