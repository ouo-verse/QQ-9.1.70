package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes20.dex */
public final class WeiyunPB$PwdVerifyMsgRsp extends MessageMicro<WeiyunPB$PwdVerifyMsgRsp> {
    public static final int CS_SIG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cs_sig"}, new Object[]{ByteStringMicro.EMPTY}, WeiyunPB$PwdVerifyMsgRsp.class);
    public final PBBytesField cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
