package com.qzone.reborn.intimate.config.download;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "mUin,mUrl")
/* loaded from: classes37.dex */
public class QZoneIntimateDownloadDbTaskState extends Entity implements Serializable, Cloneable {
    private static final String TAG = "QZoneIntimateDownloadTaskState";
    public String mBusinessKey;
    public long mDownloadedLength;
    public String mExtMapJson;
    public String mFilePath;
    public float mPercent;
    public int mState;
    public long mTaskGenerateTime;
    public long mTotalLength;
    public String mUin;
    public String mUrl;

    public String getBusinessKey() {
        return this.mBusinessKey;
    }

    public long getDownloadedLength() {
        return this.mDownloadedLength;
    }

    public String getExtMapJson() {
        return this.mExtMapJson;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getState() {
        return this.mState;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return "QZoneIntimateDownloadTaskStatev1";
    }

    public long getTaskGenerateTime() {
        return this.mTaskGenerateTime;
    }

    public long getTotalLength() {
        return this.mTotalLength;
    }

    public String getUin() {
        return this.mUin;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setBusinessKey(String str) {
        this.mBusinessKey = str;
    }

    public void setDownloadedLength(long j3) {
        this.mDownloadedLength = j3;
    }

    public void setExtMapJson(String str) {
        this.mExtMapJson = str;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setPercent(float f16) {
        this.mPercent = f16;
    }

    public void setState(int i3) {
        this.mState = i3;
    }

    public void setTaskGenerateTime(long j3) {
        this.mTaskGenerateTime = j3;
    }

    public void setTotalLength(long j3) {
        this.mTotalLength = j3;
    }

    public void setUin(String str) {
        this.mUin = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String toString() {
        return "QZoneIntimateDownloadTaskState{mUin='" + this.mUin + "', mUrl='" + this.mUrl + "', mBusinessKey='" + this.mBusinessKey + "', mState=" + this.mState + ", mFilePath='" + this.mFilePath + "', mPercent=" + this.mPercent + ", mDownloadedLength=" + this.mDownloadedLength + ", mTotalLength=" + this.mTotalLength + ", mTaskGenerateTime=" + this.mTaskGenerateTime + ", mExtMapJson=" + this.mExtMapJson + '}';
    }
}
