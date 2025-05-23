package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRecommendCardPosAdvertise {
    public int adContentType;
    public long adId;
    public int adType;
    public int providerId;
    public int providerPriority;
    public String traceId = "";
    public String traceInfo = "";
    public byte[] adContent = new byte[0];
    public byte[] transInfo = new byte[0];
    public String bidPrice = "";
    public String qualityScore = "";
    public String extInfo = "";

    public byte[] getAdContent() {
        return this.adContent;
    }

    public int getAdContentType() {
        return this.adContentType;
    }

    public long getAdId() {
        return this.adId;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getBidPrice() {
        return this.bidPrice;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public int getProviderId() {
        return this.providerId;
    }

    public int getProviderPriority() {
        return this.providerPriority;
    }

    public String getQualityScore() {
        return this.qualityScore;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getTraceInfo() {
        return this.traceInfo;
    }

    public byte[] getTransInfo() {
        return this.transInfo;
    }

    public String toString() {
        return "GProRecommendCardPosAdvertise{adId=" + this.adId + ",adType=" + this.adType + ",traceId=" + this.traceId + ",traceInfo=" + this.traceInfo + ",adContent=" + this.adContent + ",transInfo=" + this.transInfo + ",providerId=" + this.providerId + ",bidPrice=" + this.bidPrice + ",qualityScore=" + this.qualityScore + ",providerPriority=" + this.providerPriority + ",extInfo=" + this.extInfo + ",adContentType=" + this.adContentType + ",}";
    }
}
