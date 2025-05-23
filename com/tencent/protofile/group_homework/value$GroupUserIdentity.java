package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$GroupUserIdentity extends MessageMicro<value$GroupUserIdentity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, value$GroupUserIdentity.class);
    public final PBRepeatMessageField<value$UserIdentityInfo> infos = PBField.initRepeatMessage(value$UserIdentityInfo.class);
}
