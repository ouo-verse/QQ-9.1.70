package com.tencent.filament.zplanservice.pbjava;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SceneTouchEvent$TouchEvent extends MessageMicro<SceneTouchEvent$TouchEvent> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBEnumField event_state = PBField.initEnum(0);
    public final PBRepeatField<Float> locations = PBField.initRepeat(PBFloatField.__repeatHelper__);
    public final PBInt64Field touch_count = PBField.initInt64(0);
    public final PBFloatField scale = PBField.initFloat(0.0f);
    public final PBFloatField velocity = PBField.initFloat(0.0f);
    public final PBFloatField velocity_x = PBField.initFloat(0.0f);
    public final PBFloatField velocity_y = PBField.initFloat(0.0f);
    public final PBInt32Field scale_factor = PBField.initInt32(0);

    static {
        String[] strArr = {"scene_address", CGNonAgeReport.EVENT_TYPE, "event_state", "locations", "touch_count", "scale", "velocity", "velocity_x", "velocity_y", "scale_factor"};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 37, 40, 53, 61, 69, 77, 80}, strArr, new Object[]{0L, 0, 0, valueOf, 0L, valueOf, valueOf, valueOf, valueOf, 0}, SceneTouchEvent$TouchEvent.class);
    }
}
