package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupAppExtraInfo {
    public ArrayList<GroupAppTabInfo> tabInfos = new ArrayList<>();

    public ArrayList<GroupAppTabInfo> getTabInfos() {
        return this.tabInfos;
    }

    public String toString() {
        return "GroupAppExtraInfo{tabInfos=" + this.tabInfos + ",}";
    }
}
