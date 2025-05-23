package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetAISearchShareURLRsp {
    public String shareIcon = "";
    public String anwserDescription = "";
    public String brandDescription = "";
    public String tailDescription = "";
    public String tailIcon = "";
    public String shareTitle = "";
    public String shareUrl = "";
    public String shareModelDescription = "";

    public String getAnwserDescription() {
        return this.anwserDescription;
    }

    public String getBrandDescription() {
        return this.brandDescription;
    }

    public String getShareIcon() {
        return this.shareIcon;
    }

    public String getShareModelDescription() {
        return this.shareModelDescription;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getTailDescription() {
        return this.tailDescription;
    }

    public String getTailIcon() {
        return this.tailIcon;
    }

    public String toString() {
        return "GProGetAISearchShareURLRsp{shareIcon=" + this.shareIcon + ",anwserDescription=" + this.anwserDescription + ",brandDescription=" + this.brandDescription + ",tailDescription=" + this.tailDescription + ",tailIcon=" + this.tailIcon + ",shareTitle=" + this.shareTitle + ",shareUrl=" + this.shareUrl + ",shareModelDescription=" + this.shareModelDescription + ",}";
    }
}
