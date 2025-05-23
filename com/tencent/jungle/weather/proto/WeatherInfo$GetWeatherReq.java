package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherInfo$GetWeatherReq extends MessageMicro<WeatherInfo$GetWeatherReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"adcodes", "types"}, new Object[]{0, 1}, WeatherInfo$GetWeatherReq.class);
    public final PBRepeatField<Integer> adcodes = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> types = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
