package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$FirstRelationOriginInfo extends MessageMicro<Relation$FirstRelationOriginInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"origin_id", "tag_text"}, new Object[]{0, ""}, Relation$FirstRelationOriginInfo.class);
    public final PBEnumField origin_id = PBField.initEnum(0);
    public final PBStringField tag_text = PBField.initString("");
}
