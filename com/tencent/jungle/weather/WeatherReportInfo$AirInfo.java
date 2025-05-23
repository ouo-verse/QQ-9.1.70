package com.tencent.jungle.weather;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$AirInfo extends MessageMicro<WeatherReportInfo$AirInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"pm", "air_quality", "pubtime", "updatetime"}, new Object[]{"", "", "", 0L}, WeatherReportInfo$AirInfo.class);

    /* renamed from: pm, reason: collision with root package name */
    public final PBStringField f116933pm = PBField.initString("");
    public final PBStringField air_quality = PBField.initString("");
    public final PBStringField pubtime = PBField.initString("");
    public final PBUInt64Field updatetime = PBField.initUInt64(0);
}
