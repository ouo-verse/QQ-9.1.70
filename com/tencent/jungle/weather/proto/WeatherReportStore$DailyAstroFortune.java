package com.tencent.jungle.weather.proto;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$DailyAstroFortune extends MessageMicro<WeatherReportStore$DailyAstroFortune> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 64}, new String[]{"astro", "date", "fortunes", "astro_id", "astro_pic", "astro_title", "recommend", LocalPhotoFaceInfo.SCORE}, new Object[]{"", "", null, 0, "", "", null, 0}, WeatherReportStore$DailyAstroFortune.class);
    public final PBStringField astro = PBField.initString("");
    public final PBStringField date = PBField.initString("");
    public final PBRepeatMessageField<WeatherReportStore$Fortune> fortunes = PBField.initRepeatMessage(WeatherReportStore$Fortune.class);
    public final PBUInt32Field astro_id = PBField.initUInt32(0);
    public final PBStringField astro_pic = PBField.initString("");
    public final PBStringField astro_title = PBField.initString("");
    public WeatherReportStore$AstroRecommend recommend = new MessageMicro<WeatherReportStore$AstroRecommend>() { // from class: com.tencent.jungle.weather.proto.WeatherReportStore$AstroRecommend
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"signId", "daily", "commentary", "image", "path"}, new Object[]{"", "", "", "", ""}, WeatherReportStore$AstroRecommend.class);
        public final PBStringField signId = PBField.initString("");
        public final PBStringField daily = PBField.initString("");
        public final PBStringField commentary = PBField.initString("");
        public final PBStringField image = PBField.initString("");
        public final PBStringField path = PBField.initString("");
    };
    public final PBUInt32Field score = PBField.initUInt32(0);
}
