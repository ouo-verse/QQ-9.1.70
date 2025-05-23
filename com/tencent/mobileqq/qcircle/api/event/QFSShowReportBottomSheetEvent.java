package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/event/QFSShowReportBottomSheetEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feed", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleDaTongConstant.ElementParamValue.BARRAGE, "Lfeedcloud/FeedCloudMeta$StBarrage;", "comment", "Lfeedcloud/FeedCloudMeta$StComment;", "reply", "Lfeedcloud/FeedCloudMeta$StReply;", "(Lfeedcloud/FeedCloudMeta$StFeed;Lfeedcloud/FeedCloudMeta$StBarrage;Lfeedcloud/FeedCloudMeta$StComment;Lfeedcloud/FeedCloudMeta$StReply;)V", "getBarrage", "()Lfeedcloud/FeedCloudMeta$StBarrage;", "getComment", "()Lfeedcloud/FeedCloudMeta$StComment;", "getFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "getReply", "()Lfeedcloud/FeedCloudMeta$StReply;", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QFSShowReportBottomSheetEvent extends SimpleBaseEvent {

    @Nullable
    private final FeedCloudMeta$StBarrage barrage;

    @Nullable
    private final FeedCloudMeta$StComment comment;

    @NotNull
    private final FeedCloudMeta$StFeed feed;

    @Nullable
    private final FeedCloudMeta$StReply reply;

    public QFSShowReportBottomSheetEvent(@NotNull FeedCloudMeta$StFeed feed, @Nullable FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, @Nullable FeedCloudMeta$StComment feedCloudMeta$StComment, @Nullable FeedCloudMeta$StReply feedCloudMeta$StReply) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
        this.barrage = feedCloudMeta$StBarrage;
        this.comment = feedCloudMeta$StComment;
        this.reply = feedCloudMeta$StReply;
    }

    @Nullable
    public final FeedCloudMeta$StBarrage getBarrage() {
        return this.barrage;
    }

    @Nullable
    public final FeedCloudMeta$StComment getComment() {
        return this.comment;
    }

    @NotNull
    public final FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    @Nullable
    public final FeedCloudMeta$StReply getReply() {
        return this.reply;
    }
}
