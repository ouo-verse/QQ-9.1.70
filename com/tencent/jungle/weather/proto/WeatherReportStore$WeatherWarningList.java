package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeatherWarningList extends MessageMicro<WeatherReportStore$WeatherWarningList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"lst_warning", "last_proc_time"}, new Object[]{null, 0}, WeatherReportStore$WeatherWarningList.class);
    public final PBRepeatMessageField<WeatherReportStore$WeatherWarningDetail> lst_warning = PBField.initRepeatMessage(WeatherReportStore$WeatherWarningDetail.class);
    public final PBInt32Field last_proc_time = PBField.initInt32(0);
}
