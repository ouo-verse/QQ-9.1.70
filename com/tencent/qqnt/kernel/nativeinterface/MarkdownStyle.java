package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MarkdownStyle {
    public int bubbleType;
    public String mainFontSize = "";
    public String layOut = "";

    public int getBubbleType() {
        return this.bubbleType;
    }

    public String getLayOut() {
        return this.layOut;
    }

    public String getMainFontSize() {
        return this.mainFontSize;
    }

    public String toString() {
        return "MarkdownStyle{mainFontSize=" + this.mainFontSize + ",layOut=" + this.layOut + ",bubbleType=" + this.bubbleType + ",}";
    }
}
