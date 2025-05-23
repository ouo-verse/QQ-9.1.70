package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStreamInfo implements Serializable {
    long serialVersionUID;
    public int streamType;
    public ArrayList<GProStreamURL> streamUrlList;

    public GProStreamInfo() {
        this.serialVersionUID = 1L;
        this.streamUrlList = new ArrayList<>();
    }

    public int getStreamType() {
        return this.streamType;
    }

    public ArrayList<GProStreamURL> getStreamUrlList() {
        return this.streamUrlList;
    }

    public String toString() {
        return "GProStreamInfo{streamType=" + this.streamType + ",streamUrlList=" + this.streamUrlList + ",}";
    }

    public GProStreamInfo(int i3, ArrayList<GProStreamURL> arrayList) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.streamType = i3;
        this.streamUrlList = arrayList;
    }
}
