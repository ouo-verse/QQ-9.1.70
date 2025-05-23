package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPopBlockList implements Serializable {
    public String blockName;
    public ArrayList<GProBlockBaseInfo> list;
    public int nextTs;
    long serialVersionUID;

    public GProPopBlockList() {
        this.serialVersionUID = 1L;
        this.blockName = "";
        this.list = new ArrayList<>();
    }

    public String getBlockName() {
        return this.blockName;
    }

    public ArrayList<GProBlockBaseInfo> getList() {
        return this.list;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public String toString() {
        return "GProPopBlockList{blockName=" + this.blockName + ",list=" + this.list + ",nextTs=" + this.nextTs + ",}";
    }

    public GProPopBlockList(String str, ArrayList<GProBlockBaseInfo> arrayList, int i3) {
        this.serialVersionUID = 1L;
        this.blockName = "";
        new ArrayList();
        this.blockName = str;
        this.list = arrayList;
        this.nextTs = i3;
    }
}
