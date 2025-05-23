package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$ButtonInfo extends MessageMicro<mobileqq_mp$ButtonInfo> {
    public static final int AUTH_NONE = 0;
    public static final int AUTH_SID = 1;
    public static final int AUTH_VKEY = 2;
    public static final int CLICK = 1;
    public static final int EVENT = 3;
    public static final int URL = 2;
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f247282id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField key = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBEnumField auth_type = PBField.initEnum(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBRepeatMessageField<mobileqq_mp$ButtonInfo> sub_button = PBField.initRepeatMessage(mobileqq_mp$ButtonInfo.class);
    public final PBEnumField event_id = PBField.initEnum(1);
    public final PBRepeatMessageField<mobileqq_mp$ButtonInfo_EventInfoParam> event_param = PBField.initRepeatMessage(mobileqq_mp$ButtonInfo_EventInfoParam.class);
    public final PBBoolField is_need_lbs = PBField.initBool(false);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public mobileqq_mp$ActionInfo actionInfo = new mobileqq_mp$ActionInfo();
    public final PBStringField media_id = PBField.initString("");
    public final PBBoolField is_new_menu = PBField.initBool(false);
    public final PBStringField logo_url = PBField.initString("");
    public final PBStringField bg_colors = PBField.initString("");
    public final PBStringField texture_url = PBField.initString("");

    static {
        String[] strArr = {"id", "name", "key", "url", StartupReportKey.AUTH_TYPE, "type", "sub_button", "event_id", "event_param", "is_need_lbs", "item_id", "actionInfo", "media_id", "is_new_menu", "logo_url", "bg_colors", "texture_url"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 64, 74, 80, 88, 98, 106, 112, 122, 130, 138}, strArr, new Object[]{0, "", "", "", 0, 1, null, 1, null, bool, 0, null, "", bool, "", "", ""}, mobileqq_mp$ButtonInfo.class);
    }
}
