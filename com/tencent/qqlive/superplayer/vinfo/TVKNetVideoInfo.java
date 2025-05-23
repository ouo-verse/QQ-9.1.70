package com.tencent.qqlive.superplayer.vinfo;

import android.text.TextUtils;
import com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKNetVideoInfo implements Serializable {
    public static final int AUDIO_CODEC_FORMAT_AAC = 1;
    public static final int AUDIO_CODEC_FORMAT_DOLBY_ATMOS = 3;
    public static final int AUDIO_CODEC_FORMAT_DOLBY_SURROUND = 2;
    public static final String FORMAT_AUDIO = "audio";
    public static final String FORMAT_FHD = "fhd";
    public static final String FORMAT_HD = "hd";
    public static final String FORMAT_HDR10 = "hdr10";
    public static final String FORMAT_MP4 = "mp4";
    public static final String FORMAT_MSD = "msd";
    public static final String FORMAT_SD = "sd";
    public static final String FORMAT_SHD = "shd";
    public static final int TYPE_JSON = 1;
    public static final int TYPE_PICTURE_NODE = 3;
    public static final int TYPE_XML = 2;
    public static final int VIDEO_CODEC_FORMAT_AUDIO = 5;
    public static final int VIDEO_CODEC_FORMAT_DOLLBYVISION = 4;
    public static final int VIDEO_CODEC_FORMAT_H264 = 1;
    public static final int VIDEO_CODEC_FORMAT_H265 = 2;
    public static final int VIDEO_CODEC_FORMAT_HDR10 = 3;
    public static final int VIDEO_CODEC_FORMAT_SDR = 7;
    public static final int VIDEO_CODEC_FORMAT_SDRPLUS = 6;
    public static final int VIDEO_HDR_TONEMAPPING_SUPPORT = 1;
    private static final long serialVersionUID = -1;
    private ArrayList<AudioTrackInfo> mAudioTrackList;
    private TVKCGIVideoInfo mCGIVideoInfo;
    private AudioTrackInfo mCurAudioTrack;
    private DefnInfo mCurDefinition;
    private ArrayList<DefnInfo> mDefinitionList;
    private int mEndPos;
    private String mErrInfo;
    private String mErrTitle;
    private int mExem;
    private int mHlsP2p;
    private boolean mIsHevc;
    private String mLnk;
    private int mMediaVideoState;
    private String mPLString;
    private Object mPicList;
    private long mPlayBackStart;
    private long mPlayBackTime;
    private long mPlayTime;
    private long mPrePlayEndPos;
    private long mPrePlayStartPos;
    private int mQueueRank;
    private String mQueueSessionKey;
    private int mQueueStatus;
    private int mQueueVipJump;
    private int mRetCode;
    private int mStartPos;
    private int mStatus;
    private int mSubErrType;
    private long mSvrTick;
    private int mTestId;
    private int mTie;
    private String mTitle;
    private String mVid;
    private int mVideoType;
    private float mWHRadio;
    private String mWanIP;
    private ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> mWatermarkInfos;
    private int mPLType = 0;
    private HashMap<Integer, String> mVideoDownloadHostMap = new HashMap<>();
    private boolean mIsLocalVideo = false;
    private SubTitle mCurSubtitle = null;
    private ArrayList<SubTitle> mSubTitleList = new ArrayList<>();
    private int mDanmuState = 0;
    private int mChargeState = 0;
    private int mState = 2;
    private int mDuration = 0;
    private long mFileSize = 0;
    private long mPrePlayTime = 0;
    private int mIsPay = 0;
    private int mNeedPay = 0;
    private int mPrePlayCountPerDay = 0;
    private int mRestPrePlayCount = 0;
    private int mIRetDetailCode = 0;
    private int mVst = 0;
    private int mLimit = 0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class AudioTrackInfo implements Serializable {
        public static final int AAC = 1;
        public static final int DOLBY_ATMOS = 3;
        public static final int DOLBY_SURROUND = 2;
        private static final long serialVersionUID = -1;
        private long mAudioPrePlayTime;
        private String mAudioShowName;
        private String mAudioTrack;
        private int mAudioType;
        private int mIsVip;
        private String mKeyId;
        private ArrayList<String> mAudioUrlList = null;
        private String mAudioPlayUrl = null;
        private String mAction = null;

        public String getAction() {
            return this.mAction;
        }

        public String getAudioPlayUrl() {
            return this.mAudioPlayUrl;
        }

        public long getAudioPrePlayTime() {
            return this.mAudioPrePlayTime;
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

        public String getKeyId() {
            return this.mKeyId;
        }

        public boolean isSameAudio(AudioTrackInfo audioTrackInfo) {
            String str;
            if ((audioTrackInfo == null && TextUtils.isEmpty(this.mAudioTrack)) || ((audioTrackInfo != null && TextUtils.isEmpty(audioTrackInfo.getAudioTrack()) && TextUtils.isEmpty(this.mAudioTrack)) || (audioTrackInfo != null && (str = this.mAudioTrack) != null && str.equals(audioTrackInfo.getAudioTrack())))) {
                return true;
            }
            return false;
        }

        public int isVip() {
            return this.mIsVip;
        }

        public void setAction(String str) {
            this.mAction = str;
        }

        public void setAudioPrePlayTime(long j3) {
            this.mAudioPrePlayTime = j3;
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
            if (arrayList != null && arrayList.size() != 0) {
                this.mAudioPlayUrl = this.mAudioUrlList.get(0);
            } else {
                this.mAudioPlayUrl = null;
            }
        }

        public void setKeyId(String str) {
            this.mKeyId = str;
        }

        public void setVip(int i3) {
            this.mIsVip = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class DefnInfo implements Serializable, Cloneable {
        private static final long serialVersionUID = -1;
        private int drm;
        private int isVip;
        private int mAudioCodec;
        private String mDefn;
        private int mDefnId;
        private String mDefnName;
        private String mDefnRate;
        private String mDefnShowName;
        private long mFileSize;
        private int mHdr10EnHance;
        private int mVideoCodec;

        public Object clone() {
            try {
                return (DefnInfo) super.clone();
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
                return null;
            }
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
            return this.mDefnName;
        }

        public String getDefnRate() {
            return this.mDefnRate;
        }

        public String getDefnShowName() {
            return this.mDefnShowName;
        }

        public int getDrm() {
            return this.drm;
        }

        public long getFileSize() {
            return this.mFileSize;
        }

        public String getFnName() {
            return this.mDefnName;
        }

        public int getHdr10EnHance() {
            return this.mHdr10EnHance;
        }

        public int getVideoCodec() {
            return this.mVideoCodec;
        }

        public boolean isAudioOnly() {
            return "audio".equalsIgnoreCase(this.mDefn);
        }

        public int isVip() {
            return this.isVip;
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
            this.mDefnName = str;
        }

        public void setDefnRate(String str) {
            this.mDefnRate = str;
        }

        public void setDefnShowName(String str) {
            this.mDefnShowName = str;
        }

        public void setDrm(int i3) {
            this.drm = i3;
        }

        public void setFileSize(long j3) {
            this.mFileSize = j3;
        }

        public void setFnName(String str) {
            this.mDefnName = str;
        }

        public void setHdr10EnHance(int i3) {
            this.mHdr10EnHance = i3;
        }

        public void setVideoCodec(int i3) {
            this.mVideoCodec = i3;
        }

        public void setVip(int i3) {
            this.isVip = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class SubTitle implements Serializable {
        private float mCaptionBottomHPercent;
        private float mCaptionTopHPercent;
        private String mKeyId;
        private String mLang;
        private String mName;
        private String mSubTitle;
        private List<String> mUrlList;

        public float getCaptionBottomHPercent() {
            return this.mCaptionBottomHPercent;
        }

        public float getCaptionTopHPercent() {
            return this.mCaptionTopHPercent;
        }

        public List<String> getUrlList() {
            return this.mUrlList;
        }

        public String getmKeyId() {
            return this.mKeyId;
        }

        public String getmLang() {
            return this.mLang;
        }

        public String getmName() {
            return this.mName;
        }

        public String getmSubTitle() {
            return this.mSubTitle;
        }

        public void setCaptionBottomHPercent(float f16) {
            this.mCaptionBottomHPercent = f16;
        }

        public void setCaptionTopHPercent(float f16) {
            this.mCaptionTopHPercent = f16;
        }

        public void setUrlList(List<String> list) {
            this.mUrlList = list;
        }

        public void setmKeyId(String str) {
            this.mKeyId = str;
        }

        public void setmLang(String str) {
            this.mLang = str;
        }

        public void setmName(String str) {
            this.mName = str;
        }

        public void setmSubTitle(String str) {
            this.mSubTitle = str;
        }
    }

    public void addAudioTrack(AudioTrackInfo audioTrackInfo) {
        if (this.mAudioTrackList == null) {
            this.mAudioTrackList = new ArrayList<>();
        }
        this.mAudioTrackList.add(audioTrackInfo);
    }

    public void addDefinition(DefnInfo defnInfo) {
        if (this.mDefinitionList == null) {
            this.mDefinitionList = new ArrayList<>();
        }
        this.mDefinitionList.add(defnInfo);
    }

    public void addSubTitle(SubTitle subTitle) {
        this.mSubTitleList.add(subTitle);
    }

    public void addVideoDownloadHostItem(Integer num, String str) {
        this.mVideoDownloadHostMap.put(num, str);
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

    public TVKCGIVideoInfo getCGIVideoInfo() {
        return this.mCGIVideoInfo;
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

    public ArrayList<DefnInfo> getDefinitionList() {
        return this.mDefinitionList;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getEndPos() {
        return this.mEndPos;
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

    public long getFileSize() {
        return this.mFileSize;
    }

    public int getHlsp2p() {
        return this.mHlsP2p;
    }

    public int getIretDetailCode() {
        return this.mIRetDetailCode;
    }

    public int getIsPay() {
        return this.mIsPay;
    }

    public int getLimit() {
        return this.mLimit;
    }

    public String getLnk() {
        return this.mLnk;
    }

    public int getMediaVideoState() {
        return this.mMediaVideoState;
    }

    public int getMediaVideoType() {
        return this.mVideoType;
    }

    public int getNeedPay() {
        return this.mNeedPay;
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

    public long getPlayBackStart() {
        return this.mPlayBackStart;
    }

    public long getPlayBackTime() {
        return this.mPlayBackTime;
    }

    public long getPlayTime() {
        return this.mPlayTime;
    }

    public int getPrePlayCountPerDay() {
        return this.mPrePlayCountPerDay;
    }

    public long getPrePlayEndPos() {
        return this.mPrePlayEndPos;
    }

    public long getPrePlayStartPos() {
        return this.mPrePlayStartPos;
    }

    public long getPrePlayTime() {
        return this.mPrePlayTime;
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

    public int getRestPrePlayCount() {
        return this.mRestPrePlayCount;
    }

    public int getRetCode() {
        return this.mRetCode;
    }

    public int getSt() {
        return this.mState;
    }

    public int getStartPos() {
        return this.mStartPos;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getSubErrType() {
        return this.mSubErrType;
    }

    public SubTitle getSubIndex(String str) {
        Iterator<SubTitle> it = this.mSubTitleList.iterator();
        while (it.hasNext()) {
            SubTitle next = it.next();
            if (next.getmLang().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<SubTitle> getSubTitleList() {
        return this.mSubTitleList;
    }

    public long getSvrTick() {
        return this.mSvrTick;
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

    public String getVid() {
        return this.mVid;
    }

    public HashMap<Integer, String> getVideoDownloadHostMap() {
        return this.mVideoDownloadHostMap;
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

    public ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> getWatermarkInfos() {
        return this.mWatermarkInfos;
    }

    public boolean isHevc() {
        return this.mIsHevc;
    }

    public boolean isLocalVideo() {
        return this.mIsLocalVideo;
    }

    public void removeAudioTrack(AudioTrackInfo audioTrackInfo) {
        ArrayList<AudioTrackInfo> arrayList = this.mAudioTrackList;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(audioTrackInfo);
    }

    public void removeDefinition(DefnInfo defnInfo) {
        ArrayList<DefnInfo> arrayList = this.mDefinitionList;
        if (arrayList == null) {
            this.mDefinitionList = new ArrayList<>();
        } else {
            arrayList.remove(defnInfo);
        }
    }

    public void setCGIVideoInfo(TVKCGIVideoInfo tVKCGIVideoInfo) {
        this.mCGIVideoInfo = tVKCGIVideoInfo;
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

    public void setDuration(int i3) {
        this.mDuration = i3;
    }

    public void setEndPos(int i3) {
        this.mEndPos = i3;
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

    public void setFileSize(long j3) {
        this.mFileSize = j3;
    }

    public void setHlsp2p(int i3) {
        this.mHlsP2p = i3;
    }

    public void setIretDetailCode(int i3) {
        this.mIRetDetailCode = i3;
    }

    public void setIsHevc(boolean z16) {
        this.mIsHevc = z16;
    }

    public void setLimit(int i3) {
        this.mLimit = i3;
    }

    public void setLnk(String str) {
        this.mLnk = str;
    }

    public void setLocalVideo(boolean z16) {
        this.mIsLocalVideo = z16;
    }

    public void setMediaVideoState(int i3) {
        this.mMediaVideoState = i3;
    }

    public void setMediaVideoType(int i3) {
        this.mVideoType = i3;
    }

    public void setNeedPay(int i3) {
        this.mNeedPay = i3;
    }

    public void setPLString(String str) {
        this.mPLString = str;
    }

    public void setPLType(int i3) {
        this.mPLType = i3;
    }

    public void setPay(int i3) {
        this.mIsPay = i3;
    }

    public void setPayCh(int i3) {
        this.mChargeState = i3;
    }

    public void setPictureList(Object obj) {
        this.mPicList = obj;
    }

    public void setPlayBackStart(long j3) {
        this.mPlayBackStart = j3;
    }

    public void setPlayBackTime(long j3) {
        this.mPlayBackTime = j3;
    }

    public void setPlayTime(long j3) {
        this.mPlayTime = j3;
    }

    public void setPrePlayCountPerDay(int i3) {
        this.mPrePlayCountPerDay = i3;
    }

    public void setPrePlayEndPos(long j3) {
        this.mPrePlayEndPos = j3;
    }

    public void setPrePlayStartPos(long j3) {
        this.mPrePlayStartPos = j3;
    }

    public void setPrePlayTime(long j3) {
        this.mPrePlayTime = j3;
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

    public void setRestPrePlayCount(int i3) {
        this.mRestPrePlayCount = i3;
    }

    public void setRetCode(int i3) {
        this.mRetCode = i3;
    }

    public void setSt(int i3) {
        this.mState = i3;
    }

    public void setStartPos(int i3) {
        this.mStartPos = i3;
    }

    public void setStatus(int i3) {
        this.mStatus = i3;
    }

    public void setSubErrType(int i3) {
        this.mSubErrType = i3;
    }

    public void setSvrTick(long j3) {
        this.mSvrTick = j3;
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

    public void setVid(String str) {
        this.mVid = str;
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

    public void setWatermarkInfos(ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> arrayList) {
        this.mWatermarkInfos = arrayList;
    }
}
