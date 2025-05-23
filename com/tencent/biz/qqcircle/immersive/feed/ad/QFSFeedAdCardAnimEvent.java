package com.tencent.biz.qqcircle.immersive.feed.ad;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gdtad.aditem.GdtAd;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class QFSFeedAdCardAnimEvent extends SimpleBaseEvent {
    public static final int STATUS_END = 2;
    public static final int STATUS_START = 1;
    public static final int STATUS_UNKNOWN = 0;
    public GdtAd mAd;
    private String mState;
    private int mStatus;

    public QFSFeedAdCardAnimEvent(GdtAd gdtAd, String str, int i3) {
        this.mAd = gdtAd;
        this.mState = str;
        this.mStatus = i3;
    }

    public String getState() {
        return this.mState;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getTraceId() {
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null) {
            return gdtAd.getTraceId();
        }
        return null;
    }
}
