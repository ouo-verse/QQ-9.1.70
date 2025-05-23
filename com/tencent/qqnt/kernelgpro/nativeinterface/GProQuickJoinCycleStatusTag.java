package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProQuickJoinCycleStatusTag implements Serializable {
    public String highlightedText;
    public String iconUrl;
    long serialVersionUID;
    public String text;

    public GProQuickJoinCycleStatusTag() {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
        this.text = "";
        this.highlightedText = "";
    }

    public String getHighlightedText() {
        return this.highlightedText;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProQuickJoinCycleStatusTag{iconUrl=" + this.iconUrl + ",text=" + this.text + ",highlightedText=" + this.highlightedText + ",}";
    }

    public GProQuickJoinCycleStatusTag(String str, String str2, String str3) {
        this.serialVersionUID = 1L;
        this.iconUrl = str;
        this.text = str2;
        this.highlightedText = str3;
    }
}
