package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetConcernWeatherRequest extends MessageMicro<weather$GetConcernWeatherRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBBoolField isRealAdcode = PBField.initBool(false);
    public final PBRepeatField<Integer> types = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBUInt32Field offset = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field landingAdcode = PBField.initUInt32(0);
    public final PBFloatField latitude = PBField.initFloat(0.0f);
    public final PBFloatField longitude = PBField.initFloat(0.0f);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 61, 69}, new String[]{"adcode", "isRealAdcode", "types", "offset", "count", "landingAdcode", "latitude", "longitude"}, new Object[]{0, Boolean.FALSE, 1, 0, 0, 0, valueOf, valueOf}, weather$GetConcernWeatherRequest.class);
    }
}
