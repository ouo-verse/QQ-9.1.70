package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FeedRichMediaDownloadReq {
    public String feedId;
    public Integer feedsType;
    public String fileId;
    public FeedFileType fileType;
    public Integer levelType;
    public String savePath;
    public String subId;
    public String url;

    public FeedRichMediaDownloadReq() {
        this.feedId = "";
        this.fileId = "";
        this.fileType = FeedFileType.values()[0];
        this.savePath = "";
        this.url = "";
    }

    public String getFeedId() {
        return this.feedId;
    }

    public Integer getFeedsType() {
        return this.feedsType;
    }

    public String getFileId() {
        return this.fileId;
    }

    public FeedFileType getFileType() {
        return this.fileType;
    }

    public Integer getLevelType() {
        return this.levelType;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getSubId() {
        return this.subId;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "FeedRichMediaDownloadReq{feedId=" + this.feedId + ",subId=" + this.subId + ",fileId=" + this.fileId + ",fileType=" + this.fileType + ",levelType=" + this.levelType + ",savePath=" + this.savePath + ",feedsType=" + this.feedsType + JefsClass.INDEX_URL + this.url + ",}";
    }

    public FeedRichMediaDownloadReq(String str, String str2, String str3, FeedFileType feedFileType, Integer num, String str4, Integer num2, String str5) {
        this.feedId = "";
        this.fileId = "";
        FeedFileType feedFileType2 = FeedFileType.values()[0];
        this.feedId = str;
        this.subId = str2;
        this.fileId = str3;
        this.fileType = feedFileType;
        this.levelType = num;
        this.savePath = str4;
        this.feedsType = num2;
        this.url = str5;
    }
}
