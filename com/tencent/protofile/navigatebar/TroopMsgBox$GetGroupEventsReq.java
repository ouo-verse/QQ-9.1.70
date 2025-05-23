package com.tencent.protofile.navigatebar;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$GetGroupEventsReq extends MessageMicro<TroopMsgBox$GetGroupEventsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"groups"}, new Object[]{null}, TroopMsgBox$GetGroupEventsReq.class);
    public final PBRepeatMessageField<TroopMsgBox$Group> groups = PBField.initRepeatMessage(TroopMsgBox$Group.class);
}
