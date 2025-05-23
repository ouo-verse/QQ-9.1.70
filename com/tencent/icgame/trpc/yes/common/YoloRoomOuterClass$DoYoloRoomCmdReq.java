package com.tencent.icgame.trpc.yes.common;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.luggage.wxa.gf.y;
import com.tencent.luggage.wxa.uf.h;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$DoYoloRoomCmdReq extends MessageMicro<YoloRoomOuterClass$DoYoloRoomCmdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{AudienceReportConst.ROOM_ID, "cmd_type", "client_seq_id", "yolo_room_cmd_req"}, new Object[]{0L, 0, 0L, null}, YoloRoomOuterClass$DoYoloRoomCmdReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field cmd_type = PBField.initInt32(0);
    public final PBUInt64Field client_seq_id = PBField.initUInt64(0);
    public YoloRoomOuterClass$YoloRoomCmdReq yolo_room_cmd_req = new MessageMicro<YoloRoomOuterClass$YoloRoomCmdReq>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 194, 202, 210, 218, 234, 274, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, y.CTRL_INDEX, 1202, 1610, 1626, 1658, 1842, 1850}, new String[]{"yolo_room_speaking_pos_change_cmd", "yolo_room_ready_status_change_cmd", "yolo_room_voice_switch_change_cmd", "yolo_room_modify_info_cmd", "yolo_room_speaking_pos_status_change_cmd", "yolo_room_greet_user_cmd", "yolo_room_complaint_user_cmd", "yolo_room_kick_out_speaking_cmd", "yolo_room_kick_out_room_cmd", "yolo_room_start_game_cmd", "yolo_room_join_game_cmd", "yolo_room_double_check_cmd", "yolo_room_invited_speaking_cmd", "yolo_room_apply_speaking_cmd", "yolo_room_agree_speaking_cmd", "yolo_room_speaking_user_update_cmd", "yolo_room_forbidden_speech_cmd", "yolo_room_reject_speaking_cmd", "yolo_room_send_gift_cmd", "yolo_room_battle_result_cmd", "yolo_game_room_remind_start_game_cmd", "yolo_smoba_room_chooce_hero", "yolo_smoba_room_remind_start_game_cmd", "yolo_smoba_room_change_role_cmd", "yolo_start_battle_ob_cmd", "yolo_close_battle_ob_cmd"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomCmdReq.class);
        public YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd yolo_room_speaking_pos_change_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 802, 808, 816, 824, 832, h.CTRL_INDEX, TVKTPCapability.HD_WIDTH}, new String[]{"op", "voice_switch", c.G, "no_user_type_check", "show_nick", "channel_tinyid", "bill_no", IPhotoLogicFactory.ENTER_FROM, "guild_id", "from_room_id", "channel_id", "channel_name", "sub_enter_from"}, new Object[]{0, 0, 0, 0, "", "", "", 0, 0L, 0L, 0L, "", 0}, YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd.class);

            /* renamed from: op, reason: collision with root package name */
            public final PBInt32Field f116218op = PBField.initInt32(0);
            public final PBInt32Field voice_switch = PBField.initInt32(0);
            public final PBInt32Field pos = PBField.initInt32(0);
            public final PBInt32Field no_user_type_check = PBField.initInt32(0);
            public final PBStringField show_nick = PBField.initString("");
            public final PBStringField channel_tinyid = PBField.initString("");
            public final PBStringField bill_no = PBField.initString("");
            public final PBInt32Field enter_from = PBField.initInt32(0);
            public final PBUInt64Field guild_id = PBField.initUInt64(0);
            public final PBUInt64Field from_room_id = PBField.initUInt64(0);
            public final PBUInt64Field channel_id = PBField.initUInt64(0);
            public final PBStringField channel_name = PBField.initString("");
            public final PBInt32Field sub_enter_from = PBField.initInt32(0);
        };
        public YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd yolo_room_ready_status_change_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"op"}, new Object[]{0}, YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd.class);

            /* renamed from: op, reason: collision with root package name */
            public final PBInt32Field f116216op = PBField.initInt32(0);
        };
        public YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd yolo_room_voice_switch_change_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 800}, new String[]{"uid", "op", "user_id", "change_switch_by_time_out"}, new Object[]{0L, 0, null, 0}, YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd.class);
            public final PBUInt64Field uid = PBField.initUInt64(0);

            /* renamed from: op, reason: collision with root package name */
            public final PBInt32Field f116222op = PBField.initInt32(0);
            public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
            public final PBInt32Field change_switch_by_time_out = PBField.initInt32(0);
        };
        public YoloRoomOuterClass$YoloRoomModifyInfoCmd yolo_room_modify_info_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomModifyInfoCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 42, 50, 58, 66, 74, 82}, new String[]{"room_params", "smoba_room_params", "comm_room_params", "game_room_params", "pubg_room_params", "qsm_room_params", "cfm_room_params", "codm_room_params"}, new Object[]{null, null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomModifyInfoCmd.class);
            public YoloRoomOuterClass$YoloRoomParams room_params = new YoloRoomOuterClass$YoloRoomParams();
            public YoloRoomOuterClass$YoloSmobaRoomParams smoba_room_params = new YoloRoomOuterClass$YoloSmobaRoomParams();
            public YoloRoomOuterClass$YoloCommunityRoomParams comm_room_params = new YoloRoomOuterClass$YoloCommunityRoomParams();
            public YoloRoomOuterClass$YoloGameRoomParams game_room_params = new YoloRoomOuterClass$YoloGameRoomParams();
            public YoloRoomOuterClass$YoloPubgRoomParams pubg_room_params = new YoloRoomOuterClass$YoloPubgRoomParams();
            public YoloRoomOuterClass$YoloQsmRoomParams qsm_room_params = new YoloRoomOuterClass$YoloQsmRoomParams();
            public YoloRoomOuterClass$YoloCfmRoomParams cfm_room_params = new YoloRoomOuterClass$YoloCfmRoomParams();
            public YoloRoomOuterClass$YoloCodmRoomParams codm_room_params = new YoloRoomOuterClass$YoloCodmRoomParams();
        };
        public YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd yolo_room_speaking_pos_status_change_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"op", c.G}, new Object[]{0, 0}, YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd.class);

            /* renamed from: op, reason: collision with root package name */
            public final PBInt32Field f116220op = PBField.initInt32(0);
            public final PBUInt32Field pos = PBField.initUInt32(0);
        };
        public YoloRoomOuterClass$YoloRoomGreetUserCmd yolo_room_greet_user_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomGreetUserCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomGreetUserCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"greet_uid", "greet_nick", "greet_user_id"}, new Object[]{0L, "", null}, YoloRoomOuterClass$YoloRoomGreetUserCmd.class);
            public final PBUInt64Field greet_uid = PBField.initUInt64(0);
            public final PBStringField greet_nick = PBField.initString("");
            public CommonOuterClass$QQUserId greet_user_id = new CommonOuterClass$QQUserId();
        };
        public YoloRoomOuterClass$YoloRoomComplaintUserCmd yolo_room_complaint_user_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomComplaintUserCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomComplaintUserCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uid", "reason", "user_id"}, new Object[]{0L, "", null}, YoloRoomOuterClass$YoloRoomComplaintUserCmd.class);
            public final PBUInt64Field uid = PBField.initUInt64(0);
            public final PBStringField reason = PBField.initString("");
            public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        };
        public YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd yolo_room_kick_out_speaking_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 808}, new String[]{"uid", "is_close_pos", "user_id", "no_action"}, new Object[]{0L, 0, null, 0}, YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd.class);
            public final PBUInt64Field uid = PBField.initUInt64(0);
            public final PBInt32Field is_close_pos = PBField.initInt32(0);
            public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
            public final PBInt32Field no_action = PBField.initInt32(0);
        };
        public YoloRoomOuterClass$YoloRoomKickOutRoomCmd yolo_room_kick_out_room_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomKickOutRoomCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomKickOutRoomCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uid", "is_close_pos", "reason", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "user_id"}, new Object[]{0L, 0, 0L, 0, null}, YoloRoomOuterClass$YoloRoomKickOutRoomCmd.class);
            public final PBUInt64Field uid = PBField.initUInt64(0);
            public final PBInt32Field is_close_pos = PBField.initInt32(0);
            public final PBUInt64Field reason = PBField.initUInt64(0);
            public final PBUInt32Field second = PBField.initUInt32(0);
            public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        };
        public YoloRoomOuterClass$YoloRoomStartGameCmd yolo_room_start_game_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomStartGameCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloRoomStartGameCmd.class);
        };
        public YoloRoomOuterClass$YoloRoomJoinGameCmd yolo_room_join_game_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomJoinGameCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomJoinGameCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloRoomJoinGameCmd.class);
        };
        public YoloRoomOuterClass$YoloRoomDoubleCheckCmd yolo_room_double_check_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomDoubleCheckCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomDoubleCheckCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloRoomDoubleCheckCmd.class);
        };
        public YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd yolo_room_invited_speaking_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "user_id"}, new Object[]{0L, null}, YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd.class);
            public final PBUInt64Field uid = PBField.initUInt64(0);
            public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        };
        public YoloRoomOuterClass$YoloRoomApplySpeakingCmd yolo_room_apply_speaking_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomApplySpeakingCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloRoomApplySpeakingCmd.class);
        };
        public YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd yolo_room_agree_speaking_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "user_id"}, new Object[]{0L, null}, YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd.class);
            public final PBUInt64Field uid = PBField.initUInt64(0);
            public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        };
        public YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd yolo_room_speaking_user_update_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"leave_status", "user_game_data"}, new Object[]{0, null}, YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd.class);
            public final PBInt32Field leave_status = PBField.initInt32(0);
            public YoloRoomOuterClass$YoloUserGameData user_game_data = new YoloRoomOuterClass$YoloUserGameData();
        };
        public YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd yolo_room_forbidden_speech_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uid", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "is_gm_forbidden", "user_id"}, new Object[]{0L, 0, Boolean.FALSE, null}, YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd.class);
            public final PBUInt64Field uid = PBField.initUInt64(0);
            public final PBInt32Field second = PBField.initInt32(0);
            public final PBBoolField is_gm_forbidden = PBField.initBool(false);
            public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        };
        public YoloRoomOuterClass$YoloRoomRejectSpeakingCmd yolo_room_reject_speaking_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomRejectSpeakingCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomRejectSpeakingCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "user_id"}, new Object[]{0L, null}, YoloRoomOuterClass$YoloRoomRejectSpeakingCmd.class);
            public final PBUInt64Field uid = PBField.initUInt64(0);
            public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        };
        public YoloRoomOuterClass$YoloRoomSendGiftCmd yolo_room_send_gift_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomSendGiftCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSendGiftCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 64, 74, 80, 90, 98, 104}, new String[]{"recv_user_id", "gift_id", "total_num", "bill_no", "base_num", "combo_seq", "scene_id", "gift_type", "gift_name", "combo_cnt", "client_str", "send_user_id_list", "gift_material_id"}, new Object[]{null, 0, 0, "", 0, 0, 0, 0, "", 0, "", null, 0}, YoloRoomOuterClass$YoloRoomSendGiftCmd.class);
            public CommonOuterClass$QQUserId recv_user_id = new CommonOuterClass$QQUserId();
            public final PBInt32Field gift_id = PBField.initInt32(0);
            public final PBInt32Field total_num = PBField.initInt32(0);
            public final PBStringField bill_no = PBField.initString("");
            public final PBInt32Field base_num = PBField.initInt32(0);
            public final PBUInt32Field combo_seq = PBField.initUInt32(0);
            public final PBUInt32Field scene_id = PBField.initUInt32(0);
            public final PBUInt32Field gift_type = PBField.initUInt32(0);
            public final PBStringField gift_name = PBField.initString("");
            public final PBUInt32Field combo_cnt = PBField.initUInt32(0);
            public final PBStringField client_str = PBField.initString("");
            public final PBRepeatMessageField<CommonOuterClass$QQUserId> send_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
            public final PBInt32Field gift_material_id = PBField.initInt32(0);
        };
        public YoloRoomOuterClass$YoloRoomBattleResultCmd yolo_room_battle_result_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomBattleResultCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomBattleResultCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"smoba_battle_result", "pubg_settle_data", "qsm_battle_result", "cfm_battle_result", "codm_team_settle_data"}, new Object[]{null, null, null, null, null}, YoloRoomOuterClass$YoloRoomBattleResultCmd.class);
            public YoloBattleSmobaOuterClass$YoloSmobaBattleResult smoba_battle_result = new YoloBattleSmobaOuterClass$YoloSmobaBattleResult();
            public YoloRoomOuterClass$YoloPubgSettleData pubg_settle_data = new YoloRoomOuterClass$YoloPubgSettleData();
            public QsmDataOuterClass$QSMBattleResult qsm_battle_result = new QsmDataOuterClass$QSMBattleResult();
            public CfmDataOuterClass$CFMBattleResult cfm_battle_result = new CfmDataOuterClass$CFMBattleResult();
            public CodmDataOuterClass$CODMTeamSettleEvent codm_team_settle_data = new CodmDataOuterClass$CODMTeamSettleEvent();
        };
        public YoloRoomOuterClass$YoloGameRoomRemindStartGameCmd yolo_game_room_remind_start_game_cmd = new MessageMicro<YoloRoomOuterClass$YoloGameRoomRemindStartGameCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloGameRoomRemindStartGameCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloGameRoomRemindStartGameCmd.class);
        };
        public YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd yolo_smoba_room_chooce_hero = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"game_rolo_hero_info", "hero_lane_type"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd.class);
            public GameDataServerOuterClass$GameRoleHeroInfo game_rolo_hero_info = new GameDataServerOuterClass$GameRoleHeroInfo();
            public final PBInt32Field hero_lane_type = PBField.initInt32(0);
        };
        public YoloRoomOuterClass$YoloSmobaRoomRemindStartGameCmd yolo_smoba_room_remind_start_game_cmd = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomRemindStartGameCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomRemindStartGameCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloRoomOuterClass$YoloSmobaRoomRemindStartGameCmd.class);
        };
        public YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd yolo_smoba_room_change_role_cmd = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"role_id", "role_abs_info", "role_info"}, new Object[]{null, null, null}, YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd.class);
            public GameDataServerOuterClass$GameRoleId role_id = new GameDataServerOuterClass$GameRoleId();
            public GameDataServerOuterClass$GameRoleAbsInfo role_abs_info = new GameDataServerOuterClass$GameRoleAbsInfo();
            public GameDataServerOuterClass$GameRoleInfo role_info = new GameDataServerOuterClass$GameRoleInfo();
        };
        public YoloRoomOuterClass$YoloStartBattleOBCmd yolo_start_battle_ob_cmd = new MessageMicro<YoloRoomOuterClass$YoloStartBattleOBCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloStartBattleOBCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"device_id", "yolo_battle_id"}, new Object[]{"", 0L}, YoloRoomOuterClass$YoloStartBattleOBCmd.class);
            public final PBStringField device_id = PBField.initString("");
            public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
        };
        public YoloRoomOuterClass$YoloCloseBattleOBCmd yolo_close_battle_ob_cmd = new MessageMicro<YoloRoomOuterClass$YoloCloseBattleOBCmd>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCloseBattleOBCmd
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ob_id", "yolo_battle_id"}, new Object[]{0L, 0L}, YoloRoomOuterClass$YoloCloseBattleOBCmd.class);
            public final PBInt64Field ob_id = PBField.initInt64(0);
            public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
        };
    };
}
