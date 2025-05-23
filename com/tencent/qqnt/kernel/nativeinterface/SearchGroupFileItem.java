package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGroupFileItem {
    public int busId;
    public int deadTime;
    public int downloadTimes;
    public String fileId;
    public long fileModelId;
    public String fileName;
    public ArrayList<SearchHitInfo> fileNameHits;
    public long fileSize;
    public long groupCode;
    public String groupName;
    public String localPath;
    public long matchUin;
    public ArrayList<String> matchWords;
    public int modifyTime;
    public int uploadTime;
    public String uploaderName;
    public long uploaderUin;

    public SearchGroupFileItem() {
        this.groupName = "";
        this.uploaderName = "";
        this.matchWords = new ArrayList<>();
        this.fileNameHits = new ArrayList<>();
        this.fileId = "";
        this.fileName = "";
        this.localPath = "";
    }

    public int getBusId() {
        return this.busId;
    }

    public int getDeadTime() {
        return this.deadTime;
    }

    public int getDownloadTimes() {
        return this.downloadTimes;
    }

    public String getFileId() {
        return this.fileId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public ArrayList<SearchHitInfo> getFileNameHits() {
        return this.fileNameHits;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public long getMatchUin() {
        return this.matchUin;
    }

    public ArrayList<String> getMatchWords() {
        return this.matchWords;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public int getUploadTime() {
        return this.uploadTime;
    }

    public String getUploaderName() {
        return this.uploaderName;
    }

    public long getUploaderUin() {
        return this.uploaderUin;
    }

    public SearchGroupFileItem(long j3, String str, long j16, String str2, long j17, ArrayList<String> arrayList, ArrayList<SearchHitInfo> arrayList2, long j18, String str3, String str4, long j19, int i3, int i16, int i17, int i18, int i19, String str5) {
        this.groupName = "";
        this.uploaderName = "";
        this.matchWords = new ArrayList<>();
        new ArrayList();
        this.groupCode = j3;
        this.groupName = str;
        this.uploaderUin = j16;
        this.uploaderName = str2;
        this.matchUin = j17;
        this.matchWords = arrayList;
        this.fileNameHits = arrayList2;
        this.fileModelId = j18;
        this.fileId = str3;
        this.fileName = str4;
        this.fileSize = j19;
        this.busId = i3;
        this.uploadTime = i16;
        this.modifyTime = i17;
        this.deadTime = i18;
        this.downloadTimes = i19;
        this.localPath = str5;
    }
}
