package com.tencent.icgame.trpc.yes.common;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class QsmDataOuterClass$QSMPackage extends MessageMicro<QsmDataOuterClass$QSMPackage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106}, new String[]{"base_header", "qsm_room_created_req", "qsm_room_created_rsp", "qsm_room_status_change_req", "qsm_room_status_change_rsp", "qsm_player_status_change_req", "qsm_player_status_change_rsp", "qsm_idip_query_player_info_req", "qsm_idip_query_player_info_rsp", "qsm_idip_query_player_summary_req", "qsm_idip_query_player_summary_rsp", "qsm_idip_query_room_info_req", "qsm_idip_query_room_info_rsp"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null}, QsmDataOuterClass$QSMPackage.class);
    public QsmDataOuterClass$YesBaseHeader base_header = new MessageMicro<QsmDataOuterClass$YesBaseHeader>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$YesBaseHeader
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"cmd", "seq", CheckForwardServlet.KEY_ERR_CODE, "err_msg", MosaicConstants$JsProperty.PROP_ENV}, new Object[]{0, 0L, 0, "", ""}, QsmDataOuterClass$YesBaseHeader.class);
        public final PBInt32Field cmd = PBField.initInt32(0);
        public final PBUInt64Field seq = PBField.initUInt64(0);
        public final PBInt32Field err_code = PBField.initInt32(0);
        public final PBStringField err_msg = PBField.initString("");
        public final PBStringField env = PBField.initString("");
    };
    public QsmDataOuterClass$QSMRoomCreatedReq qsm_room_created_req = new MessageMicro<QsmDataOuterClass$QSMRoomCreatedReq>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMRoomCreatedReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72}, new String[]{"qsm_room_id", "yes_room_id", "game_type", "race_game_play", "owner", "inviter_uid", "world_id", "svr_id", "yes_room_id_local_svr"}, new Object[]{0L, 0L, 0, 0, null, 0L, 0, 0, 0}, QsmDataOuterClass$QSMRoomCreatedReq.class);
        public final PBUInt64Field qsm_room_id = PBField.initUInt64(0);
        public final PBUInt64Field yes_room_id = PBField.initUInt64(0);
        public final PBInt32Field game_type = PBField.initInt32(0);
        public final PBInt32Field race_game_play = PBField.initInt32(0);
        public QsmDataOuterClass$QSMPlayerInfo owner = new QsmDataOuterClass$QSMPlayerInfo();
        public final PBUInt64Field inviter_uid = PBField.initUInt64(0);
        public final PBUInt32Field world_id = PBField.initUInt32(0);
        public final PBUInt32Field svr_id = PBField.initUInt32(0);
        public final PBUInt32Field yes_room_id_local_svr = PBField.initUInt32(0);
    };
    public QsmDataOuterClass$QSMRoomCreatedRsp qsm_room_created_rsp = new MessageMicro<QsmDataOuterClass$QSMRoomCreatedRsp>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMRoomCreatedRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMRoomCreatedRsp.class);
    };
    public QsmDataOuterClass$QSMRoomStatusChangeReq qsm_room_status_change_req = new MessageMicro<QsmDataOuterClass$QSMRoomStatusChangeReq>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMRoomStatusChangeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"qsm_room_id", "yes_room_id", "room_status", "battle_result"}, new Object[]{0L, 0L, 0, null}, QsmDataOuterClass$QSMRoomStatusChangeReq.class);
        public final PBUInt64Field qsm_room_id = PBField.initUInt64(0);
        public final PBUInt64Field yes_room_id = PBField.initUInt64(0);
        public final PBInt32Field room_status = PBField.initInt32(0);
        public QsmDataOuterClass$QSMBattleResult battle_result = new QsmDataOuterClass$QSMBattleResult();
    };
    public QsmDataOuterClass$QSMRoomStatusChangeRsp qsm_room_status_change_rsp = new MessageMicro<QsmDataOuterClass$QSMRoomStatusChangeRsp>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMRoomStatusChangeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMRoomStatusChangeRsp.class);
    };
    public QsmDataOuterClass$QSMPlayerStatusChangeReq qsm_player_status_change_req = new MessageMicro<QsmDataOuterClass$QSMPlayerStatusChangeReq>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMPlayerStatusChangeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"qsm_room_id", "yes_room_id", "player_info", "player_status"}, new Object[]{0L, 0L, null, 0}, QsmDataOuterClass$QSMPlayerStatusChangeReq.class);
        public final PBUInt64Field qsm_room_id = PBField.initUInt64(0);
        public final PBUInt64Field yes_room_id = PBField.initUInt64(0);
        public QsmDataOuterClass$QSMPlayerInfo player_info = new QsmDataOuterClass$QSMPlayerInfo();
        public final PBInt32Field player_status = PBField.initInt32(0);
    };
    public QsmDataOuterClass$QSMPlayerStatusChangeRsp qsm_player_status_change_rsp = new MessageMicro<QsmDataOuterClass$QSMPlayerStatusChangeRsp>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMPlayerStatusChangeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMPlayerStatusChangeRsp.class);
    };
    public QsmDataOuterClass$QSMIDIPQueryPlayerInfoReq qsm_idip_query_player_info_req = new MessageMicro<QsmDataOuterClass$QSMIDIPQueryPlayerInfoReq>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPQueryPlayerInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"player_info", "need_player_partition_list", "need_player_info", "need_player_friend_list", "need_player_season_info", "need_player_recent_ladder_match", "need_player_game_info"}, new Object[]{null, null, null, null, null, null, null}, QsmDataOuterClass$QSMIDIPQueryPlayerInfoReq.class);
        public QsmDataOuterClass$QSMPlayerInfo player_info = new QsmDataOuterClass$QSMPlayerInfo();
        public QsmDataOuterClass$QSMIDIPNeedPlayerPartitionList need_player_partition_list = new MessageMicro<QsmDataOuterClass$QSMIDIPNeedPlayerPartitionList>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPNeedPlayerPartitionList
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMIDIPNeedPlayerPartitionList.class);
        };
        public QsmDataOuterClass$QSMIDIPNeedPlayerInfo need_player_info = new MessageMicro<QsmDataOuterClass$QSMIDIPNeedPlayerInfo>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPNeedPlayerInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMIDIPNeedPlayerInfo.class);
        };
        public QsmDataOuterClass$QSMIDIPNeedPlayerFriendList need_player_friend_list = new MessageMicro<QsmDataOuterClass$QSMIDIPNeedPlayerFriendList>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPNeedPlayerFriendList
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMIDIPNeedPlayerFriendList.class);
        };
        public QsmDataOuterClass$QSMIDIPNeedPlayerSeasonInfo need_player_season_info = new MessageMicro<QsmDataOuterClass$QSMIDIPNeedPlayerSeasonInfo>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPNeedPlayerSeasonInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMIDIPNeedPlayerSeasonInfo.class);
        };
        public QsmDataOuterClass$QSMIDIPNeedPlayerRecentLadderMatch need_player_recent_ladder_match = new MessageMicro<QsmDataOuterClass$QSMIDIPNeedPlayerRecentLadderMatch>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPNeedPlayerRecentLadderMatch
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMIDIPNeedPlayerRecentLadderMatch.class);
        };
        public QsmDataOuterClass$QSMIDIPNeedPlayerGameInfo need_player_game_info = new MessageMicro<QsmDataOuterClass$QSMIDIPNeedPlayerGameInfo>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPNeedPlayerGameInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QsmDataOuterClass$QSMIDIPNeedPlayerGameInfo.class);
        };
    };
    public QsmDataOuterClass$QSMIDIPQueryPlayerInfoRsp qsm_idip_query_player_info_rsp = new MessageMicro<QsmDataOuterClass$QSMIDIPQueryPlayerInfoRsp>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPQueryPlayerInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"player_info", "idip_player_partition_list", "idip_player_info", "idip_player_friend_list", "idip_player_season_info", "idip_player_recent_ladder_match", "player_game_info"}, new Object[]{null, null, null, null, null, null, null}, QsmDataOuterClass$QSMIDIPQueryPlayerInfoRsp.class);
        public QsmDataOuterClass$QSMPlayerInfo player_info = new QsmDataOuterClass$QSMPlayerInfo();
        public QsmDataOuterClass$QSMIDIPPlayerPartitionList idip_player_partition_list = new MessageMicro<QsmDataOuterClass$QSMIDIPPlayerPartitionList>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPPlayerPartitionList
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"per_partition_info"}, new Object[]{null}, QsmDataOuterClass$QSMIDIPPlayerPartitionList.class);
            public final PBRepeatMessageField<QsmDataOuterClass$QSMIDIPPlayerPartitionInfo> per_partition_info = PBField.initRepeatMessage(QsmDataOuterClass$QSMIDIPPlayerPartitionInfo.class);
        };
        public QsmDataOuterClass$QSMPlayerInfoDetail idip_player_info = new QsmDataOuterClass$QSMPlayerInfoDetail();
        public QsmDataOuterClass$QSMIDIPPlayerFriendList idip_player_friend_list = new MessageMicro<QsmDataOuterClass$QSMIDIPPlayerFriendList>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPPlayerFriendList
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"friend_uid_list"}, new Object[]{0L}, QsmDataOuterClass$QSMIDIPPlayerFriendList.class);
            public final PBRepeatField<Long> friend_uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        };
        public QsmDataOuterClass$QSMIDIPPlayerSeasonInfo idip_player_season_info = new MessageMicro<QsmDataOuterClass$QSMIDIPPlayerSeasonInfo>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPPlayerSeasonInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"per_season_info"}, new Object[]{null}, QsmDataOuterClass$QSMIDIPPlayerSeasonInfo.class);
            public final PBRepeatMessageField<QsmDataOuterClass$QSMIDIPPlayerPerSeasonInfo> per_season_info = PBField.initRepeatMessage(QsmDataOuterClass$QSMIDIPPlayerPerSeasonInfo.class);
        };
        public QsmDataOuterClass$QSMIDIPPlayerRecentLadderMatch idip_player_recent_ladder_match = new MessageMicro<QsmDataOuterClass$QSMIDIPPlayerRecentLadderMatch>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPPlayerRecentLadderMatch
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"per_ladder_match"}, new Object[]{null}, QsmDataOuterClass$QSMIDIPPlayerRecentLadderMatch.class);
            public final PBRepeatMessageField<QsmDataOuterClass$QSMIDIPPlayerPerLadderMatch> per_ladder_match = PBField.initRepeatMessage(QsmDataOuterClass$QSMIDIPPlayerPerLadderMatch.class);
        };
        public QsmDataOuterClass$QSMIDIPPlayerGameInfo player_game_info = new QsmDataOuterClass$QSMIDIPPlayerGameInfo();
    };
    public QsmDataOuterClass$QSMIDIPQueryPlayerSummaryReq qsm_idip_query_player_summary_req = new MessageMicro<QsmDataOuterClass$QSMIDIPQueryPlayerSummaryReq>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPQueryPlayerSummaryReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uid_list"}, new Object[]{0L}, QsmDataOuterClass$QSMIDIPQueryPlayerSummaryReq.class);
        public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public QsmDataOuterClass$QSMIDIPQueryPlayerSummaryRsp qsm_idip_query_player_summary_rsp = new MessageMicro<QsmDataOuterClass$QSMIDIPQueryPlayerSummaryRsp>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPQueryPlayerSummaryRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"player_summary"}, new Object[]{null}, QsmDataOuterClass$QSMIDIPQueryPlayerSummaryRsp.class);
        public final PBRepeatMessageField<QsmDataOuterClass$QSMPlayerInfoSummary> player_summary = PBField.initRepeatMessage(QsmDataOuterClass$QSMPlayerInfoSummary.class);
    };
    public QsmDataOuterClass$QSMIDIPQueryRoomInfoReq qsm_idip_query_room_info_req = new MessageMicro<QsmDataOuterClass$QSMIDIPQueryRoomInfoReq>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPQueryRoomInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"qsm_room_id", "yes_room_id"}, new Object[]{0L, 0L}, QsmDataOuterClass$QSMIDIPQueryRoomInfoReq.class);
        public final PBUInt64Field qsm_room_id = PBField.initUInt64(0);
        public final PBUInt64Field yes_room_id = PBField.initUInt64(0);
    };
    public QsmDataOuterClass$QSMIDIPQueryRoomInfoRsp qsm_idip_query_room_info_rsp = new MessageMicro<QsmDataOuterClass$QSMIDIPQueryRoomInfoRsp>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMIDIPQueryRoomInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"room_status", "battle_result", "player_list"}, new Object[]{0, null, null}, QsmDataOuterClass$QSMIDIPQueryRoomInfoRsp.class);
        public final PBInt32Field room_status = PBField.initInt32(0);
        public QsmDataOuterClass$QSMBattleResult battle_result = new QsmDataOuterClass$QSMBattleResult();
        public final PBRepeatMessageField<QsmDataOuterClass$QSMPlayerInfoWithStatus> player_list = PBField.initRepeatMessage(QsmDataOuterClass$QSMPlayerInfoWithStatus.class);
    };
}
