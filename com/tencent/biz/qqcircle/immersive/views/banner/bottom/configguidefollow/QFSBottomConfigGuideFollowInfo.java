package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import feedcloud.FeedCloudMeta$StUser;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomConfigGuideFollowInfo implements Serializable {
    private List<e30.b> mFeedBlockDataList;
    private boolean mIsRecOpen;
    private int mType;
    private List<FeedCloudMeta$StUser> mUserList;

    public List<e30.b> getFeedBlockDataList() {
        return this.mFeedBlockDataList;
    }

    public int getType() {
        return this.mType;
    }

    public List<FeedCloudMeta$StUser> getUserList() {
        return this.mUserList;
    }

    public boolean isRecOpen() {
        return this.mIsRecOpen;
    }

    public void setFeedBlockDataList(List<e30.b> list) {
        this.mFeedBlockDataList = list;
    }

    public QFSBottomConfigGuideFollowInfo setRecOpen(boolean z16) {
        this.mIsRecOpen = z16;
        return this;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public void setUserList(List<FeedCloudMeta$StUser> list) {
        this.mUserList = list;
    }

    public String toString() {
        return "QFSBottomConfigGuideFollowInfo{mType=" + this.mType + ", mIsRecOpen=" + this.mIsRecOpen + ", mUserList=" + this.mUserList + ", mFeedBlockDataList=" + this.mFeedBlockDataList + '}';
    }
}
