package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ShareInfo implements Serializable {
    long serialVersionUID = 1;
    public String shareLink = "";
    public String extractionCode = "";

    public String getExtractionCode() {
        return this.extractionCode;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public void setExtractionCode(String str) {
        this.extractionCode = str;
    }

    public void setShareLink(String str) {
        this.shareLink = str;
    }
}
