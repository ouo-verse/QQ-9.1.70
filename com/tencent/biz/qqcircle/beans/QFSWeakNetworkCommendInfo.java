package com.tencent.biz.qqcircle.beans;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSWeakNetworkCommendInfo {
    private int mCost;
    private int mEndNetType;
    private String mMethod;
    private long mReqTimeVal;
    private long mRspTime;
    private int mStartNetType;
    private String mTraceId;
    private String mUin;
    private String mVersion;
    private int mWeakNetType;

    public int getCost() {
        return this.mCost;
    }

    public int getEndNetType() {
        return this.mEndNetType;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public long getReqTimeVal() {
        return this.mReqTimeVal;
    }

    public long getRspTime() {
        return this.mRspTime;
    }

    public int getStartNetType() {
        return this.mStartNetType;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public String getUin() {
        return this.mUin;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public int getWeakNetType() {
        return this.mWeakNetType;
    }

    public void setCost(int i3) {
        this.mCost = i3;
    }

    public void setEndNetType(int i3) {
        this.mEndNetType = i3;
    }

    public void setMethod(String str) {
        this.mMethod = str;
    }

    public void setReqTimeVal(long j3) {
        this.mReqTimeVal = j3;
    }

    public void setRspTime(long j3) {
        this.mRspTime = j3;
    }

    public void setStartNetType(int i3) {
        this.mStartNetType = i3;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }

    public void setUin(String str) {
        this.mUin = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public void setWeakNetType(int i3) {
        this.mWeakNetType = i3;
    }

    public String toString() {
        return "QFSWeakNetworkCommendInfo{mUin='" + this.mUin + "', mTimeCost=" + this.mCost + ", mServerFeedListRspTime=" + this.mRspTime + ", mReqNetworkType=" + this.mStartNetType + ", mRspNetworkType=" + this.mEndNetType + ", mWeakNetType=" + this.mWeakNetType + ", mVersion='" + this.mVersion + "', mFeedListTraceId='" + this.mTraceId + "', mCommandFlag='" + this.mMethod + "', mReqTimeVal=" + this.mReqTimeVal + '}';
    }
}
