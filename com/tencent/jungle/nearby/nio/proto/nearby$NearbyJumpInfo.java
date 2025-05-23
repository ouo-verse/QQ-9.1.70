package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class nearby$NearbyJumpInfo extends MessageMicro<nearby$NearbyJumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"tip_content", "tip_left_btn", "tip_right_btn_installed", "tip_right_btn_not_installed", "android_app_key", "ios_app_key", "jump_uri", "app_download_url", "tip_title", "tip_right_btn"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, nearby$NearbyJumpInfo.class);
    public final PBStringField tip_content = PBField.initString("");
    public final PBStringField tip_left_btn = PBField.initString("");
    public final PBStringField tip_right_btn_installed = PBField.initString("");
    public final PBStringField tip_right_btn_not_installed = PBField.initString("");
    public final PBStringField android_app_key = PBField.initString("");
    public final PBStringField ios_app_key = PBField.initString("");
    public final PBStringField jump_uri = PBField.initString("");
    public final PBStringField app_download_url = PBField.initString("");
    public final PBStringField tip_title = PBField.initString("");
    public final PBStringField tip_right_btn = PBField.initString("");
}
