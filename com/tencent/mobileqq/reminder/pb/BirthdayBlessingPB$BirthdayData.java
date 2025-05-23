package com.tencent.mobileqq.reminder.pb;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes18.dex */
public final class BirthdayBlessingPB$BirthdayData extends MessageMicro<BirthdayBlessingPB$BirthdayData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 120}, new String[]{"uin", "friends", Element.ELEMENT_NAME_TIMES}, new Object[]{0L, null, 0L}, BirthdayBlessingPB$BirthdayData.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<BirthdayBlessingPB$Friend> friends = PBField.initRepeatMessage(BirthdayBlessingPB$Friend.class);
    public final PBUInt64Field times = PBField.initUInt64(0);
}
