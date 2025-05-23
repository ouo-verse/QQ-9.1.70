package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProConvertThirdIdRsp {
    public ArrayList<String> ids;
    public ArrayList<String> stringIds;

    public GProConvertThirdIdRsp() {
        this.ids = new ArrayList<>();
        this.stringIds = new ArrayList<>();
    }

    public ArrayList<String> getIds() {
        return this.ids;
    }

    public ArrayList<String> getStringIds() {
        return this.stringIds;
    }

    public String toString() {
        return "GProConvertThirdIdRsp{ids=" + this.ids + ",stringIds=" + this.stringIds + ",}";
    }

    public GProConvertThirdIdRsp(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.ids = new ArrayList<>();
        new ArrayList();
        this.ids = arrayList;
        this.stringIds = arrayList2;
    }
}
