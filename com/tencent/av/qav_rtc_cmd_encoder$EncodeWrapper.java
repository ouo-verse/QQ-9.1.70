package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class qav_rtc_cmd_encoder$EncodeWrapper extends MessageMicro<qav_rtc_cmd_encoder$EncodeWrapper> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cmd", "content"}, new Object[]{"", ByteStringMicro.EMPTY}, qav_rtc_cmd_encoder$EncodeWrapper.class);
    public final PBStringField cmd = PBField.initString("");
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
}
