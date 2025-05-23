package com.tencent.mobileqq.minigame.va.download;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes33.dex */
public final class DownloadManagerProto {
    public static final int APP_TYPE_JOINT_OPERATION = 2;
    public static final int APP_TYPE_QSDK = 5;
    public static final int APP_TYPE_TENCENT = 1;
    public static final int APP_TYPE_UNKNOWN = 0;
    public static final int GAME_STATUS_DOWNLOAD = 3;
    public static final int GAME_STATUS_OFFLINE = 5;
    public static final int GAME_STATUS_SUBSCRIBE = 1;
    public static final int GAME_STATUS_SUBSCRIBE_NO_BEGIN = 4;
    public static final int GAME_STATUS_UNKNOWN = 0;
    public static final int PLATFORM_ANDROID = 1;
    public static final int PLATFORM_IOS = 2;
    public static final int PLATFORM_UNSET = 0;

    /* loaded from: classes33.dex */
    public static final class Download extends MessageMicro<Download> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 64, 74, 80, 90, 98, 106}, new String[]{"appid", "app_name", "pkg_name", MiniConst.WxMiniAppInfoConst.EXTRA_ICON, "version_code", "pkg_size", "download_url", "game_status", "extendss", "app_type", "min_update_version_code", "tickets", "label_list"}, new Object[]{"", "", "", "", "", 0L, "", 0, null, 0, "", "", ""}, Download.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField app_name = PBField.initString("");
        public final PBStringField pkg_name = PBField.initString("");
        public final PBStringField app_icon = PBField.initString("");
        public final PBStringField version_code = PBField.initString("");
        public final PBInt64Field pkg_size = PBField.initInt64(0);
        public final PBStringField download_url = PBField.initString("");
        public final PBEnumField game_status = PBField.initEnum(0);
        public final PBRepeatMessageField<Pair> extendss = PBField.initRepeatMessage(Pair.class);
        public final PBEnumField app_type = PBField.initEnum(0);
        public final PBStringField min_update_version_code = PBField.initString("");
        public final PBStringField tickets = PBField.initString("");
        public final PBRepeatField<String> label_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    }

    /* loaded from: classes33.dex */
    public static final class Pair extends MessageMicro<Pair> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, Pair.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }

    /* loaded from: classes33.dex */
    public static final class QueryDownloadReq extends MessageMicro<QueryDownloadReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platform", "channel_id", "app_ids"}, new Object[]{0, "", ""}, QueryDownloadReq.class);
        public final PBEnumField platform = PBField.initEnum(0);
        public final PBStringField channel_id = PBField.initString("");
        public final PBRepeatField<String> app_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    }

    /* loaded from: classes33.dex */
    public static final class QueryDownloadRsp extends MessageMicro<QueryDownloadRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"apps"}, new Object[]{null}, QueryDownloadRsp.class);
        public final PBRepeatMessageField<Download> apps = PBField.initRepeatMessage(Download.class);
    }

    DownloadManagerProto() {
    }
}
