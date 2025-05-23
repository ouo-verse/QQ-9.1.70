package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$GetStickyRsp extends MessageMicro<Relation$GetStickyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", "items"}, new Object[]{0, "", null}, Relation$GetStickyRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<Relation$StickyItem> items = PBField.initRepeatMessage(Relation$StickyItem.class);
}
