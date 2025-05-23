package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$BatchGetShieldUsersReq extends MessageMicro<Security$BatchGetShieldUsersReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_ids"}, new Object[]{""}, Security$BatchGetShieldUsersReq.class);
    public final PBRepeatField<String> open_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
