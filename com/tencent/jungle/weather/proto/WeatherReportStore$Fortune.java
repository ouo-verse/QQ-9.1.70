package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$Fortune extends MessageMicro<WeatherReportStore$Fortune> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"type", "content", "title"}, new Object[]{"", "", ""}, WeatherReportStore$Fortune.class);
    public final PBStringField type = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField title = PBField.initString("");
}
