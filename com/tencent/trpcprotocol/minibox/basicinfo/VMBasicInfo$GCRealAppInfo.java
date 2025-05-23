package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GCRealAppInfo extends MessageMicro<VMBasicInfo$GCRealAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"gc_appid", "gc_app_name", "gc_icon_url", "gc_package_name", "gc_version_name", "gc_version_code", "gc_apk_url", "gc_game_author", "gc_permissions", "gc_privacy_guide_pic"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, VMBasicInfo$GCRealAppInfo.class);
    public final PBStringField gc_appid = PBField.initString("");
    public final PBStringField gc_app_name = PBField.initString("");
    public final PBStringField gc_icon_url = PBField.initString("");
    public final PBStringField gc_package_name = PBField.initString("");
    public final PBStringField gc_version_name = PBField.initString("");
    public final PBStringField gc_version_code = PBField.initString("");
    public final PBStringField gc_apk_url = PBField.initString("");
    public final PBStringField gc_game_author = PBField.initString("");
    public final PBStringField gc_permissions = PBField.initString("");
    public final PBStringField gc_privacy_guide_pic = PBField.initString("");
}
