package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class XwConnect$NativeReadPixelReq extends MessageMicro<XwConnect$NativeReadPixelReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBFloatField aspect = PBField.initFloat(0.0f);
    public final PBFloatField scale_y = PBField.initFloat(0.0f);
    public final PBFloatField offset_y = PBField.initFloat(0.0f);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 29, 37}, new String[]{"scene_address", "aspect", "scale_y", "offset_y"}, new Object[]{0L, valueOf, valueOf, valueOf}, XwConnect$NativeReadPixelReq.class);
    }
}
