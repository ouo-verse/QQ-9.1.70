package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxEvent extends SimpleBaseEvent {
    public static final int EVENT_ADD_COLLECT_BOX = 1;
    public static final int EVENT_ADD_COLLECT_BOX_FEEDS = 6;
    public static final int EVENT_DELETE_COLLECT_BOX = 4;
    public static final int EVENT_DELETE_RECOMMEND_COLLECT_BOX = 3;
    public static final int EVENT_MOVE_COLLECT_BOX_FEEDS = 5;
    public static final int EVENT_UPDATE_COLLECT_BOX = 2;
    private int mEventStatus;
    private FeedCloudFavoritessvr$FavoritesInfo mFavoritesInfo;
    private List<FeedCloudMeta$StFeed> mFeedList;

    public QFSPersonalCollectBoxEvent(int i3) {
        this.mEventStatus = i3;
    }

    public int getEventStatus() {
        return this.mEventStatus;
    }

    public FeedCloudFavoritessvr$FavoritesInfo getFavoritesInfo() {
        return this.mFavoritesInfo;
    }

    public List<FeedCloudMeta$StFeed> getFeedList() {
        return this.mFeedList;
    }

    public void setEventStatus(int i3) {
        this.mEventStatus = i3;
    }

    public void setFavoritesInfo(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        this.mFavoritesInfo = feedCloudFavoritessvr$FavoritesInfo;
    }

    public void setFeedList(List<FeedCloudMeta$StFeed> list) {
        this.mFeedList = list;
    }

    public String toString() {
        return "QFSPersonalCollectBoxEvent{mEventStatus=" + this.mEventStatus + ", mFavoritesInfo=" + this.mFavoritesInfo + ", mFeedList=" + this.mFeedList + "} " + super.toString();
    }
}
