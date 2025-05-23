package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildAdvFeedFeatureDataGroup {
    public GProGuildAdvFeedFeatureDataBuffer adFeatureData = new GProGuildAdvFeedFeatureDataBuffer();
    public GProGuildAdvFeedFeatureDataBuffer creativeFeatureData = new GProGuildAdvFeedFeatureDataBuffer();
    public ArrayList<GProGuildAdvFeedFeatureDataBuffer> materialFeatureDataList = new ArrayList<>();

    public GProGuildAdvFeedFeatureDataBuffer getAdFeatureData() {
        return this.adFeatureData;
    }

    public GProGuildAdvFeedFeatureDataBuffer getCreativeFeatureData() {
        return this.creativeFeatureData;
    }

    public ArrayList<GProGuildAdvFeedFeatureDataBuffer> getMaterialFeatureDataList() {
        return this.materialFeatureDataList;
    }

    public String toString() {
        return "GProGuildAdvFeedFeatureDataGroup{adFeatureData=" + this.adFeatureData + ",creativeFeatureData=" + this.creativeFeatureData + ",materialFeatureDataList=" + this.materialFeatureDataList + ",}";
    }
}
