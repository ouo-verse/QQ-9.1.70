package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$CancelPinPadRspBody extends MessageMicro<TimDocSSOMsg$CancelPinPadRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid;
    public final PBBytesField bytes_pad_url;
    public final PBUInt32Field uint32_domainid;
    public final PBUInt32Field uint32_list_type;
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"uint32_retcode", "bytes_pad_url", "uint32_list_type", "uint32_domainid", "bytes_localpadid"}, new Object[]{0, byteStringMicro, 0, 0, byteStringMicro}, TimDocSSOMsg$CancelPinPadRspBody.class);
    }

    public TimDocSSOMsg$CancelPinPadRspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pad_url = PBField.initBytes(byteStringMicro);
        this.uint32_list_type = PBField.initUInt32(0);
        this.uint32_domainid = PBField.initUInt32(0);
        this.bytes_localpadid = PBField.initBytes(byteStringMicro);
    }
}
