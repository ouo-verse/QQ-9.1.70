package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetDiscoverAudioVideoRsp {
    public String cookies;
    public GProRecommendExtInfo extInfo;
    public ArrayList<GProRecommendItem> items;

    public GProGetDiscoverAudioVideoRsp() {
        this.items = new ArrayList<>();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = "";
    }

    public String getCookies() {
        return this.cookies;
    }

    public GProRecommendExtInfo getExtInfo() {
        return this.extInfo;
    }

    public ArrayList<GProRecommendItem> getItems() {
        return this.items;
    }

    public String toString() {
        return "GProGetDiscoverAudioVideoRsp{items=" + this.items + ",extInfo=" + this.extInfo + ",cookies=" + this.cookies + ",}";
    }

    public GProGetDiscoverAudioVideoRsp(ArrayList<GProRecommendItem> arrayList, GProRecommendExtInfo gProRecommendExtInfo, String str) {
        this.items = new ArrayList<>();
        new GProRecommendExtInfo();
        this.items = arrayList;
        this.extInfo = gProRecommendExtInfo;
        this.cookies = str;
    }
}
