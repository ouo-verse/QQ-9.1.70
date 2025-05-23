package com.tencent.protofile.navigatebar;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$AddReq extends MessageMicro<TroopMsgBox$AddReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"group_id", "msg_seq", "from_tinyid", "event_random", "group_events", "to_uins"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L}, TroopMsgBox$AddReq.class);
    public final PBRepeatField<Long> group_events;
    public final PBRepeatField<Long> to_uins;
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field from_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field event_random = PBField.initUInt64(0);

    public TroopMsgBox$AddReq() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.group_events = PBField.initRepeat(pBUInt64Field);
        this.to_uins = PBField.initRepeat(pBUInt64Field);
    }
}
