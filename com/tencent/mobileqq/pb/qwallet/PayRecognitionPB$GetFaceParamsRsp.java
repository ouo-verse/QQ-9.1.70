package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayRecognitionPB$GetFaceParamsRsp extends MessageMicro<PayRecognitionPB$GetFaceParamsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"token_id", "openid", "appid", "tmpkey"}, new Object[]{"", "", "", ""}, PayRecognitionPB$GetFaceParamsRsp.class);
    public final PBStringField token_id = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField tmpkey = PBField.initString("");
}
