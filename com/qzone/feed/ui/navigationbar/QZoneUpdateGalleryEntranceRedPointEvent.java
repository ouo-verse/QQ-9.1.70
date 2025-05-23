package com.qzone.feed.ui.navigationbar;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes39.dex */
public class QZoneUpdateGalleryEntranceRedPointEvent extends SimpleBaseEvent {
    private int mRedPointNum;
    private int mRedPointType;

    public QZoneUpdateGalleryEntranceRedPointEvent(int i3, int i16) {
        this.mRedPointNum = i3;
        this.mRedPointType = i16;
    }

    public int getRedPointNum() {
        return this.mRedPointNum;
    }

    public int getRedPointType() {
        return this.mRedPointType;
    }
}
