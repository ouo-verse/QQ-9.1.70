package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class KidModePassword$SetPasswdReq extends MessageMicro<KidModePassword$SetPasswdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 56, 64, 74, 80}, new String[]{"acct_type", "account", "scene_id", "passwd_hash", "login_sig", "client_info", "timestamp", "nonce", "sha256_rounds2_params", "hash_method"}, new Object[]{0, "", 0, "", null, null, 0L, 0L, null, 0}, KidModePassword$SetPasswdReq.class);
    public final PBEnumField acct_type = PBField.initEnum(0);
    public final PBStringField account = PBField.initString("");
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBStringField passwd_hash = PBField.initString("");
    public KidModePassword$LoginSig login_sig = new KidModePassword$LoginSig();
    public KidModePassword$ClientInfo client_info = new KidModePassword$ClientInfo();
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBInt64Field nonce = PBField.initInt64(0);
    public KidModePassword$SHA256Rounds2Params sha256_rounds2_params = new KidModePassword$SHA256Rounds2Params();
    public final PBEnumField hash_method = PBField.initEnum(0);
}
