package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class PinchFaceEvent$NativePinchFaceSelectGroupReq extends MessageMicro<PinchFaceEvent$NativePinchFaceSelectGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"scene_address", "point"}, new Object[]{0L, 0}, PinchFaceEvent$NativePinchFaceSelectGroupReq.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBEnumField point = PBField.initEnum(0);
}
