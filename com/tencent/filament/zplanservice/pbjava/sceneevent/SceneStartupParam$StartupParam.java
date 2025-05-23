package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class SceneStartupParam$StartupParam extends MessageMicro<SceneStartupParam$StartupParam> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field center_uin = PBField.initUInt64(0);
    public final PBBoolField is_focus = PBField.initBool(false);
    public final PBUInt64Field action_id = PBField.initUInt64(0);
    public final PBUInt64Field action_uin = PBField.initUInt64(0);
    public final PBUInt32Field max_characters = PBField.initUInt32(0);
    public final PBUInt32Field fps = PBField.initUInt32(0);
    public final PBBoolField can_show_flower = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"scene_address", "center_uin", "is_focus", "action_id", "action_uin", "max_characters", "fps", "can_show_flower"}, new Object[]{0L, 0L, bool, 0L, 0L, 0, 0, bool}, SceneStartupParam$StartupParam.class);
    }
}
