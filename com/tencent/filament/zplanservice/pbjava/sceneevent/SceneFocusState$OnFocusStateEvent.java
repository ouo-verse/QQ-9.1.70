package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneFocusState$OnFocusStateEvent extends MessageMicro<SceneFocusState$OnFocusStateEvent> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field room_host_uin = PBField.initUInt64(0);
    public final PBBoolField host_have_own_room = PBField.initBool(false);
    public final PBBoolField host_have_flower = PBField.initBool(false);
    public HuatengSvr$FlowerData flower_data = new HuatengSvr$FlowerData();
    public final PBUInt32Field focus_x = PBField.initUInt32(0);
    public final PBUInt32Field focus_y = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 56, 64}, new String[]{"scene_address", "room_host_uin", "host_have_own_room", "host_have_flower", "flower_data", "focus_x", "focus_y"}, new Object[]{0L, 0L, bool, bool, null, 0, 0}, SceneFocusState$OnFocusStateEvent.class);
    }
}
