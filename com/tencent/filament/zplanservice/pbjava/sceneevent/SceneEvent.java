package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneEvent extends MessageMicro<SceneEvent> {
    public static final int REFRESH_MAP_BLOCK = 0;
    public static final int VISIT_NEIGHBOR = 1;
    public static final int VISIT_STRANGER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"scene_address", "uin", "scene_event"}, new Object[]{0L, 0L, 0}, SceneEvent.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBEnumField scene_event = PBField.initEnum(0);
}
