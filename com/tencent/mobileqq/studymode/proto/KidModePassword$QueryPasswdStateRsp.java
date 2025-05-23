package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class KidModePassword$QueryPasswdStateRsp extends MessageMicro<KidModePassword$QueryPasswdStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "state", "hash_method", "sha256_rounds2_params"}, new Object[]{0, "", 0, 0, null}, KidModePassword$QueryPasswdStateRsp.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBEnumField state = PBField.initEnum(0);
    public final PBEnumField hash_method = PBField.initEnum(0);
    public KidModePassword$SHA256Rounds2Params sha256_rounds2_params = new KidModePassword$SHA256Rounds2Params();
}
