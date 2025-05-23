package com.tencent.icgame.trpc.yes.common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloGameRouteInfo extends MessageMicro<YoloRoomOuterClass$YoloGameRouteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 50, 58, 66, 74, 82, 800, 808, 816, 824}, new String[]{"game_status", "double_check_players", "smoba_game_route_info", "pubg_game_route_info", "common_game_route_info", "qsm_game_route_info", "cfm_game_route_info", "codm_game_route_info", VasQQSettingMeImpl.EXPIRE_TIME, AlbumCacheData.CREATE_TIME, "timeout_report_scene", "refresh_reason"}, new Object[]{0, null, null, null, null, null, null, null, 0, 0, 0, 0}, YoloRoomOuterClass$YoloGameRouteInfo.class);
    public final PBInt32Field game_status = PBField.initInt32(0);
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> double_check_players = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomDoubleCheckPlayer.class);
    public YoloRoomOuterClass$YoloSmobaGameRouteInfo smoba_game_route_info = new MessageMicro<YoloRoomOuterClass$YoloSmobaGameRouteInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloSmobaGameRouteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 834}, new String[]{"base_info", "smoba_schema", "create_type", "team_info", "battle_room_info", "battle_entity", "battle_begin_event_info"}, new Object[]{null, null, 0, null, null, null, null}, YoloRoomOuterClass$YoloSmobaGameRouteInfo.class);
        public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        public YoloBattleSmobaOuterClass$YoloSmobaSchema smoba_schema = new YoloBattleSmobaOuterClass$YoloSmobaSchema();
        public final PBInt32Field create_type = PBField.initInt32(0);
        public SmobaDataOuterClass$YoloTeamInfo team_info = new SmobaDataOuterClass$YoloTeamInfo();
        public SmobaDataOuterClass$YoloBattleRoomInfo battle_room_info = new SmobaDataOuterClass$YoloBattleRoomInfo();
        public YoloBattleSmobaOuterClass$YoloSmobaBattleEntity battle_entity = new YoloBattleSmobaOuterClass$YoloSmobaBattleEntity();
        public YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent battle_begin_event_info = new MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent>() { // from class: com.tencent.icgame.trpc.yes.common.YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 72, 82, 90}, new String[]{"game_id", "game_type", "map_acnt_num", "map_type", "level_id", "start_time", "battle_id", "is_warm_battle", "create_type", "camps", "ob_schema"}, new Object[]{0, 0, 0, 0, 0, 0, "", 0, 0, null, ""}, YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent.class);
            public final PBInt32Field game_id = PBField.initInt32(0);
            public final PBInt32Field game_type = PBField.initInt32(0);
            public final PBInt32Field map_acnt_num = PBField.initInt32(0);
            public final PBInt32Field map_type = PBField.initInt32(0);
            public final PBInt32Field level_id = PBField.initInt32(0);
            public final PBUInt32Field start_time = PBField.initUInt32(0);
            public final PBStringField battle_id = PBField.initString("");
            public final PBInt32Field is_warm_battle = PBField.initInt32(0);
            public final PBInt32Field create_type = PBField.initInt32(0);
            public final PBRepeatMessageField<SmobaDataOuterClass$OneCamp> camps = PBField.initRepeatMessage(SmobaDataOuterClass$OneCamp.class);
            public final PBStringField ob_schema = PBField.initString("");
        };
    };
    public YoloRoomOuterClass$YoloPubgGameRouteInfo pubg_game_route_info = new MessageMicro<YoloRoomOuterClass$YoloPubgGameRouteInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloPubgGameRouteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"base_info", "pubg_schema", "team_info"}, new Object[]{null, null, null}, YoloRoomOuterClass$YoloPubgGameRouteInfo.class);
        public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        public YoloBattlePubgOuterClass$YoloPUBGSchema pubg_schema = new YoloBattlePubgOuterClass$YoloPUBGSchema();
        public PubgDataOuterClass$PUBGTeamData team_info = new PubgDataOuterClass$PUBGTeamData();
    };
    public YoloRoomOuterClass$YoloCommonGameRouteInfo common_game_route_info = new MessageMicro<YoloRoomOuterClass$YoloCommonGameRouteInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCommonGameRouteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"base_info", "common_game_schema"}, new Object[]{null, null}, YoloRoomOuterClass$YoloCommonGameRouteInfo.class);
        public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        public YoloRoomOuterClass$YoloCommonGameSchema common_game_schema = new MessageMicro<YoloRoomOuterClass$YoloCommonGameSchema>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCommonGameSchema
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schemas"}, new Object[]{null}, YoloRoomOuterClass$YoloCommonGameSchema.class);
            public final PBRepeatMessageField<YoloRoomOuterClass$YoloCommonGameOneSchema> schemas = PBField.initRepeatMessage(YoloRoomOuterClass$YoloCommonGameOneSchema.class);
        };
    };
    public YoloRoomOuterClass$YoloQsmGameRouteInfo qsm_game_route_info = new MessageMicro<YoloRoomOuterClass$YoloQsmGameRouteInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloQsmGameRouteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 802}, new String[]{"base_info", "qsm_schema", "qsm_player_info_list", "room_created_event"}, new Object[]{null, null, null, null}, YoloRoomOuterClass$YoloQsmGameRouteInfo.class);
        public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        public YoloBattleQsmOuterClass$YoloQSMSchema qsm_schema = new YoloBattleQsmOuterClass$YoloQSMSchema();
        public final PBRepeatMessageField<QsmDataOuterClass$QSMPlayerInfo> qsm_player_info_list = PBField.initRepeatMessage(QsmDataOuterClass$QSMPlayerInfo.class);
        public QsmDataOuterClass$QSMRoomCreatedEvent room_created_event = new QsmDataOuterClass$QSMRoomCreatedEvent();
    };
    public YoloRoomOuterClass$YoloCfmGameRouteInfo cfm_game_route_info = new MessageMicro<YoloRoomOuterClass$YoloCfmGameRouteInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCfmGameRouteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 802}, new String[]{"base_info", "cfm_schema", "cfm_player_info_list", "status_change_event"}, new Object[]{null, null, null, null}, YoloRoomOuterClass$YoloCfmGameRouteInfo.class);
        public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        public YoloBattleCfmOuterClass$YoloCFMSchema cfm_schema = new YoloBattleCfmOuterClass$YoloCFMSchema();
        public final PBRepeatMessageField<CfmDataOuterClass$CFMPlayerInfo> cfm_player_info_list = PBField.initRepeatMessage(CfmDataOuterClass$CFMPlayerInfo.class);
        public CfmDataOuterClass$CFMStatusChangeEvent status_change_event = new CfmDataOuterClass$CFMStatusChangeEvent();
    };
    public YoloRoomOuterClass$YoloCodmGameRouteInfo codm_game_route_info = new MessageMicro<YoloRoomOuterClass$YoloCodmGameRouteInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloCodmGameRouteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"base_info", "codm_schema", "team_event"}, new Object[]{null, null, null}, YoloRoomOuterClass$YoloCodmGameRouteInfo.class);
        public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        public YoloBattleCodmOuterClass$YoloCODMSchema codm_schema = new YoloBattleCodmOuterClass$YoloCODMSchema();
        public CodmDataOuterClass$CODMTeamEvent team_event = new MessageMicro<CodmDataOuterClass$CODMTeamEvent>() { // from class: com.tencent.icgame.trpc.yes.common.CodmDataOuterClass$CODMTeamEvent
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"spvp_playlist_id", "team_state", "player_info", AudienceReportConst.ROOM_ID, "room_guid"}, new Object[]{0, 0, null, "", ""}, CodmDataOuterClass$CODMTeamEvent.class);
            public final PBInt32Field spvp_playlist_id = PBField.initInt32(0);
            public final PBInt32Field team_state = PBField.initInt32(0);
            public final PBRepeatMessageField<CodmDataOuterClass$CODMPlayerInfo> player_info = PBField.initRepeatMessage(CodmDataOuterClass$CODMPlayerInfo.class);
            public final PBStringField room_id = PBField.initString("");
            public final PBStringField room_guid = PBField.initString("");
        };
    };
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBUInt32Field timeout_report_scene = PBField.initUInt32(0);
    public final PBUInt32Field refresh_reason = PBField.initUInt32(0);
}
