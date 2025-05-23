package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSDeleteQZoneVideoAlbumEvent extends SimpleBaseEvent {
    private String mFeedId;
    private boolean mIsDeleteAll;

    public QFSDeleteQZoneVideoAlbumEvent(boolean z16) {
        this.mIsDeleteAll = z16;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean isDeleteAll() {
        return this.mIsDeleteAll;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public QFSDeleteQZoneVideoAlbumEvent(boolean z16, String str) {
        this.mIsDeleteAll = z16;
        this.mFeedId = str;
    }
}
