package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAreaTabItemInfo {
    public static final int ITEM_VIEW_TYPE_HOST_PUSH = 1;
    private boolean isThanked;
    private boolean mIsLikeTabItem;
    private int mItemViewType;
    public boolean mNeedTopAnimation;
    private FeedCloudMeta$StFeed mStFeed;
    private int pushNum;
    private String subTitle;
    private FeedCloudMeta$StUser user;

    public String getFeedId() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mStFeed;
        if (feedCloudMeta$StFeed != null) {
            return feedCloudMeta$StFeed.f398449id.get();
        }
        return "";
    }

    public int getItemViewType() {
        return this.mItemViewType;
    }

    public boolean getNeedTopAnimation() {
        return this.mNeedTopAnimation;
    }

    public int getPushNum() {
        return this.pushNum;
    }

    public FeedCloudMeta$StFeed getStFeed() {
        return this.mStFeed;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public FeedCloudMeta$StUser getUser() {
        return this.user;
    }

    public boolean isLikeTabItem() {
        return this.mIsLikeTabItem;
    }

    public boolean isThanked() {
        return this.isThanked;
    }

    public void setIsLikeTabItem(boolean z16) {
        this.mIsLikeTabItem = z16;
    }

    public void setItemViewType(int i3) {
        this.mItemViewType = i3;
    }

    public void setLikeItemInfo(FeedCloudMeta$StUser feedCloudMeta$StUser, String str) {
        this.user = feedCloudMeta$StUser;
        this.subTitle = str;
    }

    public void setNeedTopAnimation(boolean z16) {
        this.mNeedTopAnimation = z16;
    }

    public void setPushItemInfo(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
        this.user = feedCloudMeta$StUser;
        this.pushNum = i3;
    }

    public void setStFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mStFeed = feedCloudMeta$StFeed;
    }

    public void setThanked(boolean z16) {
        this.isThanked = z16;
    }

    public String toString() {
        return "QFSCommentAreaTabItemInfo{user=" + this.user + ", subTitle='" + this.subTitle + "', pushNum=" + this.pushNum + ", mNeedTopAnimation=" + this.mNeedTopAnimation + '}';
    }
}
