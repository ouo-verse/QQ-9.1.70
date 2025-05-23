package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes38.dex */
public final class FeedPB$GetCommentAndReplyRsp extends MessageMicro<FeedPB$GetCommentAndReplyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"comment_by_page"}, new Object[]{null}, FeedPB$GetCommentAndReplyRsp.class);
    public FeedPB$CommentByPage comment_by_page = new FeedPB$CommentByPage();
}
