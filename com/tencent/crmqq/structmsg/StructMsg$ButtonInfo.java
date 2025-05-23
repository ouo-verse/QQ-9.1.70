package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StructMsg$ButtonInfo extends MessageMicro<StructMsg$ButtonInfo> {
    public static final int AUTH_NONE = 0;
    public static final int AUTH_SID = 1;
    public static final int AUTH_VKEY = 2;
    public static final int CLICK = 1;
    public static final int EVENT = 3;
    public static final int URL = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 64, 74, 80, 88}, new String[]{"id", "name", "key", "url", StartupReportKey.AUTH_TYPE, "type", "sub_button", "event_id", "event_param", "is_need_lbs", "item_id"}, new Object[]{0, "", "", "", 0, 1, null, 1, null, Boolean.FALSE, 0}, StructMsg$ButtonInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f100453id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField key = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBEnumField auth_type = PBField.initEnum(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBRepeatMessageField<StructMsg$ButtonInfo> sub_button = PBField.initRepeatMessage(StructMsg$ButtonInfo.class);
    public final PBEnumField event_id = PBField.initEnum(1);
    public final PBRepeatMessageField<StructMsg$ButtonInfo_EventInfoParam> event_param = PBField.initRepeatMessage(StructMsg$ButtonInfo_EventInfoParam.class);
    public final PBBoolField is_need_lbs = PBField.initBool(false);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
}
