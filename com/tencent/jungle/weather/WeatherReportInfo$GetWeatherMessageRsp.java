package com.tencent.jungle.weather;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$GetWeatherMessageRsp extends MessageMicro<WeatherReportInfo$GetWeatherMessageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"pbRspMsgHead", "cmd", "string_msg", "extra"}, new Object[]{null, 0, "", ""}, WeatherReportInfo$GetWeatherMessageRsp.class);
    public WeatherReportInfo$PbRspMsgHead pbRspMsgHead = new WeatherReportInfo$PbRspMsgHead();
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField string_msg = PBField.initString("");
    public final PBStringField extra = PBField.initString("");
}
