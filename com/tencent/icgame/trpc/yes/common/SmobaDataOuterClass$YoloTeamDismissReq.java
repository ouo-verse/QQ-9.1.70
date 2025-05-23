package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloTeamDismissReq extends MessageMicro<SmobaDataOuterClass$YoloTeamDismissReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"eventtime", "reason", "teamid", "cyminiid"}, new Object[]{0, 0, null, null}, SmobaDataOuterClass$YoloTeamDismissReq.class);
    public final PBUInt32Field eventtime = PBField.initUInt32(0);
    public final PBUInt32Field reason = PBField.initUInt32(0);
    public SmobaDataOuterClass$YoloTeamID teamid = new SmobaDataOuterClass$YoloTeamID();
    public SmobaDataOuterClass$YoloCyminiID cyminiid = new SmobaDataOuterClass$YoloCyminiID();
}
