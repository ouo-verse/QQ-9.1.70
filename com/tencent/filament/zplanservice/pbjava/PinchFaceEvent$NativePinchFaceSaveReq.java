package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class PinchFaceEvent$NativePinchFaceSaveReq extends MessageMicro<PinchFaceEvent$NativePinchFaceSaveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"scene_address"}, new Object[]{0L}, PinchFaceEvent$NativePinchFaceSaveReq.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
}
