package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GproGuildSpeakableRule {
    public Boolean isProhibitDatingFeed;
    public Boolean isProhibitSuspectedRiskFeed;
    public Boolean isProhibiteAdvertise;
    public Boolean isProhibiteLink;
    public Boolean isProhibiteQrCodePicture;
    public Boolean isProhibiteRedEnvelope;
    public ArrayList<String> prohibiteWords;

    public GproGuildSpeakableRule() {
    }

    public Boolean getIsProhibitDatingFeed() {
        return this.isProhibitDatingFeed;
    }

    public Boolean getIsProhibitSuspectedRiskFeed() {
        return this.isProhibitSuspectedRiskFeed;
    }

    public Boolean getIsProhibiteAdvertise() {
        return this.isProhibiteAdvertise;
    }

    public Boolean getIsProhibiteLink() {
        return this.isProhibiteLink;
    }

    public Boolean getIsProhibiteQrCodePicture() {
        return this.isProhibiteQrCodePicture;
    }

    public Boolean getIsProhibiteRedEnvelope() {
        return this.isProhibiteRedEnvelope;
    }

    public ArrayList<String> getProhibiteWords() {
        return this.prohibiteWords;
    }

    public String toString() {
        return "GproGuildSpeakableRule{isProhibiteRedEnvelope=" + this.isProhibiteRedEnvelope + ",isProhibiteLink=" + this.isProhibiteLink + ",isProhibiteQrCodePicture=" + this.isProhibiteQrCodePicture + ",isProhibiteAdvertise=" + this.isProhibiteAdvertise + ",prohibiteWords=" + this.prohibiteWords + ",isProhibitSuspectedRiskFeed=" + this.isProhibitSuspectedRiskFeed + ",isProhibitDatingFeed=" + this.isProhibitDatingFeed + ",}";
    }

    public GproGuildSpeakableRule(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, ArrayList<String> arrayList) {
        this.isProhibiteRedEnvelope = bool;
        this.isProhibiteLink = bool2;
        this.isProhibiteQrCodePicture = bool3;
        this.isProhibiteAdvertise = bool4;
        this.prohibiteWords = arrayList;
    }
}
