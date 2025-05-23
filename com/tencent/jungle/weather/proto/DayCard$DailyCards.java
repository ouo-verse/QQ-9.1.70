package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class DayCard$DailyCards extends MessageMicro<DayCard$DailyCards> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"content"}, new Object[]{null}, DayCard$DailyCards.class);
    public final PBRepeatMessageField<DayCard$DailyCard> content = PBField.initRepeatMessage(DayCard$DailyCard.class);
}
