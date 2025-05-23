package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class WeatherReportInfo$PbReqMsgHead extends MessageMicro<WeatherReportInfo$PbReqMsgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_platform_type", "uint32_version", "uint32_ext_mask"}, new Object[]{0, 0, 0}, WeatherReportInfo$PbReqMsgHead.class);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ext_mask = PBField.initUInt32(0);
}
