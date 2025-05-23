package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendExtInfo implements Serializable {
    long serialVersionUID;
    public String traceId;

    public GProRecommendExtInfo() {
        this.serialVersionUID = 1L;
        this.traceId = "";
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProRecommendExtInfo{traceId=" + this.traceId + ",}";
    }

    public GProRecommendExtInfo(String str) {
        this.serialVersionUID = 1L;
        this.traceId = str;
    }
}
