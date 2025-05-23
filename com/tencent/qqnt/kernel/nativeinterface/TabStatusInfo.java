package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TabStatusInfo {
    public boolean isExistence;
    public long tabId;

    public TabStatusInfo() {
    }

    public boolean getIsExistence() {
        return this.isExistence;
    }

    public long getTabId() {
        return this.tabId;
    }

    public String toString() {
        return "TabStatusInfo{tabId=" + this.tabId + ",isExistence=" + this.isExistence + ",}";
    }

    public TabStatusInfo(long j3, boolean z16) {
        this.tabId = j3;
        this.isExistence = z16;
    }
}
