package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneCameraControl$OnCameraFocus extends MessageMicro<SceneCameraControl$OnCameraFocus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"scene_address", HippyTKDListViewAdapter.X, "y"}, new Object[]{0L, 0, 0}, SceneCameraControl$OnCameraFocus.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);

    /* renamed from: x, reason: collision with root package name */
    public final PBInt32Field f106429x = PBField.initInt32(0);

    /* renamed from: y, reason: collision with root package name */
    public final PBInt32Field f106430y = PBField.initInt32(0);
}
