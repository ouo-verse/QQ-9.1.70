package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$ShareGameTeamInfoReq extends MessageMicro<PremadesTeamServerOuterClass$ShareGameTeamInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"team_id", "user_info", AudienceReportConst.ROOM_ID, "game_id", "uid"}, new Object[]{0L, null, 0L, 0, 0L}, PremadesTeamServerOuterClass$ShareGameTeamInfoReq.class);
    public final PBUInt64Field team_id = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId user_info = new CommonOuterClass$QQUserId();
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
