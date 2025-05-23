package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeeklySummary extends MessageMicro<WeatherReportStore$WeeklySummary> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{"title", "sub_title", "pic", "lifeindex_list", "umbrella_reminder", "tag_value"}, new Object[]{"", "", 0, null, null, ""}, WeatherReportStore$WeeklySummary.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBEnumField pic = PBField.initEnum(0);
    public WeatherReportStore$LifeIndexList lifeindex_list = new WeatherReportStore$LifeIndexList();
    public WeatherReportStore$UmbrellaReminder umbrella_reminder = new MessageMicro<WeatherReportStore$UmbrellaReminder>() { // from class: com.tencent.jungle.weather.proto.WeatherReportStore$UmbrellaReminder
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"timestamps", "text"}, new Object[]{0L, ""}, WeatherReportStore$UmbrellaReminder.class);
        public final PBRepeatField<Long> timestamps = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBStringField text = PBField.initString("");
    };
    public final PBStringField tag_value = PBField.initString("");
}
