package com.tencent.qqlive.superplayer.vinfo;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKLiveVideoInfo extends TVKNetVideoInfo {
    public static final int ERR_CGI = 10001;
    public static final int ERR_NETWORK = 10000;
    public static final int SHOT_DIRECTION_DOWN = 2;
    public static final int SHOT_DIRECTION_UP = 1;
    private static final long serialVersionUID = -1;
    private int mAcode;
    private String[] mBackPlayUrl;
    private int mBufferLoadingTime;
    private int mCdnId;
    private int mErrModule;

    @ShotDirection
    private int mLensDirection;
    private int mLive360;
    private String mProgramId;
    private int mRestPrePlayCount;
    private int mSecondBufferTime;
    private int mSecondMaxBufferTime;
    private int mSecondMinBufferTime;
    private long mServerTime;
    private int mStream;
    private String mTargetId;
    private int mVcode;
    private String mXml;
    private String mPlayUrl = null;
    private String mRand = "";
    private String mOriginalPlayUrl = "";
    private int mProxyRequestId = 0;
    private boolean mGetPreviewInfo = false;
    private boolean mGetDlnaUrl = false;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public @interface ShotDirection {
    }

    public int getAcode() {
        return this.mAcode;
    }

    public String[] getBackPlayUrl() {
        return this.mBackPlayUrl;
    }

    public int getBufferLoadingTime() {
        return this.mBufferLoadingTime;
    }

    public int getCdnId() {
        return this.mCdnId;
    }

    public int getErrModule() {
        return this.mErrModule;
    }

    public int getLensDirection() {
        return this.mLensDirection;
    }

    public int getLive360() {
        return this.mLive360;
    }

    public String getOriginalPlayUrl() {
        return this.mOriginalPlayUrl;
    }

    public String getPlayUrl() {
        if (TextUtils.isEmpty(this.mPlayUrl)) {
            return "";
        }
        return this.mPlayUrl;
    }

    public String getProgId() {
        return this.mProgramId;
    }

    public int getProxyRequestId() {
        return this.mProxyRequestId;
    }

    public String getRand() {
        return this.mRand;
    }

    public int getSecondBufferTime() {
        return this.mSecondBufferTime;
    }

    public int getSecondMaxBufferTime() {
        return this.mSecondMaxBufferTime;
    }

    public int getSecondMinBufferTime() {
        return this.mSecondMinBufferTime;
    }

    public long getServerTime() {
        return this.mServerTime;
    }

    public int getStream() {
        return this.mStream;
    }

    public String getTargetId() {
        return this.mTargetId;
    }

    public int getVcode() {
        return this.mVcode;
    }

    public String getXml() {
        return this.mXml;
    }

    public boolean isGetDlnaUrl() {
        return this.mGetDlnaUrl;
    }

    public boolean isGetPreviewInfo() {
        return this.mGetPreviewInfo;
    }

    public void setAcode(int i3) {
        this.mAcode = i3;
    }

    public void setBackPlayUrl(String[] strArr) {
        this.mBackPlayUrl = strArr;
    }

    public void setBufferLoadingTime(int i3) {
        this.mBufferLoadingTime = i3;
    }

    public void setCdnId(int i3) {
        this.mCdnId = i3;
    }

    public void setErrModule(int i3) {
        this.mErrModule = i3;
    }

    public void setGetDlnaUrl(boolean z16) {
        this.mGetDlnaUrl = z16;
    }

    public void setGetPreviewInfo(boolean z16) {
        this.mGetPreviewInfo = z16;
    }

    public void setLensDirection(@ShotDirection int i3) {
        this.mLensDirection = i3;
    }

    public void setLive360(int i3) {
        this.mLive360 = i3;
    }

    public void setOriginalPlayUrl(String str) {
        this.mOriginalPlayUrl = str;
    }

    public void setPlayUrl(String str) {
        this.mPlayUrl = str;
    }

    public void setProgId(String str) {
        this.mProgramId = str;
    }

    public void setProxyRequestId(int i3) {
        this.mProxyRequestId = i3;
    }

    public void setRand(String str) {
        this.mRand = str;
    }

    public void setSecondBufferTime(int i3) {
        this.mSecondBufferTime = i3;
    }

    public void setSecondMaxBufferTime(int i3) {
        this.mSecondMaxBufferTime = i3;
    }

    public void setSecondMinBufferTime(int i3) {
        this.mSecondMinBufferTime = i3;
    }

    public void setServerTime(long j3) {
        this.mServerTime = j3;
    }

    public void setStream(int i3) {
        this.mStream = i3;
    }

    public void setTargetId(String str) {
        this.mTargetId = str;
    }

    public void setVcode(int i3) {
        this.mVcode = i3;
    }

    public void setXml(String str) {
        this.mXml = str;
    }
}
