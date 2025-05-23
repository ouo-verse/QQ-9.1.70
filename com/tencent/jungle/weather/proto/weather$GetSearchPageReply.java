package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes7.dex */
public final class weather$GetSearchPageReply extends MessageMicro<weather$GetSearchPageReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"hot_cities", "cities_by_initial"}, new Object[]{null, null}, weather$GetSearchPageReply.class);
    public final PBRepeatMessageField<weather$AdministrativeRegion> hot_cities = PBField.initRepeatMessage(weather$AdministrativeRegion.class);
    public final PBRepeatMessageField<weather$CitiesGroupByInitial> cities_by_initial = PBField.initRepeatMessage(weather$CitiesGroupByInitial.class);
}
