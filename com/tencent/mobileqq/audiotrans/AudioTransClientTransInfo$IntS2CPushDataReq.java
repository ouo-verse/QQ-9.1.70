package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$IntS2CPushDataReq extends MessageMicro<AudioTransClientTransInfo$IntS2CPushDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"translate_result", "str_key"}, new Object[]{ByteStringMicro.EMPTY, ""}, AudioTransClientTransInfo$IntS2CPushDataReq.class);
    public final PBBytesField translate_result = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_key = PBField.initString("");
}
