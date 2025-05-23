package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStSameTopicGuideInfo {
    public int isSameTopicGuide;
    public long stayShowTime;
    public String hashTag = "";
    public String words = "";
    public String jumpUrl = "";
    public String reportExt = "";

    public String getHashTag() {
        return this.hashTag;
    }

    public int getIsSameTopicGuide() {
        return this.isSameTopicGuide;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getReportExt() {
        return this.reportExt;
    }

    public long getStayShowTime() {
        return this.stayShowTime;
    }

    public String getWords() {
        return this.words;
    }

    public String toString() {
        return "GProStSameTopicGuideInfo{isSameTopicGuide=" + this.isSameTopicGuide + ",stayShowTime=" + this.stayShowTime + ",hashTag=" + this.hashTag + ",words=" + this.words + ",jumpUrl=" + this.jumpUrl + ",reportExt=" + this.reportExt + ",}";
    }
}
