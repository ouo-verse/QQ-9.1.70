package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupAppItem {
    public long appId;
    public String iconUrl = "";
    public String title = "";
    public String desc = "";
    public String jumpUrl = "";

    public long getAppId() {
        return this.appId;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GroupAppItem{appId=" + this.appId + ",iconUrl=" + this.iconUrl + ",title=" + this.title + ",desc=" + this.desc + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
