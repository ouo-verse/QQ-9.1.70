package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsExtensionNetSugWordsInfo {
    public byte[] suggestWord = new byte[0];
    public byte[] reportData = new byte[0];
    public byte[] jumpUrl = new byte[0];

    public byte[] getJumpUrl() {
        return this.jumpUrl;
    }

    public byte[] getReportData() {
        return this.reportData;
    }

    public byte[] getSuggestWord() {
        return this.suggestWord;
    }

    public String toString() {
        return "UfsExtensionNetSugWordsInfo{suggestWord=" + this.suggestWord + ",reportData=" + this.reportData + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
