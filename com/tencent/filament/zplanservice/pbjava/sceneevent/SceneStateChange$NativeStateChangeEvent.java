package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneStateChange$NativeStateChangeEvent extends MessageMicro<SceneStateChange$NativeStateChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 40}, new String[]{"scene_address", "host_uin", "state"}, new Object[]{0L, 0L, 0}, SceneStateChange$NativeStateChangeEvent.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field host_uin = PBField.initUInt64(0);
    public final PBEnumField state = PBField.initEnum(0);
}
