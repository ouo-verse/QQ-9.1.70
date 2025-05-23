package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenAlbumModeChangeEvent extends SimpleBaseEvent {
    private boolean isAlbumMode;
    private String mFeedId;

    public QFSFullScreenAlbumModeChangeEvent(boolean z16, String str) {
        this.isAlbumMode = z16;
        this.mFeedId = str;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean isAlbumMode() {
        return this.isAlbumMode;
    }
}
