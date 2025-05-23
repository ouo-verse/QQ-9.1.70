package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class PinchFaceEvent$EnginePinchFaceNotify extends MessageMicro<PinchFaceEvent$EnginePinchFaceNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"scene_address", "ui_info"}, new Object[]{0L, null}, PinchFaceEvent$EnginePinchFaceNotify.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public PinchFaceEvent$PinchFaceUiInfo ui_info = new PinchFaceEvent$PinchFaceUiInfo();
}
