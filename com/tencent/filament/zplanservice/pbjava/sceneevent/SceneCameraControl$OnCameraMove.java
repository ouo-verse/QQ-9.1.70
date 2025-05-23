package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneCameraControl$OnCameraMove extends MessageMicro<SceneCameraControl$OnCameraMove> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"scene_address", "dx", "dy"}, new Object[]{0L, 0, 0}, SceneCameraControl$OnCameraMove.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);

    /* renamed from: dx, reason: collision with root package name */
    public final PBInt32Field f106431dx = PBField.initInt32(0);

    /* renamed from: dy, reason: collision with root package name */
    public final PBInt32Field f106432dy = PBField.initInt32(0);
}
