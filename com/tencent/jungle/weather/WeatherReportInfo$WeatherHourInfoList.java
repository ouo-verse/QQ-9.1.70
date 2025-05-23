package com.tencent.jungle.weather;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$WeatherHourInfoList extends MessageMicro<WeatherReportInfo$WeatherHourInfoList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"weatherHourInfo", "updatetime"}, new Object[]{null, 0L}, WeatherReportInfo$WeatherHourInfoList.class);
    public final PBRepeatMessageField<WeatherReportInfo$WeatherHourInfo> weatherHourInfo = PBField.initRepeatMessage(WeatherReportInfo$WeatherHourInfo.class);
    public final PBUInt64Field updatetime = PBField.initUInt64(0);
}
