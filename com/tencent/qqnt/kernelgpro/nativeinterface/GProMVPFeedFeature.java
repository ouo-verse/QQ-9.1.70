package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPFeedFeature {
    public int pornScore;
    public int qualityScore;
    public ArrayList<GProMVPTag> tags = new ArrayList<>();

    public int getPornScore() {
        return this.pornScore;
    }

    public int getQualityScore() {
        return this.qualityScore;
    }

    public ArrayList<GProMVPTag> getTags() {
        return this.tags;
    }

    public String toString() {
        return "GProMVPFeedFeature{pornScore=" + this.pornScore + ",qualityScore=" + this.qualityScore + ",tags=" + this.tags + ",}";
    }
}
