package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStDebugInfo {
    public ArrayList<GProFeedEntry> debugMapList = new ArrayList<>();

    public ArrayList<GProFeedEntry> getDebugMapList() {
        return this.debugMapList;
    }

    public String toString() {
        return "GProStDebugInfo{debugMapList=" + this.debugMapList + ",}";
    }
}
