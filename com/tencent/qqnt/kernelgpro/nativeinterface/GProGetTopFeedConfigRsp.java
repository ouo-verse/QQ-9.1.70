package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetTopFeedConfigRsp {
    public boolean allowNotifyAction;
    public boolean allowTopAction;
    public int maxNotifyCount;
    public int maxTopCount;
    public int remainderNotifyCount;
    public int topCount;
    public String notAllowReason = "";
    public ArrayList<GProLabel> canUseLabels = new ArrayList<>();
    public String notAllowNotifyReason = "";

    public boolean getAllowNotifyAction() {
        return this.allowNotifyAction;
    }

    public boolean getAllowTopAction() {
        return this.allowTopAction;
    }

    public ArrayList<GProLabel> getCanUseLabels() {
        return this.canUseLabels;
    }

    public int getMaxNotifyCount() {
        return this.maxNotifyCount;
    }

    public int getMaxTopCount() {
        return this.maxTopCount;
    }

    public String getNotAllowNotifyReason() {
        return this.notAllowNotifyReason;
    }

    public String getNotAllowReason() {
        return this.notAllowReason;
    }

    public int getRemainderNotifyCount() {
        return this.remainderNotifyCount;
    }

    public int getTopCount() {
        return this.topCount;
    }

    public String toString() {
        return "GProGetTopFeedConfigRsp{allowTopAction=" + this.allowTopAction + ",notAllowReason=" + this.notAllowReason + ",remainderNotifyCount=" + this.remainderNotifyCount + ",maxNotifyCount=" + this.maxNotifyCount + ",topCount=" + this.topCount + ",maxTopCount=" + this.maxTopCount + ",canUseLabels=" + this.canUseLabels + ",allowNotifyAction=" + this.allowNotifyAction + ",notAllowNotifyReason=" + this.notAllowNotifyReason + ",}";
    }
}
