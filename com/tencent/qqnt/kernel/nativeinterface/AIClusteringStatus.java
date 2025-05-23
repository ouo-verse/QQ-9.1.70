package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AIClusteringStatus {
    public ArrayList<FirstClusteringInfo> firstClusteringList = new ArrayList<>();
    public boolean shouldPull;

    public ArrayList<FirstClusteringInfo> getFirstClusteringList() {
        return this.firstClusteringList;
    }

    public boolean getShouldPull() {
        return this.shouldPull;
    }
}
