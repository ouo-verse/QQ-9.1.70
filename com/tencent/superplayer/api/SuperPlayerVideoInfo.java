package com.tencent.superplayer.api;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.qqlive.superplayer.vinfo.TVKVideoInfo;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class SuperPlayerVideoInfo implements Cloneable {
    public static final int AUDIO_VOD_FORMAT_MP3 = 107;
    public static final int VIDEO_FORMAT_UNKNOWN = 204;
    public static final int VIDEO_LIVE_FORMAT_FLV = 202;
    public static final int VIDEO_LIVE_FORMAT_HLS = 201;
    public static final int VIDEO_LIVE_FORMAT_UNKNOWN = 203;
    public static final int VIDEO_SOURCE_DIRECT_URL = 2;
    public static final int VIDEO_SOURCE_TVIDEO = 1;
    public static final int VIDEO_VOD_FORMAT_FILE = 105;
    public static final int VIDEO_VOD_FORMAT_HLS = 102;
    public static final int VIDEO_VOD_FORMAT_MP4 = 101;
    public static final int VIDEO_VOD_FORMAT_RTMP = 103;
    public static final int VIDEO_VOD_FORMAT_UNKNOWN = 104;
    private int mBusiPlatform;
    private ArrayList<String> mCookies;
    private final HashMap<String, String> mExtraDownLoadParams;
    private ParcelFileDescriptor mFileDescriptor;
    private String mFileId;
    private int mFormat;
    private boolean mIsDisableTVideoCache;
    private String mLocalSavePath;
    private String mPid;
    private String[] mPlayUrls;
    private long mPreloadDurationMs;
    private long mPreloadSize;
    private String mRequestDefinition;
    private ITPMediaAsset mTPMediaAssert;
    private String mTVideoLoginCookie;
    private TVideoNetInfo mTVideoNetInfo;
    private ArrayList<TVKVideoInfo.Section> mTVideoSectionList;
    private Uri mUri;
    private ArrayList<String> mUrlHostList;
    private String mVid;
    private long mVideoDurationMs;
    private int mVideoSource;
    private int mVideoType;

    /* JADX INFO: Access modifiers changed from: protected */
    public SuperPlayerVideoInfo(int i3, int i16, String str) {
        this.mCookies = null;
        this.mUrlHostList = null;
        this.mExtraDownLoadParams = new HashMap<>();
        this.mVideoSource = i3;
        this.mVideoType = i16;
        this.mBusiPlatform = SuperPlayerSDKMgr.getPlatform();
        this.mVid = str;
    }

    public void addExtraDownloadParams(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        this.mExtraDownLoadParams.putAll(hashMap);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SuperPlayerVideoInfo superPlayerVideoInfo = (SuperPlayerVideoInfo) obj;
        if (this.mVideoSource != superPlayerVideoInfo.mVideoSource || this.mVideoType != superPlayerVideoInfo.mVideoType || this.mBusiPlatform != superPlayerVideoInfo.mBusiPlatform) {
            return false;
        }
        String str = this.mVid;
        if (str == null ? superPlayerVideoInfo.mVid != null : !str.equals(superPlayerVideoInfo.mVid)) {
            return false;
        }
        String str2 = this.mPid;
        if (str2 == null ? superPlayerVideoInfo.mPid != null : !str2.equals(superPlayerVideoInfo.mPid)) {
            return false;
        }
        String str3 = this.mRequestDefinition;
        if (str3 == null ? superPlayerVideoInfo.mRequestDefinition != null : !str3.equals(superPlayerVideoInfo.mRequestDefinition)) {
            return false;
        }
        String str4 = this.mLocalSavePath;
        if (str4 == null ? superPlayerVideoInfo.mLocalSavePath != null : !str4.equals(superPlayerVideoInfo.mLocalSavePath)) {
            return false;
        }
        String str5 = this.mFileId;
        if (str5 == null ? superPlayerVideoInfo.mFileId != null : !str5.equals(superPlayerVideoInfo.mFileId)) {
            return false;
        }
        ArrayList<String> arrayList = this.mCookies;
        ArrayList<String> arrayList2 = superPlayerVideoInfo.mCookies;
        if (arrayList != null) {
            return arrayList.equals(arrayList2);
        }
        if (arrayList2 == null) {
            return true;
        }
        return false;
    }

    public int getBusiPlatform() {
        return this.mBusiPlatform;
    }

    public ArrayList<String> getCookie() {
        return this.mCookies;
    }

    public HashMap<String, String> getExtraDownloadParams() {
        return this.mExtraDownLoadParams;
    }

    public ParcelFileDescriptor getFileDescriptor() {
        return this.mFileDescriptor;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public boolean getIsDisableTVideoCache() {
        return this.mIsDisableTVideoCache;
    }

    public String getLocalSavePath() {
        return this.mLocalSavePath;
    }

    public ITPMediaAsset getMediaAssert() {
        return this.mTPMediaAssert;
    }

    public String getPid() {
        return this.mPid;
    }

    public String getPlayUrl() {
        String[] strArr = this.mPlayUrls;
        if (strArr != null && strArr.length > 0) {
            return strArr[0];
        }
        return null;
    }

    public String[] getPlayUrls() {
        return this.mPlayUrls;
    }

    public long getPreloadDurationMs() {
        return this.mPreloadDurationMs;
    }

    public long getPreloadSize() {
        return this.mPreloadSize;
    }

    public String getRequestDefinition() {
        String str = this.mRequestDefinition;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getTVideoLoginCookie() {
        return this.mTVideoLoginCookie;
    }

    public TVideoNetInfo getTVideoNetInfo() {
        return this.mTVideoNetInfo;
    }

    public ArrayList<TVKVideoInfo.Section> getTVideoSectionList() {
        return this.mTVideoSectionList;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public ArrayList<String> getUrlHostList() {
        return this.mUrlHostList;
    }

    public String getVid() {
        return this.mVid;
    }

    public long getVideoDurationMs() {
        return this.mVideoDurationMs;
    }

    public int getVideoSource() {
        return this.mVideoSource;
    }

    public int getVideoType() {
        return this.mVideoType;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = ((((this.mVideoSource * 31) + this.mVideoType) * 31) + this.mBusiPlatform) * 31;
        String str = this.mVid;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = (i26 + i3) * 31;
        String str2 = this.mPid;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        String str3 = this.mRequestDefinition;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i36 = (i29 + i17) * 31;
        String str4 = this.mLocalSavePath;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i37 = (i36 + i18) * 31;
        String str5 = this.mFileId;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i38 = (i37 + i19) * 31;
        ArrayList<String> arrayList = this.mCookies;
        if (arrayList != null) {
            i27 = arrayList.hashCode();
        }
        return i38 + i27;
    }

    public void setBusiPlatform(int i3) {
        this.mBusiPlatform = i3;
    }

    public void setCookies(ArrayList<String> arrayList) {
        this.mCookies = arrayList;
    }

    public void setFileId(String str) {
        this.mFileId = str;
    }

    public void setFormat(int i3) {
        this.mFormat = i3;
    }

    public void setIsDisableTVideoCache(boolean z16) {
        this.mIsDisableTVideoCache = z16;
    }

    public void setLocalSavePath(String str) {
        this.mLocalSavePath = str;
    }

    public void setMediaAssert(ITPMediaAsset iTPMediaAsset) {
        this.mTPMediaAssert = iTPMediaAsset;
    }

    public void setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        this.mFileDescriptor = parcelFileDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlayUrl(String[] strArr) {
        this.mPlayUrls = strArr;
    }

    public void setPreloadDurationMs(long j3) {
        this.mPreloadDurationMs = j3;
    }

    public void setPreloadSize(long j3) {
        this.mPreloadSize = j3;
    }

    public void setRequestDefinition(String str) {
        this.mRequestDefinition = str;
    }

    public void setTVideoLoginCookie(String str) {
        this.mTVideoLoginCookie = str;
    }

    public void setTVideoNetInfo(TVideoNetInfo tVideoNetInfo) {
        this.mTVideoNetInfo = tVideoNetInfo;
    }

    public void setTVideoSectionList(ArrayList<TVKVideoInfo.Section> arrayList) {
        this.mTVideoSectionList = arrayList;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }

    public void setUrlHostList(ArrayList<String> arrayList) {
        this.mUrlHostList = arrayList;
    }

    public void setVideoDurationMs(long j3) {
        this.mVideoDurationMs = j3;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SuperPlayerVideoInfo[ mVideoSource:");
        if (this.mVideoSource == 1) {
            str = "tvideo";
        } else {
            str = "directUrl";
        }
        sb5.append(str);
        sb5.append(", ");
        sb5.append("mVideoType:");
        sb5.append(this.mVideoType);
        sb5.append(", ");
        sb5.append("mBusiPlatform:");
        sb5.append(this.mBusiPlatform);
        sb5.append(", ");
        sb5.append("mVid:");
        sb5.append(this.mVid);
        sb5.append(", ");
        sb5.append("mPid:");
        sb5.append(this.mPid);
        sb5.append(", ");
        sb5.append("mPlayUrls:");
        sb5.append(Arrays.toString(this.mPlayUrls));
        sb5.append(", ");
        sb5.append("mRequestDefn:");
        sb5.append(this.mRequestDefinition);
        sb5.append(" ");
        sb5.append("mFormat:");
        sb5.append(this.mFormat);
        sb5.append(" ");
        sb5.append("]");
        return sb5.toString();
    }

    public void setPlayUrl(String str) {
        this.mPlayUrls = new String[]{str};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SuperPlayerVideoInfo(int i3, int i16, int i17, String str) {
        this.mCookies = null;
        this.mUrlHostList = null;
        this.mExtraDownLoadParams = new HashMap<>();
        this.mVideoSource = i3;
        this.mVideoType = i16;
        this.mBusiPlatform = i17;
        this.mVid = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SuperPlayerVideoInfo(int i3, int i16, String str, String str2) {
        this.mCookies = null;
        this.mUrlHostList = null;
        this.mExtraDownLoadParams = new HashMap<>();
        this.mVideoSource = i3;
        this.mVideoType = i16;
        this.mBusiPlatform = SuperPlayerSDKMgr.getPlatform();
        this.mVid = str;
        this.mPid = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SuperPlayerVideoInfo(int i3, int i16, int i17, String str, String str2) {
        this.mCookies = null;
        this.mUrlHostList = null;
        this.mExtraDownLoadParams = new HashMap<>();
        this.mVideoSource = i3;
        this.mVideoType = i16;
        this.mBusiPlatform = i17;
        this.mVid = str;
        this.mPid = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SuperPlayerVideoInfo(int i3) {
        this.mCookies = null;
        this.mUrlHostList = null;
        this.mExtraDownLoadParams = new HashMap<>();
        this.mVideoSource = i3;
    }
}
