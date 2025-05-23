package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupTabInfo {
    public ArrayList<ListNode> tabs = new ArrayList<>();
    public ListNode curTab = new ListNode();

    public ListNode getCurTab() {
        return this.curTab;
    }

    public ArrayList<ListNode> getTabs() {
        return this.tabs;
    }

    public String toString() {
        return "GroupTabInfo{tabs=" + this.tabs + ",curTab=" + this.curTab + ",}";
    }
}
