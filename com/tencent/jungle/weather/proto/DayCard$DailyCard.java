package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tenpay.realname.RealNameSource;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class DayCard$DailyCard extends MessageMicro<DayCard$DailyCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 90}, new String[]{"id", "source", RealNameSource.EXTRA_KEY_SOURCE_NAME, "originID", "tag", "reference", "content", "pic", "likeNum", "hasLike", "jumpSchema"}, new Object[]{0L, 0L, "", "", "", "", "", "", 0L, Boolean.FALSE, ""}, DayCard$DailyCard.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f116935id = PBField.initUInt64(0);
    public final PBUInt64Field source = PBField.initUInt64(0);
    public final PBStringField sourceName = PBField.initString("");
    public final PBStringField originID = PBField.initString("");
    public final PBStringField tag = PBField.initString("");
    public final PBStringField reference = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField pic = PBField.initString("");
    public final PBUInt64Field likeNum = PBField.initUInt64(0);
    public final PBBoolField hasLike = PBField.initBool(false);
    public final PBStringField jumpSchema = PBField.initString("");
}
