package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class SceneEventVsync$PauseVsync extends MessageMicro<SceneEventVsync$PauseVsync> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"scene_address"}, new Object[]{0L}, SceneEventVsync$PauseVsync.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
}
