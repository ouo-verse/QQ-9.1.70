package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class PinchFaceEvent$EnginePinchFaceRsp extends MessageMicro<PinchFaceEvent$EnginePinchFaceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"scene_address", "do_op_result", "ui_info"}, new Object[]{0L, 0, null}, PinchFaceEvent$EnginePinchFaceRsp.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt32Field do_op_result = PBField.initUInt32(0);
    public PinchFaceEvent$PinchFaceUiInfo ui_info = new PinchFaceEvent$PinchFaceUiInfo();
}
