package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildAdvFeedAdvInfo {
    public long adFirstCategory;
    public long adSecondCategory;
    public long advertiserId;
    public long aid;
    public int creativeTemplateId;
    public float durationScore;
    public float ecpm;
    public float etr;
    public long fingerprintProduct;
    public long fingerprintTid;
    public boolean isContractAd;
    public boolean isPreviewAd;
    public float pctr;
    public int productType;
    public String advertiserGroupName = "";
    public String traceId = "";
    public ArrayList<Integer> adExtensionTypeList = new ArrayList<>();
    public GProGuildAdvFeedFeatureDataGroup featureDataGroup = new GProGuildAdvFeedFeatureDataGroup();
    public byte[] transInfo = new byte[0];

    public ArrayList<Integer> getAdExtensionTypeList() {
        return this.adExtensionTypeList;
    }

    public long getAdFirstCategory() {
        return this.adFirstCategory;
    }

    public long getAdSecondCategory() {
        return this.adSecondCategory;
    }

    public String getAdvertiserGroupName() {
        return this.advertiserGroupName;
    }

    public long getAdvertiserId() {
        return this.advertiserId;
    }

    public long getAid() {
        return this.aid;
    }

    public int getCreativeTemplateId() {
        return this.creativeTemplateId;
    }

    public float getDurationScore() {
        return this.durationScore;
    }

    public float getEcpm() {
        return this.ecpm;
    }

    public float getEtr() {
        return this.etr;
    }

    public GProGuildAdvFeedFeatureDataGroup getFeatureDataGroup() {
        return this.featureDataGroup;
    }

    public long getFingerprintProduct() {
        return this.fingerprintProduct;
    }

    public long getFingerprintTid() {
        return this.fingerprintTid;
    }

    public boolean getIsContractAd() {
        return this.isContractAd;
    }

    public boolean getIsPreviewAd() {
        return this.isPreviewAd;
    }

    public float getPctr() {
        return this.pctr;
    }

    public int getProductType() {
        return this.productType;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public byte[] getTransInfo() {
        return this.transInfo;
    }

    public String toString() {
        return "GProGuildAdvFeedAdvInfo{aid=" + this.aid + ",productType=" + this.productType + ",ecpm=" + this.ecpm + ",advertiserGroupName=" + this.advertiserGroupName + ",adFirstCategory=" + this.adFirstCategory + ",adSecondCategory=" + this.adSecondCategory + ",traceId=" + this.traceId + ",pctr=" + this.pctr + ",etr=" + this.etr + ",durationScore=" + this.durationScore + ",isPreviewAd=" + this.isPreviewAd + ",adExtensionTypeList=" + this.adExtensionTypeList + ",advertiserId=" + this.advertiserId + ",creativeTemplateId=" + this.creativeTemplateId + ",fingerprintProduct=" + this.fingerprintProduct + ",fingerprintTid=" + this.fingerprintTid + ",featureDataGroup=" + this.featureDataGroup + ",transInfo=" + this.transInfo + ",isContractAd=" + this.isContractAd + ",}";
    }
}
