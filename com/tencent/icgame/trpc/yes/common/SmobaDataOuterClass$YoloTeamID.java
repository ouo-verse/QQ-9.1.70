package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloTeamID extends MessageMicro<SmobaDataOuterClass$YoloTeamID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"teamid", "teamseq", "teamentity"}, new Object[]{0, 0, 0}, SmobaDataOuterClass$YoloTeamID.class);
    public final PBUInt32Field teamid = PBField.initUInt32(0);
    public final PBUInt32Field teamseq = PBField.initUInt32(0);
    public final PBUInt32Field teamentity = PBField.initUInt32(0);
}
