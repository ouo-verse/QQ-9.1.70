package com.tencent.jungle.weather.proto;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$LifeIndexList extends MessageMicro<WeatherReportStore$LifeIndexList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 82}, new String[]{"allergy", "clothing", "morning_workout", "common_cold", "sundry_cloth", c.N, "uv_light", AdHippyFragment.HEALTH_NAME, "updatetime", "date"}, new Object[]{null, null, null, null, null, null, null, null, 0L, ""}, WeatherReportStore$LifeIndexList.class);
    public WeatherReportStore$LifeIndexItem allergy = new WeatherReportStore$LifeIndexItem();
    public WeatherReportStore$LifeIndexItem clothing = new WeatherReportStore$LifeIndexItem();
    public WeatherReportStore$LifeIndexItem morning_workout = new WeatherReportStore$LifeIndexItem();
    public WeatherReportStore$LifeIndexItem common_cold = new WeatherReportStore$LifeIndexItem();
    public WeatherReportStore$LifeIndexItem sundry_cloth = new WeatherReportStore$LifeIndexItem();
    public WeatherReportStore$LifeIndexItem makeup = new WeatherReportStore$LifeIndexItem();
    public WeatherReportStore$LifeIndexItem uv_light = new WeatherReportStore$LifeIndexItem();
    public WeatherReportStore$LifeIndexItem sport = new WeatherReportStore$LifeIndexItem();
    public final PBUInt64Field updatetime = PBField.initUInt64(0);
    public final PBStringField date = PBField.initString("");
}
