package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneCameraControl$OnCameraRotate extends MessageMicro<SceneCameraControl$OnCameraRotate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"scene_address", "dr", "dp", "dy"}, new Object[]{0L, 0, 0, 0}, SceneCameraControl$OnCameraRotate.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);

    /* renamed from: dr, reason: collision with root package name */
    public final PBInt32Field f106434dr = PBField.initInt32(0);

    /* renamed from: dp, reason: collision with root package name */
    public final PBInt32Field f106433dp = PBField.initInt32(0);

    /* renamed from: dy, reason: collision with root package name */
    public final PBInt32Field f106435dy = PBField.initInt32(0);
}
