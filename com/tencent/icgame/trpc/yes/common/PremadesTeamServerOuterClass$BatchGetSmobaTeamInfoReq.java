package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoReq extends MessageMicro<PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"team_id_list", "uid"}, new Object[]{0L, 0L}, PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoReq.class);
    public final PBRepeatField<Long> team_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
