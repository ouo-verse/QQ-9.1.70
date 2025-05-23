package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0015B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/event/QFSReportResultEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "type", "Lcom/tencent/mobileqq/qcircle/api/event/QFSReportResultEvent$ReportType;", "feed", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleDaTongConstant.ElementParamValue.BARRAGE, "Lfeedcloud/FeedCloudMeta$StBarrage;", WSAutoShowCommentParams.KEY_COMMENT_ID, "", WSAutoShowCommentParams.KEY_REPLY_ID, "(Lcom/tencent/mobileqq/qcircle/api/event/QFSReportResultEvent$ReportType;Lfeedcloud/FeedCloudMeta$StFeed;Lfeedcloud/FeedCloudMeta$StBarrage;Ljava/lang/String;Ljava/lang/String;)V", "getBarrage", "()Lfeedcloud/FeedCloudMeta$StBarrage;", "getCommentId", "()Ljava/lang/String;", "getFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "getReplyId", "getType", "()Lcom/tencent/mobileqq/qcircle/api/event/QFSReportResultEvent$ReportType;", "ReportType", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QFSReportResultEvent extends SimpleBaseEvent {

    @Nullable
    private final FeedCloudMeta$StBarrage barrage;

    @Nullable
    private final String commentId;

    @Nullable
    private final FeedCloudMeta$StFeed feed;

    @Nullable
    private final String replyId;

    @Nullable
    private final ReportType type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/event/QFSReportResultEvent$ReportType;", "", "(Ljava/lang/String;I)V", "COMMENT", "REPLY", "BARRAGE", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum ReportType {
        COMMENT,
        REPLY,
        BARRAGE
    }

    public QFSReportResultEvent(@Nullable ReportType reportType, @Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed, @Nullable FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, @Nullable String str, @Nullable String str2) {
        this.type = reportType;
        this.feed = feedCloudMeta$StFeed;
        this.barrage = feedCloudMeta$StBarrage;
        this.commentId = str;
        this.replyId = str2;
    }

    @Nullable
    public final FeedCloudMeta$StBarrage getBarrage() {
        return this.barrage;
    }

    @Nullable
    public final String getCommentId() {
        return this.commentId;
    }

    @Nullable
    public final FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    @Nullable
    public final String getReplyId() {
        return this.replyId;
    }

    @Nullable
    public final ReportType getType() {
        return this.type;
    }
}
