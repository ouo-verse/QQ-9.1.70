package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$ReportMessageNodeReq extends MessageMicro<Relation$ReportMessageNodeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"appid", "to_tinyid", "type", "node_type"}, new Object[]{0, 0L, 0, 0}, Relation$ReportMessageNodeReq.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBUInt64Field to_tinyid = PBField.initUInt64(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt32Field node_type = PBField.initUInt32(0);
}
