package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class FeedsProtocol$FeedDetailByIdsReq extends MessageMicro<FeedsProtocol$FeedDetailByIdsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feed_ids"}, new Object[]{null}, FeedsProtocol$FeedDetailByIdsReq.class);
    public final PBRepeatMessageField<FeedsProtocol$FeedIds> feed_ids = PBField.initRepeatMessage(FeedsProtocol$FeedIds.class);
}
