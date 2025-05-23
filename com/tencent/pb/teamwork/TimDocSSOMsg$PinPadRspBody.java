package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$PinPadRspBody extends MessageMicro<TimDocSSOMsg$PinPadRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid;
    public final PBBytesField bytes_pad_url;
    public final PBUInt32Field uint32_domainid;
    public final PBUInt32Field uint32_list_type;
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_pinned_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50}, new String[]{"uint32_retcode", "bytes_pad_url", "uint64_last_pinned_time", "uint32_list_type", "uint32_domainid", "bytes_localpadid"}, new Object[]{0, byteStringMicro, 0L, 0, 0, byteStringMicro}, TimDocSSOMsg$PinPadRspBody.class);
    }

    public TimDocSSOMsg$PinPadRspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pad_url = PBField.initBytes(byteStringMicro);
        this.uint64_last_pinned_time = PBField.initUInt64(0L);
        this.uint32_list_type = PBField.initUInt32(0);
        this.uint32_domainid = PBField.initUInt32(0);
        this.bytes_localpadid = PBField.initBytes(byteStringMicro);
    }
}
