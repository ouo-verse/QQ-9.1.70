package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaTeamDismissEvent extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaTeamDismissEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"reason", "team_id"}, new Object[]{0, null}, YoloBattleSmobaOuterClass$YoloSmobaTeamDismissEvent.class);
    public final PBUInt32Field reason = PBField.initUInt32(0);
    public SmobaDataOuterClass$YoloTeamID team_id = new SmobaDataOuterClass$YoloTeamID();
}
