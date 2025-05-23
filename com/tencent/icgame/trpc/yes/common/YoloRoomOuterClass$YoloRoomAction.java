package com.tencent.icgame.trpc.yes.common;

import com.tencent.luggage.wxa.gf.y;
import com.tencent.luggage.wxa.uf.h;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomAction extends MessageMicro<YoloRoomOuterClass$YoloRoomAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 90, 98, 106, 114, 122, 130, 146, 154, 162, 170, 178, 194, 202, 210, 218, 234, 274, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, h.CTRL_INDEX, 858, 866, y.CTRL_INDEX, 1202, 1210, SubAccountBindActivity.ERROR_ACCOUNT_NOT_EXIST, 1226, 1234, 1610, 1626, 1634, 1658, 2010, 2018, 2082}, new String[]{"action_id", "action_time", "action_type", "client_seq_id", "yolo_room_speaking_pos_change_action", "yolo_room_ready_status_change_action", "yolo_room_voice_switch_change_action", "yolo_room_modify_info_action", "yolo_room_speaking_pos_status_change_action", "yolo_room_greet_user_action", "yolo_room_kick_out_speaking_action", "yolo_room_kick_out_room_action", "yolo_room_start_game_action", "yolo_room_join_game_action", "yolo_room_double_check_action", "yolo_room_invited_speaking_action", "yolo_room_apply_speaking_action", "yolo_room_agree_speaking_action", "yolo_room_speaking_user_status_update_action", "yolo_room_forbidden_speech_action", "yolo_room_reject_speaking_action", "yolo_room_enter_action", "yolo_room_leave_action", "yolo_room_send_gift_action", "yolo_room_speaking_pos_list_init_action", "yolo_room_close_game_action", "yolo_room_update_game_route_info_action", "yolo_room_battle_result_action", "yolo_game_room_remind_owner_start_game_action", "yolo_game_room_owner_change_action", "yolo_game_room_team_create_tips_action", "yolo_game_room_send_notice_action", "yolo_game_room_settle_gift_notice_action", "yolo_smoba_room_chooce_hero_action", "yolo_smoba_room_remind_owner_start_game_action", "yolo_smoba_room_remind_user_start_game_action", "yolo_smoba_room_change_role_action", "yolo_smoba_room_owner_change_action", "yolo_smoba_room_battle_result_action", "yolo_battle_ob_status_change_action"}, new Object[]{0L, 0L, 11, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomAction.class);
    public final PBUInt64Field action_id = PBField.initUInt64(0);
    public final PBUInt64Field action_time = PBField.initUInt64(0);
    public final PBEnumField action_type = PBField.initEnum(11);
    public final PBUInt64Field client_seq_id = PBField.initUInt64(0);
    public YoloRoomOuterClass$YoloRoomSpeakingPosChangeAction yolo_room_speaking_pos_change_action = new MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosChangeAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosChangeAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"op", "room_speaking_pos", "speaking_pos_list_version"}, new Object[]{0, null, 0}, YoloRoomOuterClass$YoloRoomSpeakingPosChangeAction.class);

        /* renamed from: op, reason: collision with root package name */
        public final PBInt32Field f116217op = PBField.initInt32(0);
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomReadyStatusChangeAction yolo_room_ready_status_change_action = new MessageMicro<YoloRoomOuterClass$YoloRoomReadyStatusChangeAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomReadyStatusChangeAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"op", "room_speaking_pos", "speaking_pos_list_version"}, new Object[]{0, null, 0}, YoloRoomOuterClass$YoloRoomReadyStatusChangeAction.class);

        /* renamed from: op, reason: collision with root package name */
        public final PBInt32Field f116215op = PBField.initInt32(0);
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction yolo_room_voice_switch_change_action = new MessageMicro<YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"op", "room_speaking_pos", "speaking_pos_list_version"}, new Object[]{0, null, 0}, YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction.class);

        /* renamed from: op, reason: collision with root package name */
        public final PBInt32Field f116221op = PBField.initInt32(0);
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomModifyInfoAction yolo_room_modify_info_action = new MessageMicro<YoloRoomOuterClass$YoloRoomModifyInfoAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"action_content_list", AegisLogger.ROOM_INFO, "room_speaking_pos_list", "speaking_pos_list_version"}, new Object[]{null, null, null, 0}, YoloRoomOuterClass$YoloRoomModifyInfoAction.class);
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomModifyInfoActionContent> action_content_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomModifyInfoActionContent.class);
        public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction yolo_room_speaking_pos_status_change_action = new MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"op", "room_speaking_pos", "speaking_pos_list_version"}, new Object[]{0, null, 0}, YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction.class);

        /* renamed from: op, reason: collision with root package name */
        public final PBInt32Field f116219op = PBField.initInt32(0);
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomGreetUserAction yolo_room_greet_user_action = new MessageMicro<YoloRoomOuterClass$YoloRoomGreetUserAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomGreetUserAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_id", "greet_user_id", "greet_words"}, new Object[]{null, null, ""}, YoloRoomOuterClass$YoloRoomGreetUserAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        public CommonOuterClass$QQUserId greet_user_id = new CommonOuterClass$QQUserId();
        public final PBStringField greet_words = PBField.initString("");
    };
    public YoloRoomOuterClass$YoloRoomKickOutSpeakingAction yolo_room_kick_out_speaking_action = new MessageMicro<YoloRoomOuterClass$YoloRoomKickOutSpeakingAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomKickOutSpeakingAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"user_id", "room_speaking_pos", "speaking_pos_list_version", "reason"}, new Object[]{null, null, 0, 0}, YoloRoomOuterClass$YoloRoomKickOutSpeakingAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
        public final PBInt32Field reason = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomKickOutRoomAction yolo_room_kick_out_room_action = new MessageMicro<YoloRoomOuterClass$YoloRoomKickOutRoomAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomKickOutRoomAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"user_id", "room_speaking_pos", "speaking_pos_list_version", "reason"}, new Object[]{null, null, 0, 0L}, YoloRoomOuterClass$YoloRoomKickOutRoomAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
        public final PBUInt64Field reason = PBField.initUInt64(0);
    };
    public YoloRoomOuterClass$YoloRoomStartGameAction yolo_room_start_game_action = new MessageMicro<YoloRoomOuterClass$YoloRoomStartGameAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{AegisLogger.ROOM_INFO, "room_speaking_pos_list", "speaking_pos_list_version"}, new Object[]{null, null, 0}, YoloRoomOuterClass$YoloRoomStartGameAction.class);
        public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomJoinGameAction yolo_room_join_game_action = new MessageMicro<YoloRoomOuterClass$YoloRoomJoinGameAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomJoinGameAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{AegisLogger.ROOM_INFO, "user_id", "room_speaking_pos_list", "speaking_pos_list_version"}, new Object[]{null, null, null, 0}, YoloRoomOuterClass$YoloRoomJoinGameAction.class);
        public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomDoubleCheckAction yolo_room_double_check_action = new MessageMicro<YoloRoomOuterClass$YoloRoomDoubleCheckAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomDoubleCheckAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{AegisLogger.ROOM_INFO}, new Object[]{null}, YoloRoomOuterClass$YoloRoomDoubleCheckAction.class);
        public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    };
    public YoloRoomOuterClass$YoloRoomInvitedSpeakingAction yolo_room_invited_speaking_action = new MessageMicro<YoloRoomOuterClass$YoloRoomInvitedSpeakingAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomInvitedSpeakingAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"invite_user_id", "invited_user_id", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{null, null, 0L}, YoloRoomOuterClass$YoloRoomInvitedSpeakingAction.class);
        public CommonOuterClass$QQUserId invite_user_id = new CommonOuterClass$QQUserId();
        public CommonOuterClass$QQUserId invited_user_id = new CommonOuterClass$QQUserId();
        public final PBUInt64Field expire_time = PBField.initUInt64(0);
    };
    public YoloRoomOuterClass$YoloRoomApplySpeakingAction yolo_room_apply_speaking_action = new MessageMicro<YoloRoomOuterClass$YoloRoomApplySpeakingAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_id", "apply_time_ms"}, new Object[]{null, 0L}, YoloRoomOuterClass$YoloRoomApplySpeakingAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        public final PBUInt64Field apply_time_ms = PBField.initUInt64(0);
    };
    public YoloRoomOuterClass$YoloRoomAgreeSpeakingAction yolo_room_agree_speaking_action = new MessageMicro<YoloRoomOuterClass$YoloRoomAgreeSpeakingAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomAgreeSpeakingAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_id"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomAgreeSpeakingAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    };
    public YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction yolo_room_speaking_user_status_update_action = new MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"room_speaking_pos", "speaking_pos_list_version"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction.class);
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomForbiddenSpeechAction yolo_room_forbidden_speech_action = new YoloRoomOuterClass$YoloRoomForbiddenSpeechAction();
    public YoloRoomOuterClass$YoloRoomRejectSpeakingAction yolo_room_reject_speaking_action = new MessageMicro<YoloRoomOuterClass$YoloRoomRejectSpeakingAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomRejectSpeakingAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_id"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomRejectSpeakingAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    };
    public YoloRoomOuterClass$YoloRoomEnterAction yolo_room_enter_action = new YoloRoomOuterClass$YoloRoomEnterAction();
    public YoloRoomOuterClass$YoloRoomLeaveAction yolo_room_leave_action = new MessageMicro<YoloRoomOuterClass$YoloRoomLeaveAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_id"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomLeaveAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    };
    public YoloRoomOuterClass$YoloRoomSendGiftAction yolo_room_send_gift_action = new MessageMicro<YoloRoomOuterClass$YoloRoomSendGiftAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSendGiftAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 74, 80, 88, 96, 104, 114, 122}, new String[]{"send_user_id", "recv_user_id", "gift_id", "total_num", "bill_no", "base_num", QZoneDTLoginReporter.SCHEMA, AudienceReportConst.ROOM_ID, "gift_name", "combo_seq", "scene_id", "gift_type", "combo_cnt", "client_str", "send_user_id_list"}, new Object[]{null, null, 0, 0, "", 0, "", 0L, "", 0, 0, 0, 0, "", null}, YoloRoomOuterClass$YoloRoomSendGiftAction.class);
        public CommonOuterClass$QQUserId send_user_id = new CommonOuterClass$QQUserId();
        public CommonOuterClass$QQUserId recv_user_id = new CommonOuterClass$QQUserId();
        public final PBInt32Field gift_id = PBField.initInt32(0);
        public final PBInt32Field total_num = PBField.initInt32(0);
        public final PBStringField bill_no = PBField.initString("");
        public final PBInt32Field base_num = PBField.initInt32(0);
        public final PBStringField schema = PBField.initString("");
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField gift_name = PBField.initString("");
        public final PBUInt32Field combo_seq = PBField.initUInt32(0);
        public final PBUInt32Field scene_id = PBField.initUInt32(0);
        public final PBUInt32Field gift_type = PBField.initUInt32(0);
        public final PBUInt32Field combo_cnt = PBField.initUInt32(0);
        public final PBStringField client_str = PBField.initString("");
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> send_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    };
    public YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction yolo_room_speaking_pos_list_init_action = new MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"room_speaking_pos_list", "speaking_pos_list_version"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction.class);
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomCloseGameAction yolo_room_close_game_action = new MessageMicro<YoloRoomOuterClass$YoloRoomCloseGameAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomCloseGameAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{AegisLogger.ROOM_INFO}, new Object[]{null}, YoloRoomOuterClass$YoloRoomCloseGameAction.class);
        public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    };
    public YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction yolo_room_update_game_route_info_action = new MessageMicro<YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{AegisLogger.ROOM_INFO, "status_change_text", "room_speaking_pos_list", "speaking_pos_list_version"}, new Object[]{null, "", null, 0}, YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction.class);
        public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
        public final PBStringField status_change_text = PBField.initString("");
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomBattleResultAction yolo_room_battle_result_action = new YoloRoomOuterClass$YoloRoomBattleResultAction();
    public YoloRoomOuterClass$YoloGameRoomRemindOwnerStartGameAction yolo_game_room_remind_owner_start_game_action = new MessageMicro<YoloRoomOuterClass$YoloGameRoomRemindOwnerStartGameAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloGameRoomRemindOwnerStartGameAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"owner_user_id"}, new Object[]{null}, YoloRoomOuterClass$YoloGameRoomRemindOwnerStartGameAction.class);
        public CommonOuterClass$QQUserId owner_user_id = new CommonOuterClass$QQUserId();
    };
    public YoloRoomOuterClass$YoloGameRoomOwnerChangeAction yolo_game_room_owner_change_action = new MessageMicro<YoloRoomOuterClass$YoloGameRoomOwnerChangeAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloGameRoomOwnerChangeAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"from_user_id", "to_user_id", "room_speaking_pos_list", "speaking_pos_list_version", "reason"}, new Object[]{null, null, null, 0, 0}, YoloRoomOuterClass$YoloGameRoomOwnerChangeAction.class);
        public CommonOuterClass$QQUserId from_user_id = new CommonOuterClass$QQUserId();
        public CommonOuterClass$QQUserId to_user_id = new CommonOuterClass$QQUserId();
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
        public final PBInt32Field reason = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction yolo_game_room_team_create_tips_action = new MessageMicro<YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"owner_user_id", "tips"}, new Object[]{null, ""}, YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction.class);
        public CommonOuterClass$QQUserId owner_user_id = new CommonOuterClass$QQUserId();
        public final PBStringField tips = PBField.initString("");
    };
    public YoloRoomOuterClass$YokoGameRoomSendNoticeAction yolo_game_room_send_notice_action = new YoloRoomOuterClass$YokoGameRoomSendNoticeAction();
    public YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction yolo_game_room_settle_gift_notice_action = new MessageMicro<YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"settle_user_id_list", "unsettle_user_id_list"}, new Object[]{null, null}, YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction.class);
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> settle_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> unsettle_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    };
    public YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction yolo_smoba_room_chooce_hero_action = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"room_speaking_pos", "speaking_pos_list_version"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction.class);
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloSmobaRoomRemindOwnerStartGameAction yolo_smoba_room_remind_owner_start_game_action = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomRemindOwnerStartGameAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomRemindOwnerStartGameAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"owner_user_id"}, new Object[]{null}, YoloRoomOuterClass$YoloSmobaRoomRemindOwnerStartGameAction.class);
        public CommonOuterClass$QQUserId owner_user_id = new CommonOuterClass$QQUserId();
    };
    public YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction yolo_smoba_room_remind_user_start_game_action = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_id_list"}, new Object[]{null}, YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction.class);
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    };
    public YoloRoomOuterClass$YoloSmobaRoomChangeRoleAction yolo_smoba_room_change_role_action = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomChangeRoleAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomChangeRoleAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"room_speaking_pos", "speaking_pos_list_version"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloSmobaRoomChangeRoleAction.class);
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction yolo_smoba_room_owner_change_action = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"from_user_id", "to_user_id", "room_speaking_pos_list", "speaking_pos_list_version", "reason"}, new Object[]{null, null, null, 0, 0}, YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction.class);
        public CommonOuterClass$QQUserId from_user_id = new CommonOuterClass$QQUserId();
        public CommonOuterClass$QQUserId to_user_id = new CommonOuterClass$QQUserId();
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
        public final PBInt32Field reason = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloSmobaRoomBattleResultAction yolo_smoba_room_battle_result_action = new YoloRoomOuterClass$YoloSmobaRoomBattleResultAction();
    public YoloRoomOuterClass$YoloBattleOBStatusChangeAction yolo_battle_ob_status_change_action = new MessageMicro<YoloRoomOuterClass$YoloBattleOBStatusChangeAction>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloBattleOBStatusChangeAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 82}, new String[]{"status", "ob_url", "pic_url", "ob_close_event"}, new Object[]{0, "", "", null}, YoloRoomOuterClass$YoloBattleOBStatusChangeAction.class);
        public final PBUInt32Field status = PBField.initUInt32(0);
        public final PBStringField ob_url = PBField.initString("");
        public final PBStringField pic_url = PBField.initString("");
        public YoloBattleObOuterClass$YoloBattleOBClosedEvent ob_close_event = new MessageMicro<YoloBattleObOuterClass$YoloBattleOBClosedEvent>() { // from class: com.tencent.icgame.trpc.yes.common.YoloBattleObOuterClass$YoloBattleOBClosedEvent
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"status", "battle_base_info"}, new Object[]{0, null}, YoloBattleObOuterClass$YoloBattleOBClosedEvent.class);
            public final PBEnumField status = PBField.initEnum(0);
            public YoloBattleOuterClass$YoloBattleBaseInfo battle_base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        };
    };
}
