package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class MarkdownParseReq {
    public int markdownReqType;
    public String markdownText = "";

    public int getMarkdownReqType() {
        return this.markdownReqType;
    }

    public String getMarkdownText() {
        return this.markdownText;
    }

    public String toString() {
        return "MarkdownParseReq{markdownReqType=" + this.markdownReqType + ",markdownText=" + this.markdownText + ",}";
    }
}
