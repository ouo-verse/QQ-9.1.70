package com.tencent.biz.qqcircle.events;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSReplyExtraBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetReplyListRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSReplyListEvent extends SimpleBaseEvent {
    private int mContextHashCode;
    private QFSReplyExtraBean mExtraBean;
    private boolean mLoadSuccess;
    private FeedCloudRead$StGetReplyListRsp mRsp;
    private FeedCloudMeta$StComment mStComment;
    private FeedCloudMeta$StFeed mStFeed;

    public QFSReplyListEvent(int i3, boolean z16, QFSReplyExtraBean qFSReplyExtraBean) {
        this.mContextHashCode = i3;
        this.mLoadSuccess = z16;
        this.mExtraBean = qFSReplyExtraBean;
    }

    public int getContextHashCode() {
        return this.mContextHashCode;
    }

    public QFSReplyExtraBean getExtraBean() {
        return this.mExtraBean;
    }

    public FeedCloudRead$StGetReplyListRsp getRsp() {
        return this.mRsp;
    }

    public FeedCloudMeta$StComment getStComment() {
        return this.mStComment;
    }

    public FeedCloudMeta$StFeed getStFeed() {
        return this.mStFeed;
    }

    public boolean isLoadSuccess() {
        return this.mLoadSuccess;
    }

    public void setContextHashCode(int i3) {
        this.mContextHashCode = i3;
    }

    public void setExtraBean(QFSReplyExtraBean qFSReplyExtraBean) {
        this.mExtraBean = qFSReplyExtraBean;
    }

    public void setLoadSuccess(boolean z16) {
        this.mLoadSuccess = z16;
    }

    public void setRsp(FeedCloudRead$StGetReplyListRsp feedCloudRead$StGetReplyListRsp) {
        this.mRsp = feedCloudRead$StGetReplyListRsp;
    }

    public void setStComment(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        this.mStComment = feedCloudMeta$StComment;
    }

    public void setStFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mStFeed = feedCloudMeta$StFeed;
    }

    public String toString() {
        return "QFSReplyListEvent{mContextHashCode=" + this.mContextHashCode + ", mStFeed=" + this.mStFeed + ", mStComment=" + this.mStComment + ", mRsp=" + this.mRsp + ", mLoadSuccess=" + this.mLoadSuccess + ", mExtraBean=" + this.mExtraBean + "} " + super.toString();
    }

    public QFSReplyListEvent(int i3, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull FeedCloudMeta$StComment feedCloudMeta$StComment, @NonNull FeedCloudRead$StGetReplyListRsp feedCloudRead$StGetReplyListRsp, QFSReplyExtraBean qFSReplyExtraBean) {
        this.mContextHashCode = i3;
        this.mStFeed = feedCloudMeta$StFeed;
        this.mStComment = feedCloudMeta$StComment;
        this.mRsp = feedCloudRead$StGetReplyListRsp;
        this.mLoadSuccess = true;
        this.mExtraBean = qFSReplyExtraBean;
    }
}
