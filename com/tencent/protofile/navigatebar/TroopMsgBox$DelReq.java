package com.tencent.protofile.navigatebar;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$DelReq extends MessageMicro<TroopMsgBox$DelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_id", "msg_seq", "to_uins"}, new Object[]{0L, 0L, 0L}, TroopMsgBox$DelReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBRepeatField<Long> to_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
