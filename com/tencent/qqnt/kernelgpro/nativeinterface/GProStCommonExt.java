package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStCommonExt {
    public ArrayList<GProFeedEntry> mapInfoList = new ArrayList<>();
    public String attachInfo = "";
    public ArrayList<GProBytesEntry> mapBytesInfoList = new ArrayList<>();

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public ArrayList<GProBytesEntry> getMapBytesInfoList() {
        return this.mapBytesInfoList;
    }

    public ArrayList<GProFeedEntry> getMapInfoList() {
        return this.mapInfoList;
    }

    public String toString() {
        return "GProStCommonExt{mapInfoList=" + this.mapInfoList + ",attachInfo=" + this.attachInfo + ",mapBytesInfoList=" + this.mapBytesInfoList + ",}";
    }
}
