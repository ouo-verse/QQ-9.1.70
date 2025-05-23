package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProConvertThirdIdReq {
    public long appId;
    public ArrayList<String> ids;
    public ArrayList<String> stringIds;
    public int type;

    public GProConvertThirdIdReq() {
        this.ids = new ArrayList<>();
        this.stringIds = new ArrayList<>();
    }

    public long getAppId() {
        return this.appId;
    }

    public ArrayList<String> getIds() {
        return this.ids;
    }

    public ArrayList<String> getStringIds() {
        return this.stringIds;
    }

    public int getType() {
        return this.type;
    }

    public void setAppId(long j3) {
        this.appId = j3;
    }

    public void setIds(ArrayList<String> arrayList) {
        this.ids = arrayList;
    }

    public void setStringIds(ArrayList<String> arrayList) {
        this.stringIds = arrayList;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        return "GProConvertThirdIdReq{type=" + this.type + ",ids=" + this.ids + ",appId=" + this.appId + ",stringIds=" + this.stringIds + ",}";
    }

    public GProConvertThirdIdReq(int i3, ArrayList<String> arrayList, long j3, ArrayList<String> arrayList2) {
        this.ids = new ArrayList<>();
        new ArrayList();
        this.type = i3;
        this.ids = arrayList;
        this.appId = j3;
        this.stringIds = arrayList2;
    }
}
