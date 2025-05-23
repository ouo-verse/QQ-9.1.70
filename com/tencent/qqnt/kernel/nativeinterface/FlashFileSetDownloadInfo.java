package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FlashFileSetDownloadInfo {
    public boolean allWaitingStatusTask;
    public int avgSpeedBps;
    public int curDownLoadFailFileNum;
    public long curDownLoadedBytes;
    public int curDownLoadedFileNum;
    public int curDownLoadedPauseFileNum;
    public int curDownloadingFileNum;
    public int curSpeedBps;
    public boolean hasNormalFileDownloading;
    public boolean isAllFileAlreadyDownloaded;
    public int maxSpeedBps;
    public boolean onlyCompressInnerFileDownloading;
    public int remainDownLoadSeconds;
    public long totalDownLoadedBytes;
    public int totalDownLoadedFileNum;
    public ArrayList<String> failFileIdList = new ArrayList<>();
    public ArrayList<String> allFileIdList = new ArrayList<>();
    public String saveFileSetDir = "";

    public ArrayList<String> getAllFileIdList() {
        return this.allFileIdList;
    }

    public boolean getAllWaitingStatusTask() {
        return this.allWaitingStatusTask;
    }

    public int getAvgSpeedBps() {
        return this.avgSpeedBps;
    }

    public int getCurDownLoadFailFileNum() {
        return this.curDownLoadFailFileNum;
    }

    public long getCurDownLoadedBytes() {
        return this.curDownLoadedBytes;
    }

    public int getCurDownLoadedFileNum() {
        return this.curDownLoadedFileNum;
    }

    public int getCurDownLoadedPauseFileNum() {
        return this.curDownLoadedPauseFileNum;
    }

    public int getCurDownloadingFileNum() {
        return this.curDownloadingFileNum;
    }

    public int getCurSpeedBps() {
        return this.curSpeedBps;
    }

    public ArrayList<String> getFailFileIdList() {
        return this.failFileIdList;
    }

    public boolean getHasNormalFileDownloading() {
        return this.hasNormalFileDownloading;
    }

    public boolean getIsAllFileAlreadyDownloaded() {
        return this.isAllFileAlreadyDownloaded;
    }

    public int getMaxSpeedBps() {
        return this.maxSpeedBps;
    }

    public boolean getOnlyCompressInnerFileDownloading() {
        return this.onlyCompressInnerFileDownloading;
    }

    public int getRemainDownLoadSeconds() {
        return this.remainDownLoadSeconds;
    }

    public String getSaveFileSetDir() {
        return this.saveFileSetDir;
    }

    public long getTotalDownLoadedBytes() {
        return this.totalDownLoadedBytes;
    }

    public int getTotalDownLoadedFileNum() {
        return this.totalDownLoadedFileNum;
    }
}
