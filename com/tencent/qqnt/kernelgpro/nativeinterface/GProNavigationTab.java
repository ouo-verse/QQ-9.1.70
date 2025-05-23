package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProNavigationTab {
    public String name = "";
    public int subType;
    public int tabId;
    public int tabType;

    public String getName() {
        return this.name;
    }

    public int getSubType() {
        return this.subType;
    }

    public int getTabId() {
        return this.tabId;
    }

    public int getTabType() {
        return this.tabType;
    }

    public String toString() {
        return "GProNavigationTab{tabType=" + this.tabType + ",subType=" + this.subType + ",name=" + this.name + ",tabId=" + this.tabId + ",}";
    }
}
