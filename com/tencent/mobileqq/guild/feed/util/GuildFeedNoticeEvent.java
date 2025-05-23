package com.tencent.mobileqq.guild.feed.util;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/GuildFeedNoticeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", WSAutoShowCommentParams.KEY_COMMENT_ID, "", WSAutoShowCommentParams.KEY_REPLY_ID, "status", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCommentId", "()Ljava/lang/String;", "getReplyId", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedNoticeEvent extends SimpleBaseEvent {

    @NotNull
    private final String commentId;

    @NotNull
    private final String replyId;
    private final int status;

    public GuildFeedNoticeEvent(@NotNull String commentId, @NotNull String replyId, int i3) {
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        this.commentId = commentId;
        this.replyId = replyId;
        this.status = i3;
    }

    @NotNull
    public final String getCommentId() {
        return this.commentId;
    }

    @NotNull
    public final String getReplyId() {
        return this.replyId;
    }

    public final int getStatus() {
        return this.status;
    }
}
