package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.Utils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MusicItemInfo implements Parcelable {
    public static final int CAPTURE_VIDEO_LENGTH = 10000;
    public static final Parcelable.Creator<MusicItemInfo> CREATOR = new Parcelable.Creator<MusicItemInfo>() { // from class: com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicItemInfo[] newArray(int i3) {
            return new MusicItemInfo[0];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicItemInfo createFromParcel(Parcel parcel) {
            return new MusicItemInfo(parcel);
        }
    };
    public static final int ITEM_ID_ADD = -3;
    public static final int ITEM_ID_BGM_RECOGNITION = -6;
    public static final int ITEM_ID_HUM_HUNT = -4;
    public static final int ITEM_ID_MOCK = -5;
    public static final int ITEM_ID_MUTE = -2;
    public static final int ITEM_ID_ORIGIN = -1;
    public static final int ITEM_ID_WS_BANNER = -7;
    public static final float NOT_RECOGNITION_RESULT_OFFSET = -1.0f;
    public static final int TYPE_ADD = 4;
    public static final int TYPE_BGM_RECOGNITION_TAB = 8;
    public static final int TYPE_COMMON = 1;
    public static final int TYPE_DOV_BANNER = 11;
    public static final int TYPE_HUM_NO_MATCH = 7;
    public static final int TYPE_HUM_RECOGNITION_TAB = 6;
    public static final int TYPE_MUTE = 3;
    public static final int TYPE_ORIGIN = 2;
    public static final int TYPE_QQ_MUSIC = 5;
    public static final int TYPE_WS_BANNER = 10;
    public int downLv;
    public long fileSize;
    public String jumpWs;
    public int mAccuracy;
    public String mAlbumUrl;
    public boolean mHasCopyright;
    public int mItemId;
    public String mMusicName;
    private String mPath;
    public int mProgress;
    public float mRecognitionOffset;
    public String mSingername;
    public String mSongMid;
    public String mTagName;
    public int mType;
    public String mUrl;
    public int musicDuration;
    public int musicEnd;
    public int musicStart;

    public MusicItemInfo(JSONObject jSONObject) {
        this.mRecognitionOffset = -1.0f;
        this.mProgress = -1;
        this.mType = 1;
        this.musicStart = 0;
        this.musicEnd = 0;
        this.musicDuration = 0;
        this.fileSize = 0L;
        this.downLv = 0;
        try {
            if (jSONObject.has("mMusicName")) {
                this.mMusicName = jSONObject.getString("mMusicName");
            }
            if (jSONObject.has("mSingername")) {
                this.mSingername = jSONObject.getString("mSingername");
            }
            if (jSONObject.has("mUrl")) {
                this.mUrl = jSONObject.getString("mUrl");
            }
            if (jSONObject.has("mTagName")) {
                this.mTagName = jSONObject.getString("mTagName");
            }
            if (jSONObject.has("mPath")) {
                this.mPath = jSONObject.getString("mPath");
            }
            this.mItemId = jSONObject.getInt("mItemId");
            this.mType = jSONObject.getInt(HttpMsg.MTYPE);
            this.musicStart = jSONObject.getInt("musicStart");
            this.musicEnd = jSONObject.getInt("musicEnd");
            this.musicDuration = jSONObject.getInt("musicDuration");
            if (jSONObject.has("mSongMid")) {
                this.mSongMid = jSONObject.getString("mSongMid");
            }
            this.mRecognitionOffset = (float) jSONObject.getDouble("mRecognitionOffset");
            this.mHasCopyright = jSONObject.getBoolean("mHasCopyright");
            this.mAccuracy = jSONObject.getInt("mAccuracy");
            if (jSONObject.has("jump_ws")) {
                this.jumpWs = jSONObject.getString("jump_ws");
            }
            this.downLv = jSONObject.optInt("downLv", 0);
        } catch (Exception unused) {
        }
    }

    private String getMusicSuffix() {
        int i3 = this.mType;
        String str = DefaultHlsExtractorFactory.MP3_FILE_EXTENSION;
        if (i3 == 5) {
            int i16 = -1;
            try {
                i16 = this.mUrl.indexOf(".m4a");
                if (i16 >= 0) {
                    str = this.mUrl.substring(i16, i16 + 4);
                }
            } catch (Exception e16) {
                if (SLog.isEnable()) {
                    SLog.d("MusicItemInfo", "getMusicSuffix e:" + e16.toString());
                }
                if (SLog.isEnable()) {
                    SLog.d("MusicItemInfo", "getMusicSuffix e:" + e16.toString());
                }
            }
            if (SLog.isEnable()) {
                SLog.d("MusicItemInfo", "getMusicSuffix " + str + " vIndex=" + i16);
            }
        }
        return str;
    }

    public static MusicItemInfo mock() {
        MusicItemInfo musicItemInfo = new MusicItemInfo();
        musicItemInfo.mMusicName = "\u7a3b\u9999";
        musicItemInfo.mSingername = "\u5468\u6770\u4f26";
        return musicItemInfo;
    }

    public JSONObject convertToJSON() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.mMusicName;
            if (str != null) {
                jSONObject.put("mMusicName", str);
            }
            String str2 = this.mSingername;
            if (str2 != null) {
                jSONObject.put("mSingername", str2);
            }
            String str3 = this.mUrl;
            if (str3 != null) {
                jSONObject.put("mUrl", str3);
            }
            String str4 = this.mTagName;
            if (str4 != null) {
                jSONObject.put("mTagName", str4);
            }
            String str5 = this.mPath;
            if (str5 != null) {
                jSONObject.put("mPath", str5);
            }
            jSONObject.put("mItemId", this.mItemId);
            jSONObject.put(HttpMsg.MTYPE, this.mType);
            jSONObject.put("musicStart", this.musicStart);
            jSONObject.put("musicEnd", this.musicEnd);
            jSONObject.put("musicDuration", this.musicDuration);
            String str6 = this.mSongMid;
            if (str6 != null) {
                jSONObject.put("mSongMid", str6);
            }
            jSONObject.put("mRecognitionOffset", this.mRecognitionOffset);
            jSONObject.put("mHasCopyright", this.mHasCopyright);
            jSONObject.put("mAccuracy", this.mAccuracy);
            jSONObject.put("downLv", this.downLv);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public MusicItemInfo copy() {
        MusicItemInfo musicItemInfo = new MusicItemInfo();
        musicItemInfo.mMusicName = this.mMusicName;
        musicItemInfo.mSingername = this.mSingername;
        musicItemInfo.mUrl = this.mUrl;
        musicItemInfo.mTagName = this.mTagName;
        musicItemInfo.mItemId = this.mItemId;
        musicItemInfo.mType = this.mType;
        musicItemInfo.musicStart = this.musicStart;
        musicItemInfo.musicEnd = this.musicEnd;
        musicItemInfo.musicDuration = this.musicDuration;
        musicItemInfo.mSongMid = this.mSongMid;
        musicItemInfo.mPath = this.mPath;
        musicItemInfo.mRecognitionOffset = this.mRecognitionOffset;
        musicItemInfo.mHasCopyright = this.mHasCopyright;
        musicItemInfo.mAccuracy = this.mAccuracy;
        musicItemInfo.jumpWs = this.jumpWs;
        return musicItemInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(MusicItemInfo musicItemInfo) {
        int i3;
        if (musicItemInfo != null && (i3 = musicItemInfo.mType) != 1 && i3 != 5) {
            if (this.mType != i3) {
                return false;
            }
            return true;
        }
        if (musicItemInfo == null || musicItemInfo.mItemId != this.mItemId || musicItemInfo.mType != this.mType) {
            return false;
        }
        String str = musicItemInfo.mMusicName;
        String str2 = this.mMusicName;
        if (str != str2 && (str == null || !str.equals(str2))) {
            return false;
        }
        return true;
    }

    public String getLocalPath() {
        try {
            if (TextUtils.isEmpty(this.mPath)) {
                StringBuilder sb5 = new StringBuilder(SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath());
                if (this.mType == 5 && TextUtils.isEmpty(this.mUrl)) {
                    this.mPath = null;
                    return null;
                }
                if (!TextUtils.isEmpty(this.mUrl) && !TextUtils.isEmpty(this.mMusicName)) {
                    sb5.append(Utils.Crc64String(this.mUrl));
                    sb5.append("_");
                    sb5.append(this.mMusicName.hashCode());
                    sb5.append(getMusicSuffix());
                }
                this.mPath = sb5.toString();
            }
        } catch (Exception unused) {
        }
        return this.mPath;
    }

    public int hashCode() {
        int i3;
        int i16;
        if (!TextUtils.isEmpty(this.mMusicName) && !TextUtils.isEmpty(this.mSongMid)) {
            i3 = this.mMusicName.hashCode() + this.mSongMid.hashCode() + this.mItemId;
            i16 = this.mType;
        } else {
            i3 = this.mItemId;
            i16 = this.mType;
        }
        return i3 + i16;
    }

    public boolean isDownloading() {
        int i3 = this.mProgress;
        if (i3 > -1 && i3 < 100) {
            return true;
        }
        return false;
    }

    public boolean isFileExist() {
        int i3 = this.mType;
        if ((i3 == 5 || i3 == 1) && FileUtil.fileExistsAndNotEmpty(getLocalPath())) {
            return true;
        }
        return false;
    }

    public boolean isMute() {
        if (this.mType != 2) {
            return true;
        }
        return false;
    }

    public boolean isMyMusicInfo() {
        if (this.mType == 5) {
            return true;
        }
        return false;
    }

    public boolean isWsBanner() {
        int i3 = this.mType;
        if (i3 != 10 && i3 != 11) {
            return false;
        }
        return true;
    }

    public boolean needPlay() {
        int i3 = this.mType;
        if (i3 == 1 || i3 == 5) {
            return true;
        }
        return false;
    }

    public void setPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPath = str;
        }
    }

    public String toString() {
        return "MusicItemInfo: " + this.mSingername + " - " + this.mMusicName + " - mRecognitionOffset=" + this.mRecognitionOffset;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mMusicName);
        parcel.writeString(this.mSingername);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mTagName);
        parcel.writeInt(this.mItemId);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.musicStart);
        parcel.writeInt(this.musicEnd);
        parcel.writeInt(this.musicDuration);
        parcel.writeString(this.mSongMid);
        parcel.writeFloat(this.mRecognitionOffset);
        parcel.writeByte(this.mHasCopyright ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mAccuracy);
        parcel.writeString(this.jumpWs);
        parcel.writeInt(this.downLv);
        parcel.writeString(this.mAlbumUrl);
    }

    public MusicItemInfo() {
        this.mRecognitionOffset = -1.0f;
        this.mProgress = -1;
        this.mType = 1;
        this.musicStart = 0;
        this.musicEnd = 0;
        this.musicDuration = 0;
        this.fileSize = 0L;
        this.downLv = 0;
    }

    public MusicItemInfo(Parcel parcel) {
        this.mRecognitionOffset = -1.0f;
        this.mProgress = -1;
        this.mType = 1;
        this.musicStart = 0;
        this.musicEnd = 0;
        this.musicDuration = 0;
        this.fileSize = 0L;
        this.downLv = 0;
        this.mMusicName = parcel.readString();
        this.mSingername = parcel.readString();
        this.mUrl = parcel.readString();
        this.mTagName = parcel.readString();
        this.mItemId = parcel.readInt();
        this.mType = parcel.readInt();
        this.musicStart = parcel.readInt();
        this.musicEnd = parcel.readInt();
        this.musicDuration = parcel.readInt();
        this.mSongMid = parcel.readString();
        this.mRecognitionOffset = parcel.readFloat();
        this.mHasCopyright = parcel.readByte() != 0;
        this.mAccuracy = parcel.readInt();
        this.jumpWs = parcel.readString();
        this.downLv = parcel.readInt();
        this.mAlbumUrl = parcel.readString();
    }

    public MusicItemInfo(String str) throws JSONException {
        this.mRecognitionOffset = -1.0f;
        this.mProgress = -1;
        this.mType = 1;
        this.musicStart = 0;
        this.musicEnd = 0;
        this.musicDuration = 0;
        this.fileSize = 0L;
        this.downLv = 0;
        JSONObject jSONObject = new JSONObject(str);
        this.mMusicName = jSONObject.optString("title");
        this.mUrl = jSONObject.optString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        this.mSingername = jSONObject.optString("author");
        this.mItemId = jSONObject.optInt("item_id");
        if (jSONObject.has("type")) {
            this.mType = jSONObject.optInt("type");
        } else {
            this.mType = 1;
        }
        this.jumpWs = jSONObject.optString("jump_ws");
        this.downLv = jSONObject.optInt("downLv", 0);
        this.mAlbumUrl = jSONObject.optString("image_url");
    }

    public MusicItemInfo(String str, String str2, String str3, int i3, String str4, int i16, int i17, int i18, boolean z16) {
        this.mRecognitionOffset = -1.0f;
        this.mProgress = -1;
        this.fileSize = 0L;
        this.downLv = 0;
        this.mType = 5;
        this.mMusicName = str;
        this.mUrl = str2;
        this.mSingername = str3;
        this.mItemId = i3;
        this.mSongMid = str4;
        this.musicStart = i16;
        this.musicEnd = i17;
        this.musicDuration = i18;
        this.mHasCopyright = z16;
    }
}
