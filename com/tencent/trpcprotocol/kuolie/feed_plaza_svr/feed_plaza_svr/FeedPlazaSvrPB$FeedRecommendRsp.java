package com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;

/* loaded from: classes38.dex */
public final class FeedPlazaSvrPB$FeedRecommendRsp extends MessageMicro<FeedPlazaSvrPB$FeedRecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 32, 42, 50}, new String[]{"ret_code", "err_msg", "flag_end", "content_feeds", "ext_data"}, new Object[]{0, "", 0, null, ""}, FeedPlazaSvrPB$FeedRecommendRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field flag_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedPB$Feed> content_feeds = PBField.initRepeatMessage(FeedPB$Feed.class);
    public final PBStringField ext_data = PBField.initString("");
}
