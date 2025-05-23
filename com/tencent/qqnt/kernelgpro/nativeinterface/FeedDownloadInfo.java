package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FeedDownloadInfo {
    public FeedFileType downloadType;
    public int errorCode;
    public String errorMsg;
    public String feedId;
    public String fileId;
    public String fileName;
    public int levelType;
    public long progress;
    public String savePath;
    public String subId;
    public String url;

    public FeedDownloadInfo() {
        this.errorMsg = "";
        this.feedId = "";
        this.subId = "";
        this.fileId = "";
        this.downloadType = FeedFileType.values()[0];
        this.fileName = "";
        this.url = "";
        this.savePath = "";
    }

    public FeedFileType getDownloadType() {
        return this.downloadType;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLevelType() {
        return this.levelType;
    }

    public long getProgress() {
        return this.progress;
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
        return "FeedDownloadInfo{errorCode=" + this.errorCode + ",errorMsg=" + this.errorMsg + ",progress=" + this.progress + ",feedId=" + this.feedId + ",subId=" + this.subId + ",fileId=" + this.fileId + ",downloadType=" + this.downloadType + ",fileName=" + this.fileName + ",levelType=" + this.levelType + JefsClass.INDEX_URL + this.url + ",savePath=" + this.savePath + ",}";
    }

    public FeedDownloadInfo(int i3, String str, long j3, String str2, String str3, String str4, FeedFileType feedFileType, String str5, int i16, String str6, String str7) {
        this.errorMsg = "";
        this.feedId = "";
        this.subId = "";
        this.fileId = "";
        FeedFileType feedFileType2 = FeedFileType.values()[0];
        this.errorCode = i3;
        this.errorMsg = str;
        this.progress = j3;
        this.feedId = str2;
        this.subId = str3;
        this.fileId = str4;
        this.downloadType = feedFileType;
        this.fileName = str5;
        this.levelType = i16;
        this.url = str6;
        this.savePath = str7;
    }
}
