package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$FeedAlbum;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAlbumDetailBean extends QCircleInitBean {
    private long mAlbumId;
    private byte[] mFeedAlbumByte;

    public QCircleAlbumDetailBean() {
    }

    public long getAlbumId() {
        return this.mAlbumId;
    }

    public byte[] getFeedAlbumByte() {
        return this.mFeedAlbumByte;
    }

    public void setFeedAlbum(FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum) {
        if (feedCloudMeta$FeedAlbum != null) {
            this.mFeedAlbumByte = feedCloudMeta$FeedAlbum.toByteArray();
        }
    }

    public QCircleAlbumDetailBean(long j3) {
        this.mAlbumId = j3;
    }
}
