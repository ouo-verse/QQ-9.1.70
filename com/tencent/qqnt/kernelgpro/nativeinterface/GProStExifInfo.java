package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStExifInfo {
    public ArrayList<GProFeedEntry> kvs = new ArrayList<>();

    public ArrayList<GProFeedEntry> getKvs() {
        return this.kvs;
    }

    public String toString() {
        return "GProStExifInfo{kvs=" + this.kvs + ",}";
    }
}
