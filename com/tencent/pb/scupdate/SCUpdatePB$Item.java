package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class SCUpdatePB$Item extends MessageMicro<SCUpdatePB$Item> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"bid", "scid"}, new Object[]{0, ""}, SCUpdatePB$Item.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBStringField scid = PBField.initString("");
}
