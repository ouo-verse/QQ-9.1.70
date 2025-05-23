package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$GetInteractiveMarkerReq extends MessageMicro<Relation$GetInteractiveMarkerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "tinyids"}, new Object[]{0, 0L}, Relation$GetInteractiveMarkerReq.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBRepeatField<Long> tinyids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
