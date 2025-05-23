package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$ShareGameBattleResultReq extends MessageMicro<PremadesTeamServerOuterClass$ShareGameBattleResultReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"result_action", "user_info", AudienceReportConst.ROOM_ID, "game_id", "uid"}, new Object[]{null, null, 0L, 0, 0L}, PremadesTeamServerOuterClass$ShareGameBattleResultReq.class);
    public YoloRoomOuterClass$YoloRoomBattleResultAction result_action = new YoloRoomOuterClass$YoloRoomBattleResultAction();
    public CommonOuterClass$QQUserId user_info = new CommonOuterClass$QQUserId();
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
