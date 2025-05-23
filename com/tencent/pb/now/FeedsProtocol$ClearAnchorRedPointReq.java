package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$ClearAnchorRedPointReq extends MessageMicro<FeedsProtocol$ClearAnchorRedPointReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"anchor_uid", "feed_id"}, new Object[]{0L, ""}, FeedsProtocol$ClearAnchorRedPointReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
    public final PBStringField feed_id = PBField.initString("");
}
