package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class QFSTVideoPendantToastEvent extends SimpleBaseEvent {
    private String jumpUrl;
    private int showTime;
    private String toastContent;

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getShowTime() {
        return this.showTime;
    }

    public String getToastContent() {
        return this.toastContent;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setShowTime(int i3) {
        this.showTime = i3;
    }

    public void setToastContent(String str) {
        this.toastContent = str;
    }
}
