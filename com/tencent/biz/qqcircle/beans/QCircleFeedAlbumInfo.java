package com.tencent.biz.qqcircle.beans;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFeedAlbumInfo implements Serializable {
    public String coverUrl;
    public String description;
    public boolean isCollect;
    public boolean isDraft;
    public long mAlbumId;
    public int mFeedCount;
    public String ownerUin;
    public String title;

    public QCircleFeedAlbumInfo(long j3) {
        this.mAlbumId = j3;
    }

    public QCircleFeedAlbumInfo(String str, long j3, String str2, String str3, String str4, boolean z16, boolean z17) {
        this.mAlbumId = j3;
        this.title = str2;
        this.description = str3;
        this.coverUrl = str4;
        this.ownerUin = str;
        this.isCollect = z16;
        this.isDraft = z17;
    }
}
