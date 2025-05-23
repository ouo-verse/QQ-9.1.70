package com.tencent.protofile.navigatebar;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$GroupEvent extends MessageMicro<TroopMsgBox$GroupEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_id", LinkReportConstant$GlobalKey.EVENTS}, new Object[]{0L, null}, TroopMsgBox$GroupEvent.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<TroopMsgBox$Event> events = PBField.initRepeatMessage(TroopMsgBox$Event.class);
}
