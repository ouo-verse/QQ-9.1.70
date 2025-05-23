package com.tencent.icgame.trpc.yes.common;

import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class QsmDataOuterClass$QSMPlayerBattleResult extends MessageMicro<QsmDataOuterClass$QSMPlayerBattleResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 64, 72, 402, 410, 418, PlayUI.UIType.BIG_CARD_SHAPED_PIC, 434, 442}, new String[]{"qsm_player_info", "rank", "camp", "finish_time", "team_rank", "is_lost_connection", "speed_single_result", "speed_team_result", "prop_single_result", "prop_team_result", "action_speed_team_result", "action_speed_single_result"}, new Object[]{null, 0, 0, 0, 0, 0, null, null, null, null, null, null}, QsmDataOuterClass$QSMPlayerBattleResult.class);
    public QsmDataOuterClass$QSMPlayerInfo qsm_player_info = new QsmDataOuterClass$QSMPlayerInfo();
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBInt32Field camp = PBField.initInt32(0);
    public final PBInt32Field finish_time = PBField.initInt32(0);
    public final PBInt32Field team_rank = PBField.initInt32(0);
    public final PBInt32Field is_lost_connection = PBField.initInt32(0);
    public QsmDataOuterClass$QSMPlayerSpeedSingleResult speed_single_result = new MessageMicro<QsmDataOuterClass$QSMPlayerSpeedSingleResult>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMPlayerSpeedSingleResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"speed_common_result"}, new Object[]{null}, QsmDataOuterClass$QSMPlayerSpeedSingleResult.class);
        public QsmDataOuterClass$QSMPlayerSpeedCommonResult speed_common_result = new QsmDataOuterClass$QSMPlayerSpeedCommonResult();
    };
    public QsmDataOuterClass$QSMPlayerSpeedTeamResult speed_team_result = new MessageMicro<QsmDataOuterClass$QSMPlayerSpeedTeamResult>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMPlayerSpeedTeamResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"speed_common_result", "total_score"}, new Object[]{null, 0}, QsmDataOuterClass$QSMPlayerSpeedTeamResult.class);
        public QsmDataOuterClass$QSMPlayerSpeedCommonResult speed_common_result = new QsmDataOuterClass$QSMPlayerSpeedCommonResult();
        public final PBUInt32Field total_score = PBField.initUInt32(0);
    };
    public QsmDataOuterClass$QSMPlayerPropSingleResult prop_single_result = new MessageMicro<QsmDataOuterClass$QSMPlayerPropSingleResult>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMPlayerPropSingleResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"prop_common_result"}, new Object[]{null}, QsmDataOuterClass$QSMPlayerPropSingleResult.class);
        public QsmDataOuterClass$QSMPlayerPropCommonResult prop_common_result = new QsmDataOuterClass$QSMPlayerPropCommonResult();
    };
    public QsmDataOuterClass$QSMPlayerPropTeamResult prop_team_result = new MessageMicro<QsmDataOuterClass$QSMPlayerPropTeamResult>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMPlayerPropTeamResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"prop_common_result"}, new Object[]{null}, QsmDataOuterClass$QSMPlayerPropTeamResult.class);
        public QsmDataOuterClass$QSMPlayerPropCommonResult prop_common_result = new QsmDataOuterClass$QSMPlayerPropCommonResult();
    };
    public QsmDataOuterClass$QSMPlayerActionSpeedTeamResult action_speed_team_result = new MessageMicro<QsmDataOuterClass$QSMPlayerActionSpeedTeamResult>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMPlayerActionSpeedTeamResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"speed_common_result"}, new Object[]{null}, QsmDataOuterClass$QSMPlayerActionSpeedTeamResult.class);
        public QsmDataOuterClass$QSMPlayerSpeedCommonResult speed_common_result = new QsmDataOuterClass$QSMPlayerSpeedCommonResult();
    };
    public QsmDataOuterClass$QSMPlayerActionSpeedSingleResult action_speed_single_result = new MessageMicro<QsmDataOuterClass$QSMPlayerActionSpeedSingleResult>() { // from class: com.tencent.icgame.trpc.yes.common.QsmDataOuterClass$QSMPlayerActionSpeedSingleResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"speed_common_result"}, new Object[]{null}, QsmDataOuterClass$QSMPlayerActionSpeedSingleResult.class);
        public QsmDataOuterClass$QSMPlayerSpeedCommonResult speed_common_result = new QsmDataOuterClass$QSMPlayerSpeedCommonResult();
    };
}
