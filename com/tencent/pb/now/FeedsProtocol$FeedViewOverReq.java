package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$FeedViewOverReq extends MessageMicro<FeedsProtocol$FeedViewOverReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"anchor_uid", "update_time"}, new Object[]{0L, 0L}, FeedsProtocol$FeedViewOverReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
    public final PBUInt64Field update_time = PBField.initUInt64(0);
}
