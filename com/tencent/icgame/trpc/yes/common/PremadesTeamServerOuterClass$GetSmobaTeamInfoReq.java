package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GetSmobaTeamInfoReq extends MessageMicro<PremadesTeamServerOuterClass$GetSmobaTeamInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"team_id", "uid"}, new Object[]{"", 0L}, PremadesTeamServerOuterClass$GetSmobaTeamInfoReq.class);
    public final PBStringField team_id = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
