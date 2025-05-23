package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class KidModePassword$VerifyPasswdRsp extends MessageMicro<KidModePassword$VerifyPasswdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "signature"}, new Object[]{0, "", ""}, KidModePassword$VerifyPasswdRsp.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
}
