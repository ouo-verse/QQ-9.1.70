package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class CodmDataOuterClass$CODMTeamSettleEvent extends MessageMicro<CodmDataOuterClass$CODMTeamSettleEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 64, 72, 82, 88, 96, 104, 112, 122, 128, 136, 144, 152, 162, 168, 176, 184, 192, 200, 208, 216}, new String[]{"winning_camp", "game_mode", "map_id", "match_service_module", "playlist_id", "game_time", "game_end_time", "rebel_kill_count", "regular_kill_count", "player_settle", "br_final_team_count", "difficulty_level", "match_mode", "game_type", "gsp_guid", "is_game_end", "pve_curr_mission_id", "pve_level_id", "pve_mission_count", "pve_total_damage", "regular_score", "rebel_score", "round_count", "team_type", "total_player_count", "total_player_num", "total_team_num"}, new Object[]{0, 0, "", 0, 0L, 0, 0L, 0, 0, null, 0, 0, 0, 0, "", 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0, 0}, CodmDataOuterClass$CODMTeamSettleEvent.class);
    public final PBInt32Field winning_camp = PBField.initInt32(0);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBStringField map_id = PBField.initString("");
    public final PBInt32Field match_service_module = PBField.initInt32(0);
    public final PBUInt64Field playlist_id = PBField.initUInt64(0);
    public final PBInt32Field game_time = PBField.initInt32(0);
    public final PBUInt64Field game_end_time = PBField.initUInt64(0);
    public final PBInt32Field rebel_kill_count = PBField.initInt32(0);
    public final PBInt32Field regular_kill_count = PBField.initInt32(0);
    public final PBRepeatMessageField<CodmDataOuterClass$CODMPlayerSettleData> player_settle = PBField.initRepeatMessage(CodmDataOuterClass$CODMPlayerSettleData.class);
    public final PBInt32Field br_final_team_count = PBField.initInt32(0);
    public final PBInt32Field difficulty_level = PBField.initInt32(0);
    public final PBInt32Field match_mode = PBField.initInt32(0);
    public final PBInt32Field game_type = PBField.initInt32(0);
    public final PBStringField gsp_guid = PBField.initString("");
    public final PBInt32Field is_game_end = PBField.initInt32(0);
    public final PBInt32Field pve_curr_mission_id = PBField.initInt32(0);
    public final PBInt32Field pve_level_id = PBField.initInt32(0);
    public final PBInt32Field pve_mission_count = PBField.initInt32(0);
    public final PBStringField pve_total_damage = PBField.initString("");
    public final PBInt32Field regular_score = PBField.initInt32(0);
    public final PBInt32Field rebel_score = PBField.initInt32(0);
    public final PBInt32Field round_count = PBField.initInt32(0);
    public final PBInt32Field team_type = PBField.initInt32(0);
    public final PBInt32Field total_player_count = PBField.initInt32(0);
    public final PBInt32Field total_player_num = PBField.initInt32(0);
    public final PBInt32Field total_team_num = PBField.initInt32(0);
}
