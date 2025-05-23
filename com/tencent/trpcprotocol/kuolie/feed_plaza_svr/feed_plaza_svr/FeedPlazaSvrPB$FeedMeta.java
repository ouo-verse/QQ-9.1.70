package com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class FeedPlazaSvrPB$FeedMeta extends MessageMicro<FeedPlazaSvrPB$FeedMeta> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"feed_id", "content", "created_at"}, new Object[]{0L, null, 0L}, FeedPlazaSvrPB$FeedMeta.class);
    public final PBUInt64Field feed_id = PBField.initUInt64(0);
    public FeedPlazaSvrPB$FeedContent content = new MessageMicro<FeedPlazaSvrPB$FeedContent>() { // from class: com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr.FeedPlazaSvrPB$FeedContent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"feed_text", "feed_emoji_id"}, new Object[]{"", 0}, FeedPlazaSvrPB$FeedContent.class);
        public final PBStringField feed_text = PBField.initString("");
        public final PBUInt32Field feed_emoji_id = PBField.initUInt32(0);
    };
    public final PBUInt64Field created_at = PBField.initUInt64(0);
}
