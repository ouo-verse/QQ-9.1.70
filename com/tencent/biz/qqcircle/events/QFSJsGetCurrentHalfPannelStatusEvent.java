package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSJsGetCurrentHalfPannelStatusEvent extends SimpleBaseEvent {
    private final String mArgs;
    private final String mCallback;
    private final int mWebViewHashCode;

    public QFSJsGetCurrentHalfPannelStatusEvent(String str, String str2, int i3) {
        this.mCallback = str;
        this.mArgs = str2;
        this.mWebViewHashCode = i3;
    }

    public String getArgs() {
        return this.mArgs;
    }

    public String getCallBack() {
        return this.mCallback;
    }

    public int getWebViewHashCode() {
        return this.mWebViewHashCode;
    }
}
