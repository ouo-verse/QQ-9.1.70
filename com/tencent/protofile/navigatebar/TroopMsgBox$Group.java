package com.tencent.protofile.navigatebar;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$Group extends MessageMicro<TroopMsgBox$Group> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"group_id", "event_types", "begin_seq", "end_seq", LinkReportConstant$GlobalKey.EVENTS}, new Object[]{0L, 0L, 0L, 0L, null}, TroopMsgBox$Group.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> event_types = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field begin_seq = PBField.initUInt64(0);
    public final PBUInt64Field end_seq = PBField.initUInt64(0);
    public final PBRepeatMessageField<TroopMsgBox$Event> events = PBField.initRepeatMessage(TroopMsgBox$Event.class);
}
