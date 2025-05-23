package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class FeedPB$GetFeedDetailReq extends MessageMicro<FeedPB$GetFeedDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feed_id"}, new Object[]{""}, FeedPB$GetFeedDetailReq.class);
    public final PBStringField feed_id = PBField.initString("");
}
