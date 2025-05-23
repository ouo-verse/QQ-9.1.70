package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TimDocSSOMsg$LoginInfo extends MessageMicro<TimDocSSOMsg$LoginInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pskey;
    public final PBBytesField bytes_skey;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_skey", "bytes_pskey"}, new Object[]{byteStringMicro, byteStringMicro}, TimDocSSOMsg$LoginInfo.class);
    }

    public TimDocSSOMsg$LoginInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_skey = PBField.initBytes(byteStringMicro);
        this.bytes_pskey = PBField.initBytes(byteStringMicro);
    }
}
