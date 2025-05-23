package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp extends MessageMicro<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 32, 40, 56, 64, 74, 178, 200, 210}, new String[]{"game_info", "refresh_interval", "equip_setting_status", "play_together_status", "equip_open_status", AudienceReportConst.ANCHOR_ID, "live_team_info", "yes_game_id", "new_play_together_info"}, new Object[]{null, 0, 0, 0, 0, "", null, 0, null}, PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp.class);
    public PremadesTeamServerOuterClass$AnchorGameInfo game_info = new PremadesTeamServerOuterClass$AnchorGameInfo();
    public final PBInt32Field refresh_interval = PBField.initInt32(0);
    public final PBInt32Field equip_setting_status = PBField.initInt32(0);
    public final PBInt32Field play_together_status = PBField.initInt32(0);
    public final PBInt32Field equip_open_status = PBField.initInt32(0);
    public final PBStringField anchor_id = PBField.initString("");
    public YoloTeamOuterClass$YoloLiveTeamInfo live_team_info = new YoloTeamOuterClass$YoloLiveTeamInfo();
    public final PBInt32Field yes_game_id = PBField.initInt32(0);
    public PremadesTeamServerOuterClass$NewPlayTogetherInfo new_play_together_info = new PremadesTeamServerOuterClass$NewPlayTogetherInfo();
}
