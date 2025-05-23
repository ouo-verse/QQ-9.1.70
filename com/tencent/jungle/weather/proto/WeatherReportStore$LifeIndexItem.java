package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$LifeIndexItem extends MessageMicro<WeatherReportStore$LifeIndexItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56}, new String[]{"summary", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "highlight", "name", "tips", "display_order", "rank"}, new Object[]{"", "", 0, "", "", 0, 0}, WeatherReportStore$LifeIndexItem.class);
    public final PBStringField summary = PBField.initString("");
    public final PBStringField link = PBField.initString("");
    public final PBUInt32Field highlight = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField tips = PBField.initString("");
    public final PBUInt32Field display_order = PBField.initUInt32(0);
    public final PBUInt32Field rank = PBField.initUInt32(0);
}
