package com.tencent.mobileqq.reminder.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes18.dex */
public final class BirthdayBlessingPB$ReserveReq extends MessageMicro<BirthdayBlessingPB$ReserveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uins", "source"}, new Object[]{0L, 0}, BirthdayBlessingPB$ReserveReq.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field source = PBField.initUInt32(0);
}
