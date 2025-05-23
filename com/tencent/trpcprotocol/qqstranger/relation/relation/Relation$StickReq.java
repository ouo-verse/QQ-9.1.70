package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$StickReq extends MessageMicro<Relation$StickReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"appid", "user_id", "op"}, new Object[]{0, "", 0}, Relation$StickReq.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBStringField user_id = PBField.initString("");

    /* renamed from: op, reason: collision with root package name */
    public final PBEnumField f381615op = PBField.initEnum(0);
}
