package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFDLStCommonExt {
    public ArrayList<GProFDLEntry> mapInfo;

    public GProFDLStCommonExt() {
        this.mapInfo = new ArrayList<>();
    }

    public ArrayList<GProFDLEntry> getMapInfo() {
        return this.mapInfo;
    }

    public void setMapInfo(ArrayList<GProFDLEntry> arrayList) {
        this.mapInfo = arrayList;
    }

    public String toString() {
        return "GProFDLStCommonExt{mapInfo=" + this.mapInfo + ",}";
    }

    public GProFDLStCommonExt(ArrayList<GProFDLEntry> arrayList) {
        new ArrayList();
        this.mapInfo = arrayList;
    }
}
