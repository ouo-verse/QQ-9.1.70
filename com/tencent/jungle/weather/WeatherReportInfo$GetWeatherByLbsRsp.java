package com.tencent.jungle.weather;

import SLICE_UPLOAD.cnst.appid_ups;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$GetWeatherByLbsRsp extends MessageMicro<WeatherReportInfo$GetWeatherByLbsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 74}, new String[]{"pbRspMsgHead", GdtGetUserInfoHandler.KEY_AREA, "o_wea_code", "t_wea_code", "wea_desc", "temper", "show_flag", "weather_display", "alarms"}, new Object[]{null, null, "", "", "", "", 0, null, null}, WeatherReportInfo$GetWeatherByLbsRsp.class);
    public WeatherReportInfo$PbRspMsgHead pbRspMsgHead = new WeatherReportInfo$PbRspMsgHead();
    public WeatherReportInfo$Area area = new MessageMicro<WeatherReportInfo$Area>() { // from class: com.tencent.jungle.weather.WeatherReportInfo$Area
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"area_id", "area_name", "en_name", "city", "province", "country"}, new Object[]{0, "", "", "", "", ""}, WeatherReportInfo$Area.class);
        public final PBUInt32Field area_id = PBField.initUInt32(0);
        public final PBStringField area_name = PBField.initString("");
        public final PBStringField en_name = PBField.initString("");
        public final PBStringField city = PBField.initString("");
        public final PBStringField province = PBField.initString("");
        public final PBStringField country = PBField.initString("");
    };
    public final PBStringField o_wea_code = PBField.initString("");
    public final PBStringField t_wea_code = PBField.initString("");
    public final PBStringField wea_desc = PBField.initString("");
    public final PBStringField temper = PBField.initString("");
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public WeatherReportInfo$WeatherDisplay weather_display = new MessageMicro<WeatherReportInfo$WeatherDisplay>() { // from class: com.tencent.jungle.weather.WeatherReportInfo$WeatherDisplay
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{appid_ups.value, "down"}, new Object[]{null, null}, WeatherReportInfo$WeatherDisplay.class);
        public final PBRepeatMessageField<WeatherReportInfo$WeatherDisplayUp> ups = PBField.initRepeatMessage(WeatherReportInfo$WeatherDisplayUp.class);
        public WeatherReportInfo$WeatherDisplayDown down = new MessageMicro<WeatherReportInfo$WeatherDisplayDown>() { // from class: com.tencent.jungle.weather.WeatherReportInfo$WeatherDisplayDown
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"content"}, new Object[]{""}, WeatherReportInfo$WeatherDisplayDown.class);
            public final PBStringField content = PBField.initString("");
        };
    };
    public final PBRepeatMessageField<WeatherReportInfo$Alarm> alarms = PBField.initRepeatMessage(WeatherReportInfo$Alarm.class);
}
