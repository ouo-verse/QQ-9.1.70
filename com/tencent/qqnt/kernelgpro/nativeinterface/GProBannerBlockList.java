package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBannerBlockList implements Serializable {
    public String blockName;
    public ArrayList<GProBlockBaseInfo> list;
    long serialVersionUID;

    public GProBannerBlockList() {
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

    public String toString() {
        return "GProBannerBlockList{blockName=" + this.blockName + ",list=" + this.list + ",}";
    }

    public GProBannerBlockList(String str, ArrayList<GProBlockBaseInfo> arrayList) {
        this.serialVersionUID = 1L;
        this.blockName = "";
        new ArrayList();
        this.blockName = str;
        this.list = arrayList;
    }
}
