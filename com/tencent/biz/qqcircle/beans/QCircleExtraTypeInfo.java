package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleExtraTypeInfo implements Serializable {
    private static final long serialVersionUID = -137590948041340019L;
    public String mCurrentPersonalUin;
    public int mDataPosition;
    public transient FeedCloudMeta$StFeed mFeed;
    public String mGlobalViewModelKey;
    public int mPlayScene;
    public int mSubPageId;
    public int mSubPageType;
    public int pageType;
    public int sourceType;
    public String title;
    public int subSource = 0;
    public final Map<String, Object> mReportExtraMap = new ConcurrentHashMap();

    public String toString() {
        return "QCircleExtraTypeInfo{pageType=" + this.pageType + ", sourceType=" + this.sourceType + ", mDataPosition=" + this.mDataPosition + ", mPlayScene=" + this.mPlayScene + ", mFeed=" + this.mFeed + ", title='" + this.title + "', mCurrentPersonalUin='" + this.mCurrentPersonalUin + "', mGlobalViewModelKey='" + this.mGlobalViewModelKey + "'}";
    }
}
