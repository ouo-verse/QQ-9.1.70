package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloTeamStateReq extends MessageMicro<SmobaDataOuterClass$YoloTeamStateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"eventtime", "chgtype", "teaminfo", "cyminiid"}, new Object[]{0, 0, null, null}, SmobaDataOuterClass$YoloTeamStateReq.class);
    public final PBUInt32Field eventtime = PBField.initUInt32(0);
    public final PBUInt32Field chgtype = PBField.initUInt32(0);
    public SmobaDataOuterClass$YoloTeamInfo teaminfo = new SmobaDataOuterClass$YoloTeamInfo();
    public SmobaDataOuterClass$YoloCyminiID cyminiid = new SmobaDataOuterClass$YoloCyminiID();
}
