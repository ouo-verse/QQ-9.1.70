package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProNoticeAction {
    public int style;
    public String title = "";
    public String actionId = "";

    public String getActionId() {
        return this.actionId;
    }

    public int getStyle() {
        return this.style;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProNoticeAction{style=" + this.style + ",title=" + this.title + ",actionId=" + this.actionId + ",}";
    }
}
