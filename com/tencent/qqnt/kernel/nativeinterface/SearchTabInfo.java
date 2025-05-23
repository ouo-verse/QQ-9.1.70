package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchTabInfo {
    public long tabMask;
    public String tabName = "";

    public long getTabMask() {
        return this.tabMask;
    }

    public String getTabName() {
        return this.tabName;
    }

    public String toString() {
        return "SearchTabInfo{tabName=" + this.tabName + ",tabMask=" + this.tabMask + ",}";
    }
}
