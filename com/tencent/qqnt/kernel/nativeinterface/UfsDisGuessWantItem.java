package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisGuessWantItem {
    public int type;
    public byte[] wordId = new byte[0];
    public String word = "";
    public String bytesExtension = "";
    public String reportData = "";
    public String url = "";

    public String getBytesExtension() {
        return this.bytesExtension;
    }

    public String getReportData() {
        return this.reportData;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWord() {
        return this.word;
    }

    public byte[] getWordId() {
        return this.wordId;
    }

    public String toString() {
        return "UfsDisGuessWantItem{wordId=" + this.wordId + ",word=" + this.word + ",bytesExtension=" + this.bytesExtension + ",reportData=" + this.reportData + ",type=" + this.type + JefsClass.INDEX_URL + this.url + ",}";
    }
}
