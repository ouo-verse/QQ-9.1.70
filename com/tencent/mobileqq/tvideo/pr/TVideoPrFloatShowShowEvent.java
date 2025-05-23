package com.tencent.mobileqq.tvideo.pr;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class TVideoPrFloatShowShowEvent extends SimpleBaseEvent {
    private boolean handleLeftWebView;
    private boolean isShow;
    private boolean needRestore;

    public boolean isHandleLeftWebView() {
        return this.handleLeftWebView;
    }

    public boolean isNeedRestore() {
        return this.needRestore;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setHandleLeftWebView(boolean z16) {
        this.handleLeftWebView = z16;
    }

    public void setNeedRestore(boolean z16) {
        this.needRestore = z16;
    }

    public void setShow(boolean z16) {
        this.isShow = z16;
    }
}
