package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$FeedDetailReq extends MessageMicro<FeedsProtocol$FeedDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "feed_id"}, new Object[]{0L, ""}, FeedsProtocol$FeedDetailReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField feed_id = PBField.initString("");
}
