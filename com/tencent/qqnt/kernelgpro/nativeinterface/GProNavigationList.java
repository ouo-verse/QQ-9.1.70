package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProNavigationList implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProNavigationData> dataList = new ArrayList<>();
    public String navigationVersion = "";

    public ArrayList<GProNavigationData> getDataList() {
        return this.dataList;
    }

    public String getNavigationVersion() {
        return this.navigationVersion;
    }

    public String toString() {
        return "GProNavigationList{dataList=" + this.dataList + ",navigationVersion=" + this.navigationVersion + ",}";
    }
}
