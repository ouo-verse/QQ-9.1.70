package com.tencent.jungle.weather.proto;

import SLICE_UPLOAD.cnst.appid_ups;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$WeatherDisplay extends MessageMicro<WeatherReportInfo$WeatherDisplay> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{appid_ups.value, "down"}, new Object[]{null, null}, WeatherReportInfo$WeatherDisplay.class);
    public final PBRepeatMessageField<WeatherReportInfo$WeatherDisplayUp> ups = PBField.initRepeatMessage(WeatherReportInfo$WeatherDisplayUp.class);
    public WeatherReportInfo$WeatherDisplayDown down = new WeatherReportInfo$WeatherDisplayDown();
}
