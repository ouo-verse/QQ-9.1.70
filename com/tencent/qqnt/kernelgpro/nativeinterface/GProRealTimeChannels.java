package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRealTimeChannels {
    public ArrayList<GProRealTimeChannel> channels;

    public GProRealTimeChannels() {
        this.channels = new ArrayList<>();
    }

    public ArrayList<GProRealTimeChannel> getChannels() {
        return this.channels;
    }

    public String toString() {
        return "GProRealTimeChannels{channels=" + this.channels + ",}";
    }

    public GProRealTimeChannels(ArrayList<GProRealTimeChannel> arrayList) {
        new ArrayList();
        this.channels = arrayList;
    }
}
