package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class PinchFaceEvent$NativePinchFaceSideReq extends MessageMicro<PinchFaceEvent$NativePinchFaceSideReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"scene_address", "is_side_view"}, new Object[]{0L, Boolean.FALSE}, PinchFaceEvent$NativePinchFaceSideReq.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBBoolField is_side_view = PBField.initBool(false);
}
