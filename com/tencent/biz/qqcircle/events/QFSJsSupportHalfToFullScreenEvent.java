package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSJsSupportHalfToFullScreenEvent extends SimpleBaseEvent {
    private final String mArgs;
    private final int mSupportHalfToFullScreen;
    private final int mWebViewHashCode;

    public QFSJsSupportHalfToFullScreenEvent(int i3, String str, int i16) {
        this.mSupportHalfToFullScreen = i3;
        this.mArgs = str;
        this.mWebViewHashCode = i16;
    }

    public String getArgs() {
        return this.mArgs;
    }

    public int getSupportHalfToFullScreen() {
        return this.mSupportHalfToFullScreen;
    }

    public int getWebViewHashCode() {
        return this.mWebViewHashCode;
    }
}
