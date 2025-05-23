package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPB$GetCommentAndReplyReq extends MessageMicro<FeedPB$GetCommentAndReplyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 58}, new String[]{"user_id", "account_type", "feed_id", "offset", "count", "sort_type", "attach_info"}, new Object[]{"", 0, "", 0, 0, 0, ""}, FeedPB$GetCommentAndReplyReq.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBEnumField account_type = PBField.initEnum(0);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt32Field offset = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field sort_type = PBField.initUInt32(0);
    public final PBStringField attach_info = PBField.initString("");
}
