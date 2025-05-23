package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$UinWeatherInfo extends MessageMicro<WeatherReportStore$UinWeatherInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field last_push_time = PBField.initUInt32(0);
    public final PBUInt32Field area_id = PBField.initUInt32(0);

    /* renamed from: ip, reason: collision with root package name */
    public final PBUInt32Field f116939ip = PBField.initUInt32(0);
    public final PBUInt32Field last_query_id = PBField.initUInt32(0);
    public final PBBoolField no_lbs = PBField.initBool(false);
    public final PBUInt32Field extra = PBField.initUInt32(0);
    public final PBUInt32Field last_query_time = PBField.initUInt32(0);
    public final PBUInt32Field last_query_adcode = PBField.initUInt32(0);
    public final PBBoolField auth_loc_cache = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 64, 72, 80}, new String[]{"last_push_time", "area_id", "ip", "last_query_id", "no_lbs", "extra", "last_query_time", "last_query_adcode", "auth_loc_cache"}, new Object[]{0, 0, 0, 0, bool, 0, 0, 0, bool}, WeatherReportStore$UinWeatherInfo.class);
    }
}
