package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetGuildLabelRsp {
    public ArrayList<GProLabelInfo> labelInfos;
    public long maxAvNums;
    public long maxLabels;
    public String welcomeContent;

    public GProGetGuildLabelRsp() {
        this.welcomeContent = "";
        this.labelInfos = new ArrayList<>();
    }

    public ArrayList<GProLabelInfo> getLabelInfos() {
        return this.labelInfos;
    }

    public long getMaxAvNums() {
        return this.maxAvNums;
    }

    public long getMaxLabels() {
        return this.maxLabels;
    }

    public String getWelcomeContent() {
        return this.welcomeContent;
    }

    public String toString() {
        return "GProGetGuildLabelRsp{maxLabels=" + this.maxLabels + ",maxAvNums=" + this.maxAvNums + ",welcomeContent=" + this.welcomeContent + ",labelInfos=" + this.labelInfos + ",}";
    }

    public GProGetGuildLabelRsp(long j3, long j16, String str, ArrayList<GProLabelInfo> arrayList) {
        this.welcomeContent = "";
        new ArrayList();
        this.maxLabels = j3;
        this.maxAvNums = j16;
        this.welcomeContent = str;
        this.labelInfos = arrayList;
    }
}
