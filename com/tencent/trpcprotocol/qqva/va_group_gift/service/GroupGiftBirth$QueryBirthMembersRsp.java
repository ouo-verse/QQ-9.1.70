package com.tencent.trpcprotocol.qqva.va_group_gift.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GroupGiftBirth$QueryBirthMembersRsp extends MessageMicro<GroupGiftBirth$QueryBirthMembersRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "msg", "birth_list"}, new Object[]{0, "", null}, GroupGiftBirth$QueryBirthMembersRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381644msg = PBField.initString("");
    public final PBRepeatMessageField<GroupGiftBirth$UserBirth> birth_list = PBField.initRepeatMessage(GroupGiftBirth$UserBirth.class);
}
