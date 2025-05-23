package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$GetPadRightInfoReqBody extends MessageMicro<TimDocSSOMsg$GetPadRightInfoReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid;
    public final PBBytesField bytes_pad_url;
    public TimDocSSOMsg$LoginInfo msg_login_info;
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_domainid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"uint32_appid", "bytes_pad_url", "msg_login_info", "uint32_domainid", "bytes_localpadid"}, new Object[]{0, byteStringMicro, null, 0, byteStringMicro}, TimDocSSOMsg$GetPadRightInfoReqBody.class);
    }

    public TimDocSSOMsg$GetPadRightInfoReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pad_url = PBField.initBytes(byteStringMicro);
        this.msg_login_info = new TimDocSSOMsg$LoginInfo();
        this.uint32_domainid = PBField.initUInt32(0);
        this.bytes_localpadid = PBField.initBytes(byteStringMicro);
    }
}
