package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloTeamBindToBattleReq extends MessageMicro<SmobaDataOuterClass$YoloTeamBindToBattleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50}, new String[]{"eventtime", "teamid", "deskid", "relayentity", "deskseq", "cyminiid"}, new Object[]{0, null, 0, 0, 0, null}, SmobaDataOuterClass$YoloTeamBindToBattleReq.class);
    public final PBUInt32Field eventtime = PBField.initUInt32(0);
    public SmobaDataOuterClass$YoloTeamID teamid = new SmobaDataOuterClass$YoloTeamID();
    public final PBUInt32Field deskid = PBField.initUInt32(0);
    public final PBUInt32Field relayentity = PBField.initUInt32(0);
    public final PBUInt32Field deskseq = PBField.initUInt32(0);
    public SmobaDataOuterClass$YoloCyminiID cyminiid = new SmobaDataOuterClass$YoloCyminiID();
}
