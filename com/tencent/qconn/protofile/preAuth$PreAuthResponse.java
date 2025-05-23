package com.tencent.qconn.protofile;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* loaded from: classes22.dex */
public final class preAuth$PreAuthResponse extends MessageMicro<preAuth$PreAuthResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 50, 122, 130, 162, 170, 322, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 336, 346}, new String[]{"ret", "msg", "appid", "app_name", "icons_url", "android_info", "ios_info", "auth_items", "authorized_union_text", "profiles", "vid", "is_high_quality_game", "guide"}, new Object[]{0, "", 0L, "", null, null, null, null, "", null, 0L, Boolean.FALSE, null}, preAuth$PreAuthResponse.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342476msg = PBField.initString("");
    public final PBInt64Field appid = PBField.initInt64(0);
    public final PBStringField app_name = PBField.initString("");
    public final PBRepeatMessageField<appType$MsgIconsurl> icons_url = PBField.initRepeatMessage(appType$MsgIconsurl.class);
    public appType$AndroidInfo android_info = new appType$AndroidInfo();
    public appType$IOSInfo ios_info = new MessageMicro<appType$IOSInfo>() { // from class: com.tencent.qconn.protofile.appType$IOSInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{QZoneDTLoginReporter.SCHEMA, "bundleid", "appstore_id", AppConstants.Key.SHARE_SOURCE_URL, "offical_website", "message_tail", "a_bundleid"}, new Object[]{"", "", "", "", "", "", ""}, appType$IOSInfo.class);
        public final PBStringField schema = PBField.initString("");
        public final PBStringField bundleid = PBField.initString("");
        public final PBStringField appstore_id = PBField.initString("");
        public final PBStringField source_url = PBField.initString("");
        public final PBStringField offical_website = PBField.initString("");
        public final PBStringField message_tail = PBField.initString("");
        public final PBStringField a_bundleid = PBField.initString("");
    };
    public final PBRepeatMessageField<appType$AuthItem> auth_items = PBField.initRepeatMessage(appType$AuthItem.class);
    public final PBStringField authorized_union_text = PBField.initString("");
    public final PBRepeatMessageField<preAuth$VirtualProfile> profiles = PBField.initRepeatMessage(preAuth$VirtualProfile.class);
    public final PBUInt64Field vid = PBField.initUInt64(0);
    public final PBBoolField is_high_quality_game = PBField.initBool(false);
    public preAuth$GuideInfo guide = new preAuth$GuideInfo();
}
