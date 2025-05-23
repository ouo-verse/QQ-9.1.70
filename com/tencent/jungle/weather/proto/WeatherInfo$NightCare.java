package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherInfo$NightCare extends MessageMicro<WeatherInfo$NightCare> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"prompt", "background", "tomorrowLifeIndexs"}, new Object[]{"", "", null}, WeatherInfo$NightCare.class);
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField background = PBField.initString("");
    public final PBRepeatMessageField<WeatherInfo$LifeIndex> tomorrowLifeIndexs = PBField.initRepeatMessage(WeatherInfo$LifeIndex.class);
}
