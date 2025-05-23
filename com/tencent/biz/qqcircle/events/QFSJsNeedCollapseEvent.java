package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSJsNeedCollapseEvent extends SimpleBaseEvent {
    private final String mArgs;
    private final int mNeedCollapse;
    private final int mWebViewHashCode;

    public QFSJsNeedCollapseEvent(int i3, String str, int i16) {
        this.mNeedCollapse = i3;
        this.mArgs = str;
        this.mWebViewHashCode = i16;
    }

    public String getArgs() {
        return this.mArgs;
    }

    public int getNeedCollapse() {
        return this.mNeedCollapse;
    }

    public int getWebViewHashCode() {
        return this.mWebViewHashCode;
    }
}
