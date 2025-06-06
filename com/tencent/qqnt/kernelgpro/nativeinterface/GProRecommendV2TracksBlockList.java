package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendV2TracksBlockList implements Serializable {
    public String blockName;
    public ArrayList<GProRecommendV2Channel> channelList;
    long serialVersionUID;

    public GProRecommendV2TracksBlockList() {
        this.serialVersionUID = 1L;
        this.blockName = "";
        this.channelList = new ArrayList<>();
    }

    public String getBlockName() {
        return this.blockName;
    }

    public ArrayList<GProRecommendV2Channel> getChannelList() {
        return this.channelList;
    }

    public String toString() {
        return "GProRecommendV2TracksBlockList{blockName=" + this.blockName + ",channelList=" + this.channelList + ",}";
    }

    public GProRecommendV2TracksBlockList(String str, ArrayList<GProRecommendV2Channel> arrayList) {
        this.serialVersionUID = 1L;
        this.blockName = "";
        new ArrayList();
        this.blockName = str;
        this.channelList = arrayList;
    }
}
