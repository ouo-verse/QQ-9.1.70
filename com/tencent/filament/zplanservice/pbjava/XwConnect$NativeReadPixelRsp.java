package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class XwConnect$NativeReadPixelRsp extends MessageMicro<XwConnect$NativeReadPixelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"scene_address", "success", "data", "width", "height"}, new Object[]{0L, Boolean.FALSE, ByteStringMicro.EMPTY, 0, 0}, XwConnect$NativeReadPixelRsp.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBBoolField success = PBField.initBool(false);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
}
