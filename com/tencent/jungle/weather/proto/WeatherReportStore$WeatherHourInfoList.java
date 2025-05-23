package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeatherHourInfoList extends MessageMicro<WeatherReportStore$WeatherHourInfoList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"weatherHourInfo", "updatetime"}, new Object[]{null, 0L}, WeatherReportStore$WeatherHourInfoList.class);
    public final PBRepeatMessageField<WeatherReportStore$WeatherHourInfo> weatherHourInfo = PBField.initRepeatMessage(WeatherReportStore$WeatherHourInfo.class);
    public final PBUInt64Field updatetime = PBField.initUInt64(0);
}
