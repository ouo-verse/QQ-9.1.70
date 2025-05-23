package com.tencent.qqlive.tvkplayer.api.vinfo;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveVideoInfo extends TVKNetVideoInfo {
    public static final int RET_CODE_CKEY_VERIFY_FAILED = 32;
    public static final int RET_CODE_SUCCESS = 0;
    private static final long serialVersionUID = -1;
    private int mACode;
    private int mBufferLoadingTime;
    private int mCdnId;
    private String mCdnName;
    private String mDecKey;
    private String mDrmCkc;
    private int mExpectDelaySec;
    private int mHeightenType;
    private ShotDirection mLensDirection;
    private int mLive360;
    private String mNonce;
    private int mPaymentStatus;
    private int mPaymentType;
    private int mPlayType;
    private String mRandoms;
    private int mSecondBufferTime;
    private int mSecondMaxBufferTime;
    private int mSecondMinBufferTime;
    private long mServerTime;
    private float mSpeedUpRate;
    private float mStartReduceLatencyBufferSizeSec;
    private float mStopReduceLatencyBufferSizeSec;
    private int mStream;
    private String mTargetId;
    private int mVCode;
    private String mPlayUrl = null;
    private String mRand = "";
    private String[] mBackPlayUrl = new String[0];
    private String mOriginalPlayUrl = "";
    private Integer mReduceLatencyAction = null;
    private String mCryptParamJsonString = "{}";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface HeightenType {
        public static final int DOLBY_VISION = 2;
        public static final int HDR_VIVID = 4;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface PaymentStatus {
        public static final int CHARGES_PAID = 1;
        public static final int CHARGES_UNPAID = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface PaymentType {
        public static final int FREE_CHANNEL = 0;
        public static final int PREMIUM_CHANNEL = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface PlayType {
        public static final int LIVE_INFO_QUERY = 1;
        public static final int MULTI_DEFINITIONS = 5;
        public static final int NORMAL = 4;
        public static final int PLAYBACK = 2;
        public static final int PREVIEW = 3;
        public static final int UNKNOWN = 0;
        public static final int VKEY_RENEW = 7;
        public static final int WATERMARK_QUERY = 6;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface ReduceLatencyAction {
        public static final int NONE = 0;
        public static final int SKIP_FRAME = 2;
        public static final int SPEED_UP = 1;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum ShotDirection {
        SHOT_UP,
        SHOT_DOWN;

        private static final long serialVersionUID = -1;
    }

    public TVKLiveVideoInfo() {
        this.mFromType = TVKVideoInfoFromType.FROM_TYPE_SERVER;
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

    public String getCdnName() {
        return this.mCdnName;
    }

    public String getCryptParamJsonString() {
        return this.mCryptParamJsonString;
    }

    public String getDecKey() {
        return this.mDecKey;
    }

    public String getDrmCkc() {
        return this.mDrmCkc;
    }

    public int getExpectDelaySec() {
        return this.mExpectDelaySec;
    }

    public int getHeightenType() {
        return this.mHeightenType;
    }

    public ShotDirection getLensDirection() {
        return this.mLensDirection;
    }

    public int getLive360() {
        return this.mLive360;
    }

    public String getNonce() {
        return this.mNonce;
    }

    public String getOriginalPlayUrl() {
        return this.mOriginalPlayUrl;
    }

    public int getPaymentStatus() {
        return this.mPaymentStatus;
    }

    public int getPaymentType() {
        return this.mPaymentType;
    }

    public int getPlayType() {
        return this.mPlayType;
    }

    public String getPlayUrl() {
        if (TextUtils.isEmpty(this.mPlayUrl)) {
            return "";
        }
        return this.mPlayUrl;
    }

    public String getRand() {
        return this.mRand;
    }

    public String getRandoms() {
        return this.mRandoms;
    }

    public Integer getReduceLatencyAction() {
        return this.mReduceLatencyAction;
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

    public float getSpeedUpRate() {
        return this.mSpeedUpRate;
    }

    public float getStartReduceLatencyBufferSizeSec() {
        return this.mStartReduceLatencyBufferSizeSec;
    }

    public float getStopReduceLatencyBufferSizeSec() {
        return this.mStopReduceLatencyBufferSizeSec;
    }

    public int getStream() {
        return this.mStream;
    }

    public String getTargetId() {
        return this.mTargetId;
    }

    public int getaCode() {
        return this.mACode;
    }

    public int getvCode() {
        return this.mVCode;
    }

    public boolean isPlayback() {
        if (this.mPlayType == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo
    public boolean isPreview() {
        if (getPaymentType() != 0 && getPaymentStatus() == 0) {
            return true;
        }
        return false;
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

    public void setCdnName(String str) {
        this.mCdnName = str;
    }

    public void setCryptParamJsonString(String str) {
        this.mCryptParamJsonString = str;
    }

    public void setDecKey(String str) {
        this.mDecKey = str;
    }

    public void setDrmCkc(String str) {
        this.mDrmCkc = str;
    }

    public void setExpectDelaySec(int i3) {
        this.mExpectDelaySec = i3;
    }

    public void setHeightenType(int i3) {
        this.mHeightenType = i3;
    }

    public void setLensDirection(ShotDirection shotDirection) {
        this.mLensDirection = shotDirection;
    }

    public void setLive360(int i3) {
        this.mLive360 = i3;
    }

    public void setNonce(String str) {
        this.mNonce = str;
    }

    public void setOriginalPlayUrl(String str) {
        this.mOriginalPlayUrl = str;
    }

    public void setPaymentStatus(int i3) {
        this.mPaymentStatus = i3;
    }

    public void setPaymentType(int i3) {
        this.mPaymentType = i3;
    }

    public void setPlayType(int i3) {
        this.mPlayType = i3;
    }

    public void setPlayUrl(String str) {
        this.mPlayUrl = str;
    }

    public void setRand(String str) {
        this.mRand = str;
    }

    public void setRandoms(String str) {
        this.mRandoms = str;
    }

    public void setReduceLatencyAction(int i3) {
        this.mReduceLatencyAction = Integer.valueOf(i3);
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

    public void setSpeedUpRate(float f16) {
        this.mSpeedUpRate = f16;
    }

    public void setStartReduceLatencyBufferSizeSec(float f16) {
        this.mStartReduceLatencyBufferSizeSec = f16;
    }

    public void setStopReduceLatencyBufferSizeSec(float f16) {
        this.mStopReduceLatencyBufferSizeSec = f16;
    }

    public void setStream(int i3) {
        this.mStream = i3;
    }

    public void setTargetId(String str) {
        this.mTargetId = str;
    }

    public void setaCode(int i3) {
        this.mACode = i3;
    }

    public void setvCode(int i3) {
        this.mVCode = i3;
    }
}
