package com.tencent.mobileqq.ark.core;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class Proto$EchoReq extends MessageMicro<Proto$EchoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg"}, new Object[]{""}, Proto$EchoReq.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f199323msg = PBField.initString("");
}
