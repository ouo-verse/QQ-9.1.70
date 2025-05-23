package com.tencent.biz.richframework.video.rfw.player.datacollect;

import com.tencent.biz.richframework.network.util.VSNetworkSpeedHelper;
import com.tencent.biz.richframework.video.RFWNetworkHelper;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qcircle.picload.listener.a;
import java.util.ArrayList;
import java.util.List;
import uq3.n;

/* loaded from: classes5.dex */
public class RFWPlayerCollectParams {
    private float mCacheS;
    private String mErrorCode;
    private String mErrorMsg;
    private String mFileId;
    private boolean mIsFloating;
    private boolean mIsSeeking;
    private boolean mNotStart;
    private float mOffsetS;
    private boolean mPlayByOnResume;
    private String mPlayUrl;
    private int mPoi;
    private String mPreloadTag;
    private float mRateKBS;
    private String mScene;
    private final int mSceneId;
    private boolean mScrollNext;
    private boolean mSdkReady;
    private long mStartTime;
    private String mStartTimeDate;
    private final String mTag;
    private int mWeakNetTipsStatus;
    private String mWeakNetTipsUserClickTime;
    private float mProcessTimeS = -1.0f;
    private float mPrepareTimeS = -1.0f;
    private float mFirstRenderTimeS = -1.0f;
    private final List<RFWPlayerSeekRecode> mSeekList = new ArrayList();
    private final List<RFWPlayerBufferRecode> mBufferList = new ArrayList();
    private final float mNetKBS = (float) RFWVideoUtils.getPredictSpeedWithOutDownGrade(126);
    private final int mDevice = QCircleDeviceInfoUtils.getLevel();
    private final float mFeedTimeS = ((Double) VSNetworkSpeedHelper.getNetworkSpeedTest().getSpeedAndSucceedRate().first).floatValue() / 1000.0f;
    private final float mPicKBS = ((Double) a.c().getSpeedAndSucceedRate().first).floatValue();
    private final boolean mIsMsfWeakNet = RFWNetworkHelper.isMsfWeakNet();
    private final int mMsfWeakNetReason = RFWNetworkHelper.getMsfWeakReason();

    public RFWPlayerCollectParams(int i3, String str) {
        this.mSceneId = i3;
        this.mTag = str;
    }

    public RFWPlayerCollectParams addSecondBufferRecode(RFWPlayerBufferRecode rFWPlayerBufferRecode) {
        if (rFWPlayerBufferRecode == null) {
            return this;
        }
        this.mBufferList.add(rFWPlayerBufferRecode);
        return this;
    }

    public RFWPlayerCollectParams addSeekRecodeList(RFWPlayerSeekRecode rFWPlayerSeekRecode) {
        if (rFWPlayerSeekRecode == null) {
            return this;
        }
        this.mSeekList.add(rFWPlayerSeekRecode);
        return this;
    }

    public float getCanPlayTimeS() {
        return this.mCacheS;
    }

