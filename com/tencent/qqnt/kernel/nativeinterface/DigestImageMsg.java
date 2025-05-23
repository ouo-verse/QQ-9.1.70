package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DigestImageMsg {
    public int fileId;
    public int fileSize;
    public int height;
    public int imgType;
    public int serverIP;
    public int serverPort;
    public int width;
    public String md5 = "";
    public String uuid = "";
    public String strFilePath = "";
    public String thumbUrl = "";
    public String originalUrl = "";
    public String resaveUrl = "";

    public int getFileId() {
        return this.fileId;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public int getHeight() {
        return this.height;
    }

    public int getImgType() {
        return this.imgType;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public String getResaveUrl() {
        return this.resaveUrl;
    }

    public int getServerIP() {
        return this.serverIP;
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public String getStrFilePath() {
        return this.strFilePath;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "DigestImageMsg{md5=" + this.md5 + ",uuid=" + this.uuid + ",imgType=" + this.imgType + ",fileSize=" + this.fileSize + ",width=" + this.width + ",height=" + this.height + ",fileId=" + this.fileId + ",serverIP=" + this.serverIP + ",serverPort=" + this.serverPort + ",strFilePath=" + this.strFilePath + ",thumbUrl=" + this.thumbUrl + ",originalUrl=" + this.originalUrl + ",resaveUrl=" + this.resaveUrl + ",}";
    }
}
