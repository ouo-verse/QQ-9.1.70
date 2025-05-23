package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherInfo$LifeIndex extends MessageMicro<WeatherInfo$LifeIndex> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "content", "icon"}, new Object[]{"", "", ""}, WeatherInfo$LifeIndex.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
