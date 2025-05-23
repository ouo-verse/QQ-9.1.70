package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UserDownloadOperationInfo {
    public String fileSetId = "";
    public ArrayList<String> allFileList = new ArrayList<>();
    public ArrayList<String> safeBeatFileList = new ArrayList<>();
    public ArrayList<String> safePendingFileList = new ArrayList<>();
    public ArrayList<String> uploadFailedFileList = new ArrayList<>();
    public ArrayList<String> downloadRunningFileList = new ArrayList<>();

    public ArrayList<String> getAllFileList() {
        return this.allFileList;
    }

    public ArrayList<String> getDownloadRunningFileList() {
        return this.downloadRunningFileList;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public ArrayList<String> getSafeBeatFileList() {
        return this.safeBeatFileList;
    }

    public ArrayList<String> getSafePendingFileList() {
        return this.safePendingFileList;
    }

    public ArrayList<String> getUploadFailedFileList() {
        return this.uploadFailedFileList;
    }
}
