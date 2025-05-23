package com.tencent.qqnt.ntrelation.protocol.onLineStatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OnlineStatusExtInfo$ZodiacBizInfo extends MessageMicro<OnlineStatusExtInfo$ZodiacBizInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"string_today_trend", "string_tomorrow_trend", "string_miniapp", "string_today_date", "string_lucky_color", "string_lucky_number"}, new Object[]{"", "", "", "", "", ""}, OnlineStatusExtInfo$ZodiacBizInfo.class);
    public final PBStringField string_today_trend = PBField.initString("");
    public final PBStringField string_tomorrow_trend = PBField.initString("");
    public final PBStringField string_miniapp = PBField.initString("");
    public final PBStringField string_today_date = PBField.initString("");
    public final PBStringField string_lucky_color = PBField.initString("");
    public final PBStringField string_lucky_number = PBField.initString("");
}
