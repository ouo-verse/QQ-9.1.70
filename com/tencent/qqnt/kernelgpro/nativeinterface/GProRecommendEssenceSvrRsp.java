package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendEssenceSvrRsp {
    public String content;
    public ArrayList<GProRecommendChannel0x11bc> recommendChannels;

    public GProRecommendEssenceSvrRsp() {
        this.content = "";
        this.recommendChannels = new ArrayList<>();
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<GProRecommendChannel0x11bc> getRecommendChannels() {
        return this.recommendChannels;
    }

    public String toString() {
        return "GProRecommendEssenceSvrRsp{content=" + this.content + ",recommendChannels=" + this.recommendChannels + ",}";
    }

    public GProRecommendEssenceSvrRsp(String str, ArrayList<GProRecommendChannel0x11bc> arrayList) {
        this.content = "";
        new ArrayList();
        this.content = str;
        this.recommendChannels = arrayList;
    }
}
