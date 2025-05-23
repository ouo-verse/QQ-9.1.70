package com.tencent.biz.qqcircle.immersive.album.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSFullScreenClickAlbumPanelShowEvent extends SimpleBaseEvent {
    private String mFeedId;
    private boolean mIsHasShow;

    public QFSFullScreenClickAlbumPanelShowEvent(String str, boolean z16) {
        this.mFeedId = str;
        this.mIsHasShow = z16;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean isHasShow() {
        return this.mIsHasShow;
    }
}
