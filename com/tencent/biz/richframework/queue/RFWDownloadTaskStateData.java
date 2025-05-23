package com.tencent.biz.richframework.queue;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloadTaskStateData {
    private final String mBusinessKey;
    private long mDownloadedLength;
    private HashMap<String, String> mExtMap;
    private String mFilePath;
    private float mPercent;
    private DownloadState mState;
    private long mTaskGenerateTime = System.currentTimeMillis();
    private long mTotalLength;
    private final String mUrl;

    public RFWDownloadTaskStateData(String str, String str2) {
        this.mUrl = str2;
        this.mBusinessKey = str;
    }

    public String getBusinessKey() {
        return this.mBusinessKey;
    }

    public long getDownloadedLength() {
        return this.mDownloadedLength;
    }

    public HashMap<String, String> getExtMap() {
        return this.mExtMap;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public DownloadState getState() {
        return this.mState;
    }

    public long getTaskGenerateTime() {
        return this.mTaskGenerateTime;
    }

    public long getTotalLength() {
        return this.mTotalLength;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setDownloadedLength(long j3) {
        this.mDownloadedLength = j3;
    }

    public void setExtMap(HashMap<String, String> hashMap) {
        this.mExtMap = hashMap;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setPercent(float f16) {
        this.mPercent = f16;
    }

    public void setState(DownloadState downloadState) {
        this.mState = downloadState;
    }

    public void setTaskGenerateTime(long j3) {
        this.mTaskGenerateTime = j3;
    }

    public void setTotalLength(long j3) {
        this.mTotalLength = j3;
    }

    public String toString() {
        return "RFWDownloadTaskState{mUrl='" + this.mUrl + ", mBusinessKey='" + this.mBusinessKey + ", mState=" + this.mState + ", mFilePath='" + this.mFilePath + ", mPercent=" + this.mPercent + ", mDownloadedLength=" + this.mDownloadedLength + ", mTotalLength=" + this.mTotalLength + ", mTaskGenerateTime=" + this.mTaskGenerateTime + ", mExtMap=" + RFWDownloadQueueUtils.mapToString(this.mExtMap) + '}';
    }
}
