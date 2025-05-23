package com.tencent.mobileqq.reminder.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes18.dex */
public final class BirthdayBlessingPB$Friend extends MessageMicro<BirthdayBlessingPB$Friend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "birthday"}, new Object[]{0L, 0}, BirthdayBlessingPB$Friend.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field birthday = PBField.initUInt32(0);
}
