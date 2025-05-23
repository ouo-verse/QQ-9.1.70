package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetRecommendForIntroRsp {
    public ArrayList<IntroductoryGuildInfo> introductoryGuildInfos;

    public GProGetRecommendForIntroRsp() {
        this.introductoryGuildInfos = new ArrayList<>();
    }

    public ArrayList<IntroductoryGuildInfo> getIntroductoryGuildInfos() {
        return this.introductoryGuildInfos;
    }

    public String toString() {
        return "GProGetRecommendForIntroRsp{introductoryGuildInfos=" + this.introductoryGuildInfos + ",}";
    }

    public GProGetRecommendForIntroRsp(ArrayList<IntroductoryGuildInfo> arrayList) {
        new ArrayList();
        this.introductoryGuildInfos = arrayList;
    }
}
