package com.tencent.qqlive.tvkplayer.api.vinfo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKNetVideoInfo implements Serializable {
    public static final int AUDIO_CODEC_FORMAT_AAC = 1;
    public static final int AUDIO_CODEC_FORMAT_AAC_5_1 = 8;
    public static final int AUDIO_CODEC_FORMAT_AUDIO_VIVID_5_1_4 = 9;
    public static final int AUDIO_CODEC_FORMAT_DOLBY2 = 4;
    public static final int AUDIO_CODEC_FORMAT_DOLBY_ATMOS = 3;
    public static final int AUDIO_CODEC_FORMAT_DOLBY_SURROUND = 2;
    public static final String AUDIO_TRACK_DOLBY = "db";
    public static final int AUDIO_TRACK_TYPE_EXTERNAL = 0;
    public static final int AUDIO_TRACK_TYPE_INTERNAL = 1;
    public static final int FALSE = 0;
    public static final int IS_AVS_SEPARATE_SUPPORT = 1;
    public static final int LIVE_VIDEO_CODEC_FORMAT_H264 = 1;
    public static final int LIVE_VIDEO_CODEC_FORMAT_H265 = 2;
    public static final int LIVE_VIDEO_CODEC_FORMAT_H266 = 3;
    public static final int MSHOT_SCREENSHOT_BY_PLAYER = 0;
    public static final int MSHOT_SCREENSHOT_BY_SERVER = 1;
    public static final int SSHOT_DEPEND_ON_APP_RECORD = 0;
    public static final int SSHOT_DISABLE_ALL_RECORD = 1;
    public static final int SSHOT_DISABLE_SYSTEM_RECORD = 2;
    public static final int SSHOT_ENABLE_ALL_RECORD = 3;
    public static final int SUBTITLE_TYPE_ASS = 2;
    public static final int SUBTITLE_TYPE_SRT = 1;
    public static final int SUBTITLE_TYPE_VTT = 3;
    public static final int TRUE = 1;
    public static final int TYPE_JSON = 1;
    public static final int TYPE_PICTURE_NODE = 3;
    public static final int TYPE_XML = 2;
    public static final int VIDEO_CODEC_FORMAT_AUDIO = 5;
    public static final int VIDEO_CODEC_FORMAT_AV1 = 26;
    public static final int VIDEO_CODEC_FORMAT_AVS3 = 13;
    public static final int VIDEO_CODEC_FORMAT_DOLLBYVISION = 4;
    public static final int VIDEO_CODEC_FORMAT_H264 = 1;
    public static final int VIDEO_CODEC_FORMAT_H265 = 2;
    public static final int VIDEO_CODEC_FORMAT_HDR10 = 3;
    public static final int VIDEO_CODEC_FORMAT_HDR_VIVID = 19;
    public static final int VIDEO_CODEC_FORMAT_SDR = 7;
    public static final int VIDEO_CODEC_FORMAT_SDRPLUS = 6;
    public static final int VIDEO_CODEC_FORMAT_SFR3X_HDR = 12;
    public static final int VIDEO_CODEC_FORMAT_SFR3X_TIE_V2_HDR = 17;
    public static final int VIDEO_CODEC_FORMAT_SFR4X_HDR = 11;
    public static final int VIDEO_CODEC_FORMAT_SFR4X_TIE_V2_HDR = 18;
    public static final int VIDEO_CODEC_FORMAT_SFR_HDR = 10;
    public static final int VIDEO_CODEC_FORMAT_SFR_TIE_V2_HDR = 16;
    public static final int VIDEO_CODEC_FORMAT_SRF_HDR_VIVID = 27;
    public static final int VIDEO_CODEC_FORMAT_T265 = 8;
    public static final int VIDEO_CODEC_FORMAT_TIE_V2_HDR = 15;
    public static final int VIDEO_CODEC_FORMAT_VVC = 20;
    public static final int VIDEO_HDR_TONEMAPPING_SUPPORT = 1;
    public static final int VIDEO_STATE_CAN_PLAY = 2;
    public static final int VIDEO_STATE_PRE_PLAY = 8;
    public static final String VID_ENCRYPTION_TYPE_HIGH = "8265900";
    public static final String VID_ENCRYPTION_TYPE_LOW = "8265899";
    public static final String VID_ENCRYPTION_TYPE_OFF = "8265898";
    private static final long serialVersionUID = -1;
    private AdInfo mAdInfo;
    private int mBandwidthLevel;
    private String mBizExt;
    private int mCached;
    private String mCastSet;
    private Map<String, String> mCdnHttpHeaders;
    private AudioTrackInfo mCurAudioTrack;
    private DefnInfo mCurDefinition;
    private String mErrInfo;
    private String mErrTitle;
    private int mExem;
    private TVKFloatWaterMarkInfo mFloatWaterMarkInfo;
    private String mFps;
    private int mFvideo;
    private int mHeight;
    private boolean mIsFreeNetFlowUrl;
    private boolean mIsHevc;
    private boolean mIsVvc;
    private long mLiveCurrentPreviewDurationSec;
    private TVKDynamicsLogoInfo mLiveDynLogo;
    private String mLnk;
    private LogoPositionInfo mLogoPositionInfo;
    private long mMaxBitrate;
    private int mMediaVideoState;
    private int mMshot;
    private String mPLString;
    private Object mPicList;
    private long mPlayBackStartSec;
    private long mPlayBackTimeSec;
    private String mPlayExperienceLevel;
    private long mPreviewStartPositionSec;
    private String mPureVid;
    private int mQueueRank;
    private String mQueueSessionKey;
    private int mQueueStatus;
    private int mQueueVipJump;
    protected String mReport;
    private int mRetCode;
    private String mSeReport;
    private String mSescy;
    private String mSignature;
    private int mSkipEndPositionSec;
    private String mSse;
    private int mSshot;
    private int mStartPositionSec;
    private int mStatus;
    private int mStreamSecret;
    private int mSubErrType;
    private long mSvrTick;
    protected TVKRichMediaInfo mTVKRichMediaInfo;
    private String mTestBucket;
    private int mTestId;
    private int mTie;
    private String mTitle;
    private long mTotalDurationMs;
    private String mVid;
    private int mVideoType;
    private String mVodEncryption;
    private String mVodLogoActionUrl;
    private float mWHRadio;
    private String mWanIP;
    private int mWidth;
    private String mXml = "";
    private final List<DefnInfo> mDefinitionList = new ArrayList();
    private String mStrategyParamExtInfo = "";
    private Map<String, Integer> mAbTestInfo = new HashMap();
    private ArrayList<AudioTrackInfo> mAudioTrackList = new ArrayList<>();
    private int mFp2p = 1;
    private int mCdnOrigin = 0;
    private int mPttn = 0;
    private int mPLType = 0;
    private HashMap<Integer, String> mVideoDownloadHostMap = new HashMap<>();
    private List<EmbeddedAdDot> mEmbeddedAdDotList = new ArrayList();
    private String mDotInfo = "";
    private SubTitle mCurSubtitle = null;
    private ArrayList<SubTitle> mSubTitleList = new ArrayList<>();
    private String mLivePid = "";
    private String mLiveChid = "";
    private boolean mIsLocalVideo = false;
    private ArrayList<TVKLogoInfo> mLogoList = new ArrayList<>();
    protected TVKVideoInfoFromType mFromType = TVKVideoInfoFromType.FROM_TYPE_SERVER;
    private int mDanmuState = 0;
    private int mChargeState = 0;
    private int mState = 2;
    private int mDurationSec = 0;
    private long mFileSizeByte = 0;
    private long mPreviewDurationSec = 0;
    private int mPrePlayCountPerDay = 0;
    private int mRestPrePlayCount = 0;
    private int mIRetDetailCode = 0;
    private int mVst = 0;
    private int mLimit = 0;
    private int mMediaLabVR = 0;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class AdInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private String mAdPass;
        private List<PluginAdInfo> mPluginAdInfos = new ArrayList();
        private String mPluginAdInfosJson;
        private String mSessionId;

        public void addPluginAdInfo(PluginAdInfo pluginAdInfo) {
            this.mPluginAdInfos.add(pluginAdInfo);
        }

        public String getAdPass() {
            return this.mAdPass;
        }

        public List<PluginAdInfo> getPluginAdInfos() {
            return this.mPluginAdInfos;
        }

        public String getPluginAdInfosJson() {
            return this.mPluginAdInfosJson;
        }

        public String getSessionId() {
            return this.mSessionId;
        }

        public void setAdPass(String str) {
            this.mAdPass = str;
        }

        public void setPluginAdInfosJson(String str) {
            this.mPluginAdInfosJson = str;
        }

        public void setSessionId(String str) {
            this.mSessionId = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class AudioTrackInfo implements Serializable {
        public static final int AAC = 1;
        public static final int DOLBY_ATMOS = 3;
        public static final int DOLBY_SURROUND = 2;
        private static final long serialVersionUID = -1;
        private long mAudioPrePlayTimeSec;
        private String mAudioShowName;
        private String mAudioTrack;
        private int mAudioType;
        private int mFormatId;
        private boolean mIsAvsSeparate;
        private boolean mIsVipOnly;
        private String mKeyId;
        private String mM3u8;
        private int mTrackType;
        private ArrayList<String> mAudioUrlList = null;
        private String mAudioPlayUrl = null;
        private String mAction = null;

        public String getAction() {
            return this.mAction;
        }

        public String getAudioPlayUrl() {
            return this.mAudioPlayUrl;
        }

        public long getAudioPrePlayTimeSec() {
            return this.mAudioPrePlayTimeSec;
        }

        public String getAudioShowName() {
            return this.mAudioShowName;
        }

        public String getAudioTrack() {
            return this.mAudioTrack;
        }

        public int getAudioType() {
            return this.mAudioType;
        }

        public ArrayList<String> getAudioUrlList() {
            return this.mAudioUrlList;
        }

        public int getFormatId() {
            return this.mFormatId;
        }

        public String getKeyId() {
            return this.mKeyId;
        }

        public String getM3u8() {
            return this.mM3u8;
        }

        public int getTrackType() {
            return this.mTrackType;
        }

        public boolean isAvsSeparate() {
            return this.mIsAvsSeparate;
        }

        public boolean isSameAudio(AudioTrackInfo audioTrackInfo) {
            String str;
            if ((audioTrackInfo == null && TextUtils.isEmpty(this.mAudioTrack)) || ((audioTrackInfo != null && TextUtils.isEmpty(audioTrackInfo.getAudioTrack()) && TextUtils.isEmpty(this.mAudioTrack)) || (audioTrackInfo != null && (str = this.mAudioTrack) != null && str.equals(audioTrackInfo.getAudioTrack())))) {
                return true;
            }
            return false;
        }

        public boolean isVipOnly() {
            return this.mIsVipOnly;
        }

        public void setAction(String str) {
            this.mAction = str;
        }

        public void setAudioPrePlayTimeSec(long j3) {
            this.mAudioPrePlayTimeSec = j3;
        }

        public void setAudioShowName(String str) {
            this.mAudioShowName = str;
        }

        public void setAudioTrack(String str) {
            this.mAudioTrack = str;
        }

        public void setAudioType(int i3) {
            this.mAudioType = i3;
        }

        public void setAudioUrlList(ArrayList<String> arrayList) {
            this.mAudioUrlList = arrayList;
            if (arrayList != null && !arrayList.isEmpty()) {
                this.mAudioPlayUrl = this.mAudioUrlList.get(0);
            } else {
                this.mAudioPlayUrl = null;
            }
        }

        public void setFormatId(int i3) {
            this.mFormatId = i3;
        }

        public void setIsAvsSeparate(boolean z16) {
            this.mIsAvsSeparate = z16;
        }

        public void setKeyId(String str) {
            this.mKeyId = str;
        }

        public void setM3u8(String str) {
            this.mM3u8 = str;
        }

        public void setTrackType(int i3) {
            this.mTrackType = i3;
        }

        public void setVipOnly(boolean z16) {
            this.mIsVipOnly = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DefnInfo implements Serializable, Cloneable {
        private static final long serialVersionUID = -1;
        private long mAudioBandwidth;
        private int mAudioCodec;
        private String mDefn;
        private int mDefnId;
        private String mDefnName;
        private String mDefnRate;
        private String mDefnShowName;
        private int mDrm;
        private int mFeature;
        private long mFileSizeByte;
        private String mFormatDefn;
        private String mGroup;
        private int mHdr10EnHance;
        private boolean mIsAvsSeparate;
        private boolean mIsSuperResolutionNeedVip;
        private boolean mIsVipOnly;
        private List<String> mLiveAudioTrackList;
        private int mLmt;
        private String mM3u8Resolution;
        private int mRecommend;
        private int mSuperResolution;
        private int mTVMSRReasonCode;
        private int mVfps;
        private long mVideoBandwidth;
        private int mVideoCodec;
        private int mVideoSuperResolutionType;

        public Object clone() {
            try {
                return (DefnInfo) super.clone();
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public long getAudioBandwidth() {
            return this.mAudioBandwidth;
        }

        public int getAudioCodec() {
            return this.mAudioCodec;
        }

        public String getDefn() {
            return this.mDefn;
        }

        public int getDefnId() {
            return this.mDefnId;
        }

        public String getDefnName() {
            return this.mDefnShowName;
        }

        public String getDefnRate() {
            return this.mDefnRate;
        }

        public int getDrm() {
            return this.mDrm;
        }

        public int getFeature() {
            return this.mFeature;
        }

        public long getFileSizeByte() {
            return this.mFileSizeByte;
        }

        public String getFnName() {
            return this.mDefnName;
        }

        public String getFormatDefn() {
            return this.mFormatDefn;
        }

        public String getGroup() {
            return this.mGroup;
        }

        public int getHdr10EnHance() {
            return this.mHdr10EnHance;
        }

        public List<String> getLiveAudioTracks() {
            return this.mLiveAudioTrackList;
        }

        public int getLmt() {
            return this.mLmt;
        }

        public String getM3u8Resolution() {
            return this.mM3u8Resolution;
        }

        public int getRecommend() {
            return this.mRecommend;
        }

        public int getSuperResolution() {
            return this.mSuperResolution;
        }

        public int getTVMSRReasonCode() {
            return this.mTVMSRReasonCode;
        }

        public int getVfps() {
            return this.mVfps;
        }

        public long getVideoBandwidth() {
            return this.mVideoBandwidth;
        }

        public int getVideoCodec() {
            return this.mVideoCodec;
        }

        public int getVideoSuperResolutionType() {
            return this.mVideoSuperResolutionType;
        }

        public boolean isAudioOnly() {
            return "audio".equalsIgnoreCase(this.mDefn);
        }

        public boolean isAvsSeparate() {
            return this.mIsAvsSeparate;
        }

        public boolean isDrm() {
            int i3 = this.mDrm;
            if (i3 != 5 && i3 != 6 && i3 != 7) {
                return false;
            }
            return true;
        }

        public boolean isSuperResolutionNeedVip() {
            return this.mIsSuperResolutionNeedVip;
        }

        public boolean isVipOnly() {
            return this.mIsVipOnly;
        }

        public void setAudioBandwidth(long j3) {
            this.mAudioBandwidth = j3;
        }

        public void setAudioCodec(int i3) {
            this.mAudioCodec = i3;
        }

        public void setDefn(String str) {
            this.mDefn = str;
        }

        public void setDefnId(int i3) {
            this.mDefnId = i3;
        }

        public void setDefnName(String str) {
            this.mDefnShowName = str;
        }

        public void setDefnRate(String str) {
            this.mDefnRate = str;
        }

        public void setDrm(int i3) {
            this.mDrm = i3;
        }

        public void setFeature(int i3) {
            this.mFeature = i3;
        }

        public void setFileSizeByte(long j3) {
            this.mFileSizeByte = j3;
        }

        public void setFnName(String str) {
            this.mDefnName = str;
        }

        public void setFormatDefn(String str) {
            this.mFormatDefn = str;
        }

        public void setGroup(String str) {
            this.mGroup = str;
        }

        public void setHdr10EnHance(int i3) {
            this.mHdr10EnHance = i3;
        }

        public void setIsAvsSeparate(boolean z16) {
            this.mIsAvsSeparate = z16;
        }

        public void setLiveAudioTracks(List<String> list) {
            this.mLiveAudioTrackList = list;
        }

        public void setLmt(int i3) {
            this.mLmt = i3;
        }

        public void setM3u8Resolution(String str) {
            this.mM3u8Resolution = str;
        }

        public void setRecommend(int i3) {
            this.mRecommend = i3;
        }

        public void setSuperResolution(int i3) {
            this.mSuperResolution = i3;
        }

        public void setSuperResolutionNeedVip(int i3) {
            boolean z16;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsSuperResolutionNeedVip = z16;
        }

        public void setTVMSRReasonCode(int i3) {
            this.mTVMSRReasonCode = i3;
        }

        public void setVfps(int i3) {
            this.mVfps = i3;
        }

        public void setVideoBandwidth(long j3) {
            this.mVideoBandwidth = j3;
        }

        public void setVideoCodec(int i3) {
            this.mVideoCodec = i3;
        }

        public void setVideoSuperResolutionType(int i3) {
            this.mVideoSuperResolutionType = i3;
        }

        public void setVipOnly(boolean z16) {
            this.mIsVipOnly = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class EmbeddedAdDot implements Serializable {
        private static final long serialVersionUID = -1;
        private int mAdDurationMs;
        private int mEndTimeMs;
        private int mStartTimeMs;

        public int getAdDurationMs() {
            return this.mAdDurationMs;
        }

        public int getEndTimeMs() {
            return this.mEndTimeMs;
        }

        public int getStartTimeMs() {
            return this.mStartTimeMs;
        }

        public void setAdDurationMs(int i3) {
            this.mAdDurationMs = i3;
        }

        public void setEndTimeMs(int i3) {
            this.mEndTimeMs = i3;
        }

        public void setStartTimeMs(int i3) {
            this.mStartTimeMs = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class LogoPositionInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private boolean mIsLogoShow;
        private int mLogoHeight;
        private int mLogoWidth;
        private int mLogoX;
        private int mLogoY;

        public int getLogoHeight() {
            return this.mLogoHeight;
        }

        public int getLogoWidth() {
            return this.mLogoWidth;
        }

        public int getLogoX() {
            return this.mLogoX;
        }

        public int getLogoY() {
            return this.mLogoY;
        }

        public boolean isLogoShow() {
            return this.mIsLogoShow;
        }

        public void setLogShow(boolean z16) {
            this.mIsLogoShow = z16;
        }

        public void setLogoHeight(int i3) {
            this.mLogoHeight = i3;
        }

        public void setLogoWidth(int i3) {
            this.mLogoWidth = i3;
        }

        public void setLogoX(int i3) {
            this.mLogoX = i3;
        }

        public void setLogoY(int i3) {
            this.mLogoY = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class PluginAdInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private String mCid;
        private double mDurationSec;
        private double mOffsetTimeSec;
        private int mOptType;
        private int mSlotIndex;
        private double mStartTimeSec;
        private String mVid;

        public String getCid() {
            return this.mCid;
        }

        public double getDurationSec() {
            return this.mDurationSec;
        }

        public double getOffsetTimeSec() {
            return this.mOffsetTimeSec;
        }

        public int getOptType() {
            return this.mOptType;
        }

        public int getSlotIndex() {
            return this.mSlotIndex;
        }

        public double getStartTimeSec() {
            return this.mStartTimeSec;
        }

        public String getVid() {
            return this.mVid;
        }

        public void setCid(String str) {
            this.mCid = str;
        }

        public void setDurationSec(double d16) {
            this.mDurationSec = d16;
        }

        public void setOffsetTimeSec(double d16) {
            this.mOffsetTimeSec = d16;
        }

        public void setOptType(int i3) {
            this.mOptType = i3;
        }

        public void setSlotIndex(int i3) {
            this.mSlotIndex = i3;
        }

        public void setStartTimeSec(double d16) {
            this.mStartTimeSec = d16;
        }

        public void setVid(String str) {
            this.mVid = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RecommadInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private String mCid;
        private boolean mDanmuOpen;
        private String mTargetId;
        private String mVid;

        public String getCid() {
            return this.mCid;
        }

        public String getTargetId() {
            return this.mTargetId;
        }

        public String getVid() {
            return this.mVid;
        }

        public boolean isDanmuOpen() {
            return this.mDanmuOpen;
        }

        public void setCid(String str) {
            this.mCid = str;
        }

        public void setDanmuOpen(boolean z16) {
            this.mDanmuOpen = z16;
        }

        public void setTargetId(String str) {
            this.mTargetId = "targetid=" + str + "&type=2";
        }

        public void setVid(String str) {
            this.mVid = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class SubTitle implements Serializable {
        private static final long serialVersionUID = -1;
        private float mCaptionBottomHPercent;
        private float mCaptionTopHPercent;
        private boolean mIsAvsSeparate;
        private String mKeyId;
        private String mLang;
        private int mLangId;
        private String mM3u8;
        private String mName;
        private String mSubTitle;
        private int mSubtitleType;
        private List<String> mUrlList;

        public float getCaptionBottomHPercent() {
            return this.mCaptionBottomHPercent;
        }

        public float getCaptionTopHPercent() {
            return this.mCaptionTopHPercent;
        }

        public String getKeyId() {
            return this.mKeyId;
        }

        public String getLang() {
            return this.mLang;
        }

        public int getLangId() {
            return this.mLangId;
        }

        public String getM3u8() {
            return this.mM3u8;
        }

        public String getName() {
            return this.mName;
        }

        public String getSubTitle() {
            return this.mSubTitle;
        }

        public int getSubtitleType() {
            return this.mSubtitleType;
        }

        public List<String> getUrlList() {
            return this.mUrlList;
        }

        public boolean isAvsSeparate() {
            return this.mIsAvsSeparate;
        }

        public void setCaptionBottomHPercent(float f16) {
            this.mCaptionBottomHPercent = f16;
        }

        public void setCaptionTopHPercent(float f16) {
            this.mCaptionTopHPercent = f16;
        }

        public void setIsAvsSeparate(boolean z16) {
            this.mIsAvsSeparate = z16;
        }

        public void setKeyId(String str) {
            this.mKeyId = str;
        }

        public void setLang(String str) {
            this.mLang = str;
        }

        public void setLangId(int i3) {
            this.mLangId = i3;
        }

        public void setM3u8(String str) {
            this.mM3u8 = str;
        }

        public void setName(String str) {
            this.mName = str;
        }

        public void setSubTitle(String str) {
            this.mSubTitle = str;
        }

        public void setSubtitleType(int i3) {
            this.mSubtitleType = i3;
        }

        public void setUrlList(List<String> list) {
            this.mUrlList = list;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKFloatWaterMarkInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private int mFWFlag;
        private String mUKey;

        public int getFWFlag() {
            return this.mFWFlag;
        }

        public String getUKey() {
            return this.mUKey;
        }

        public void setFWFlag(int i3) {
            this.mFWFlag = i3;
        }

        public void setUKey(String str) {
            this.mUKey = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKRichMediaInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private List<String> mRichMediaFeatureList;
        private String mRichMediaUrl;

        public List<String> getRichMediaFeatureList() {
            return this.mRichMediaFeatureList;
        }

        public String getRichMediaUrl() {
            return this.mRichMediaUrl;
        }

        public void setRichMediaFeatureList(List<String> list) {
            this.mRichMediaFeatureList = list;
        }

        public void setRichMediaUrl(String str) {
            this.mRichMediaUrl = str;
        }
    }

    private boolean isVideoCodecZhenCaiShiTing(int i3) {
        if (i3 != 3 && i3 != 10 && i3 != 11 && i3 != 12 && i3 != 15 && i3 != 16 && i3 != 17 && i3 != 18 && i3 != 19 && i3 != 27) {
            return false;
        }
        return true;
    }

    public void addAudioTrack(AudioTrackInfo audioTrackInfo) {
        if (this.mAudioTrackList == null) {
            this.mAudioTrackList = new ArrayList<>();
        }
        this.mAudioTrackList.add(audioTrackInfo);
    }

    public void addDefinition(DefnInfo defnInfo) {
        this.mDefinitionList.add(defnInfo);
    }

    public void addEmbeddedAdDot(EmbeddedAdDot embeddedAdDot) {
        this.mEmbeddedAdDotList.add(embeddedAdDot);
    }

    public void addLogoInfo(TVKLogoInfo tVKLogoInfo) {
        this.mLogoList.add(tVKLogoInfo);
    }

    public void addSubTitle(SubTitle subTitle) {
        this.mSubTitleList.add(subTitle);
    }

    public void addVideoDownloadHostItem(Integer num, String str) {
        this.mVideoDownloadHostMap.put(num, str);
    }

    public Map<String, Integer> getAbTestInfo() {
        return this.mAbTestInfo;
    }

    public AdInfo getAdInfo() {
        return this.mAdInfo;
    }

    public AudioTrackInfo getAudioTrackByTrackName(String str) {
        ArrayList<AudioTrackInfo> arrayList;
        if (!TextUtils.isEmpty(str) && (arrayList = this.mAudioTrackList) != null && arrayList.size() != 0) {
            Iterator<AudioTrackInfo> it = this.mAudioTrackList.iterator();
            while (it.hasNext()) {
                AudioTrackInfo next = it.next();
                if (next.mAudioTrack.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public List<AudioTrackInfo> getAudioTrackList() {
        return this.mAudioTrackList;
    }

    public int getBandwidthLevel() {
        return this.mBandwidthLevel;
    }

    public String getBizExt() {
        return this.mBizExt;
    }

    public int getCached() {
        return this.mCached;
    }

    public String getCastSet() {
        return this.mCastSet;
    }

    public Map<String, String> getCdnHttpHeaders() {
        return this.mCdnHttpHeaders;
    }

    public int getCdnOrigin() {
        return this.mCdnOrigin;
    }

    public AudioTrackInfo getCurAudioTrack() {
        return this.mCurAudioTrack;
    }

    public DefnInfo getCurDefinition() {
        return this.mCurDefinition;
    }

    public SubTitle getCurSubtitle() {
        return this.mCurSubtitle;
    }

    public int getDanmuState() {
        return this.mDanmuState;
    }

    @NonNull
    public List<DefnInfo> getDefinitionList() {
        return this.mDefinitionList;
    }

    public String getDotInfo() {
        return this.mDotInfo;
    }

    public int getDurationSec() {
        return this.mDurationSec;
    }

    public TVKDynamicsLogoInfo getDynamicLogo() {
        return this.mLiveDynLogo;
    }

    public List<EmbeddedAdDot> getEmbeddedAdDotList() {
        return this.mEmbeddedAdDotList;
    }

    public String getErrInfo() {
        return this.mErrInfo;
    }

    public String getErrtitle() {
        return this.mErrTitle;
    }

    public int getExem() {
        return this.mExem;
    }

    public long getFileSizeByte() {
        return this.mFileSizeByte;
    }

    public TVKFloatWaterMarkInfo getFloatWaterMarkInfo() {
        return this.mFloatWaterMarkInfo;
    }

    public int getFp2p() {
        return this.mFp2p;
    }

    public String getFps() {
        return this.mFps;
    }

    public TVKVideoInfoFromType getFromType() {
        return this.mFromType;
    }

    public int getFvideo() {
        return this.mFvideo;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getIretDetailCode() {
        return this.mIRetDetailCode;
    }

    public int getLimit() {
        return this.mLimit;
    }

    public String getLiveChid() {
        return this.mLiveChid;
    }

    public long getLiveCurrentPreviewDurationSec() {
        return this.mLiveCurrentPreviewDurationSec;
    }

    public String getLivePid() {
        return this.mLivePid;
    }

    public String getLnk() {
        return this.mLnk;
    }

    public ArrayList<TVKLogoInfo> getLogoList() {
        return this.mLogoList;
    }

    public LogoPositionInfo getLogoPositionInfo() {
        return this.mLogoPositionInfo;
    }

    public long getMaxBitrate() {
        return this.mMaxBitrate;
    }

    public int getMediaLabVR() {
        return this.mMediaLabVR;
    }

    public int getMediaVideoState() {
        return this.mMediaVideoState;
    }

    public int getMediaVideoType() {
        return this.mVideoType;
    }

    public int getMshot() {
        return this.mMshot;
    }

    public String getPLString() {
        return this.mPLString;
    }

    public int getPLType() {
        return this.mPLType;
    }

    public int getPayCh() {
        return this.mChargeState;
    }

    public Object getPictureList() {
        return this.mPicList;
    }

    public long getPlayBackStartSec() {
        return this.mPlayBackStartSec;
    }

    public long getPlayBackTimeSec() {
        return this.mPlayBackTimeSec;
    }

    public String getPlayExperienceLevel() {
        return this.mPlayExperienceLevel;
    }

    public int getPrePlayCountPerDay() {
        return this.mPrePlayCountPerDay;
    }

    public long getPreviewDurationSec() {
        return this.mPreviewDurationSec;
    }

    public long getPreviewStartPositionSec() {
        return this.mPreviewStartPositionSec;
    }

    public int getPttn() {
        return this.mPttn;
    }

    public String getPureVid() {
        return this.mPureVid;
    }

    public int getQueueRank() {
        return this.mQueueRank;
    }

    public String getQueueSessionKey() {
        return this.mQueueSessionKey;
    }

    public int getQueueStatus() {
        return this.mQueueStatus;
    }

    public int getQueueVipJump() {
        return this.mQueueVipJump;
    }

    public String getReport() {
        return this.mReport;
    }

    public int getRestPrePlayCount() {
        return this.mRestPrePlayCount;
    }

    public int getRetCode() {
        return this.mRetCode;
    }

    public String getSeReport() {
        return this.mSeReport;
    }

    public String getSescy() {
        return this.mSescy;
    }

    public String getSignature() {
        return this.mSignature;
    }

    public int getSkipEndPositionSec() {
        return this.mSkipEndPositionSec;
    }

    public String getSse() {
        return this.mSse;
    }

    public int getSshot() {
        return this.mSshot;
    }

    public int getSt() {
        return this.mState;
    }

    public int getStartPositionSec() {
        return this.mStartPositionSec;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStrategyParamExtInfo() {
        return this.mStrategyParamExtInfo;
    }

    public int getStreamSecret() {
        return this.mStreamSecret;
    }

    public int getSubErrType() {
        return this.mSubErrType;
    }

    public SubTitle getSubIndex(String str) {
        Iterator<SubTitle> it = this.mSubTitleList.iterator();
        while (it.hasNext()) {
            SubTitle next = it.next();
            if (next.getLang() != null && next.getLang().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    public ArrayList<SubTitle> getSubTitleList() {
        return this.mSubTitleList;
    }

    public long getSvrTick() {
        return this.mSvrTick;
    }

    public TVKRichMediaInfo getTVKRichMediaInfo() {
        return this.mTVKRichMediaInfo;
    }

    public String getTestBucket() {
        return this.mTestBucket;
    }

    public int getTestId() {
        return this.mTestId;
    }

    public int getTie() {
        return this.mTie;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getTotalDurationMs() {
        return this.mTotalDurationMs;
    }

    public String getVid() {
        return this.mVid;
    }

    public HashMap<Integer, String> getVideoDownloadHostMap() {
        return this.mVideoDownloadHostMap;
    }

    public String getVodEncryption() {
        return this.mVodEncryption;
    }

    public String getVodLogoActionUrl() {
        return this.mVodLogoActionUrl;
    }

    public int getVst() {
        return this.mVst;
    }

    public float getWHRadio() {
        return this.mWHRadio;
    }

    public String getWanIP() {
        return this.mWanIP;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public String getXml() {
        return this.mXml;
    }

    public boolean isAntiScreenShot() {
        int i3 = this.mSshot;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public boolean isDolbyVision() {
        DefnInfo defnInfo = this.mCurDefinition;
        if (defnInfo == null || TextUtils.isEmpty(defnInfo.getDefn()) || this.mCurDefinition.getVideoCodec() != 4) {
            return false;
        }
        return true;
    }

    public boolean isFreeNetFlowUrl() {
        return this.mIsFreeNetFlowUrl;
    }

    public boolean isHDR() {
        DefnInfo defnInfo = this.mCurDefinition;
        if (defnInfo == null || TextUtils.isEmpty(defnInfo.getDefn())) {
            return false;
        }
        int videoCodec = this.mCurDefinition.getVideoCodec();
        if (videoCodec != 3 && videoCodec != 10 && videoCodec != 11 && videoCodec != 12 && videoCodec != 19 && videoCodec != 27) {
            return false;
        }
        return true;
    }

    public boolean isHevc() {
        return this.mIsHevc;
    }

    public boolean isLocalVideo() {
        return this.mIsLocalVideo;
    }

    @Deprecated
    public boolean isLowDefinitionOpen() {
        return false;
    }

    public boolean isMatchDrmType(int i3) {
        DefnInfo defnInfo = this.mCurDefinition;
        if (defnInfo == null || defnInfo.getDrm() != i3) {
            return false;
        }
        return true;
    }

    public boolean isPreview() {
        return false;
    }

    public boolean isVvc() {
        return this.mIsVvc;
    }

    public boolean isZhenCaiShiTingDefinition() {
        DefnInfo defnInfo = this.mCurDefinition;
        if (defnInfo == null) {
            return false;
        }
        String defn = defnInfo.getDefn();
        if (TextUtils.isEmpty(defn)) {
            return false;
        }
        if (!defn.equals("hdr10") && !defn.equals(TVKDefinitionType.DEFINITION_TYPE_SUHD)) {
            return false;
        }
        return isVideoCodecZhenCaiShiTing(this.mCurDefinition.getVideoCodec());
    }

    public void removeAudioTrack(AudioTrackInfo audioTrackInfo) {
        ArrayList<AudioTrackInfo> arrayList = this.mAudioTrackList;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(audioTrackInfo);
    }

    public void removeDefinition(DefnInfo defnInfo) {
        this.mDefinitionList.remove(defnInfo);
    }

    public void setAbTestInfo(Map<String, Integer> map) {
        this.mAbTestInfo = map;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.mAdInfo = adInfo;
    }

    public void setBandwidthLevel(int i3) {
        this.mBandwidthLevel = i3;
    }

    public void setBizExt(String str) {
        this.mBizExt = str;
    }

    public void setCached(int i3) {
        this.mCached = i3;
    }

    public void setCastSet(String str) {
        this.mCastSet = str;
    }

    public void setCdnHttpHeaders(Map<String, String> map) {
        this.mCdnHttpHeaders = map;
    }

    public void setCdnOrigin(int i3) {
        this.mCdnOrigin = i3;
    }

    public void setCurAudioTrack(AudioTrackInfo audioTrackInfo) {
        this.mCurAudioTrack = audioTrackInfo;
    }

    public void setCurDefinition(DefnInfo defnInfo) {
        this.mCurDefinition = defnInfo;
    }

    public void setCurSubtitle(SubTitle subTitle) {
        this.mCurSubtitle = subTitle;
    }

    public void setDanmuState(int i3) {
        this.mDanmuState = i3;
    }

    public void setDotInfo(String str) {
        this.mDotInfo = str;
    }

    public void setDurationSec(int i3) {
        this.mDurationSec = i3;
    }

    public void setDynamicLogo(TVKDynamicsLogoInfo tVKDynamicsLogoInfo) {
        this.mLiveDynLogo = tVKDynamicsLogoInfo;
    }

    public void setErrInfo(String str) {
        this.mErrInfo = str;
    }

    public void setErrtitle(String str) {
        this.mErrTitle = str;
    }

    public void setExem(int i3) {
        this.mExem = i3;
    }

    public void setFileSizeByte(long j3) {
        this.mFileSizeByte = j3;
    }

    public void setFloatWaterMarkInfo(TVKFloatWaterMarkInfo tVKFloatWaterMarkInfo) {
        this.mFloatWaterMarkInfo = tVKFloatWaterMarkInfo;
    }

    public void setFp2p(int i3) {
        this.mFp2p = i3;
    }

    public void setFps(String str) {
        this.mFps = str;
    }

    public void setFreeNetFlowUrl(boolean z16) {
        this.mIsFreeNetFlowUrl = z16;
    }

    public void setFromType(TVKVideoInfoFromType tVKVideoInfoFromType) {
        this.mFromType = tVKVideoInfoFromType;
    }

    public void setFvideo(int i3) {
        this.mFvideo = i3;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
    }

    public void setIretDetailCode(int i3) {
        this.mIRetDetailCode = i3;
    }

    public void setIsHevc(boolean z16) {
        this.mIsHevc = z16;
    }

    public void setIsVvc(boolean z16) {
        this.mIsVvc = z16;
    }

    public void setLimit(int i3) {
        this.mLimit = i3;
    }

    public void setLiveChid(String str) {
        this.mLiveChid = str;
    }

    public void setLiveCurrentPreviewDurationSec(long j3) {
        this.mLiveCurrentPreviewDurationSec = j3;
    }

    public void setLivePid(String str) {
        this.mLivePid = str;
    }

    public void setLnk(String str) {
        this.mLnk = str;
    }

    public void setLocalVideo(boolean z16) {
        this.mIsLocalVideo = z16;
    }

    public void setLogoPositionInfo(LogoPositionInfo logoPositionInfo) {
        this.mLogoPositionInfo = logoPositionInfo;
    }

    public void setMaxBitrate(long j3) {
        this.mMaxBitrate = j3;
    }

    public void setMediaLabVR(int i3) {
        this.mMediaLabVR = i3;
    }

    public void setMediaVideoState(int i3) {
        this.mMediaVideoState = i3;
    }

    public void setMediaVideoType(int i3) {
        this.mVideoType = i3;
    }

    public void setMshot(int i3) {
        this.mMshot = i3;
    }

    public void setPLString(String str) {
        this.mPLString = str;
    }

    public void setPLType(int i3) {
        this.mPLType = i3;
    }

    public void setPayCh(int i3) {
        this.mChargeState = i3;
    }

    public void setPictureList(Object obj) {
        this.mPicList = obj;
    }

    public void setPlayBackStartSec(long j3) {
        this.mPlayBackStartSec = j3;
    }

    public void setPlayBackTimeSec(long j3) {
        this.mPlayBackTimeSec = j3;
    }

    public void setPlayExperienceLevel(String str) {
        this.mPlayExperienceLevel = str;
    }

    public void setPrePlayCountPerDay(int i3) {
        this.mPrePlayCountPerDay = i3;
    }

    public void setPreviewDurationSec(long j3) {
        this.mPreviewDurationSec = j3;
    }

    public void setPreviewStartPositionSec(long j3) {
        this.mPreviewStartPositionSec = j3;
    }

    public void setPttn(int i3) {
        this.mPttn = i3;
    }

    public void setPureVid(String str) {
        this.mPureVid = str;
    }

    public void setQueueRank(int i3) {
        this.mQueueRank = i3;
    }

    public void setQueueSessionKey(String str) {
        this.mQueueSessionKey = str;
    }

    public void setQueueStatus(int i3) {
        this.mQueueStatus = i3;
    }

    public void setQueueVipJump(int i3) {
        this.mQueueVipJump = i3;
    }

    public void setReport(String str) {
        this.mReport = str;
    }

    public void setRestPrePlayCount(int i3) {
        this.mRestPrePlayCount = i3;
    }

    public void setRetCode(int i3) {
        this.mRetCode = i3;
    }

    public void setSeReport(String str) {
        this.mSeReport = str;
    }

    public void setSescy(String str) {
        this.mSescy = str;
    }

    public void setSignature(String str) {
        this.mSignature = str;
    }

    public void setSkipEndPositionSec(int i3) {
        this.mSkipEndPositionSec = i3;
    }

    public void setSse(String str) {
        this.mSse = str;
    }

    public void setSshot(int i3) {
        this.mSshot = i3;
    }

    public void setSt(int i3) {
        this.mState = i3;
    }

    public void setStartPositionSec(int i3) {
        this.mStartPositionSec = i3;
    }

    public void setStatus(int i3) {
        this.mStatus = i3;
    }

    public void setStrategyParamExtInfo(String str) {
        this.mStrategyParamExtInfo = str;
    }

    public void setStreamSecret(int i3) {
        this.mStreamSecret = i3;
    }

    public void setSubErrType(int i3) {
        this.mSubErrType = i3;
    }

    public void setSvrTick(long j3) {
        this.mSvrTick = j3;
    }

    public void setTVKRichMediaInfo(TVKRichMediaInfo tVKRichMediaInfo) {
        this.mTVKRichMediaInfo = tVKRichMediaInfo;
    }

    public void setTestBucket(String str) {
        this.mTestBucket = str;
    }

    public void setTestId(int i3) {
        this.mTestId = i3;
    }

    public void setTie(int i3) {
        this.mTie = i3;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTotalDurationMs(long j3) {
        this.mTotalDurationMs = j3;
    }

    public void setVid(String str) {
        this.mVid = str;
    }

    public void setVodEncryption(String str) {
        this.mVodEncryption = str;
    }

    public void setVodLogoActionUrl(String str) {
        this.mVodLogoActionUrl = str;
    }

    public void setVst(int i3) {
        this.mVst = i3;
    }

    public void setWHRadio(float f16) {
        this.mWHRadio = f16;
    }

    public void setWanIP(String str) {
        this.mWanIP = str;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
    }

    public void setXml(String str) {
        this.mXml = str;
    }
}
