package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$GetStickyReq extends MessageMicro<Relation$GetStickyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"appid", "user_id"}, new Object[]{0, ""}, Relation$GetStickyReq.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBRepeatField<String> user_id = PBField.initRepeat(PBStringField.__repeatHelper__);
}
