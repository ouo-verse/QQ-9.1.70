package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class TianshuAdPlacementInfo {
    public ArrayList<TianshuAdItem> adItem;
    public String ctlInfo;
    public String extInfo;
    public int nextQueryTs;
    public int type;

    public TianshuAdPlacementInfo() {
        this.adItem = new ArrayList<>();
        this.extInfo = "";
        this.ctlInfo = "";
    }

    public ArrayList<TianshuAdItem> getAdItem() {
        return this.adItem;
    }

    public String getCtlInfo() {
        return this.ctlInfo;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public int getNextQueryTs() {
        return this.nextQueryTs;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "TianshuAdPlacementInfo{type=" + this.type + ",adItem=" + this.adItem + ",nextQueryTs=" + this.nextQueryTs + ",extInfo=" + this.extInfo + ",ctlInfo=" + this.ctlInfo + ",}";
    }

    public TianshuAdPlacementInfo(int i3, ArrayList<TianshuAdItem> arrayList, int i16, String str, String str2) {
        new ArrayList();
        this.type = i3;
        this.adItem = arrayList;
        this.nextQueryTs = i16;
        this.extInfo = str;
        this.ctlInfo = str2;
    }
}
