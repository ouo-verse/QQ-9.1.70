package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes20.dex */
public final class WeiyunPB$PwdVerifyMsgReq extends MessageMicro<WeiyunPB$PwdVerifyMsgReq> {
    public static final int CS_SIG_FIELD_NUMBER = 2;
    public static final int PWD_MD5_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cs_sig;
    public final PBBytesField pwd_md5;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pwd_md5", "cs_sig"}, new Object[]{byteStringMicro, byteStringMicro}, WeiyunPB$PwdVerifyMsgReq.class);
    }

    public WeiyunPB$PwdVerifyMsgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pwd_md5 = PBField.initBytes(byteStringMicro);
        this.cs_sig = PBField.initBytes(byteStringMicro);
    }
}
