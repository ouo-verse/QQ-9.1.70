package com.tencent.biz.qqcircle.beans;

import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StHelperInfo;

/* loaded from: classes4.dex */
public class QFSHelpPushPanelItemInfo {
    public static final int ITEM_TYPE_HEAD = -101;
    public static final int ITEM_TYPE_HELP_PUSH_USER = -103;
    public static final int ITEM_TYPE_SPILT_LINE = -102;
    private FeedCloudMeta$StFeed feed;
    private FeedCloudMeta$PushBoxViewInfo mPushBoxViewInfo;
    private QCircleReportBean mReportBean;
    private long mShareTime;
    private FeedCloudMeta$StUser mShareUser;
    private FeedCloudRead$StHelperInfo mStHelperInfo;
    private int mTotalHelpUserNum;
    private int mType;

    public FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    public FeedCloudMeta$PushBoxViewInfo getPushBoxViewInfo() {
        return this.mPushBoxViewInfo;
    }

    public QCircleReportBean getReportBean() {
        return this.mReportBean;
    }

    public long getShareTime() {
        return this.mShareTime;
    }

    public FeedCloudMeta$StUser getShareUser() {
        return this.mShareUser;
    }

    public FeedCloudRead$StHelperInfo getStHelperInfo() {
        return this.mStHelperInfo;
    }

    public int getTotalHelpUserNum() {
        return this.mTotalHelpUserNum;
    }

    public int getType() {
        return this.mType;
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.feed = feedCloudMeta$StFeed;
    }

    public void setPushBoxViewInfo(FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo) {
        this.mPushBoxViewInfo = feedCloudMeta$PushBoxViewInfo;
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = qCircleReportBean;
    }

    public void setShareTime(long j3) {
        this.mShareTime = j3;
    }

    public void setShareUser(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.mShareUser = feedCloudMeta$StUser;
    }

    public void setStHelperInfo(FeedCloudRead$StHelperInfo feedCloudRead$StHelperInfo) {
        this.mStHelperInfo = feedCloudRead$StHelperInfo;
    }

    public void setTotalHelpUserNum(int i3) {
        this.mTotalHelpUserNum = i3;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public String toString() {
        return "QFSHelpPushPanelItemInfo{mPushBoxViewInfo=" + this.mPushBoxViewInfo + ", mTotalHelpUsers=" + this.mTotalHelpUserNum + ", mStHelperInfo=" + this.mStHelperInfo + ", feed=" + this.feed + ", mShareUser=" + this.mShareUser + ", mShareTime=" + this.mShareTime + ", mReportBean=" + this.mReportBean + ", mType=" + this.mType + '}';
    }
}
