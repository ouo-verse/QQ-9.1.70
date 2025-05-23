package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommentReplyEvent extends SimpleBaseEvent {
    public CertifiedAccountMeta$StComment mStComment;
    public CertifiedAccountMeta$StReply mStReply;

    public CommentReplyEvent(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        this.mStComment = certifiedAccountMeta$StComment;
        this.mStReply = certifiedAccountMeta$StReply;
    }
}
