package com.tencent.trpcprotocol.qqva.va_group_gift.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GroupGiftBirth$UserBirth extends MessageMicro<GroupGiftBirth$UserBirth> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"uid", "time", "bless_list"}, new Object[]{"", 0L, null}, GroupGiftBirth$UserBirth.class);
    public final PBStringField uid = PBField.initString("");
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBRepeatMessageField<GroupGiftBirth$BirthBless> bless_list = PBField.initRepeatMessage(GroupGiftBirth$BirthBless.class);
}
