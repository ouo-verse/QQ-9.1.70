package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPersonalSignatureTemplate {
    public String avatarUrl;
    public String sampleText;

    public GProPersonalSignatureTemplate() {
        this.avatarUrl = "";
        this.sampleText = "";
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getSampleText() {
        return this.sampleText;
    }

    public String toString() {
        return "GProPersonalSignatureTemplate{avatarUrl=" + this.avatarUrl + ",sampleText=" + this.sampleText + ",}";
    }

    public GProPersonalSignatureTemplate(String str, String str2) {
        this.avatarUrl = str;
        this.sampleText = str2;
    }
}
