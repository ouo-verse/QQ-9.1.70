package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$SendMenuEventRequest extends MessageMicro<mobileqq_mp$SendMenuEventRequest> {
    public static final int CLICK = 1;
    public static final int CUSTOM_MENU = 1;
    public static final int EVENT = 3;
    public static final int SM_CLICK = 2;
    public static final int UNKNOW = 0;
    public static final int URL = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField key = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBBoolField is_need_lbs = PBField.initBool(false);
    public final PBDoubleField latitude = PBField.initDouble(0.0d);
    public final PBDoubleField longitude = PBField.initDouble(0.0d);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt64Field msg_id = PBField.initUInt64(0);
    public final PBEnumField s_type = PBField.initEnum(0);
    public final PBStringField url = PBField.initString("");
    public mobileqq_mp$ActionInfo actionInfo = new mobileqq_mp$ActionInfo();
    public final PBStringField scan_result = PBField.initString("");
    public final PBStringField media_id = PBField.initString("");
    public final PBEnumField event_id = PBField.initEnum(1);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBBoolField is_new_menu = PBField.initBool(false);
    public final PBUInt32Field pictureCount = PBField.initUInt32(0);
    public final PBStringField lbsAddressLabel = PBField.initString("");
    public final PBRepeatField<String> picture_Md5s = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field scanType = PBField.initUInt32(0);
    public final PBUInt32Field menu_type = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 41, 49, 56, 64, 72, 82, 90, 98, 106, 112, 122, 128, 136, 146, 154, 160, 168}, new String[]{"uin", "key", "type", "is_need_lbs", "latitude", "longitude", "luin", "msg_id", "s_type", "url", "actionInfo", "scan_result", "media_id", "event_id", "versionInfo", "is_new_menu", "pictureCount", "lbsAddressLabel", "picture_Md5s", "scanType", "menu_type"}, new Object[]{0, "", 1, bool, valueOf, valueOf, 0L, 0L, 0, "", null, "", "", 1, "", bool, 0, "", "", 0, 0}, mobileqq_mp$SendMenuEventRequest.class);
    }
}
