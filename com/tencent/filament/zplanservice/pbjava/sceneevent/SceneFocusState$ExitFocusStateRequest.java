package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneFocusState$ExitFocusStateRequest extends MessageMicro<SceneFocusState$ExitFocusStateRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"scene_address"}, new Object[]{0L}, SceneFocusState$ExitFocusStateRequest.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
}
