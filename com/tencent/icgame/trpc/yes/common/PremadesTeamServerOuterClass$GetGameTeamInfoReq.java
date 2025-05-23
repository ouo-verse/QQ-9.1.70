package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GetGameTeamInfoReq extends MessageMicro<PremadesTeamServerOuterClass$GetGameTeamInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"team_id", "uid", "game_id"}, new Object[]{"", 0L, 0}, PremadesTeamServerOuterClass$GetGameTeamInfoReq.class);
    public final PBStringField team_id = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
}
