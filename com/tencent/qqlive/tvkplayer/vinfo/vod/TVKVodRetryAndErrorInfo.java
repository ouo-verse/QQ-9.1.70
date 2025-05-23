package com.tencent.qqlive.tvkplayer.vinfo.vod;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodRetryAndErrorInfo {
    public static final int EEROR_OK = 0;
    private long mCurTime;
    private int mErrCode;
    private int mErrDetailCode;
    private String mIpInfo;
    private String mMessage;
    private int mNeedRetry;
    private String mRand;

    public long getCurTime() {
        return this.mCurTime;
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public int getErrDetailCode() {
        return this.mErrDetailCode;
    }

    public String getIpInfo() {
        return this.mIpInfo;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getNeedRetry() {
        return this.mNeedRetry;
    }

    public String getRand() {
        return this.mRand;
    }

    public void setCurTime(long j3) {
        this.mCurTime = j3;
    }

    public void setErrCode(int i3) {
        this.mErrCode = i3;
    }

    public void setErrDetailCode(int i3) {
        this.mErrDetailCode = i3;
    }

    public void setIpInfo(String str) {
        this.mIpInfo = str;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setNeedRetry(int i3) {
        this.mNeedRetry = i3;
    }

    public void setRand(String str) {
        this.mRand = str;
    }
}
