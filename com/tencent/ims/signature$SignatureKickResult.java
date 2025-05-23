package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class signature$SignatureKickResult extends MessageMicro<signature$SignatureKickResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_title", "str_content", "bytes_data"}, new Object[]{"", "", ByteStringMicro.EMPTY}, signature$SignatureKickResult.class);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
