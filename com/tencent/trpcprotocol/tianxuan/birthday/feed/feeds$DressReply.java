package com.tencent.trpcprotocol.tianxuan.birthday.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds$DressReply extends MessageMicro<feeds$DressReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "msg"}, new Object[]{0L, ""}, feeds$DressReply.class);
    public final PBInt64Field code = PBField.initInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381666msg = PBField.initString("");
}
