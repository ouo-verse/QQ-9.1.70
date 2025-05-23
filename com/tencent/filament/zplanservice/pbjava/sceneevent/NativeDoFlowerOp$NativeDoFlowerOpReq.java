package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class NativeDoFlowerOp$NativeDoFlowerOpReq extends MessageMicro<NativeDoFlowerOp$NativeDoFlowerOpReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 800}, new String[]{"scene_address", "uin", "op", "op_data", "device_level"}, new Object[]{0L, 0L, 0, ByteStringMicro.EMPTY, 0}, NativeDoFlowerOp$NativeDoFlowerOpReq.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: op, reason: collision with root package name */
    public final PBEnumField f106426op = PBField.initEnum(0);
    public final PBBytesField op_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField device_level = PBField.initEnum(0);
}
