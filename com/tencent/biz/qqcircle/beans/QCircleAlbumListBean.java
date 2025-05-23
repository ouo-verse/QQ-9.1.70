package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAlbumListBean extends QCircleInitBean {
    private boolean mHasMore;
    private List<byte[]> mFeedAlbumInfoBytes = new ArrayList();
    private String mAttachInfo = "";

    public String getAttachInfo() {
        return this.mAttachInfo;
    }

    public List<byte[]> getFeedAlbumInfoBytes() {
        return this.mFeedAlbumInfoBytes;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public void setAttachInfo(String str) {
        this.mAttachInfo = str;
    }

    public void setFeedAlbumInfo(List<FeedCloudMeta$FeedAlbumInfo> list) {
        if (list != null && list.size() > 0) {
            Iterator<FeedCloudMeta$FeedAlbumInfo> it = list.iterator();
            while (it.hasNext()) {
                this.mFeedAlbumInfoBytes.add(it.next().toByteArray());
            }
        }
    }

    public void setHasMore(boolean z16) {
        this.mHasMore = z16;
    }
}
