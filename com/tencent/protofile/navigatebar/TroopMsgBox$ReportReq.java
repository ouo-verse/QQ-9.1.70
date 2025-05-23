package com.tencent.protofile.navigatebar;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$ReportReq extends MessageMicro<TroopMsgBox$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"groups"}, new Object[]{null}, TroopMsgBox$ReportReq.class);
    public final PBRepeatMessageField<TroopMsgBox$GroupReport> groups = PBField.initRepeatMessage(TroopMsgBox$GroupReport.class);
}
