package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class RootPageContentInfo {
    public String groupName = "";
    public ArrayList<FileBridgeNodeInfo> groupContent = new ArrayList<>();

    public ArrayList<FileBridgeNodeInfo> getGroupContent() {
        return this.groupContent;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String toString() {
        return "RootPageContentInfo{groupName=" + this.groupName + ",groupContent=" + this.groupContent + ",}";
    }
}
