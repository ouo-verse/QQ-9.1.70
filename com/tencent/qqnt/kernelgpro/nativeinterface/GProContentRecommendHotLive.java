package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentRecommendHotLive implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProHotLiveCard> hotLives = new ArrayList<>();

    public ArrayList<GProHotLiveCard> getHotLives() {
        return this.hotLives;
    }

    public String toString() {
        return "GProContentRecommendHotLive{hotLives=" + this.hotLives + ",}";
    }
}
