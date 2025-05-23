package com.tencent.trpcprotocol.qqva.va_group_gift.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GroupGiftBirth$QueryBirthMembersReq extends MessageMicro<GroupGiftBirth$QueryBirthMembersReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_id"}, new Object[]{0L}, GroupGiftBirth$QueryBirthMembersReq.class);
    public final PBInt64Field group_id = PBField.initInt64(0);
}
