package com.tencent.biz.qqcircle.immersive.events;

import android.graphics.Bitmap;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFloatEndCaptureEvent extends SimpleBaseEvent {
    private final Bitmap mCoverBitMap;
    private final String mFeedId;

    public QFSFloatEndCaptureEvent(String str, Bitmap bitmap) {
        this.mFeedId = str;
        this.mCoverBitMap = bitmap;
    }

    public Bitmap getBitMap() {
        return this.mCoverBitMap;
    }

    public String getFeedId() {
        return this.mFeedId;
    }
}
