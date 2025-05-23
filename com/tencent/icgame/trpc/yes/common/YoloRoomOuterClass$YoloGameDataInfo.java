package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloGameDataInfo extends MessageMicro<YoloRoomOuterClass$YoloGameDataInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 42, 50, 58, 66, 74, 82}, new String[]{"smoba_game_data_info", "community_game_data_info", "pubg_game_data_info", "common_game_data_info", "qsm_game_data_info", "cfm_game_data_info", "codm_game_data_info"}, new Object[]{null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloGameDataInfo.class);
    public YoloRoomOuterClass$YoloSmobaGameDataInfo smoba_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloSmobaGameDataInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "game_mode", "grade_list", "voice_control", "mode_name", "create_type", "is_auto_dismiss", "is_off_double_check", "base_room_id", "need_lane_type", "use_smoba_grade_check_rule"}, new Object[]{0, 0, 0, 0, "", 0, 0, 0, 0L, 0, Boolean.FALSE}, YoloRoomOuterClass$YoloSmobaGameDataInfo.class);
        public final PBUInt64Field base_room_id;
        public final PBInt32Field create_type;
        public final PBRepeatField<Integer> grade_list;
        public final PBInt32Field is_auto_dismiss;
        public final PBInt32Field is_off_double_check;
        public final PBStringField mode_name;
        public final PBRepeatField<Integer> need_lane_type;
        public final PBBoolField use_smoba_grade_check_rule;
        public final PBInt32Field voice_control;
        public final PBInt32Field area = PBField.initInt32(0);
        public final PBInt32Field game_mode = PBField.initInt32(0);

        {
            PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
            this.grade_list = PBField.initRepeat(pBInt32Field);
            this.voice_control = PBField.initInt32(0);
            this.mode_name = PBField.initString("");
            this.create_type = PBField.initInt32(0);
            this.is_auto_dismiss = PBField.initInt32(0);
            this.is_off_double_check = PBField.initInt32(0);
            this.base_room_id = PBField.initUInt64(0L);
            this.need_lane_type = PBField.initRepeat(pBInt32Field);
            this.use_smoba_grade_check_rule = PBField.initBool(false);
        }
    };
    public YoloRoomOuterClass$YoloCommunityGameDataInfo community_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloCommunityGameDataInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCommunityGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"game_id"}, new Object[]{0}, YoloRoomOuterClass$YoloCommunityGameDataInfo.class);
        public final PBInt32Field game_id = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloPubgGameDataInfo pubg_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloPubgGameDataInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloPubgGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24}, new String[]{"min_role_level"}, new Object[]{0}, YoloRoomOuterClass$YoloPubgGameDataInfo.class);
        public final PBInt32Field min_role_level = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloCommonGameDataInfo common_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloCommonGameDataInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBInt32Field create_type = PBField.initInt32(0);
        public final PBInt32Field is_auto_dismiss = PBField.initInt32(0);
        public final PBInt32Field is_off_double_check = PBField.initInt32(0);
        public final PBUInt64Field base_room_id = PBField.initUInt64(0);
        public final PBInt32Field game_mode = PBField.initInt32(0);
        public final PBRepeatField<Integer> grade_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
        public final PBStringField game_desc = PBField.initString("");
        public final PBStringField mode_name = PBField.initString("");
        public YoloRoomOuterClass$YoloGiftConfig gift_config = new YoloRoomOuterClass$YoloGiftConfig();
        public YoloRoomOuterClass$QQLiveRoomConfig qq_live_room_config = new YoloRoomOuterClass$QQLiveRoomConfig();
        public final PBRepeatMessageField<YoloRoomOuterClass$ListParam> list_param_list = PBField.initRepeatMessage(YoloRoomOuterClass$ListParam.class);
        public final PBStringField client_min_version = PBField.initString("");
        public final PBInt32Field launch_game_type = PBField.initInt32(0);
        public final PBBoolField create_with_battle = PBField.initBool(false);
        public final PBBoolField join_with_battle = PBField.initBool(false);
        public final PBBoolField owner_related_game_room = PBField.initBool(false);
        public final PBBoolField player_related_game_room = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74, 82, 90, 802, 808, 816, 824, 832, 840}, new String[]{"create_type", "is_auto_dismiss", "is_off_double_check", "base_room_id", "game_mode", "grade_list", "game_desc", "mode_name", "gift_config", "qq_live_room_config", "list_param_list", "client_min_version", "launch_game_type", "create_with_battle", "join_with_battle", "owner_related_game_room", "player_related_game_room"}, new Object[]{0, 0, 0, 0L, 0, 0, "", "", null, null, null, "", 0, bool, bool, bool, bool}, YoloRoomOuterClass$YoloCommonGameDataInfo.class);
        }
    };
    public YoloRoomOuterClass$YoloQsmGameDataInfo qsm_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloQsmGameDataInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloQsmGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloQsmGameDataInfo.class);
    };
    public YoloRoomOuterClass$YoloCfmGameDataInfo cfm_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloCfmGameDataInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCfmGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"play_mode", "map_id", "match_type", "mode_type"}, new Object[]{0, 0, 0, 0}, YoloRoomOuterClass$YoloCfmGameDataInfo.class);
        public final PBInt32Field play_mode = PBField.initInt32(0);
        public final PBInt32Field map_id = PBField.initInt32(0);
        public final PBInt32Field match_type = PBField.initInt32(0);
        public final PBInt32Field mode_type = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloCodmGameDataInfo codm_game_data_info = new MessageMicro<YoloRoomOuterClass$YoloCodmGameDataInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCodmGameDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"room_type", "play_list"}, new Object[]{0, ""}, YoloRoomOuterClass$YoloCodmGameDataInfo.class);
        public final PBUInt32Field room_type = PBField.initUInt32(0);
        public final PBRepeatField<String> play_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
