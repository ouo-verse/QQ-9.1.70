package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetItemDetailReq {
    public ArrayList<GProItemIdInfo> itemList;
    public GProBottomTabSourceInfo source;
    public String transBuffer;

    public GProGetItemDetailReq() {
        this.source = new GProBottomTabSourceInfo();
        this.itemList = new ArrayList<>();
        this.transBuffer = "";
    }

    public ArrayList<GProItemIdInfo> getItemList() {
        return this.itemList;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String getTransBuffer() {
        return this.transBuffer;
    }

    public void setItemList(ArrayList<GProItemIdInfo> arrayList) {
        this.itemList = arrayList;
    }

    public void setSource(GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.source = gProBottomTabSourceInfo;
    }

    public void setTransBuffer(String str) {
        this.transBuffer = str;
    }

    public String toString() {
        return "GProGetItemDetailReq{source=" + this.source + ",itemList=" + this.itemList + ",transBuffer=" + this.transBuffer + ",}";
    }

    public GProGetItemDetailReq(GProBottomTabSourceInfo gProBottomTabSourceInfo, ArrayList<GProItemIdInfo> arrayList, String str) {
        this.source = new GProBottomTabSourceInfo();
        new ArrayList();
        this.source = gProBottomTabSourceInfo;
        this.itemList = arrayList;
        this.transBuffer = str;
    }
}
