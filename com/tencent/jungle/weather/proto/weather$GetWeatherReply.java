package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetWeatherReply extends MessageMicro<weather$GetWeatherReply> {
    static final MessageMicro.FieldMap __fieldMap__;
    public Oidb_0xca6$RspBody weather = new Oidb_0xca6$RspBody();
    public DayCard$DailyCards dailyCards = new DayCard$DailyCards();
    public final PBBoolField locCacheAuth = PBField.initBool(false);
    public final PBBoolField isActiveUser = PBField.initBool(false);
    public MedicalArticle$MedicalArticleDate medicalArticle = new MedicalArticle$MedicalArticleDate();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"weather", "dailyCards", "locCacheAuth", "isActiveUser", "medicalArticle"}, new Object[]{null, null, bool, bool, null}, weather$GetWeatherReply.class);
    }
}
