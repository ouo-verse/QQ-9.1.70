package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class SigActPb$RspBody extends MessageMicro<SigActPb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"ret", "desc", "cmd", "seq", "rsp", "auth_rsp"}, new Object[]{0, "", 0, 0L, null, null}, SigActPb$RspBody.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public SigActPb$SigactRsp rsp = new SigActPb$SigactRsp();
    public SigActPb$SigauthRsp auth_rsp = new SigActPb$SigauthRsp();
}
