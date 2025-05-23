package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MessageOuterClass$MsgContent extends MessageMicro<MessageOuterClass$MsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 386, 442, P2VGlobalConfig.WATER_MARKER_WIDTH, 522, 530, 634, 642, 650, 658, 666, 674, 682, 690, 698, 706, 714, QVipServiceAccountFolderProcessor.CMD, TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH, 738, 746, 754}, new String[]{"text_msg", "yolo_room_action_msg", "share_yolo_room_msg", "yolo_room_rotate_msg", "yolo_room_new_data_push_msg", "at_user_msg", "qq_user_info_msg", "gift_msg", "user_info_modify_notify_msg", "anchor_equip_status_notify_msg", "anchor_premades_team_msg", "share_ark_msg", "kpl_schedule_modify_notify_msg", "anchor_room_info_msg", "anchor_room_bullet_screen_msg", "live_room_lottery_result_msg", "timi_emo_msg", "live_room_enter_game_room_msg", "live_room_update_team_info_msg", "anchor_charge_msg", "pendant_msg", "power_redpacket_lottery_result_msg"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, MessageOuterClass$MsgContent.class);
    public MessageOuterClass$TextMsg text_msg = new MessageOuterClass$TextMsg();
    public MessageOuterClass$YoloRoomRotateMsg yolo_room_rotate_msg = new MessageOuterClass$YoloRoomRotateMsg();
    public MessageOuterClass$YoloRoomActionMsg yolo_room_action_msg = new MessageOuterClass$YoloRoomActionMsg();
    public PremadesTeamServerOuterClass$ShareYoloRoomMsg share_yolo_room_msg = new MessageMicro<PremadesTeamServerOuterClass$ShareYoloRoomMsg>() { // from class: com.tencent.icgame.trpc.yes.common.PremadesTeamServerOuterClass$ShareYoloRoomMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{AegisLogger.ROOM_INFO, "room_speaking_pos_list", "team_info"}, new Object[]{null, null, null}, PremadesTeamServerOuterClass$ShareYoloRoomMsg.class);
        public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
        public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
        public PremadesTeamServerOuterClass$YesGamePremadesTeamInfo team_info = new PremadesTeamServerOuterClass$YesGamePremadesTeamInfo();
    };
    public MessageOuterClass$YoloRoomNewDataPushMsg yolo_room_new_data_push_msg = new MessageMicro<MessageOuterClass$YoloRoomNewDataPushMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$YoloRoomNewDataPushMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"new_data_time_ms"}, new Object[]{0L}, MessageOuterClass$YoloRoomNewDataPushMsg.class);
        public final PBUInt64Field new_data_time_ms = PBField.initUInt64(0);
    };
    public MessageOuterClass$AtUserMsg at_user_msg = new MessageOuterClass$AtUserMsg();
    public MessageOuterClass$QQUserInfoMsg qq_user_info_msg = new MessageMicro<MessageOuterClass$QQUserInfoMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$QQUserInfoMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 56}, new String[]{"qq_user_info", "show_scene", "user_id", "add_friend_tips_text", "game_id", "game_role_info", "version_type"}, new Object[]{null, 0, null, "", 0, null, 0}, MessageOuterClass$QQUserInfoMsg.class);
        public UserProxyCmdOuterClass$QQUserInfo qq_user_info = new UserProxyCmdOuterClass$QQUserInfo();
        public final PBInt32Field show_scene = PBField.initInt32(0);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        public final PBStringField add_friend_tips_text = PBField.initString("");
        public final PBInt32Field game_id = PBField.initInt32(0);
        public YesGameInfoOuterClass$YesGameRoleInfo game_role_info = new YesGameInfoOuterClass$YesGameRoleInfo();
        public final PBInt32Field version_type = PBField.initInt32(0);
    };
    public MessageOuterClass$GiftMsg gift_msg = new MessageOuterClass$GiftMsg();
    public MessageOuterClass$UserInfoModifyNotifyMsg user_info_modify_notify_msg = new MessageMicro<MessageOuterClass$UserInfoModifyNotifyMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$UserInfoModifyNotifyMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"qq_user_info"}, new Object[]{null}, MessageOuterClass$UserInfoModifyNotifyMsg.class);
        public UserProxyCmdOuterClass$QQUserInfo qq_user_info = new UserProxyCmdOuterClass$QQUserInfo();
    };
    public MessageOuterClass$AnchorEquipStatusNotifyMsg anchor_equip_status_notify_msg = new MessageMicro<MessageOuterClass$AnchorEquipStatusNotifyMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$AnchorEquipStatusNotifyMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"equip_status", "game_info"}, new Object[]{0, null}, MessageOuterClass$AnchorEquipStatusNotifyMsg.class);
        public final PBInt32Field equip_status = PBField.initInt32(0);
        public PremadesTeamServerOuterClass$AnchorGameInfo game_info = new PremadesTeamServerOuterClass$AnchorGameInfo();
    };
    public MessageOuterClass$AnchorPremadesTeamMsg anchor_premades_team_msg = new MessageOuterClass$AnchorPremadesTeamMsg();
    public MessageOuterClass$ShareArkMsg share_ark_msg = new MessageOuterClass$ShareArkMsg();
    public MessageOuterClass$KPLScheduleModifyNotifyMsg kpl_schedule_modify_notify_msg = new MessageMicro<MessageOuterClass$KPLScheduleModifyNotifyMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$KPLScheduleModifyNotifyMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"schedule"}, new Object[]{""}, MessageOuterClass$KPLScheduleModifyNotifyMsg.class);
        public final PBStringField schedule = PBField.initString("");
    };
    public MessageOuterClass$AnchorRoomInfoMsg anchor_room_info_msg = new MessageMicro<MessageOuterClass$AnchorRoomInfoMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$AnchorRoomInfoMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MessageOuterClass$AnchorRoomInfoMsg.class);
    };
    public MessageOuterClass$AnchorRoomBulletScreenMsg anchor_room_bullet_screen_msg = new MessageOuterClass$AnchorRoomBulletScreenMsg();
    public MessageOuterClass$LiveRoomLotteryResultMsg live_room_lottery_result_msg = new MessageMicro<MessageOuterClass$LiveRoomLotteryResultMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$LiveRoomLotteryResultMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"h5_msg", "task_id"}, new Object[]{null, 0}, MessageOuterClass$LiveRoomLotteryResultMsg.class);
        public MessageOuterClass$H5Msg h5_msg = new MessageOuterClass$H5Msg();
        public final PBInt32Field task_id = PBField.initInt32(0);
    };
    public MessageOuterClass$TimiEmoMsg timi_emo_msg = new MessageMicro<MessageOuterClass$TimiEmoMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimiEmoMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_data"}, new Object[]{null}, MessageOuterClass$TimiEmoMsg.class);
        public MessageOuterClass$TimiEmoData msg_data = new MessageMicro<MessageOuterClass$TimiEmoData>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimiEmoData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"type", "url", EmojiManagerServiceProxy.EPID, "eId", "pkgEmoData"}, new Object[]{0, "", "", "", null}, MessageOuterClass$TimiEmoData.class);
            public final PBInt32Field type = PBField.initInt32(0);
            public final PBStringField url = PBField.initString("");
            public final PBStringField epId = PBField.initString("");
            public final PBStringField eId = PBField.initString("");
            public MessageOuterClass$TimiPkgEmoticonData pkgEmoData = new MessageMicro<MessageOuterClass$TimiPkgEmoticonData>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimiPkgEmoticonData
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBStringField epId = PBField.initString("");
                public final PBStringField eId = PBField.initString("");
                public final PBStringField name = PBField.initString("");
                public final PBStringField encryptKey = PBField.initString("");
                public final PBBoolField isSound = PBField.initBool(false);
                public final PBInt32Field width = PBField.initInt32(0);
                public final PBInt32Field height = PBField.initInt32(0);
                public final PBInt32Field jobType = PBField.initInt32(0);
                public final PBStringField keyword = PBField.initString("");
                public final PBStringField keywords = PBField.initString("");
                public final PBStringField character = PBField.initString("");
                public final PBInt32Field extensionWidth = PBField.initInt32(0);
                public final PBInt32Field extensionHeight = PBField.initInt32(0);
                public final PBBoolField isAPNG = PBField.initBool(false);
                public final PBInt32Field imageType = PBField.initInt32(0);

                static {
                    String[] strArr = {EmojiManagerServiceProxy.EPID, "eId", "name", "encryptKey", ThemeReporter.THEME_ISSOUND, "width", "height", "jobType", "keyword", "keywords", "character", "extensionWidth", "extensionHeight", "isAPNG", NodeProps.CUSTOM_PROP_IMAGE_TYPE};
                    Boolean bool = Boolean.FALSE;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 74, 82, 90, 96, 104, 112, 120}, strArr, new Object[]{"", "", "", "", bool, 0, 0, 0, "", "", "", 0, 0, bool, 0}, MessageOuterClass$TimiPkgEmoticonData.class);
                }
            };
        };
    };
    public MessageOuterClass$LiveRoomEnterGameTeamMsg live_room_enter_game_room_msg = new MessageOuterClass$LiveRoomEnterGameTeamMsg();
    public MessageOuterClass$LiveRoomUpdateTeamInfoMsg live_room_update_team_info_msg = new MessageMicro<MessageOuterClass$LiveRoomUpdateTeamInfoMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$LiveRoomUpdateTeamInfoMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"live_team_info", "game_start"}, new Object[]{null, 0}, MessageOuterClass$LiveRoomUpdateTeamInfoMsg.class);
        public YoloTeamOuterClass$YoloLiveTeamInfo live_team_info = new YoloTeamOuterClass$YoloLiveTeamInfo();
        public final PBInt32Field game_start = PBField.initInt32(0);
    };
    public MessageOuterClass$AnchorChargeMsg anchor_charge_msg = new MessageOuterClass$AnchorChargeMsg();
    public PendantOuterClass$PendantMsg pendant_msg = new PendantOuterClass$PendantMsg();
    public MessageOuterClass$PowerRedpacketLotteryResultMsg power_redpacket_lottery_result_msg = new MessageMicro<MessageOuterClass$PowerRedpacketLotteryResultMsg>() { // from class: com.tencent.icgame.trpc.yes.common.MessageOuterClass$PowerRedpacketLotteryResultMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"h5_msg", "activity_id"}, new Object[]{null, ""}, MessageOuterClass$PowerRedpacketLotteryResultMsg.class);
        public MessageOuterClass$H5Msg h5_msg = new MessageOuterClass$H5Msg();
        public final PBStringField activity_id = PBField.initString("");
    };
}
