package com.tencent.biz.richframework.video.rfw.player;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.RFWPlayerLimitLogUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodVidAsset;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class RFWPlayerOptions {
    public static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(90000);
    private HashMap<String, Object> mAttachInfo;
    private List<String> mBackUpBackUpList;
    private boolean mEnableDataCollected;
    private String mExchangedUrl;
    private long mExchangedUrlErrorCode;
    private String mFileId;
    private boolean mFirstFramePreRenderSucceed;
    private boolean mForceActive;
    private boolean mForceSystemPlayer;
    private int mFromType;
    private boolean mHasDownLevel;
    private boolean mHasExchangeUrl;
    private boolean mHasPreLoadPlayer;
    private boolean mHasReusePlayer;
    private boolean mHitPreloadCache;
    private boolean mInitBackThread;
    private RFWPlayerIOC mIoc;
    private boolean mIsLocalVideo;
    private boolean mIsPageFirstPlayer;
    private boolean mNeedToDownLevelUrl;
    private boolean mNeedToExchangeUrl;
    private boolean mOffsetBySeek;
    private String mPlayUrl;
    private String mPreDownloadTag;
    private String mPreLoadPlayerTag;
    private String mPreloadSourceType;
    private RFWVideoUrlBean mRealPlayBean;
    private String mRealPlayUrl;
    private int mRetryCount;
    private final int mSceneId;
    private boolean mSelectUrlHitCache;
    private RFWVideoUrlBean mServerPlayBean;
    private RFWStVideo mStVideo;
    private long mStartOffset;
    private RFWTVKPlayerOptions mTVKPlayerOption;
    private String mTargetDualStackV4IpUrl;
    private String mTargetIpUrl;
    private List<RFWVideoUrlBean> mVecUrlBean;
    private int mVideoFormat;
    private boolean mIsVideo = true;
    private boolean mDisableSuperSample = false;
    private boolean mIsMutualExclusion = true;
    private boolean mVideoIsDelete = false;
    private int mPredictSpeed = ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;
    private boolean mEnableIpDirect = true;
    private boolean mUseUrlMD5AsId = false;
    private final int mSeq = ATOMIC_INTEGER.getAndIncrement();
    private RFWPlayerListenerSet mListenerSet = new RFWPlayerListenerSet();

    RFWPlayerOptions(int i3) {
        this.mSceneId = i3;
        createDefaultIoc();
    }

    private void createDefaultIoc() {
        this.mIoc = new RFWPlayerIOC() { // from class: com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions.1
            @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
            public boolean isValid() {
                return true;
            }
        };
    }

    public static RFWPlayerOptions obtain(int i3) {
        return new RFWPlayerOptions(i3);
    }

    public RFWPlayerOptions addAttachInfo(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.mAttachInfo == null) {
                this.mAttachInfo = new HashMap<>();
            }
            this.mAttachInfo.put(str, obj);
        }
        return this;
    }

    public boolean enableDataCollected() {
        return this.mEnableDataCollected;
    }

    public boolean enableIpDirect() {
        return this.mEnableIpDirect;
    }

    public boolean forceActive() {
        return this.mForceActive;
    }

    public boolean forceSystemPlayer() {
        return this.mForceSystemPlayer;
    }

    public HashMap<String, Object> getAttachInfo() {
        return this.mAttachInfo;
    }

    public List<String> getDirectIPBackUpList() {
        return this.mBackUpBackUpList;
    }

    public String getExchangedUrl() {
        return this.mExchangedUrl;
    }

    public long getExchangedUrlErrorCode() {
        return this.mExchangedUrlErrorCode;
    }

    public String getFileId() {
        if (!TextUtils.isEmpty(this.mFileId)) {
            return this.mFileId;
        }
        RFWStVideo rFWStVideo = this.mStVideo;
        if (rFWStVideo != null && !TextUtils.isEmpty(rFWStVideo.getFileId())) {
            String fileId = this.mStVideo.getFileId();
            this.mFileId = fileId;
            return fileId;
        }
        String realPlayUrl = getRealPlayUrl();
        this.mFileId = realPlayUrl;
        return realPlayUrl;
    }

    public boolean getFirstFramePreRenderSucceed() {
        return this.mFirstFramePreRenderSucceed;
    }

    public int getFromType() {
        return this.mFromType;
    }

    public String getHost() {
        return RFWVideoUtils.getUrlHost(this.mRealPlayUrl);
    }

    public RFWPlayerIOC getIOC() {
        return this.mIoc;
    }

    public RFWPlayerListenerSet getListenerSet() {
        return this.mListenerSet;
    }

    public String getPlayUrl() {
        if (TextUtils.isEmpty(this.mPlayUrl)) {
            return "";
        }
        return this.mPlayUrl;
    }

    public String getPlayVid() {
        RFWTVKPlayerOptions rFWTVKPlayerOptions = this.mTVKPlayerOption;
        if (rFWTVKPlayerOptions != null && rFWTVKPlayerOptions.getTVKPlayerVideoInfo() != null && (this.mTVKPlayerOption.getTVKPlayerVideoInfo().getAsset() instanceof TVKOnlineVodVidAsset)) {
            return ((TVKOnlineVodVidAsset) this.mTVKPlayerOption.getTVKPlayerVideoInfo().getAsset()).getVid();
        }
        RFWTVKPlayerOptions rFWTVKPlayerOptions2 = this.mTVKPlayerOption;
        if (rFWTVKPlayerOptions2 != null) {
            return rFWTVKPlayerOptions2.getVid();
        }
        return "";
    }

    public int getPredictSpeed() {
        return this.mPredictSpeed;
    }

    public String getPreloadPlayerTag() {
        return this.mPreLoadPlayerTag;
    }

    public String getPreloadSourceType() {
        return this.mPreloadSourceType;
    }

    public RFWVideoUrlBean getRealPlayBean() {
        return this.mRealPlayBean;
    }

    public String getRealPlayUrl() {
        if (TextUtils.isEmpty(this.mRealPlayUrl)) {
            return getPlayUrl();
        }
        return this.mRealPlayUrl;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public int getSceneId() {
        return this.mSceneId;
    }

    public RFWVideoUrlBean getServerPlayBean() {
        return this.mServerPlayBean;
    }

    public RFWStVideo getStVideo() {
        if (this.mStVideo == null) {
            this.mStVideo = new RFWStVideo().setPlayUrl(getPlayUrl());
        }
        return this.mStVideo;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public RFWTVKPlayerOptions getTVKPlayerOption() {
        return this.mTVKPlayerOption;
    }

    public String getTargetDualStackV4IpUrl() {
        return this.mTargetDualStackV4IpUrl;
    }

    public String getTargetIPURL() {
        if (enableIpDirect()) {
            return this.mTargetIpUrl;
        }
        return "";
    }

    public List<RFWVideoUrlBean> getVecUrlBean() {
        return this.mVecUrlBean;
    }

    public int getVideoFormat() {
        return this.mVideoFormat;
    }

    public boolean hasPreLoadPlayer() {
        return this.mHasPreLoadPlayer;
    }

    public boolean hasReusePlayer() {
        return this.mHasReusePlayer;
    }

    public boolean hitPreloadCache() {
        return this.mHitPreloadCache;
    }

    public boolean hitSelectUrlCache() {
        return this.mSelectUrlHitCache;
    }

    public RFWPlayerOptions inCreRetryCount() {
        this.mRetryCount++;
        return this;
    }

    public boolean isDisableSuperSample() {
        return this.mDisableSuperSample;
    }

    public boolean isFirstPlayer() {
        return this.mIsPageFirstPlayer;
    }

    public boolean isHasExchangeUrl() {
        return this.mHasExchangeUrl;
    }

    public boolean isLocalVideo() {
        return this.mIsLocalVideo;
    }

    public boolean isMutualExclusion() {
        return this.mIsMutualExclusion;
    }

    public boolean isPlayerByDirectIP() {
        if (!TextUtils.isEmpty(this.mTargetIpUrl) && enableIpDirect()) {
            return true;
        }
        return false;
    }

    public boolean isPreloadPlayer() {
        if (this.mFromType >= 10000) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        return this.mIoc.isValid();
    }

    public boolean isVideo() {
        return this.mIsVideo;
    }

    public boolean isVideoDelete() {
        return this.mVideoIsDelete;
    }

    public boolean needDownLevelUrl() {
        return this.mNeedToDownLevelUrl;
    }

    public boolean needExChangeUrl() {
        return this.mNeedToExchangeUrl;
    }

    public boolean offsetBySeek() {
        return this.mOffsetBySeek;
    }

    public RFWPlayerOptions replaceListenerSet(RFWPlayerListenerSet rFWPlayerListenerSet) {
        if (rFWPlayerListenerSet == null) {
            return this;
        }
        this.mListenerSet = rFWPlayerListenerSet;
        return this;
    }

    public void setDirectIPBackUpList(List<String> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.mBackUpBackUpList = arrayList;
        arrayList.addAll(list);
    }

    public RFWPlayerOptions setDisableSuperSample(boolean z16) {
        this.mDisableSuperSample = z16;
        return this;
    }

    public RFWPlayerOptions setEnableDataCollect(boolean z16) {
        this.mEnableDataCollected = z16;
        return this;
    }

    public RFWPlayerOptions setEnableDirectIP(boolean z16) {
        this.mEnableIpDirect = z16;
        return this;
    }

    public RFWPlayerOptions setExchangedUrl(String str) {
        this.mExchangedUrl = str;
        return this;
    }

    public RFWPlayerOptions setExchangedUrlErrorCode(long j3) {
        this.mExchangedUrlErrorCode = j3;
        return this;
    }

    public RFWPlayerOptions setFileId(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mFileId = str;
        return this;
    }

    public void setFirstFramePreRenderSucceed(boolean z16) {
        this.mFirstFramePreRenderSucceed = z16;
    }

    public RFWPlayerOptions setForceActive(boolean z16) {
        this.mForceActive = z16;
        return this;
    }

    public RFWPlayerOptions setForceSystemPlayer(boolean z16) {
        this.mForceSystemPlayer = z16;
        return this;
    }

    public RFWPlayerOptions setFromType(int i3) {
        this.mFromType = i3;
        return this;
    }

    public RFWPlayerOptions setHasDownLevel(boolean z16) {
        this.mHasDownLevel = z16;
        return this;
    }

    public RFWPlayerOptions setHasExchangeUrl(boolean z16) {
        this.mHasExchangeUrl = z16;
        return this;
    }

    public RFWPlayerOptions setHasHitPreLoadCache(boolean z16) {
        this.mHitPreloadCache = z16;
        return this;
    }

    public RFWPlayerOptions setHasPreLoadPlayer(boolean z16) {
        this.mHasPreLoadPlayer = z16;
        return this;
    }

    public RFWPlayerOptions setHasReusePlayer(boolean z16) {
        this.mHasReusePlayer = z16;
        return this;
    }

    public RFWPlayerOptions setInitBackThread(boolean z16) {
        this.mInitBackThread = z16;
        return this;
    }

    public RFWPlayerOptions setIsFirstPlayer(boolean z16) {
        this.mIsPageFirstPlayer = z16;
        return this;
    }

    public RFWPlayerOptions setIsLocalVideo(boolean z16) {
        this.mIsLocalVideo = z16;
        return this;
    }

    public RFWPlayerOptions setIsMutualExclusion(boolean z16) {
        this.mIsMutualExclusion = z16;
        return this;
    }

    public RFWPlayerOptions setIsVideo(boolean z16) {
        this.mIsVideo = z16;
        return this;
    }

    public RFWPlayerOptions setNeedExchangeUrl(boolean z16) {
        this.mNeedToExchangeUrl = z16;
        return this;
    }

    public RFWPlayerOptions setOffSetBySeek(boolean z16) {
        this.mOffsetBySeek = z16;
        return this;
    }

    public RFWPlayerOptions setPlayIOC(RFWPlayerIOC rFWPlayerIOC) {
        if (rFWPlayerIOC == null) {
            createDefaultIoc();
            QLog.d(tag(), 1, "setPlayIOC reset default IOC:stack," + RFWPlayerLimitLogUtils.getCurrentStackTrace("setPlayIOC", 10));
            return this;
        }
        this.mIoc = rFWPlayerIOC;
        QLog.d(tag(), 1, "setPlayIOC:" + rFWPlayerIOC.getClass() + ": stack," + RFWPlayerLimitLogUtils.getCurrentStackTrace("setPlayIOC", 10));
        return this;
    }

    public RFWPlayerOptions setPlayUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mPlayUrl = str;
        return this;
    }

    public RFWPlayerOptions setPreDownloadTag(String str) {
        this.mPreDownloadTag = str;
        return this;
    }

    public RFWPlayerOptions setPreLoadPlayerTag(String str) {
        this.mPreLoadPlayerTag = str;
        return this;
    }

    public RFWPlayerOptions setPredictSpeed(int i3) {
        this.mPredictSpeed = i3;
        return this;
    }

    public RFWPlayerOptions setPreloadSourceType(String str) {
        this.mPreloadSourceType = str;
        return this;
    }

    public RFWPlayerOptions setRealPlayBean(RFWVideoUrlBean rFWVideoUrlBean) {
        this.mRealPlayBean = rFWVideoUrlBean;
        return this;
    }

    public RFWPlayerOptions setRealPlayUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mRealPlayUrl = str;
        return this;
    }

    public RFWPlayerOptions setSelectHitUrlCache(boolean z16) {
        this.mSelectUrlHitCache = z16;
        return this;
    }

    public RFWPlayerOptions setServerPlayBean(RFWVideoUrlBean rFWVideoUrlBean) {
        this.mServerPlayBean = rFWVideoUrlBean;
        return this;
    }

    public RFWPlayerOptions setStVideo(RFWStVideo rFWStVideo) {
        this.mStVideo = rFWStVideo;
        return this;
    }

    public RFWPlayerOptions setStartOffset(long j3) {
        this.mStartOffset = j3;
        return this;
    }

    public RFWPlayerOptions setTVKPlayerOption(RFWTVKPlayerOptions rFWTVKPlayerOptions) {
        if (rFWTVKPlayerOptions != null) {
            this.mTVKPlayerOption = rFWTVKPlayerOptions;
        }
        return this;
    }

    public void setTargetDualStackV4IpUrl(String str) {
        this.mTargetDualStackV4IpUrl = str;
    }

    public RFWPlayerOptions setTargetIPURl(String str) {
        this.mTargetIpUrl = str;
        return this;
    }

    public RFWPlayerOptions setUseUrlMD5AsID(boolean z16) {
        this.mUseUrlMD5AsId = z16;
        return this;
    }

    public RFWPlayerOptions setVecUrlBean(List<RFWVideoUrlBean> list) {
        this.mVecUrlBean = list;
        return this;
    }

    public RFWPlayerOptions setVideoIsDelete(boolean z16) {
        this.mVideoIsDelete = z16;
        return this;
    }

    public boolean shouldInitBackThread() {
        return this.mInitBackThread;
    }

    public String tag() {
        return "RFW_PLAYER_" + this.mSceneId + "_" + this.mFromType + "_" + this.mSeq;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QFSPlayerOptions{");
        stringBuffer.append("mSeq=");
        stringBuffer.append(this.mSeq);
        stringBuffer.append(", mFileId='");
        stringBuffer.append(this.mFileId);
        stringBuffer.append('\'');
        stringBuffer.append(", mStartOffset=");
        stringBuffer.append(this.mStartOffset);
        stringBuffer.append(", mFromType=");
        stringBuffer.append(this.mFromType);
        stringBuffer.append(", mPreDownloadTag='");
        stringBuffer.append(this.mPreDownloadTag);
        stringBuffer.append('\'');
        stringBuffer.append(", mHasPreLoadPlayer=");
        stringBuffer.append(this.mHasPreLoadPlayer);
        stringBuffer.append(", mPreLoadPlayerTag='");
        stringBuffer.append(this.mPreLoadPlayerTag);
        stringBuffer.append('\'');
        stringBuffer.append(", mHasDownLevel=");
        stringBuffer.append(this.mHasDownLevel);
        stringBuffer.append(", mIsLocalVideo=");
        stringBuffer.append(this.mIsLocalVideo);
        stringBuffer.append(", mPredictSpeed=");
        stringBuffer.append(this.mPredictSpeed);
        stringBuffer.append('\'');
        stringBuffer.append(", mSelectUrlHitCache=");
        stringBuffer.append(this.mSelectUrlHitCache);
        stringBuffer.append('\'');
        stringBuffer.append(", mHitPreloadCache=");
        stringBuffer.append(this.mHitPreloadCache);
        stringBuffer.append('\'');
        stringBuffer.append(", mPlayUrl='");
        stringBuffer.append(this.mPlayUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mTargetIpUrl=");
        stringBuffer.append(this.mTargetIpUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mRealPlayUrl='");
        stringBuffer.append(this.mRealPlayUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mNeedToExchangeUrl=");
        stringBuffer.append(this.mNeedToExchangeUrl);
        stringBuffer.append(", mNeedToDownLevelUrl=");
        stringBuffer.append(this.mNeedToDownLevelUrl);
        stringBuffer.append(", mHasExchangeUrl=");
        stringBuffer.append(this.mHasExchangeUrl);
        stringBuffer.append(", mTVKPlayerOption='");
        stringBuffer.append(this.mTVKPlayerOption);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public boolean useMD5AsId() {
        return this.mUseUrlMD5AsId;
    }
}
