package com.tencent.mobileqq.reminder.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes18.dex */
public final class BirthdayBlessingPB$RemindReq extends MessageMicro<BirthdayBlessingPB$RemindReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"friends"}, new Object[]{null}, BirthdayBlessingPB$RemindReq.class);
    public final PBRepeatMessageField<BirthdayBlessingPB$Friend> friends = PBField.initRepeatMessage(BirthdayBlessingPB$Friend.class);
}
