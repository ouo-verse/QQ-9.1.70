package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class GameLinkShareReportPB$ReportItem extends MessageMicro<GameLinkShareReportPB$ReportItem> {
    public static final int LINK_TYPE_APK = 1;
    public static final int LINK_TYPE_ARK = 2;
    public static final int LINK_TYPE_H5 = 3;
    public static final int LINK_TYPE_UNKNOWN = 0;
    public static final int SCENE_C2C_AIO = 1;
    public static final int SCENE_GROUP_AIO = 2;
    public static final int SCENE_QQ_ZONE = 3;
    public static final int SCENE_UNKNOWN = 0;
    public static final int TYPE_SAMPLE = 1;
    public static final int TYPE_WHITE = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66, 72, 80}, new String[]{"url", "action_time", "scene", "material_id", "imie", "ua", SharedPreferencedUtil.SP_KEY_ANDROID_ID, "device_type", "type", "link_type"}, new Object[]{"", 0L, 0, "", "", "", "", "", 0, 0}, GameLinkShareReportPB$ReportItem.class);
    public final PBStringField url = PBField.initString("");
    public final PBInt64Field action_time = PBField.initInt64(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBStringField material_id = PBField.initString("");
    public final PBStringField imie = PBField.initString("");

    /* renamed from: ua, reason: collision with root package name */
    public final PBStringField f213224ua = PBField.initString("");
    public final PBStringField android_id = PBField.initString("");
    public final PBStringField device_type = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBEnumField link_type = PBField.initEnum(0);
}
