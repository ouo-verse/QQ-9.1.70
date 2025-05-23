package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSquareTabItem {
    public long tabId;
    public String txt = "";
    public GroupClassInfo classInfo = new GroupClassInfo();

    public GroupClassInfo getClassInfo() {
        return this.classInfo;
    }

    public long getTabId() {
        return this.tabId;
    }

    public String getTxt() {
        return this.txt;
    }

    public String toString() {
        return "GroupSquareTabItem{txt=" + this.txt + ",classInfo=" + this.classInfo + ",tabId=" + this.tabId + ",}";
    }
}
