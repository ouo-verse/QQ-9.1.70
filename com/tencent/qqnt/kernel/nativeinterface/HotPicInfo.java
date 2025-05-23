package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class HotPicInfo {
    public String downloadUrl;
    public int fileHeight;
    public String fileMd5;
    public long fileSize;
    public int fileType;
    public int fileWidth;
    public boolean isExist;
    public String path;
    public String picId;
    public int picIndex;
    public int sourceType;
    public ThirdPartyInfo thirdPartyInfo;
    public String thumbDownloadUrl;
    public int thumbFileHeight;
    public long thumbFileSize;
    public int thumbFileWidth;
    public String thumbMd5;

    public HotPicInfo() {
        this.picId = "";
        this.fileMd5 = "";
        this.downloadUrl = "";
        this.thumbMd5 = "";
        this.thumbDownloadUrl = "";
        this.thirdPartyInfo = new ThirdPartyInfo();
        this.path = "";
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getFileHeight() {
        return this.fileHeight;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getFileType() {
        return this.fileType;
    }

    public int getFileWidth() {
        return this.fileWidth;
    }

    public boolean getIsExist() {
        return this.isExist;
    }

    public String getPath() {
        return this.path;
    }

    public String getPicId() {
        return this.picId;
    }

    public int getPicIndex() {
        return this.picIndex;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public ThirdPartyInfo getThirdPartyInfo() {
        return this.thirdPartyInfo;
    }

    public String getThumbDownloadUrl() {
        return this.thumbDownloadUrl;
    }

    public int getThumbFileHeight() {
        return this.thumbFileHeight;
    }

    public long getThumbFileSize() {
        return this.thumbFileSize;
    }

    public int getThumbFileWidth() {
        return this.thumbFileWidth;
    }

    public String getThumbMd5() {
        return this.thumbMd5;
    }

    public String toString() {
        return "HotPicInfo{picId=" + this.picId + ",fileMd5=" + this.fileMd5 + ",fileType=" + this.fileType + ",fileSize=" + this.fileSize + ",fileWidth=" + this.fileWidth + ",fileHeight=" + this.fileHeight + ",downloadUrl=" + this.downloadUrl + ",thumbMd5=" + this.thumbMd5 + ",thumbFileSize=" + this.thumbFileSize + ",thumbFileWidth=" + this.thumbFileWidth + ",thumbFileHeight=" + this.thumbFileHeight + ",thumbDownloadUrl=" + this.thumbDownloadUrl + ",picIndex=" + this.picIndex + ",sourceType=" + this.sourceType + ",thirdPartyInfo=" + this.thirdPartyInfo + ",path=" + this.path + ",isExist=" + this.isExist + ",}";
    }

    public HotPicInfo(String str, String str2, int i3, long j3, int i16, int i17, String str3, String str4, long j16, int i18, int i19, String str5, int i26, int i27, ThirdPartyInfo thirdPartyInfo, String str6, boolean z16) {
        this.picId = "";
        this.fileMd5 = "";
        this.downloadUrl = "";
        this.thumbMd5 = "";
        this.thumbDownloadUrl = "";
        new ThirdPartyInfo();
        this.picId = str;
        this.fileMd5 = str2;
        this.fileType = i3;
        this.fileSize = j3;
        this.fileWidth = i16;
        this.fileHeight = i17;
        this.downloadUrl = str3;
        this.thumbMd5 = str4;
        this.thumbFileSize = j16;
        this.thumbFileWidth = i18;
        this.thumbFileHeight = i19;
        this.thumbDownloadUrl = str5;
        this.picIndex = i26;
        this.sourceType = i27;
        this.thirdPartyInfo = thirdPartyInfo;
        this.path = str6;
        this.isExist = z16;
    }
}
