package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes6.dex */
public final class PinchFaceEvent$PinchFaceUiInfo extends MessageMicro<PinchFaceEvent$PinchFaceUiInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField cp_name = PBField.initString("");
    public final PBBoolField is_side = PBField.initBool(false);
    public final PBBoolField can_side = PBField.initBool(false);
    public final PBBoolField can_undo = PBField.initBool(false);
    public final PBBoolField can_redo = PBField.initBool(false);
    public final PBEnumField select_point = PBField.initEnum(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"cp_name", "is_side", "can_side", "can_undo", "can_redo", "select_point"}, new Object[]{"", bool, bool, bool, bool, 0}, PinchFaceEvent$PinchFaceUiInfo.class);
    }
}
