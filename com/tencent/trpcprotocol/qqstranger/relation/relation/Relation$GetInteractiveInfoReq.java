package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$GetInteractiveInfoReq extends MessageMicro<Relation$GetInteractiveInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"node_infos"}, new Object[]{null}, Relation$GetInteractiveInfoReq.class);
    public final PBRepeatMessageField<Relation$MessageNodeInfo> node_infos = PBField.initRepeatMessage(Relation$MessageNodeInfo.class);
}
