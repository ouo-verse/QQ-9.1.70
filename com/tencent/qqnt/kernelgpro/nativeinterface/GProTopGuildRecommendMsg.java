package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTopGuildRecommendMsg implements Serializable {
    public GProRecommendItem recommendItem;
    long serialVersionUID;

    public GProTopGuildRecommendMsg() {
        this.serialVersionUID = 1L;
        this.recommendItem = new GProRecommendItem();
    }

    public GProRecommendItem getRecommendItem() {
        return this.recommendItem;
    }

    public String toString() {
        return "GProTopGuildRecommendMsg{recommendItem=" + this.recommendItem + ",}";
    }

    public GProTopGuildRecommendMsg(GProRecommendItem gProRecommendItem) {
        this.serialVersionUID = 1L;
        new GProRecommendItem();
        this.recommendItem = gProRecommendItem;
    }
}
