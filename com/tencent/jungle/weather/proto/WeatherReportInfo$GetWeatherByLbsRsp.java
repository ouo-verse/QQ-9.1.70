package com.tencent.jungle.weather.proto;

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
    public WeatherReportInfo$Area area = new WeatherReportInfo$Area();
    public final PBStringField o_wea_code = PBField.initString("");
    public final PBStringField t_wea_code = PBField.initString("");
    public final PBStringField wea_desc = PBField.initString("");
    public final PBStringField temper = PBField.initString("");
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public WeatherReportInfo$WeatherDisplay weather_display = new WeatherReportInfo$WeatherDisplay();
    public final PBRepeatMessageField<WeatherReportInfo$Alarm> alarms = PBField.initRepeatMessage(WeatherReportInfo$Alarm.class);
}
