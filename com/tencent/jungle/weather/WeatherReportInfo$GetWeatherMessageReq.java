package com.tencent.jungle.weather;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$GetWeatherMessageReq extends MessageMicro<WeatherReportInfo$GetWeatherMessageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 74, 82, 88}, new String[]{"pbReqMsgHead", "uin", QCircleSchemeAttr.Polymerize.LAT, "lng", "ip", "area_id", "source", "fore_flag", "extra", "adcode", "adcode_from_mapsdk"}, new Object[]{null, 0L, 0, 0, 0, 0, 0, 0, "", "", 0}, WeatherReportInfo$GetWeatherMessageReq.class);
    public WeatherReportInfo$PbReqMsgHead pbReqMsgHead = new WeatherReportInfo$PbReqMsgHead();
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field lat = PBField.initUInt32(0);
    public final PBUInt32Field lng = PBField.initUInt32(0);

    /* renamed from: ip, reason: collision with root package name */
    public final PBUInt32Field f116934ip = PBField.initUInt32(0);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field fore_flag = PBField.initUInt32(0);
    public final PBStringField extra = PBField.initString("");
    public final PBStringField adcode = PBField.initString("");
    public final PBUInt32Field adcode_from_mapsdk = PBField.initUInt32(0);
}
