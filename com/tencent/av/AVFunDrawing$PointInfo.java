package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes3.dex */
public final class AVFunDrawing$PointInfo extends MessageMicro<AVFunDrawing$PointInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField float_x = PBField.initFloat(0.0f);
    public final PBFloatField float_y = PBField.initFloat(0.0f);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 24}, new String[]{"float_x", "float_y", "uint32_type"}, new Object[]{valueOf, valueOf, 0}, AVFunDrawing$PointInfo.class);
    }
}
