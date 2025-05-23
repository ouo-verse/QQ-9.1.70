package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloTeamCancelMatchReq extends MessageMicro<SmobaDataOuterClass$YoloTeamCancelMatchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"eventtime", "teamid", "cyminiid"}, new Object[]{0, null, null}, SmobaDataOuterClass$YoloTeamCancelMatchReq.class);
    public final PBUInt32Field eventtime = PBField.initUInt32(0);
    public SmobaDataOuterClass$YoloTeamID teamid = new SmobaDataOuterClass$YoloTeamID();
    public SmobaDataOuterClass$YoloCyminiID cyminiid = new SmobaDataOuterClass$YoloCyminiID();
}
