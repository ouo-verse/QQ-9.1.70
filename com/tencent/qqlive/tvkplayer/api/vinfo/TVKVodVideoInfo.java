package com.tencent.qqlive.tvkplayer.api.vinfo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodVideoInfo extends TVKNetVideoInfo {
    public static final int CGI_CODE_CKEY_VERIFY_FAILED = 85;
    public static final int DRM_PAY_TYPE_NONE = 0;
    public static final int EXEM_DEFN_LIMIT = 3;
    public static final int OFFLINE_QUERY_SERVICE_ABNORMAL = 2;
    public static final int OFFLINE_QUERY_SERVICE_IDLE = 0;
    public static final int OFFLINE_QUERY_SERVICE_NORMAL = 1;
    public static final int SUCCESS = 0;
    private static final long serialVersionUID = -1;
    private String mAdsid;
    private String[] mBakPlayUrl;
    private String mBase;
    private int mBitrate;
    private String mCid;
    private String mCkc;
    private String[] mClipUrl;
    private int mCt;
    private TVKDarkLogoInfo mDarkLogoInfo;
    private int mDownloadType;
    private long mExpirationTimeSec;
    private String mFileName;
    private String mHlsKeyid;
    private boolean mIsQuickPlay;
    private String mM3u8;
    private DirectM3u8Info mMasterM3u8Info;
    private String mPlayUrl;
    private String mPollingServiceUrl;
    private int mPreviewClipCount;
    private float mSubtitleNadir;
    private int mSwhdcp;
    private long mTm;
    private int mType;
    private int mVideoType;
    private String mVodAnimationUrl;
    private int mCgiCode = 0;
    private int mModuleCode = 0;
    private ArrayList<String> mCdnUrlList = new ArrayList<>();
    private ArrayList<ReferUrl> mUrlList = new ArrayList<>();
    private String mVKey = "";
    private String mSha = "";
    private String mTargetId = "";
    private int mIFlag = 0;
    private int mDrmType = 0;
    private int mEnc = 0;
    private int mSectionNum = 0;
    private ArrayList<Section> mSectionList = new ArrayList<>();
    private final List<TVKVideoPcdnInfo> mPcdnInfos = new ArrayList();
    private final List<TVKVideoMultiNetUrlInfo> mMultiNetUrlInfos = new ArrayList();
    private final List<DirectM3u8Info> mAudioM3u8List = new ArrayList();
    private final List<DirectM3u8Info> mVideoM3u8List = new ArrayList();
    private final List<DirectM3u8Info> mSubTitleM3u8List = new ArrayList();
    private final List<TVKAudioEffectModel> mAudioEffectList = new ArrayList();
    private SimulatedLiveInfo mSimulatedLiveInfo = new SimulatedLiveInfo();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DirectM3u8Info implements Serializable {
        private static final long serialVersionUID = -1;
        private String mKeyId;
        private String mM3u8Content;
        private String mM3u8Url;

        public String getKeyId() {
            return this.mKeyId;
        }

        public String getM3u8Content() {
            return this.mM3u8Content;
        }

        public String getM3u8Url() {
            return this.mM3u8Url;
        }

        public void setKeyId(String str) {
            this.mKeyId = str;
        }

        public void setM3u8Content(String str) {
            this.mM3u8Content = str;
        }

        public void setM3u8Url(String str) {
            this.mM3u8Url = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ReferUrl implements Serializable {
        private static final long serialVersionUID = -1;
        private String mHk;
        private String mPath;
        private String mPt;
        private String mSpip;
        private String mSpport;
        private String mUrl = "";
        private int mVt;

        public String getHk() {
            return this.mHk;
        }

        public String getPath() {
            return this.mPath;
        }

        public String getPt() {
            return this.mPt;
        }

        public String getSpip() {
            return this.mSpip;
        }

        public String getSpport() {
            return this.mSpport;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public int getVt() {
            return this.mVt;
        }

        public void setHk(String str) {
            this.mHk = str;
        }

        public void setPath(String str) {
            this.mPath = str;
        }

        public void setPt(String str) {
            this.mPt = str;
        }

        public void setSpip(String str) {
            this.mSpip = str;
        }

        public void setSpport(String str) {
            this.mSpport = str;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }

        public void setVt(int i3) {
            this.mVt = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Section implements Serializable {
        private static final long serialVersionUID = -1;
        private String mCmd5;
        private double mDurationSec;
        private int mIdx;
        private String mIndexName;
        private int mSize;
        private String mUrl;
        private final List<String> mUrlList = new ArrayList();
        private String mVbkey;
        private String mVbkeyId;

        public String getCmd5() {
            return this.mCmd5;
        }

        public double getDurationSec() {
            return this.mDurationSec;
        }

        public int getIdx() {
            return this.mIdx;
        }

        public String getIndexName() {
            return this.mIndexName;
        }

        public int getSize() {
            return this.mSize;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public List<String> getUrlList() {
            return this.mUrlList;
        }

        public String getVbkey() {
            return this.mVbkey;
        }

        public String getVbkeyId() {
            return this.mVbkeyId;
        }

        public void setCmd5(String str) {
            this.mCmd5 = str;
        }

        public void setDurationSec(double d16) {
            this.mDurationSec = d16;
        }

        public void setIdx(int i3) {
            this.mIdx = i3;
        }

        public void setIndexName(String str) {
            this.mIndexName = str;
        }

        public void setSize(int i3) {
            this.mSize = i3;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }

        public void setUrlList(List<String> list) {
            this.mUrlList.addAll(list);
        }

        public void setVbkey(String str) {
            this.mVbkey = str;
        }

        public void setVbkeyId(String str) {
            this.mVbkeyId = str;
        }

        public void setIndexName(String str, int i3) {
            this.mIndexName = str.replace(".mp4", "") + "." + i3 + ".mp4";
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class SimulatedLiveInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private long mCurrentPositionSec;
        private String mExtInfo = "";
        private String mChid = "";
        private final List<String> mVidList = new ArrayList();

        public void addVid(String str) {
            this.mVidList.add(str);
        }

        public String getChid() {
            return this.mChid;
        }

        public long getCurrentPositionSec() {
            return this.mCurrentPositionSec;
        }

        public String getExtInfo() {
            return this.mExtInfo;
        }

        public List<String> getVidList() {
            return this.mVidList;
        }

        public void setChid(String str) {
            this.mChid = str;
        }

        public void setCurrentPositionSec(long j3) {
            this.mCurrentPositionSec = j3;
        }

        public void setExtInfo(String str) {
            this.mExtInfo = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKAudioEffectModel implements Serializable {
        public static final String AUDIO_EFFECT_NAME_CLEAR_VOICE = "clear_voice";
        public static final String AUDIO_EFFECT_NAME_LIVE_CONCERT = "live_concert";
        public static final String AUDIO_EFFECT_NAME_PANO_SURROUND = "pano_surround";
        public static final String AUDIO_EFFECT_NAME_SURROUND = "surround";
        private static final long serialVersionUID = -1;
        private String mEffectFilterParam;
        private String mEffectName;
        private String mEffectShowName;
        private int mVipLimit;

        public String getEffectFilterParam() {
            return this.mEffectFilterParam;
        }

        public String getEffectName() {
            return this.mEffectName;
        }

        public String getEffectShowName() {
            return this.mEffectShowName;
        }

        public int getVipLimit() {
            return this.mVipLimit;
        }

        public void setEffectFilterParam(String str) {
            this.mEffectFilterParam = str;
        }

        public void setEffectName(String str) {
            this.mEffectName = str;
        }

        public void setEffectShowName(String str) {
            this.mEffectShowName = str;
        }

        public void setVipLimit(int i3) {
            this.mVipLimit = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKVideoMultiNetUrlInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private String mUrl = "";
        private int mVt;

        public String getUrl() {
            return this.mUrl;
        }

        public int getVt() {
            return this.mVt;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }

        public void setVt(int i3) {
            this.mVt = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKVideoPcdnInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private String mUrl = "";
        private int mVt;

        public String getUrl() {
            return this.mUrl;
        }

        public int getVt() {
            return this.mVt;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }

        public void setVt(int i3) {
            this.mVt = i3;
        }
    }

    public void addAudioEffectInfo(TVKAudioEffectModel tVKAudioEffectModel) {
        this.mAudioEffectList.add(tVKAudioEffectModel);
    }

    public void addAudioM3u8Info(DirectM3u8Info directM3u8Info) {
        this.mAudioM3u8List.add(directM3u8Info);
    }

    public void addMultiNetUrlInfos(TVKVideoMultiNetUrlInfo tVKVideoMultiNetUrlInfo) {
        this.mMultiNetUrlInfos.add(tVKVideoMultiNetUrlInfo);
    }

    public void addPcdnInfos(TVKVideoPcdnInfo tVKVideoPcdnInfo) {
        this.mPcdnInfos.add(tVKVideoPcdnInfo);
    }

    public void addReferUrlItem(int i3, ReferUrl referUrl) {
        if (referUrl != null) {
            Pattern compile = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
            if (referUrl.getUrl() != null && !TextUtils.isEmpty(referUrl.getUrl())) {
                Matcher matcher = compile.matcher(referUrl.getUrl());
                if (matcher.find() && matcher.group() != null) {
                    addVideoDownloadHostItem(Integer.valueOf(i3), matcher.group());
                }
            }
        }
        this.mUrlList.add(referUrl);
    }

    public void addSectionItem(Section section) {
        this.mSectionList.add(section);
    }

    public void addSubTitleM3u8Info(DirectM3u8Info directM3u8Info) {
        this.mSubTitleM3u8List.add(directM3u8Info);
    }

    public void addVideoM3u8Info(DirectM3u8Info directM3u8Info) {
        this.mVideoM3u8List.add(directM3u8Info);
    }

    public String getAdsid() {
        return this.mAdsid;
    }

    @NonNull
    public List<TVKAudioEffectModel> getAudioEffectList() {
        return this.mAudioEffectList;
    }

    @NonNull
    public List<DirectM3u8Info> getAudioM3u8List() {
        return this.mAudioM3u8List;
    }

    public String[] getBakPlayUrl() {
        return this.mBakPlayUrl;
    }

    public String getBase() {
        return this.mBase;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public ArrayList<String> getCdnUrlList() {
        return this.mCdnUrlList;
    }

    public int getCgiCode() {
        return this.mCgiCode;
    }

    public String getCid() {
        return this.mCid;
    }

    public String getCkc() {
        return this.mCkc;
    }

    public String[] getClipUrl() {
        return this.mClipUrl;
    }

    public int getCt() {
        return this.mCt;
    }

    public TVKDarkLogoInfo getDarkLogoInfo() {
        return this.mDarkLogoInfo;
    }

    public int getDownloadType() {
        return this.mDownloadType;
    }

    public int getDrm() {
        return this.mDrmType;
    }

    public int getEnc() {
        return this.mEnc;
    }

    public long getExpirationTimeSec() {
        return this.mExpirationTimeSec;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFirstCdnHlsPlayUrl() {
        if (this.mUrlList.size() > 0) {
            ReferUrl referUrl = this.mUrlList.get(0);
            return referUrl.getUrl() + referUrl.getPt();
        }
        return null;
    }

    public int getFirstCdnId() {
        if (this.mUrlList.size() <= 0) {
            return 0;
        }
        return getUrlList().get(0).getVt();
    }

    public String getFirstCdnServer() {
        if (this.mUrlList.size() > 0) {
            return getUrlList().get(0).getUrl();
        }
        return null;
    }

    public int getIFlag() {
        return this.mIFlag;
    }

    public String getKeyid() {
        return this.mHlsKeyid;
    }

    public String getM3u8() {
        return this.mM3u8;
    }

    public DirectM3u8Info getMasterM3u8Info() {
        return this.mMasterM3u8Info;
    }

    public int getModuleCode() {
        return this.mModuleCode;
    }

    public List<TVKVideoMultiNetUrlInfo> getMultiNetUrlInfos() {
        return this.mMultiNetUrlInfos;
    }

    public List<TVKVideoPcdnInfo> getPcdnInfos() {
        return this.mPcdnInfos;
    }

    public String getPlayUrl() {
        if (TextUtils.isEmpty(this.mPlayUrl)) {
            return "";
        }
        return this.mPlayUrl;
    }

    public String getPollingServiceUrl() {
        return this.mPollingServiceUrl;
    }

    public int getPreviewClipCount() {
        return this.mPreviewClipCount;
    }

    public List<Section> getSectionList() {
        return this.mSectionList;
    }

    public int getSectionNum() {
        return this.mSectionNum;
    }

    public String getSelectedDefn() {
        if (getCurDefinition() == null) {
            return "";
        }
        return getCurDefinition().getDefn();
    }

    public int getSelectedDefnId() {
        if (getCurDefinition() == null) {
            return 0;
        }
        return getCurDefinition().getDefnId();
    }

    public long getSelectedFileSizeByte() {
        if (getCurDefinition() == null) {
            return 0L;
        }
        return getCurDefinition().getFileSizeByte();
    }

    public String getSha() {
        return this.mSha;
    }

    public SimulatedLiveInfo getSimulatedLiveInfo() {
        return this.mSimulatedLiveInfo;
    }

    @NonNull
    public List<DirectM3u8Info> getSubTitleM3u8List() {
        return this.mSubTitleM3u8List;
    }

    public float getSubtitleNadir() {
        return this.mSubtitleNadir;
    }

    public int getSwhdcp() {
        return this.mSwhdcp;
    }

    public String getTargetId() {
        return this.mTargetId;
    }

    public long getTm() {
        return this.mTm;
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<ReferUrl> getUrlList() {
        return this.mUrlList;
    }

    public String getVKey() {
        return this.mVKey;
    }

    @NonNull
    public List<DirectM3u8Info> getVideoM3u8List() {
        return this.mVideoM3u8List;
    }

    public int getVideoType() {
        return this.mVideoType;
    }

    @Nullable
    public String getVodAnimationUrl() {
        return this.mVodAnimationUrl;
    }

    public boolean isHLSDownloadType() {
        if (this.mDownloadType == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo
    public boolean isPreview() {
        if (getExem() <= 0 && getSt() != 8) {
            return false;
        }
        return true;
    }

    public boolean isQuickPlay() {
        return this.mIsQuickPlay;
    }

    public void setAdsid(String str) {
        this.mAdsid = str;
    }

    public void setBakPlayUrl(String[] strArr) {
        this.mBakPlayUrl = strArr;
    }

    public void setBase(String str) {
        this.mBase = str;
    }

    public void setBitrate(int i3) {
        this.mBitrate = i3;
    }

    public void setCdnUrlList(ArrayList<String> arrayList) {
        this.mCdnUrlList = arrayList;
    }

    public void setCgiCode(int i3) {
        this.mCgiCode = i3;
    }

    public void setCid(String str) {
        this.mCid = str;
    }

    public void setCkc(String str) {
        this.mCkc = str;
    }

    public void setClipUrl(String[] strArr) {
        this.mClipUrl = strArr;
    }

    public void setCt(int i3) {
        this.mCt = i3;
    }

    public void setDarkLogoInfo(TVKDarkLogoInfo tVKDarkLogoInfo) {
        this.mDarkLogoInfo = tVKDarkLogoInfo;
    }

    public void setDownloadType(int i3) {
        this.mDownloadType = i3;
    }

    public void setDrm(int i3) {
        this.mDrmType = i3;
    }

    public void setEnc(int i3) {
        this.mEnc = i3;
    }

    public void setExpirationTimeSec(long j3) {
        this.mExpirationTimeSec = j3;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setIFlag(int i3) {
        this.mIFlag = i3;
    }

    public void setKeyid(String str) {
        this.mHlsKeyid = str;
    }

    public void setM3u8(String str) {
        this.mM3u8 = str;
    }

    public void setMasterM3u8Info(DirectM3u8Info directM3u8Info) {
        this.mMasterM3u8Info = directM3u8Info;
    }

    public void setModuleCode(int i3) {
        this.mModuleCode = i3;
    }

    public void setPlayUrl(String str) {
        this.mPlayUrl = str;
    }

    public void setPollingServiceUrl(String str) {
        this.mPollingServiceUrl = str;
    }

    public void setPreviewClipCount(int i3) {
        this.mPreviewClipCount = i3;
    }

    public void setQuickPlay(boolean z16) {
        this.mIsQuickPlay = z16;
    }

    public void setSectionNum(int i3) {
        this.mSectionNum = i3;
    }

    public void setSha(String str) {
        this.mSha = str;
    }

    public void setSimulatedLiveInfo(SimulatedLiveInfo simulatedLiveInfo) {
        this.mSimulatedLiveInfo = simulatedLiveInfo;
    }

    public void setSubtitleNadir(float f16) {
        this.mSubtitleNadir = f16;
    }

    public void setSwhdcp(int i3) {
        this.mSwhdcp = i3;
    }

    public void setTargetId(String str) {
        this.mTargetId = str;
    }

    public void setTm(long j3) {
        this.mTm = j3;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public void setVKey(String str) {
        this.mVKey = str;
    }

    public void setVideoType(int i3) {
        this.mVideoType = i3;
    }

    public void setVodAnimationUrl(String str) {
        this.mVodAnimationUrl = str;
    }
}
