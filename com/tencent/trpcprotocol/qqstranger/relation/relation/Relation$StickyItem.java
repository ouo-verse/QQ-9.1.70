package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$StickyItem extends MessageMicro<Relation$StickyItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_id", "update_time"}, new Object[]{"", 0L}, Relation$StickyItem.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBInt64Field update_time = PBField.initInt64(0);
}
