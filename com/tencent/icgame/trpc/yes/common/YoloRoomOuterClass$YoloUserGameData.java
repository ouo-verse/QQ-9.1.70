package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloUserGameData extends MessageMicro<YoloRoomOuterClass$YoloUserGameData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"user_smoba_game_data", "user_common_game_data", "user_pubg_game_data", "user_qsm_game_data", "user_cfm_game_data", "user_codm_game_data"}, new Object[]{null, null, null, null, null, null}, YoloRoomOuterClass$YoloUserGameData.class);
    public YoloRoomOuterClass$YoloSmobaUserGameData user_smoba_game_data = new MessageMicro<YoloRoomOuterClass$YoloSmobaUserGameData>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 96, 104, 122, 808}, new String[]{"role_id", "role_abs_info", "game_rolo_hero_info", "hero_lane_type", "game_status", "update_status", "update_process", MsfConstants.ATTRIBUTE_LOGIN_TYPE, "phone_system", "role_info", "last_notify_time"}, new Object[]{null, null, null, 0, 0, 0, 0, 0, 0, null, 0}, YoloRoomOuterClass$YoloSmobaUserGameData.class);
        public GameDataServerOuterClass$GameRoleId role_id = new GameDataServerOuterClass$GameRoleId();
        public GameDataServerOuterClass$GameRoleAbsInfo role_abs_info = new GameDataServerOuterClass$GameRoleAbsInfo();
        public GameDataServerOuterClass$GameRoleHeroInfo game_rolo_hero_info = new GameDataServerOuterClass$GameRoleHeroInfo();
        public final PBInt32Field hero_lane_type = PBField.initInt32(0);
        public final PBInt32Field game_status = PBField.initInt32(0);
        public final PBInt32Field update_status = PBField.initInt32(0);
        public final PBInt32Field update_process = PBField.initInt32(0);
        public final PBInt32Field login_type = PBField.initInt32(0);
        public final PBInt32Field phone_system = PBField.initInt32(0);
        public GameDataServerOuterClass$GameRoleInfo role_info = new GameDataServerOuterClass$GameRoleInfo();
        public final PBUInt32Field last_notify_time = PBField.initUInt32(0);
    };
    public YoloRoomOuterClass$YoloCommonUserGameData user_common_game_data = new MessageMicro<YoloRoomOuterClass$YoloCommonUserGameData>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCommonUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 64, 74, 82, 88, 96, 106, 802, 810}, new String[]{"game_status", "game_status_desc", "user_room_status", "user_room_status_desc", "update_status", "update_process", MsfConstants.ATTRIBUTE_LOGIN_TYPE, "phone_system", "game_openid", "game_role_info", "user_room_status_button_style", "user_room_status_button_event", "game_gopenid", "gift_data", "tgpa_version_info"}, new Object[]{0, "", 0, "", 0, 0, 0, 0, "", null, 0, 0, "", null, null}, YoloRoomOuterClass$YoloCommonUserGameData.class);
        public final PBInt32Field game_status = PBField.initInt32(0);
        public final PBStringField game_status_desc = PBField.initString("");
        public final PBInt32Field user_room_status = PBField.initInt32(0);
        public final PBStringField user_room_status_desc = PBField.initString("");
        public final PBInt32Field update_status = PBField.initInt32(0);
        public final PBInt32Field update_process = PBField.initInt32(0);
        public final PBInt32Field login_type = PBField.initInt32(0);
        public final PBInt32Field phone_system = PBField.initInt32(0);
        public final PBStringField game_openid = PBField.initString("");
        public YesGameInfoOuterClass$YesGameRoleInfo game_role_info = new YesGameInfoOuterClass$YesGameRoleInfo();
        public final PBInt32Field user_room_status_button_style = PBField.initInt32(0);
        public final PBInt32Field user_room_status_button_event = PBField.initInt32(0);
        public final PBStringField game_gopenid = PBField.initString("");
        public YoloRoomOuterClass$YoloGiftData gift_data = new MessageMicro<YoloRoomOuterClass$YoloGiftData>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloGiftData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"task_id", "bill_no"}, new Object[]{"", ""}, YoloRoomOuterClass$YoloGiftData.class);
            public final PBStringField task_id = PBField.initString("");
            public final PBStringField bill_no = PBField.initString("");
        };
        public UserProxyCmdOuterClass$TgpaNewVersionInfo tgpa_version_info = new UserProxyCmdOuterClass$TgpaNewVersionInfo();
    };
    public YoloRoomOuterClass$YoloPubgUserGameData user_pubg_game_data = new MessageMicro<YoloRoomOuterClass$YoloPubgUserGameData>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloPubgUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloPubgUserGameData.class);
    };
    public YoloRoomOuterClass$YoloQsmUserGameData user_qsm_game_data = new MessageMicro<YoloRoomOuterClass$YoloQsmUserGameData>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloQsmUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloQsmUserGameData.class);
    };
    public YoloRoomOuterClass$YoloCfmUserGameData user_cfm_game_data = new MessageMicro<YoloRoomOuterClass$YoloCfmUserGameData>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCfmUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloCfmUserGameData.class);
    };
    public YoloRoomOuterClass$YoloCodmUserGameData user_codm_game_data = new MessageMicro<YoloRoomOuterClass$YoloCodmUserGameData>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCodmUserGameData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloCodmUserGameData.class);
    };
}
