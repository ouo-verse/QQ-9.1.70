package com.tencent.trpcprotocol.qqva.va_group_gift.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GroupGiftBirth$BirthBless extends MessageMicro<GroupGiftBirth$BirthBless> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"wisher", "time"}, new Object[]{"", 0L}, GroupGiftBirth$BirthBless.class);
    public final PBStringField wisher = PBField.initString("");
    public final PBInt64Field time = PBField.initInt64(0);
}
