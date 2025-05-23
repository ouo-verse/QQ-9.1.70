package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$IntC2SRawDataReq extends MessageMicro<AudioTransClientTransInfo$IntC2SRawDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_data", "str_key"}, new Object[]{ByteStringMicro.EMPTY, ""}, AudioTransClientTransInfo$IntC2SRawDataReq.class);
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_key = PBField.initString("");
}
