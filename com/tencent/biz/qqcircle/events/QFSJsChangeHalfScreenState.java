package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSJsChangeHalfScreenState extends SimpleBaseEvent {
    private final String mArgs;
    private final String mState;
    private final int mWebViewHashCode;

    public QFSJsChangeHalfScreenState(String str, int i3, String str2) {
        this.mArgs = str;
        this.mWebViewHashCode = i3;
        this.mState = str2;
    }

    public String getArgs() {
        return this.mArgs;
    }

    public String getState() {
        return this.mState;
    }

    public int getWebViewHashCode() {
        return this.mWebViewHashCode;
    }
}
