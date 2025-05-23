package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$MenuItem extends MessageMicro<QZoneOfficialAccountBase$MenuItem> {
    public static final int ENUM_TYPE_INVALID = 0;
    public static final int MENU_TYPE_DEFAULT = 1;
    public static final int MENU_TYPE_INTIMATE = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"menu_type", "caption", "jump_url", "pic_url"}, new Object[]{0, "", "", ""}, QZoneOfficialAccountBase$MenuItem.class);
    public final PBEnumField menu_type = PBField.initEnum(0);
    public final PBStringField caption = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
}
