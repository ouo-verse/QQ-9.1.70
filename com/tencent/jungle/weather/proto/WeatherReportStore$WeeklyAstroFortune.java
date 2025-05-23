package com.tencent.jungle.weather.proto;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeeklyAstroFortune extends MessageMicro<WeatherReportStore$WeeklyAstroFortune> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"astro", LocalPhotoFaceInfo.SCORE, "fortunes", "keyword", "summary"}, new Object[]{"", 0, null, "", ""}, WeatherReportStore$WeeklyAstroFortune.class);
    public final PBStringField astro = PBField.initString("");
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBRepeatMessageField<WeatherReportStore$Fortune> fortunes = PBField.initRepeatMessage(WeatherReportStore$Fortune.class);
    public final PBStringField keyword = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
}
