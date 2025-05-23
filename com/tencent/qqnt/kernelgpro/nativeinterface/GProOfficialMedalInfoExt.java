package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProOfficialMedalInfoExt implements Serializable {
    public String iconUrl;
    public boolean isOffical;
    long serialVersionUID;

    public GProOfficialMedalInfoExt() {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public boolean getIsOffical() {
        return this.isOffical;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setIsOffical(boolean z16) {
        this.isOffical = z16;
    }

    public String toString() {
        return "GProOfficialMedalInfoExt{isOffical=" + this.isOffical + ",iconUrl=" + this.iconUrl + ",}";
    }

    public GProOfficialMedalInfoExt(boolean z16, String str) {
        this.serialVersionUID = 1L;
        this.isOffical = z16;
        this.iconUrl = str;
    }
}
