package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneFocusState$NativeDoFlowerOpReq extends MessageMicro<SceneFocusState$NativeDoFlowerOpReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 800}, new String[]{"scene_address", "uin", "op", "op_data", "device_level"}, new Object[]{0L, 0L, 0, "", 0}, SceneFocusState$NativeDoFlowerOpReq.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: op, reason: collision with root package name */
    public final PBEnumField f106436op = PBField.initEnum(0);
    public final PBRepeatField<String> op_data = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field device_level = PBField.initUInt32(0);
}
