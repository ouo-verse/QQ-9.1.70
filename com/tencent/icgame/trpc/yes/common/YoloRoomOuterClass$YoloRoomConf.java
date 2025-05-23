package com.tencent.icgame.trpc.yes.common;

import com.tencent.icgame.trpc.yes.wuji.WujiSafeOuterClass$WujiSafeConf;
import com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCfmRoomConf;
import com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCodmRoomConf;
import com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
import com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloPubgRoomConf;
import com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloQsmRoomConf;
import com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tenpay.sdk.util.UinConfigManager;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomConf extends MessageMicro<YoloRoomOuterClass$YoloRoomConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 50, 58, 66, 74, 82, 90}, new String[]{"yolo_room_smoba_conf", "yolo_room_common_conf", "yolo_room_community_conf", "yolo_room_pubg_conf", "yolo_room_game_conf", "yolo_room_qsm_conf", "yolo_room_cfm_conf", "yolo_room_codm_conf"}, new Object[]{null, null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomConf.class);
    public YoloRoomOuterClass$YoloRoomSmobaConf yolo_room_smoba_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomSmobaConf>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSmobaConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_smoba_room_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomSmobaConf.class);
        public WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf yolo_smoba_room_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf>() { // from class: com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBInt32Field lanetype_message_send_time_interval = PBField.initInt32(0);
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "lanetype_message_send_time_interval", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", 0, bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf.class);
            }
        };
    };
    public YoloRoomOuterClass$YoloRoomCommonConf yolo_room_common_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomCommonConf>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomCommonConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66}, new String[]{"get_data_pull_time", "forbidden_speech_conf_list", "tag_list", "safe_conf", "is_ios_audit", "greet_words_list", "enter_room_greet_words_list", "game_config_info"}, new Object[]{0, null, "", null, Boolean.FALSE, "", "", null}, YoloRoomOuterClass$YoloRoomCommonConf.class);
        public final PBRepeatField<String> enter_room_greet_words_list;
        public YesGameInfoOuterClass$GameConfigInfo game_config_info;
        public final PBRepeatField<String> greet_words_list;
        public final PBBoolField is_ios_audit;
        public WujiSafeOuterClass$WujiSafeConf safe_conf;
        public final PBRepeatField<String> tag_list;
        public final PBInt32Field get_data_pull_time = PBField.initInt32(0);
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomForbiddenSpeechConf> forbidden_speech_conf_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomForbiddenSpeechConf.class);

        /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.icgame.trpc.yes.wuji.WujiSafeOuterClass$WujiSafeConf] */
        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.tag_list = PBField.initRepeat(pBStringField);
            this.safe_conf = new MessageMicro<WujiSafeOuterClass$WujiSafeConf>() { // from class: com.tencent.icgame.trpc.yes.wuji.WujiSafeOuterClass$WujiSafeConf
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64}, new String[]{"id", "send_interval_times", "forbidden_speech_time", "system_notice_message_num", "introduce", "game_room_send_interval_times", "send_greet_interval_times", "forbidden_speech_time_list"}, new Object[]{0, 0, 0, 0, "", 0, 0, 0}, WujiSafeOuterClass$WujiSafeConf.class);

                /* renamed from: id, reason: collision with root package name */
                public final PBInt32Field f116223id = PBField.initInt32(0);
                public final PBInt32Field send_interval_times = PBField.initInt32(0);
                public final PBInt32Field forbidden_speech_time = PBField.initInt32(0);
                public final PBInt32Field system_notice_message_num = PBField.initInt32(0);
                public final PBStringField introduce = PBField.initString("");
                public final PBInt32Field game_room_send_interval_times = PBField.initInt32(0);
                public final PBInt32Field send_greet_interval_times = PBField.initInt32(0);
                public final PBRepeatField<Integer> forbidden_speech_time_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
            };
            this.is_ios_audit = PBField.initBool(false);
            this.greet_words_list = PBField.initRepeat(pBStringField);
            this.enter_room_greet_words_list = PBField.initRepeat(pBStringField);
            this.game_config_info = new YesGameInfoOuterClass$GameConfigInfo();
        }
    };
    public YoloRoomOuterClass$YoloRoomCommunityConf yolo_room_community_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomCommunityConf>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomCommunityConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"wuji_yolo_room_community_conf", "add_friend_tips_text_list"}, new Object[]{null, ""}, YoloRoomOuterClass$YoloRoomCommunityConf.class);
        public WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wuji_yolo_room_community_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf>() { // from class: com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBInt32Field create_from = PBField.initInt32(0);
            public final PBStringField introduce = PBField.initString("");
            public final PBStringField notice = PBField.initString("");
            public final PBStringField room_cover = PBField.initString("");
            public final PBStringField room_background_img = PBField.initString("");
            public final PBRepeatMessageField<WujiYoloRoomOuterClass$WujiYoloRoomCommunityOnlineNumItem> online_num_items = PBField.initRepeatMessage(WujiYoloRoomOuterClass$WujiYoloRoomCommunityOnlineNumItem.class);
            public final PBStringField room_detail_background_img = PBField.initString("");
            public final PBInt32Field max_user_limit = PBField.initInt32(0);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField speaking_list_switch = PBField.initBool(false);
            public final PBBoolField is_show_third_part_gift = PBField.initBool(false);
            public final PBInt32Field apply_speaking_time_interval = PBField.initInt32(0);
            public final PBInt32Field kick_out_speaking_normal_user_time_interval = PBField.initInt32(0);
            public final PBBoolField apply_speaking_switch = PBField.initBool(false);
            public final PBInt32Field last_comm_room_stay_time = PBField.initInt32(0);
            public final PBInt32Field last_comm_room_cache_time = PBField.initInt32(0);
            public final PBStringField room_pin_icon = PBField.initString("");

            static {
                String[] strArr = {"create_from", "introduce", UinConfigManager.KEY_ADS, "room_cover", "room_background_img", "online_num_items", "room_detail_background_img", "max_user_limit", "room_background_img_v2", "room_background_color_v2", "speaking_list_switch", "is_show_third_part_gift", "apply_speaking_time_interval", "kick_out_speaking_normal_user_time_interval", "apply_speaking_switch", "last_comm_room_stay_time", "last_comm_room_cache_time", "room_pin_icon"};
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 74, 82, 88, 96, 104, 112, 120, 128, 136, 146}, strArr, new Object[]{0, "", "", "", "", null, "", 0, "", "", bool, bool, 0, 0, bool, 0, 0, ""}, WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.class);
            }
        };
        public final PBRepeatField<String> add_friend_tips_text_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public YoloRoomOuterClass$YoloRoomPubgConf yolo_room_pubg_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomPubgConf>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomPubgConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_room_pubg_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomPubgConf.class);
        public WujiYoloRoomOuterClass$WujiYoloPubgRoomConf yolo_room_pubg_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloPubgRoomConf>() { // from class: com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloPubgRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloPubgRoomConf.class);
            }
        };
    };
    public YoloRoomOuterClass$YoloRoomGameConf yolo_room_game_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomGameConf>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomGameConf
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField room_background_img = PBField.initString("");
        public final PBBoolField is_use_voice = PBField.initBool(false);
        public final PBStringField room_background_img_v2 = PBField.initString("");
        public final PBStringField room_background_color_v2 = PBField.initString("");
        public final PBBoolField is_use_tgpa = PBField.initBool(false);
        public final PBStringField game_room_notice = PBField.initString("");

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "game_room_notice"}, new Object[]{"", bool, "", "", bool, ""}, YoloRoomOuterClass$YoloRoomGameConf.class);
        }
    };
    public YoloRoomOuterClass$YoloRoomQsmConf yolo_room_qsm_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomQsmConf>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomQsmConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_room_qsm_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomQsmConf.class);
        public WujiYoloRoomOuterClass$WujiYoloQsmRoomConf yolo_room_qsm_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloQsmRoomConf>() { // from class: com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloQsmRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloQsmRoomConf.class);
            }
        };
    };
    public YoloRoomOuterClass$YoloRoomCfmConf yolo_room_cfm_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomCfmConf>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomCfmConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_room_cfm_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomCfmConf.class);
        public WujiYoloRoomOuterClass$WujiYoloCfmRoomConf yolo_room_cfm_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloCfmRoomConf>() { // from class: com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCfmRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloCfmRoomConf.class);
            }
        };
    };
    public YoloRoomOuterClass$YoloRoomCodmConf yolo_room_codm_conf = new MessageMicro<YoloRoomOuterClass$YoloRoomCodmConf>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomCodmConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"yolo_room_codm_conf"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomCodmConf.class);
        public WujiYoloRoomOuterClass$WujiYoloCodmRoomConf yolo_room_codm_conf = new MessageMicro<WujiYoloRoomOuterClass$WujiYoloCodmRoomConf>() { // from class: com.tencent.icgame.trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCodmRoomConf
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField room_background_img = PBField.initString("");
            public final PBBoolField is_use_voice = PBField.initBool(false);
            public final PBStringField room_background_img_v2 = PBField.initString("");
            public final PBStringField room_background_color_v2 = PBField.initString("");
            public final PBBoolField is_use_tgpa = PBField.initBool(false);
            public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
            public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
            public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloCodmRoomConf.class);
            }
        };
    };
}
