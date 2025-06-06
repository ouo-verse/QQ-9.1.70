package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileElement implements IKernelModel {
    public Long expireTime;
    public String file10MMd5;
    public Integer fileBizId;
    public Integer fileGroupIndex;
    public String fileMd5;
    public String fileName;
    public String filePath;
    public String fileSha;
    public String fileSha3;
    public long fileSize;
    public String fileSubId;
    public Integer fileTransType;
    public String fileUuid;
    public String folderId;
    public Integer invalidState;
    public Integer picHeight;
    public HashMap<Integer, String> picThumbPath;
    public Integer picWidth;
    public Integer progress;
    public int storeID;
    public Integer subElementType;
    public int thumbFileSize;
    public String thumbMd5;
    public Integer transferStatus;
    public Integer videoDuration;

    public FileElement() {
        this.fileMd5 = "";
        this.fileName = "";
        this.filePath = "";
        this.file10MMd5 = "";
        this.fileSha = "";
        this.fileSha3 = "";
        this.fileUuid = "";
        this.fileSubId = "";
    }

    public Long getExpireTime() {
        return this.expireTime;
    }

    public String getFile10MMd5() {
        return this.file10MMd5;
    }

    public Integer getFileBizId() {
        return this.fileBizId;
    }

    public Integer getFileGroupIndex() {
        return this.fileGroupIndex;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileSha() {
        return this.fileSha;
    }

    public String getFileSha3() {
        return this.fileSha3;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileSubId() {
        return this.fileSubId;
    }

    public Integer getFileTransType() {
        return this.fileTransType;
    }

    public String getFileUuid() {
        return this.fileUuid;
    }

    public String getFolderId() {
        return this.folderId;
    }

    public Integer getInvalidState() {
        return this.invalidState;
    }

    public Integer getPicHeight() {
        return this.picHeight;
    }

    public HashMap<Integer, String> getPicThumbPath() {
        return this.picThumbPath;
    }

    public Integer getPicWidth() {
        return this.picWidth;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public Integer getSubElementType() {
        return this.subElementType;
    }

    public int getThumbFileSize() {
        return this.thumbFileSize;
    }

    public String getThumbMd5() {
        return this.thumbMd5;
    }

    public Integer getTransferStatus() {
        return this.transferStatus;
    }

    public Integer getVideoDuration() {
        return this.videoDuration;
    }

    public void setExpireTime(Long l3) {
        this.expireTime = l3;
    }

    public void setFile10MMd5(String str) {
        this.file10MMd5 = str;
    }

    public void setFileBizId(Integer num) {
        this.fileBizId = num;
    }

    public void setFileGroupIndex(Integer num) {
        this.fileGroupIndex = num;
    }

    public void setFileMd5(String str) {
        this.fileMd5 = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSha(String str) {
        this.fileSha = str;
    }

    public void setFileSha3(String str) {
        this.fileSha3 = str;
    }

    public void setFileSize(long j3) {
        this.fileSize = j3;
    }

    public void setFileSubId(String str) {
        this.fileSubId = str;
    }

    public void setFileTransType(Integer num) {
        this.fileTransType = num;
    }

    public void setFileUuid(String str) {
        this.fileUuid = str;
    }

    public void setFolderId(String str) {
        this.folderId = str;
    }

    public void setInvalidState(Integer num) {
        this.invalidState = num;
    }

    public void setPicHeight(Integer num) {
        this.picHeight = num;
    }

    public void setPicThumbPath(HashMap<Integer, String> hashMap) {
        this.picThumbPath = hashMap;
    }

    public void setPicWidth(Integer num) {
        this.picWidth = num;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public void setStoreID(int i3) {
        this.storeID = i3;
    }

    public void setSubElementType(Integer num) {
        this.subElementType = num;
    }

    public void setThumbFileSize(int i3) {
        this.thumbFileSize = i3;
    }

    public void setThumbMd5(String str) {
        this.thumbMd5 = str;
    }

    public void setTransferStatus(Integer num) {
        this.transferStatus = num;
    }

    public void setVideoDuration(Integer num) {
        this.videoDuration = num;
    }

    public String toString() {
        return "FileElement{fileMd5=" + this.fileMd5 + ",fileName=" + this.fileName + ",filePath=" + this.filePath + ",fileSize=" + this.fileSize + ",picHeight=" + this.picHeight + ",picWidth=" + this.picWidth + ",picThumbPath=" + this.picThumbPath + ",expireTime=" + this.expireTime + ",file10MMd5=" + this.file10MMd5 + ",fileSha=" + this.fileSha + ",fileSha3=" + this.fileSha3 + ",videoDuration=" + this.videoDuration + ",transferStatus=" + this.transferStatus + ",progress=" + this.progress + ",invalidState=" + this.invalidState + ",fileUuid=" + this.fileUuid + ",fileSubId=" + this.fileSubId + ",thumbFileSize=" + this.thumbFileSize + ",fileBizId=" + this.fileBizId + ",thumbMd5=" + this.thumbMd5 + ",folderId=" + this.folderId + ",fileGroupIndex=" + this.fileGroupIndex + ",fileTransType=" + this.fileTransType + ",subElementType=" + this.subElementType + ",storeID=" + this.storeID + ",}";
    }

    public FileElement(String str, String str2, String str3, long j3, Integer num, Integer num2, HashMap<Integer, String> hashMap, Long l3, String str4, String str5, String str6, Integer num3, Integer num4, Integer num5, Integer num6, String str7, String str8, int i3, Integer num7, String str9, String str10, Integer num8, Integer num9, Integer num10, int i16) {
        this.fileMd5 = str;
        this.fileName = str2;
        this.filePath = str3;
        this.fileSize = j3;
        this.picHeight = num;
        this.picWidth = num2;
        this.picThumbPath = hashMap;
        this.expireTime = l3;
        this.file10MMd5 = str4;
        this.fileSha = str5;
        this.fileSha3 = str6;
        this.videoDuration = num3;
        this.transferStatus = num4;
        this.progress = num5;
        this.invalidState = num6;
        this.fileUuid = str7;
        this.fileSubId = str8;
        this.thumbFileSize = i3;
        this.fileBizId = num7;
        this.thumbMd5 = str9;
        this.folderId = str10;
        this.fileGroupIndex = num8;
        this.fileTransType = num9;
        this.subElementType = num10;
        this.storeID = i16;
    }
}
