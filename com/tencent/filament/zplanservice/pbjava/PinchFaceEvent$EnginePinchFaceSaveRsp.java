package com.tencent.filament.zplanservice.pbjava;

import com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$FaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class PinchFaceEvent$EnginePinchFaceSaveRsp extends MessageMicro<PinchFaceEvent$EnginePinchFaceSaveRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"scene_address", "save_success", "save_face_info"}, new Object[]{0L, Boolean.FALSE, null}, PinchFaceEvent$EnginePinchFaceSaveRsp.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBBoolField save_success = PBField.initBool(false);
    public AvatarDressInfo$FaceInfo save_face_info = new AvatarDressInfo$FaceInfo();
}
