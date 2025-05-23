package com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPlazaSvrPB$ContentFeedPunishReq extends MessageMicro<FeedPlazaSvrPB$ContentFeedPunishReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"feed_id", "punish_level"}, new Object[]{"", 0}, FeedPlazaSvrPB$ContentFeedPunishReq.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt32Field punish_level = PBField.initUInt32(0);
}
