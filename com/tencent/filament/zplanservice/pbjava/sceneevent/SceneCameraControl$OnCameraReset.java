package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneCameraControl$OnCameraReset extends MessageMicro<SceneCameraControl$OnCameraReset> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"scene_address"}, new Object[]{0L}, SceneCameraControl$OnCameraReset.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
}
