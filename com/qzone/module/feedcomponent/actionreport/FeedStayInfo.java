package com.qzone.module.feedcomponent.actionreport;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedStayInfo {
    public BusinessFeedData mFeedData;
    public long mFeedEnterTime;
    public int mFeedPosition;

    public FeedStayInfo(long j3, int i3, BusinessFeedData businessFeedData) {
        this.mFeedEnterTime = j3;
        this.mFeedPosition = i3;
        this.mFeedData = businessFeedData;
    }
}
