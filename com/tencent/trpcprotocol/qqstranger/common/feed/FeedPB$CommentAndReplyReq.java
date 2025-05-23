package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class FeedPB$CommentAndReplyReq extends MessageMicro<FeedPB$CommentAndReplyReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField comment_id = PBField.initString("");
    public final PBStringField reply_id = PBField.initString("");
    public FeedPB$Content content = new FeedPB$Content();
    public final PBBoolField visible_to_public = PBField.initBool(false);
    public final PBStringField target_tid = PBField.initString("");
    public final PBBoolField is_recommend_comment = PBField.initBool(false);
    public final PBEnumField source = PBField.initEnum(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 42, 48, 58, 72, 80}, new String[]{"feed_id", "comment_id", "reply_id", "content", "visible_to_public", "target_tid", "is_recommend_comment", "source"}, new Object[]{"", "", "", null, bool, "", bool, 0}, FeedPB$CommentAndReplyReq.class);
    }
}
