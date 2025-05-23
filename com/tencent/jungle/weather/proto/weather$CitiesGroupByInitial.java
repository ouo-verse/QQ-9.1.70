package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$CitiesGroupByInitial extends MessageMicro<weather$CitiesGroupByInitial> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"initial", "cities"}, new Object[]{"", null}, weather$CitiesGroupByInitial.class);
    public final PBStringField initial = PBField.initString("");
    public final PBRepeatMessageField<weather$AdministrativeRegion> cities = PBField.initRepeatMessage(weather$AdministrativeRegion.class);
}
