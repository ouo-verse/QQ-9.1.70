package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class CfmDataOuterClass$CFMPlayerBattleResult extends MessageMicro<CfmDataOuterClass$CFMPlayerBattleResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"player_info", "times_kill", "times_be_killed", "times_assists", "display_weapon", "times_headshot", "camp"}, new Object[]{null, 0, 0, 0, 0L, 0, 0}, CfmDataOuterClass$CFMPlayerBattleResult.class);
    public CfmDataOuterClass$CFMPlayerInfo player_info = new CfmDataOuterClass$CFMPlayerInfo();
    public final PBInt32Field times_kill = PBField.initInt32(0);
    public final PBInt32Field times_be_killed = PBField.initInt32(0);
    public final PBInt32Field times_assists = PBField.initInt32(0);
    public final PBUInt64Field display_weapon = PBField.initUInt64(0);
    public final PBInt32Field times_headshot = PBField.initInt32(0);
    public final PBInt32Field camp = PBField.initInt32(0);
}
