package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenSeekBarEvent extends SimpleBaseEvent {
    public static final int SEEK_ACTION_START = 1;
    public static final int SEEK_ACTION_STOP = 2;
    private String mFeedId;
    private int mSeekBarAction;

    public QFSFullScreenSeekBarEvent(int i3, String str) {
        this.mSeekBarAction = i3;
        this.mFeedId = str;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getSeekBarAction() {
        return this.mSeekBarAction;
    }
}
