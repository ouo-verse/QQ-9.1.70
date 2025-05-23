package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneFocusState$EnterFocusStateRequest extends MessageMicro<SceneFocusState$EnterFocusStateRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"scene_address", "room_host_uin"}, new Object[]{0L, 0L}, SceneFocusState$EnterFocusStateRequest.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBUInt64Field room_host_uin = PBField.initUInt64(0);
}
