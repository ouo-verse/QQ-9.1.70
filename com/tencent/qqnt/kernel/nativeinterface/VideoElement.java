package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class VideoElement implements IKernelModel {
    public int busiType;
    public Integer fileBizId;
    public int fileFormat;
    public String fileName;
    public String filePath;
    public long fileSize;
    public String fileSubId;
    public int fileTime;
    public String fileUuid;
    public byte[] importRichMediaContext;
    public Integer invalidState;
    public String originVideoMd5;
    public boolean original;
    public Integer progress;
    public VideoCodecFormatType sourceVideoCodecFormat;
    public int storeID;
    public int subBusiType;
    public int thumbHeight;
    public String thumbMd5;
    public HashMap<Integer, String> thumbPath;
    public int thumbSize;
    public int thumbWidth;
    public Integer transferStatus;
    public int videoFrom;
    public String videoMd5;

    public VideoElement() {
        this.filePath = "";
        this.fileName = "";
        this.videoMd5 = "";
        this.thumbMd5 = "";
        this.fileUuid = "";
        this.fileSubId = "";
        this.originVideoMd5 = "";
        this.sourceVideoCodecFormat = VideoCodecFormatType.values()[0];
    }

    public int getBusiType() {
        return this.busiType;
    }

    public Integer getFileBizId() {
        return this.fileBizId;
    }

    public int getFileFormat() {
        return this.fileFormat;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileSubId() {
        return this.fileSubId;
    }

    public int getFileTime() {
        return this.fileTime;
    }

    public String getFileUuid() {
        return this.fileUuid;
    }

    public byte[] getImportRichMediaContext() {
        return this.importRichMediaContext;
    }

    public Integer getInvalidState() {
        return this.invalidState;
    }

    public String getOriginVideoMd5() {
        return this.originVideoMd5;
    }

    public boolean getOriginal() {
        return this.original;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public VideoCodecFormatType getSourceVideoCodecFormat() {
        return this.sourceVideoCodecFormat;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public int getSubBusiType() {
        return this.subBusiType;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    public String getThumbMd5() {
        return this.thumbMd5;
    }

    public HashMap<Integer, String> getThumbPath() {
        return this.thumbPath;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public Integer getTransferStatus() {
        return this.transferStatus;
    }

    public int getVideoFrom() {
        return this.videoFrom;
    }

    public String getVideoMd5() {
        return this.videoMd5;
    }

    public void setBusiType(int i3) {
        this.busiType = i3;
    }

    public void setFileBizId(Integer num) {
        this.fileBizId = num;
    }

    public void setFileFormat(int i3) {
        this.fileFormat = i3;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(long j3) {
        this.fileSize = j3;
    }

    public void setFileSubId(String str) {
        this.fileSubId = str;
    }

    public void setFileTime(int i3) {
        this.fileTime = i3;
    }

    public void setFileUuid(String str) {
        this.fileUuid = str;
    }

    public void setImportRichMediaContext(byte[] bArr) {
        this.importRichMediaContext = bArr;
    }

    public void setInvalidState(Integer num) {
        this.invalidState = num;
    }

    public void setOriginVideoMd5(String str) {
        this.originVideoMd5 = str;
    }

    public void setOriginal(boolean z16) {
        this.original = z16;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public void setSourceVideoCodecFormat(VideoCodecFormatType videoCodecFormatType) {
        this.sourceVideoCodecFormat = videoCodecFormatType;
    }

    public void setStoreID(int i3) {
        this.storeID = i3;
    }

    public void setSubBusiType(int i3) {
        this.subBusiType = i3;
    }

    public void setThumbHeight(int i3) {
        this.thumbHeight = i3;
    }

    public void setThumbMd5(String str) {
        this.thumbMd5 = str;
    }

    public void setThumbPath(HashMap<Integer, String> hashMap) {
        this.thumbPath = hashMap;
    }

    public void setThumbSize(int i3) {
        this.thumbSize = i3;
    }

    public void setThumbWidth(int i3) {
        this.thumbWidth = i3;
    }

    public void setTransferStatus(Integer num) {
        this.transferStatus = num;
    }

    public void setVideoFrom(int i3) {
        this.videoFrom = i3;
    }

    public void setVideoMd5(String str) {
        this.videoMd5 = str;
    }

    public String toString() {
        return "VideoElement{filePath=" + this.filePath + ",fileName=" + this.fileName + ",videoMd5=" + this.videoMd5 + ",thumbMd5=" + this.thumbMd5 + ",fileTime=" + this.fileTime + ",thumbSize=" + this.thumbSize + ",fileFormat=" + this.fileFormat + ",fileSize=" + this.fileSize + ",thumbWidth=" + this.thumbWidth + ",thumbHeight=" + this.thumbHeight + ",busiType=" + this.busiType + ",subBusiType=" + this.subBusiType + ",thumbPath=" + this.thumbPath + ",transferStatus=" + this.transferStatus + ",progress=" + this.progress + ",invalidState=" + this.invalidState + ",fileUuid=" + this.fileUuid + ",fileSubId=" + this.fileSubId + ",fileBizId=" + this.fileBizId + ",originVideoMd5=" + this.originVideoMd5 + ",importRichMediaContext=" + this.importRichMediaContext + ",sourceVideoCodecFormat=" + this.sourceVideoCodecFormat + ",storeID=" + this.storeID + ",original=" + this.original + ",videoFrom=" + this.videoFrom + ",}";
    }

    public VideoElement(String str, String str2, String str3, String str4, int i3, int i16, int i17, long j3, int i18, int i19, int i26, int i27, HashMap<Integer, String> hashMap, Integer num, Integer num2, Integer num3, String str5, String str6, Integer num4, String str7, byte[] bArr, VideoCodecFormatType videoCodecFormatType, int i28) {
        this.filePath = "";
        this.fileName = "";
        this.videoMd5 = "";
        this.thumbMd5 = "";
        this.fileUuid = "";
        this.fileSubId = "";
        this.originVideoMd5 = "";
        VideoCodecFormatType videoCodecFormatType2 = VideoCodecFormatType.values()[0];
        this.filePath = str;
        this.fileName = str2;
        this.videoMd5 = str3;
        this.thumbMd5 = str4;
        this.fileTime = i3;
        this.thumbSize = i16;
        this.fileFormat = i17;
        this.fileSize = j3;
        this.thumbWidth = i18;
        this.thumbHeight = i19;
        this.busiType = i26;
        this.subBusiType = i27;
        this.thumbPath = hashMap;
        this.transferStatus = num;
        this.progress = num2;
        this.invalidState = num3;
        this.fileUuid = str5;
        this.fileSubId = str6;
        this.fileBizId = num4;
        this.originVideoMd5 = str7;
        this.importRichMediaContext = bArr;
        this.sourceVideoCodecFormat = videoCodecFormatType;
        this.storeID = i28;
    }
}
