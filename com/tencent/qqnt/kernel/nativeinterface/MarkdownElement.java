package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MarkdownElement {
    public String content;
    public MarkdownElementExtInfo mdExtInfo;
    public int mdExtType;
    public String mdSummary;
    public String processMsg;
    public MarkdownStyle style;

    public MarkdownElement() {
        this.content = "";
        this.processMsg = "";
        this.mdSummary = "";
    }

    public String getContent() {
        return this.content;
    }

    public MarkdownElementExtInfo getMdExtInfo() {
        return this.mdExtInfo;
    }

    public int getMdExtType() {
        return this.mdExtType;
    }

    public String getMdSummary() {
        return this.mdSummary;
    }

    public String getProcessMsg() {
        return this.processMsg;
    }

    public MarkdownStyle getStyle() {
        return this.style;
    }

    public String toString() {
        return "MarkdownElement{content=" + this.content + ",style=" + this.style + ",processMsg=" + this.processMsg + ",mdSummary=" + this.mdSummary + ",mdExtType=" + this.mdExtType + ",mdExtInfo=" + this.mdExtInfo + ",}";
    }

    public MarkdownElement(String str, String str2, int i3, MarkdownElementExtInfo markdownElementExtInfo) {
        this.processMsg = "";
        this.content = str;
        this.mdSummary = str2;
        this.mdExtType = i3;
        this.mdExtInfo = markdownElementExtInfo;
    }
}
