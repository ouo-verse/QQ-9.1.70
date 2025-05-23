package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneStateChange$EngineStateChangeEvent extends MessageMicro<SceneStateChange$EngineStateChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"scene_address", "host_uin", "host_have_own_room", "host_name", "state"}, new Object[]{0L, 0L, Boolean.FALSE, "", 0}, SceneStateChange$EngineStateChangeEvent.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field host_uin = PBField.initUInt64(0);
    public final PBBoolField host_have_own_room = PBField.initBool(false);
    public final PBStringField host_name = PBField.initString("");
    public final PBEnumField state = PBField.initEnum(0);
}
