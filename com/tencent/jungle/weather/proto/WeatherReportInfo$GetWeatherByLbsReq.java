package com.tencent.jungle.weather.proto;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$GetWeatherByLbsReq extends MessageMicro<WeatherReportInfo$GetWeatherByLbsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"pbReqMsgHead", "uin", QCircleSchemeAttr.Polymerize.LAT, "lng", "adcode_from_mapsdk"}, new Object[]{null, 0L, 0, 0, 0}, WeatherReportInfo$GetWeatherByLbsReq.class);
    public WeatherReportInfo$PbReqMsgHead pbReqMsgHead = new WeatherReportInfo$PbReqMsgHead();
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field lat = PBField.initUInt32(0);
    public final PBUInt32Field lng = PBField.initUInt32(0);
    public final PBUInt32Field adcode_from_mapsdk = PBField.initUInt32(0);
}
