package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes6.dex */
public final class XwConnect$ImagePixel extends MessageMicro<XwConnect$ImagePixel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"data", "width", "height", "level"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0}, XwConnect$ImagePixel.class);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field level = PBField.initUInt32(0);
}
