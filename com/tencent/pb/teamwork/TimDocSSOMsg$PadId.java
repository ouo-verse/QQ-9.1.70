package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$PadId extends MessageMicro<TimDocSSOMsg$PadId> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid;
    public final PBBytesField bytes_pad_url;
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_domainid", "bytes_localpadid", "bytes_pad_url", "uint32_retcode"}, new Object[]{0, byteStringMicro, byteStringMicro, 0}, TimDocSSOMsg$PadId.class);
    }

    public TimDocSSOMsg$PadId() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_localpadid = PBField.initBytes(byteStringMicro);
        this.bytes_pad_url = PBField.initBytes(byteStringMicro);
        this.uint32_retcode = PBField.initUInt32(0);
    }
}
