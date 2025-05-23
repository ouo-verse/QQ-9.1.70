package com.tencent.protofile.homework.hw_recite_score;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class hw_recite_score$ErrorInfo extends MessageMicro<hw_recite_score$ErrorInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"error_code", "error_desc"}, new Object[]{0, ByteStringMicro.EMPTY}, hw_recite_score$ErrorInfo.class);
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);
}
