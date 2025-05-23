package com.tencent.jungle.weather.proto;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeatherRecord extends MessageMicro<WeatherReportStore$WeatherRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{WidgetCacheLunarData.WEEK}, new Object[]{null}, WeatherReportStore$WeatherRecord.class);
    public WeatherReportStore$WeatherWeekRecord week = new MessageMicro<WeatherReportStore$WeatherWeekRecord>() { // from class: com.tencent.jungle.weather.proto.WeatherReportStore$WeatherWeekRecord
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"exposedWeekChangeTypes", "weekChangeType", "timestamp"}, new Object[]{0, 0, 0L}, WeatherReportStore$WeatherWeekRecord.class);
        public final PBRepeatField<Integer> exposedWeekChangeTypes = PBField.initRepeat(PBInt32Field.__repeatHelper__);
        public final PBInt32Field weekChangeType = PBField.initInt32(0);
        public final PBUInt64Field timestamp = PBField.initUInt64(0);
    };
}
