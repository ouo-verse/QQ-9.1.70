package com.tencent.qqlive.tvkplayer.api;

/* loaded from: classes23.dex */
public class TVKDownloadProgressInfo {
    private long mAvailablePositionMs;
    private long mDownloadBytes;
    private long mDownloadSpeedbps;
    private String mExtraInfo;
    private long mFileTotalBytes;

    public long getAvailablePositionMs() {
        return this.mAvailablePositionMs;
    }

    public long getDownloadBytes() {
        return this.mDownloadBytes;
    }

    public long getDownloadSpeedbps() {
        return this.mDownloadSpeedbps;
    }

    public String getExtraInfo() {
        return this.mExtraInfo;
    }

    public long getFileTotalBytes() {
        return this.mFileTotalBytes;
    }

    public void setAvailablePositionMs(long j3) {
        this.mAvailablePositionMs = j3;
    }

    public void setDownloadBytes(long j3) {
        this.mDownloadBytes = j3;
    }

    public void setDownloadSpeedbps(long j3) {
        this.mDownloadSpeedbps = j3;
    }

    public void setExtraInfo(String str) {
        this.mExtraInfo = str;
    }

    public void setFileTotalBytes(long j3) {
        this.mFileTotalBytes = j3;
    }

    public String toString() {
        return "TVKDownloadProgressInfo, downloadSpeedbps:" + this.mDownloadSpeedbps + ", availablePositionMs:" + this.mAvailablePositionMs + ", downloadBytes:" + this.mDownloadBytes + ", fileTotalBytes:" + this.mFileTotalBytes + ", extraInfo:" + this.mExtraInfo;
    }
}
