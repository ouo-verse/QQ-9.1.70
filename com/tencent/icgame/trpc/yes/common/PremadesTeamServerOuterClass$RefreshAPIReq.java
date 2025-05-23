package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$RefreshAPIReq extends MessageMicro<PremadesTeamServerOuterClass$RefreshAPIReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"team_id_list", "uid_list", "game_id", "uid"}, new Object[]{0L, 0L, 0, 0L}, PremadesTeamServerOuterClass$RefreshAPIReq.class);
    public final PBInt32Field game_id;
    public final PBRepeatField<Long> team_id_list;
    public final PBUInt64Field uid;
    public final PBRepeatField<Long> uid_list;

    public PremadesTeamServerOuterClass$RefreshAPIReq() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.team_id_list = PBField.initRepeat(pBUInt64Field);
        this.uid_list = PBField.initRepeat(pBUInt64Field);
        this.game_id = PBField.initInt32(0);
        this.uid = PBField.initUInt64(0L);
    }
}
