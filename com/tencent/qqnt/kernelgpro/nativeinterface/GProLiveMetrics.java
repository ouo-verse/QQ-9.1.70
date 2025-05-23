package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProLiveMetrics {
    public ArrayList<GProMetricsItem> items = new ArrayList<>();

    public ArrayList<GProMetricsItem> getItems() {
        return this.items;
    }

    public String toString() {
        return "GProLiveMetrics{items=" + this.items + ",}";
    }
}
