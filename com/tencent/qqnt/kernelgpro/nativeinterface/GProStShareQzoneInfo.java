package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStShareQzoneInfo implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProFeedEntry> entrys = new ArrayList<>();

    public ArrayList<GProFeedEntry> getEntrys() {
        return this.entrys;
    }

    public String toString() {
        return "GProStShareQzoneInfo{entrys=" + this.entrys + ",}";
    }
}
