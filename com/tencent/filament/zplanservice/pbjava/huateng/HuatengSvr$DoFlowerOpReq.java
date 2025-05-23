package com.tencent.filament.zplanservice.pbjava.huateng;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class HuatengSvr$DoFlowerOpReq extends MessageMicro<HuatengSvr$DoFlowerOpReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 800}, new String[]{"uin", "op", "op_data", "device_level"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0}, HuatengSvr$DoFlowerOpReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: op, reason: collision with root package name */
    public final PBEnumField f106420op = PBField.initEnum(0);
    public final PBBytesField op_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField device_level = PBField.initEnum(0);
}
