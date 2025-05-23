package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x3RspFetchBq extends MessageMicro<EmosmPb$SubCmd0x3RspFetchBq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_bytes_key"}, new Object[]{ByteStringMicro.EMPTY}, EmosmPb$SubCmd0x3RspFetchBq.class);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_key = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
