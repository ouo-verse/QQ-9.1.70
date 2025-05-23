package com.tencent.jungle.weather.proto;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetWidgetWeatherReply extends MessageMicro<weather$GetWidgetWeatherReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"weather", "alarms", "day_forcasts", QCircleSchemeAttr.Detail.CURRENT_TIME}, new Object[]{null, null, null, 0L}, weather$GetWidgetWeatherReply.class);
    public weather$WidgetWeather weather = new MessageMicro<weather$WidgetWeather>() { // from class: com.tencent.jungle.weather.proto.weather$WidgetWeather
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "city", "temper", "concrete_weather_type", "day_temper", "night_temper", "weather_icon_schema"}, new Object[]{"", "", "", 1, "", "", ""}, weather$WidgetWeather.class);
        public final PBStringField area = PBField.initString("");
        public final PBStringField city = PBField.initString("");
        public final PBStringField temper = PBField.initString("");
        public final PBEnumField concrete_weather_type = PBField.initEnum(1);
        public final PBStringField day_temper = PBField.initString("");
        public final PBStringField night_temper = PBField.initString("");
        public final PBStringField weather_icon_schema = PBField.initString("");
    };
    public final PBRepeatMessageField<weather$WidgetAlarm> alarms = PBField.initRepeatMessage(weather$WidgetAlarm.class);
    public final PBRepeatMessageField<weather$WidgetDayForcast> day_forcasts = PBField.initRepeatMessage(weather$WidgetDayForcast.class);
    public final PBUInt64Field current_time = PBField.initUInt64(0);
}
