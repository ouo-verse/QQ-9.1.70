package com.tencent.jungle.weather;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05494;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$WeatherDisplayUp extends MessageMicro<WeatherReportInfo$WeatherDisplayUp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{QCircleLpReportDc05494.KEY_UP_TYPE, "theme", "content"}, new Object[]{1, 1, ""}, WeatherReportInfo$WeatherDisplayUp.class);
    public final PBEnumField up_type = PBField.initEnum(1);
    public final PBEnumField theme = PBField.initEnum(1);
    public final PBStringField content = PBField.initString("");
}