    public int getDeviceLevel() {
        return this.mDevice;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public float getFeedTimes() {
        return this.mFeedTimeS;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public float getFirstRenderCostTimeS() {
        return this.mFirstRenderTimeS;
    }

    public int getMsfWeakNetReason() {
        return this.mMsfWeakNetReason;
    }

    public float getNetKBS() {
        return this.mNetKBS;
    }

    public float getOffsetS() {
        return this.mOffsetS;
    }

    public float getPicTimeS() {
        return this.mPicKBS;
    }

    public long getPlayRequestStartTime() {
        return this.mStartTime;
    }

    public String getPlayScene() {
        return this.mScene;
    }

    public String getPlayerErrorCode() {
        return this.mErrorCode;
    }

    public int getPoi() {
        return this.mPoi;
    }

    public String getPreloadTag() {
        return this.mPreloadTag;
    }

    public float getPrepareCostTimeS() {
        return this.mPrepareTimeS;
    }

    public float getProcessCostTimeS() {
        return this.mProcessTimeS;
    }

    public float getRate() {
        return this.mRateKBS;
    }

    public String getRealPlayUrl() {
        return this.mPlayUrl;
    }

    public int getSceneId() {
        return this.mSceneId;
    }

    public List<RFWPlayerBufferRecode> getSecondBufferRecodeList() {
        return this.mBufferList;
    }

    public List<RFWPlayerSeekRecode> getSeekRecodeList() {
        return this.mSeekList;
    }

    public String getTag() {
        return this.mTag;
    }

    public int getWeakNetTipsStatus() {
        return this.mWeakNetTipsStatus;
    }

    public String getWeakNetTipsUserClickTime() {
        return this.mWeakNetTipsUserClickTime;
    }

    public boolean isFloating() {
        return this.mIsFloating;
    }

    public boolean isIsSdkReady() {
        return this.mSdkReady;
    }

    public boolean isMsfWeakNet() {
        return this.mIsMsfWeakNet;
    }

    public boolean isNotStart() {
        return this.mNotStart;
    }

    public boolean isOnSeeking() {
        return this.mIsSeeking;
    }

    public boolean isPlayByONResume() {
        return this.mPlayByOnResume;
    }

    public boolean isScrollNext() {
        return this.mScrollNext;
    }

    public RFWPlayerCollectParams setCanPlayTimeS(float f16) {
        this.mCacheS = f16;
        return this;
    }

    public RFWPlayerCollectParams setErrorMsg(String str) {
        this.mErrorMsg = str;
        return this;
    }

    public RFWPlayerCollectParams setFileId(String str) {
        this.mFileId = str;
        return this;
    }

    public RFWPlayerCollectParams setFirstRenderCostTimeS(float f16) {
        this.mFirstRenderTimeS = f16;
        return this;
    }

    public RFWPlayerCollectParams setIsFloating(boolean z16) {
        this.mIsFloating = z16;
        return this;
    }

    public RFWPlayerCollectParams setIsOnSeeking(boolean z16) {
        this.mIsSeeking = z16;
        return this;
    }

    public RFWPlayerCollectParams setIsScrollNext(boolean z16) {
        this.mScrollNext = z16;
        return this;
    }

    public RFWPlayerCollectParams setIsSdkReady(boolean z16) {
        this.mSdkReady = z16;
        return this;
    }

    public void setNotStart(boolean z16) {
        this.mNotStart = z16;
    }

    public RFWPlayerCollectParams setPlayByOnResume(boolean z16) {
        this.mPlayByOnResume = z16;
        return this;
    }

    public RFWPlayerCollectParams setPlayPoi(int i3) {
        this.mPoi = i3;
        return this;
    }

    public RFWPlayerCollectParams setPlayRequestStartTime(long j3) {
        this.mStartTime = j3;
        this.mStartTimeDate = n.a(j3);
        return this;
    }

    public RFWPlayerCollectParams setPlayScene(String str) {
        this.mScene = str;
        return this;
    }

    public RFWPlayerCollectParams setPlayUrl(String str) {
        this.mPlayUrl = str;
        return this;
    }

    public RFWPlayerCollectParams setPlayerErrorCode(String str) {
        this.mErrorCode = str;
        return this;
    }

    public RFWPlayerCollectParams setPreloadTag(String str) {
        this.mPreloadTag = str;
        return this;
    }

    public RFWPlayerCollectParams setPrepareCostTimeS(float f16) {
        this.mPrepareTimeS = f16;
        return this;
    }

    public RFWPlayerCollectParams setProcessCostTimeS(float f16) {
        this.mProcessTimeS = f16;
        return this;
    }

    public RFWPlayerCollectParams setRateKBS(float f16) {
        this.mRateKBS = f16;
        return this;
    }

    public RFWPlayerCollectParams setStartOffset(float f16) {
        this.mOffsetS = f16;
        return this;
    }

    public void setWeakNetTipsStatus(int i3) {
        this.mWeakNetTipsStatus = i3;
    }

    public void setWeakNetTipsUserClickTime(long j3) {
        if (j3 > 0) {
            this.mWeakNetTipsUserClickTime = n.a(j3);
        } else {
            this.mWeakNetTipsUserClickTime = "";
        }
    }

    public String toString() {
        return "QFSPlayCollectParams{mTag='" + this.mTag + "', mFileId='" + this.mFileId + "', mCacheS=" + this.mCacheS + ", mOffsetS=" + this.mOffsetS + ", mScene=" + this.mScene + "', mPoi=" + this.mPoi + ", mIsFloating=" + this.mIsFloating + ", mNotStart=" + this.mNotStart + ", mPlayUrl=" + this.mPlayUrl + "', mDevice=" + this.mDevice + ", mNetKBS=" + this.mNetKBS + ", mRateKBS=" + this.mRateKBS + ", mFeedTimeS=" + this.mFeedTimeS + ", mPicKBS=" + this.mPicKBS + ", mSdkReady=" + this.mSdkReady + ", mStartTime=" + this.mStartTimeDate + ", mProcessTimeS=" + this.mProcessTimeS + ", mPrepareTimeS=" + this.mPrepareTimeS + ", mFirstRenderTimeS=" + this.mFirstRenderTimeS + ", mPreloadTag='" + this.mPreloadTag + "', mErrorCode='" + this.mErrorCode + "', mScrollNext=" + this.mScrollNext + ", mPlayByOnResume=" + this.mPlayByOnResume + ", mIsSeeking=" + this.mIsSeeking + ", mSeekList=" + this.mSeekList + ", mBufferList=" + this.mBufferList + ", mIsMsfWeakNet=" + this.mIsMsfWeakNet + ", mMsfWeakNetReason=" + this.mMsfWeakNetReason + ", mErrorMsg='" + this.mErrorMsg + "', mWeakNetTipsStatus=" + this.mWeakNetTipsStatus + ", mWeakNetTipsUserClickTime:" + this.mWeakNetTipsUserClickTime + '}';
    }
}
