package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaTeamBeginMatchEvent extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaTeamBeginMatchEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"team_id", "battle_info"}, new Object[]{null, null}, YoloBattleSmobaOuterClass$YoloSmobaTeamBeginMatchEvent.class);
    public SmobaDataOuterClass$YoloTeamID team_id = new SmobaDataOuterClass$YoloTeamID();
    public SmobaDataOuterClass$YoloTeamBattleInfo battle_info = new SmobaDataOuterClass$YoloTeamBattleInfo();
}
