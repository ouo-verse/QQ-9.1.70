package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsTabItemGroup {
    public byte[] tabName = new byte[0];
    public ArrayList<Long> groupMaskList = new ArrayList<>();

    public ArrayList<Long> getGroupMaskList() {
        return this.groupMaskList;
    }

    public byte[] getTabName() {
        return this.tabName;
    }

    public String toString() {
        return "UfsTabItemGroup{tabName=" + this.tabName + ",groupMaskList=" + this.groupMaskList + ",}";
    }
}
