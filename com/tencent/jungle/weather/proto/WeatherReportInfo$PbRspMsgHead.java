package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class WeatherReportInfo$PbRspMsgHead extends MessageMicro<WeatherReportInfo$PbRspMsgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "string_err_msg"}, new Object[]{0, ""}, WeatherReportInfo$PbRspMsgHead.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBStringField string_err_msg = PBField.initString("");
}
