package com.tencent.mobileqq.activity.photo;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class LocalMediaInfo implements Comparable<LocalMediaInfo>, Parcelable, Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int CAMARA_PHOTO = 4;
    public static final Parcelable.Creator<LocalMediaInfo> CREATOR;
    public static final int DEFAULT = 0;
    public static final int PHOTO_LAST_SELECTED = 3;
    public static final int PHOTO_SELECTED = 1;
    public static final int PHOTO_UNSELECTED = 2;
    private static final long serialVersionUID = 4712583313352439425L;
    public long _id;
    public long addedDate;
    public ArrayList<String> aiTextLabel;

    @Deprecated
    public Bundle bundle;
    public HashMap<String, Serializable> extData;
    public String fakeVid;
    public long fileSize;
    public String filterID;
    public int index;
    public boolean isCaptured;
    public boolean isHDRVideo;
    public boolean isMakeVideo;
    public boolean isProgressThumbnail;
    public boolean isRecord;
    public boolean isRegionThumbUseNewDecoder;
    public boolean isRwa;
    public boolean isSegment;
    public boolean isSyncToWeishi;
    public boolean isSystemMeidaStore;
    public boolean isVideoReady;
    public boolean isVideoShareToQZone;
    public int latitude;
    public int listViewPosition;
    public int longitude;
    public String mAlbumName;
    public String mAudioPath;
    public boolean mChecked;
    public String mCloudPhotoId;
    public String mCloudPhotoOwnerAlbumId;
    public long mCloudPhotoOwnerUin;
    public long mDuration;
    public boolean mHasAudioTrack;
    public ArrayList<String> mHashTagList;
    public boolean mIsUploadOrigin;
    public float mKuolieCenterX;
    public float mKuolieCenterY;
    public float mKuolieHeightScale;
    public String mKuolieId;
    public float mKuolieRotate;
    public float mKuolieWidthScale;
    public int mMediaType;
    public String mMimeType;
    public ArrayList<String> mOriginPath;
    public int mSampleRate;
    public long mStartTime;
    public int mTextId;
    public String mTextStr;
    public long mTotalDuration;
    public String mTransId;
    public ArrayList<Long> mTransferPosList;
    public int mVideoType;
    public String materialID;
    public String materialName;
    public long mediaBitrate;
    public int mediaHeight;
    public long mediaOriginBitrate;
    public int mediaOriginHeight;
    public long mediaOriginSize;
    public int mediaOriginWidth;
    public int mediaWidth;
    public String missionID;
    public long modifiedDate;
    public boolean needProcess;
    public int orientation;
    public int panoramaPhotoType;
    public String path;
    public String picPathBeforeEdit;
    public Integer position;
    public int rotation;
    public String scheme;
    public int selectStatus;
    public int showCircleTakeSame;
    public int thumbHeight;
    public Rect thumbRect;
    public int thumbSize;
    public int thumbWidth;
    public String thumbnailPath;
    public float thumbnailProgress;
    public String videoMimeType;
    public long visableTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37458);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new Parcelable.Creator<LocalMediaInfo>() { // from class: com.tencent.mobileqq.activity.photo.LocalMediaInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public LocalMediaInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new LocalMediaInfo[0] : (LocalMediaInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public LocalMediaInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                    }
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    localMediaInfo._id = parcel.readLong();
                    localMediaInfo.path = parcel.readString();
                    localMediaInfo.fileSize = parcel.readLong();
                    localMediaInfo.addedDate = parcel.readLong();
                    localMediaInfo.modifiedDate = parcel.readLong();
                    localMediaInfo.orientation = parcel.readInt();
                    localMediaInfo.rotation = parcel.readInt();
                    localMediaInfo.mDuration = parcel.readLong();
                    localMediaInfo.mStartTime = parcel.readLong();
                    localMediaInfo.mChecked = parcel.readByte() == 1;
                    localMediaInfo.selectStatus = parcel.readInt();
                    localMediaInfo.thumbWidth = parcel.readInt();
                    localMediaInfo.thumbHeight = parcel.readInt();
                    localMediaInfo.thumbnailPath = parcel.readString();
                    localMediaInfo.index = parcel.readInt();
                    localMediaInfo.position = Integer.valueOf(parcel.readInt());
                    localMediaInfo.mMimeType = parcel.readString();
                    localMediaInfo.mMediaType = parcel.readInt();
                    localMediaInfo.mediaWidth = parcel.readInt();
                    localMediaInfo.mediaHeight = parcel.readInt();
                    localMediaInfo.mediaBitrate = parcel.readLong();
                    localMediaInfo.mediaOriginWidth = parcel.readInt();
                    localMediaInfo.mediaOriginHeight = parcel.readInt();
                    localMediaInfo.mediaOriginSize = parcel.readLong();
                    localMediaInfo.mediaOriginBitrate = parcel.readLong();
                    localMediaInfo.isSystemMeidaStore = parcel.readByte() == 1;
                    localMediaInfo.isRegionThumbUseNewDecoder = parcel.readByte() == 1;
                    localMediaInfo.longitude = parcel.readInt();
                    localMediaInfo.latitude = parcel.readInt();
                    localMediaInfo.panoramaPhotoType = parcel.readInt();
                    localMediaInfo.mCloudPhotoOwnerUin = parcel.readLong();
                    localMediaInfo.mCloudPhotoOwnerAlbumId = parcel.readString();
                    localMediaInfo.mCloudPhotoId = parcel.readString();
                    localMediaInfo.isVideoReady = parcel.readByte() == 1;
                    localMediaInfo.materialID = parcel.readString();
                    localMediaInfo.materialName = parcel.readString();
                    localMediaInfo.filterID = parcel.readString();
                    localMediaInfo.scheme = parcel.readString();
                    localMediaInfo.showCircleTakeSame = parcel.readInt();
                    localMediaInfo.missionID = parcel.readString();
                    localMediaInfo.mTransferPosList = parcel.readArrayList(Long.class.getClassLoader());
                    localMediaInfo.aiTextLabel = parcel.readArrayList(String.class.getClassLoader());
                    localMediaInfo.thumbnailProgress = parcel.readFloat();
                    localMediaInfo.mOriginPath = parcel.readArrayList(String.class.getClassLoader());
                    localMediaInfo.mKuolieId = parcel.readString();
                    localMediaInfo.mKuolieCenterX = parcel.readFloat();
                    localMediaInfo.mKuolieCenterY = parcel.readFloat();
                    localMediaInfo.mKuolieRotate = parcel.readFloat();
                    localMediaInfo.mKuolieWidthScale = parcel.readFloat();
                    localMediaInfo.mKuolieHeightScale = parcel.readFloat();
                    localMediaInfo.mHashTagList = parcel.readArrayList(String.class.getClassLoader());
                    localMediaInfo.isRwa = parcel.readByte() == 1;
                    localMediaInfo.picPathBeforeEdit = parcel.readString();
                    localMediaInfo.videoMimeType = parcel.readString();
                    localMediaInfo.isHDRVideo = parcel.readByte() == 1;
                    localMediaInfo.isSegment = parcel.readByte() == 1;
                    localMediaInfo.isVideoShareToQZone = parcel.readByte() == 1;
                    localMediaInfo.isCaptured = parcel.readByte() == 1;
                    localMediaInfo.extData = (HashMap) parcel.readBundle(getClass().getClassLoader()).getSerializable("extData");
                    return localMediaInfo;
                }
            };
        }
    }

    public LocalMediaInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.thumbRect = null;
        this.thumbnailProgress = 0.5f;
        this.isProgressThumbnail = true;
        this.rotation = 0;
        this.latitude = 0;
        this.longitude = 0;
        this.isCaptured = false;
        this.isVideoReady = true;
        this.mCloudPhotoOwnerUin = 0L;
        this.mCloudPhotoOwnerAlbumId = "";
        this.mCloudPhotoId = "";
        this.position = -1;
        this.mTransferPosList = null;
        this.mOriginPath = null;
        this.materialID = "";
        this.materialName = "";
        this.filterID = "";
        this.scheme = "";
        this.showCircleTakeSame = 0;
        this.mKuolieId = "";
        this.mKuolieCenterX = 0.0f;
        this.mKuolieCenterY = 0.0f;
        this.mKuolieRotate = 0.0f;
        this.mKuolieWidthScale = 0.0f;
        this.mKuolieHeightScale = 0.0f;
        this.mHashTagList = new ArrayList<>();
        this.isSystemMeidaStore = true;
        this.isRegionThumbUseNewDecoder = false;
        this.mIsUploadOrigin = false;
        this.listViewPosition = -1;
        this.panoramaPhotoType = 0;
        this.mHasAudioTrack = false;
        this.mSampleRate = 1;
        this.mTextId = -1;
    }

    public static LocalMediaInfo formObjectByJsonString(String str) {
        String optString;
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            localMediaInfo.path = jSONObject.getString("path");
            localMediaInfo.mMediaType = jSONObject.getInt("mMediaType");
            localMediaInfo._id = jSONObject.getLong("_id");
            localMediaInfo.fileSize = jSONObject.getLong("fileSize");
            localMediaInfo.addedDate = jSONObject.getLong("addedDate");
            localMediaInfo.modifiedDate = jSONObject.getLong("modifiedDate");
            localMediaInfo.orientation = jSONObject.getInt("orientation");
            localMediaInfo.mDuration = jSONObject.getLong("mDuration");
            localMediaInfo.mChecked = jSONObject.getBoolean("mChecked");
            localMediaInfo.isSegment = jSONObject.getBoolean("isSegment");
            localMediaInfo.selectStatus = jSONObject.getInt("selectStatus");
            localMediaInfo.rotation = jSONObject.getInt(BasicAnimation.KeyPath.ROTATION);
            localMediaInfo.thumbnailPath = jSONObject.getString("thumbnailPath");
            localMediaInfo.thumbWidth = jSONObject.getInt("thumbWidth");
            localMediaInfo.thumbHeight = jSONObject.getInt("thumbHeight");
            localMediaInfo.index = jSONObject.getInt("index");
            localMediaInfo.position = Integer.valueOf(jSONObject.getInt("position"));
            localMediaInfo.mMimeType = jSONObject.getString("mMimeType");
            localMediaInfo.mediaWidth = jSONObject.getInt("mediaWidth");
            localMediaInfo.mediaHeight = jSONObject.getInt("mediaHeight");
            localMediaInfo.mediaBitrate = jSONObject.getLong("mediaBitrate");
            localMediaInfo.isSystemMeidaStore = jSONObject.getBoolean("isSystemMeidaStore");
            localMediaInfo.isRegionThumbUseNewDecoder = jSONObject.getBoolean("isRegionThumbUseNewDecoder");
            localMediaInfo.panoramaPhotoType = jSONObject.getInt("panoramaPhotoType");
            localMediaInfo.isVideoReady = jSONObject.getBoolean("isVideoReady");
            localMediaInfo.materialID = jSONObject.getString("materialID");
            localMediaInfo.materialName = jSONObject.getString("materialName");
            localMediaInfo.filterID = jSONObject.getString(ITroopAnnouncementHelperApi.CONTROL_INFO_FILTER_ID);
            localMediaInfo.scheme = jSONObject.getString(ZPlanPublishSource.FROM_SCHEME);
            localMediaInfo.showCircleTakeSame = jSONObject.getInt("showCircleTakeSame");
            localMediaInfo.missionID = jSONObject.getString("missionID");
            localMediaInfo.thumbnailProgress = jSONObject.getInt("thumbnailProgress");
            localMediaInfo.mediaOriginWidth = jSONObject.getInt("mediaOriginWidth");
            localMediaInfo.mediaOriginHeight = jSONObject.getInt("mediaOriginHeight");
            localMediaInfo.mediaOriginSize = jSONObject.getInt("mediaOriginSize");
            localMediaInfo.mediaOriginBitrate = jSONObject.getInt("mediaOriginBitrate");
            localMediaInfo.mKuolieId = jSONObject.getString("mKuolieId");
            localMediaInfo.mKuolieCenterX = jSONObject.getInt("mKuolieCenterX");
            localMediaInfo.mKuolieCenterY = jSONObject.getInt("mKuolieCenterY");
            localMediaInfo.mKuolieWidthScale = jSONObject.getInt("mKuolieWidthScale");
            localMediaInfo.mKuolieHeightScale = jSONObject.getInt("mKuolieHeightScale");
            localMediaInfo.isRwa = jSONObject.getBoolean("isRwa");
            if (jSONObject.isNull("picPathBeforeEdit")) {
                optString = null;
            } else {
                optString = jSONObject.optString("picPathBeforeEdit");
            }
            localMediaInfo.picPathBeforeEdit = optString;
            localMediaInfo.videoMimeType = jSONObject.getString("videoMimeType");
            localMediaInfo.isHDRVideo = jSONObject.getBoolean("isHDRVideo");
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("LocalMediaInfo", 2, "Form Object by json string error:" + e16.getMessage());
        }
        return localMediaInfo;
    }

    public static String getUrl(LocalMediaInfo localMediaInfo) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(localMediaInfo.path);
        sb5.append("|");
        sb5.append(localMediaInfo.thumbWidth);
        sb5.append("|");
        sb5.append(localMediaInfo.thumbHeight);
        sb5.append("|");
        sb5.append(localMediaInfo.modifiedDate);
        sb5.append("|");
        sb5.append(0);
        sb5.append("|");
        sb5.append("201403010");
        if (localMediaInfo.isRegionThumbUseNewDecoder) {
            sb5.append("|");
            sb5.append("useNewDecoder");
        }
        return sb5.toString();
    }

    public static LocalMediaInfo parseUrl(URL url) {
        try {
            String file = url.getFile();
            String[] split = file.split("\\|");
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = split[0];
            localMediaInfo.thumbWidth = Integer.parseInt(split[1]);
            localMediaInfo.thumbHeight = Integer.parseInt(split[2]);
            localMediaInfo.modifiedDate = Long.parseLong(split[3]);
            if (split.length > 6 && !split[6].equals("useNewDecoder")) {
                localMediaInfo.index = Integer.parseInt(split[6]);
            }
            if (file.endsWith("useNewDecoder")) {
                localMediaInfo.isRegionThumbUseNewDecoder = true;
            }
            return localMediaInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public String toJsonString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{\"_id\":");
        sb5.append(this._id);
        sb5.append(", \"path\":\"");
        sb5.append(this.path);
        sb5.append("\", \"fileSize\":");
        sb5.append(this.fileSize);
        sb5.append(", \"addedDate\":");
        sb5.append(this.addedDate);
        sb5.append(", \"modifiedDate\":");
        sb5.append(this.modifiedDate);
        sb5.append(", \"orientation\":");
        sb5.append(this.orientation);
        sb5.append(", \"mDuration\":");
        sb5.append(this.mDuration);
        sb5.append(", \"mChecked\":");
        sb5.append(this.mChecked);
        sb5.append(", \"isSegment\":");
        sb5.append(this.isSegment);
        sb5.append(", \"selectStatus\":");
        sb5.append(this.selectStatus);
        sb5.append(", \"rotation\":");
        sb5.append(this.rotation);
        sb5.append(", \"thumbWidth\":");
        sb5.append(this.thumbWidth);
        sb5.append(", \"thumbHeight\":");
        sb5.append(this.thumbHeight);
        sb5.append(", \"index\":");
        sb5.append(this.index);
        sb5.append(", \"position\":");
        sb5.append(this.position);
        sb5.append(", \"mMimeType\":\"");
        sb5.append(this.mMimeType);
        sb5.append("\", \"mediaWidth\":");
        sb5.append(this.mediaWidth);
        sb5.append(", \"mediaHeight\":");
        sb5.append(this.mediaHeight);
        sb5.append(", \"mediaBitrate\":");
        sb5.append(this.mediaBitrate);
        sb5.append(", \"isSystemMeidaStore\":");
        sb5.append(this.isSystemMeidaStore);
        sb5.append(", \"isRegionThumbUseNewDecoder\":");
        sb5.append(this.isRegionThumbUseNewDecoder);
        sb5.append(", \"panoramaPhotoType\":");
        sb5.append(this.panoramaPhotoType);
        sb5.append(", \"mMediaType\":");
        sb5.append(this.mMediaType);
        sb5.append(", \"isVideoReady\":");
        sb5.append(this.isVideoReady);
        sb5.append(", \"materialID\":\"");
        sb5.append(this.materialID);
        sb5.append("\", \"materialName\":\"");
        sb5.append(this.materialName);
        sb5.append("\", \"filterID\":\"");
        sb5.append(this.filterID);
        sb5.append("\", \"scheme\":\"");
        sb5.append(this.scheme);
        sb5.append("\", \"showCircleTakeSame\":");
        sb5.append(this.showCircleTakeSame);
        sb5.append(", \"missionID\":\"");
        sb5.append(this.missionID);
        sb5.append("\", \"thumbnailProgress\":");
        sb5.append(this.thumbnailProgress);
        sb5.append(", \"thumbnailPath\":\"");
        sb5.append(this.thumbnailPath);
        sb5.append("\", \"mediaOriginWidth\":");
        sb5.append(this.mediaOriginWidth);
        sb5.append(", \"mediaOriginHeight\":");
        sb5.append(this.mediaOriginHeight);
        sb5.append(", \"mediaOriginSize\":");
        sb5.append(this.mediaOriginSize);
        sb5.append(", \"mediaOriginBitrate\":");
        sb5.append(this.mediaOriginBitrate);
        sb5.append(", \"mKuolieId\":\"");
        sb5.append(this.mKuolieId);
        sb5.append("\", \"mKuolieCenterX\":");
        sb5.append(this.mKuolieCenterX);
        sb5.append(", \"mKuolieCenterY\":");
        sb5.append(this.mKuolieCenterY);
        sb5.append(", \"mKuolieRotate\":");
        sb5.append(this.mKuolieRotate);
        sb5.append(", \"mKuolieWidthScale\":");
        sb5.append(this.mKuolieWidthScale);
        sb5.append(", \"mKuolieHeightScale\":");
        sb5.append(this.mKuolieHeightScale);
        sb5.append(", \"isRwa\":");
        sb5.append(this.isRwa);
        sb5.append(", \"picPathBeforeEdit\":");
        if (this.picPathBeforeEdit == null) {
            str = "null";
        } else {
            str = "\"" + this.picPathBeforeEdit + "\"";
        }
        sb5.append(str);
        sb5.append(", \"videoMimeType\":\"");
        sb5.append(this.videoMimeType);
        sb5.append("\", \"isHDRVideo\":\"");
        sb5.append(this.isHDRVideo);
        sb5.append("\"}");
        return sb5.toString();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LocalMediaInfo{_id=" + this._id + ", path='" + this.path + "', fileSize=" + this.fileSize + ", addedDate=" + this.addedDate + ", modifiedDate=" + this.modifiedDate + ", orientation=" + this.orientation + ", mDuration=" + this.mDuration + ", mChecked=" + this.mChecked + ", isSegment=" + this.isSegment + ", selectStatus=" + this.selectStatus + ", rotation=" + this.rotation + ", thumbnailPath=" + this.thumbnailPath + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", index=" + this.index + ", position=" + this.position + ", mMimeType='" + this.mMimeType + "', mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ", mediaBitrate=" + this.mediaBitrate + ", isSystemMeidaStore=" + this.isSystemMeidaStore + ", isRegionThumbUseNewDecoder=" + this.isRegionThumbUseNewDecoder + ", panoramaPhotoType=" + this.panoramaPhotoType + ", mediaType=" + this.mMediaType + ", isVideoReady=" + this.isVideoReady + ", videoInfo=" + this.materialID + ", materialName=" + this.materialName + ", filterID=" + this.filterID + ", scheme=" + this.scheme + ", showCircleTakeSame=" + this.showCircleTakeSame + ", missionID=" + this.missionID + ", thumbnailProgress=" + this.thumbnailProgress + ", mediaOriginWidth=" + this.mediaOriginWidth + ", mediaOriginHeight=" + this.mediaOriginHeight + ", mediaOriginSize=" + this.mediaOriginSize + ", mediaOriginBitrate=" + this.mediaOriginBitrate + ", mOriginPath=" + this.mOriginPath + ", mKuolieId=" + this.mKuolieId + ", mKuolieCenterX=" + this.mKuolieCenterX + ", mKuolieCenterY=" + this.mKuolieCenterY + ", mKuolieRotate=" + this.mKuolieRotate + ", mKuolieWidthScale=" + this.mKuolieWidthScale + ", mKuolieHeightScale=" + this.mKuolieHeightScale + ", picPathBeforeEdit=" + this.picPathBeforeEdit + ", videoMimeType=" + this.videoMimeType + ", isHDRVideo=" + this.isHDRVideo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeLong(this._id);
        parcel.writeString(this.path);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.addedDate);
        parcel.writeLong(this.modifiedDate);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.rotation);
        parcel.writeLong(this.mDuration);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte(this.mChecked ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.selectStatus);
        parcel.writeInt(this.thumbWidth);
        parcel.writeInt(this.thumbHeight);
        parcel.writeString(this.thumbnailPath);
        parcel.writeInt(this.index);
        parcel.writeInt(this.position.intValue());
        parcel.writeString(this.mMimeType);
        parcel.writeInt(this.mMediaType);
        parcel.writeInt(this.mediaWidth);
        parcel.writeInt(this.mediaHeight);
        parcel.writeLong(this.mediaBitrate);
        parcel.writeInt(this.mediaOriginWidth);
        parcel.writeInt(this.mediaOriginHeight);
        parcel.writeLong(this.mediaOriginSize);
        parcel.writeLong(this.mediaOriginBitrate);
        parcel.writeByte(this.isSystemMeidaStore ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRegionThumbUseNewDecoder ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.longitude);
        parcel.writeInt(this.latitude);
        parcel.writeInt(this.panoramaPhotoType);
        parcel.writeLong(this.mCloudPhotoOwnerUin);
        parcel.writeString(this.mCloudPhotoOwnerAlbumId);
        parcel.writeString(this.mCloudPhotoId);
        parcel.writeByte(this.isVideoReady ? (byte) 1 : (byte) 0);
        parcel.writeString(this.materialID);
        parcel.writeString(this.materialName);
        parcel.writeString(this.filterID);
        parcel.writeString(this.scheme);
        parcel.writeInt(this.showCircleTakeSame);
        parcel.writeString(this.missionID);
        parcel.writeList(this.mTransferPosList);
        parcel.writeList(this.aiTextLabel);
        parcel.writeFloat(this.thumbnailProgress);
        parcel.writeList(this.mOriginPath);
        parcel.writeString(this.mKuolieId);
        parcel.writeFloat(this.mKuolieCenterX);
        parcel.writeFloat(this.mKuolieCenterY);
        parcel.writeFloat(this.mKuolieRotate);
        parcel.writeFloat(this.mKuolieWidthScale);
        parcel.writeFloat(this.mKuolieHeightScale);
        parcel.writeList(this.mHashTagList);
        parcel.writeByte(this.isRwa ? (byte) 1 : (byte) 0);
        parcel.writeString(this.picPathBeforeEdit);
        parcel.writeString(this.videoMimeType);
        parcel.writeByte(this.isHDRVideo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSegment ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVideoShareToQZone ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCaptured ? (byte) 1 : (byte) 0);
        Bundle bundle = new Bundle();
        bundle.putSerializable("extData", this.extData);
        parcel.writeBundle(bundle);
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) localMediaInfo)).intValue();
        }
        if (localMediaInfo == null) {
            return -1;
        }
        long j3 = localMediaInfo.modifiedDate;
        long j16 = this.modifiedDate;
        if (j3 > j16) {
            return 1;
        }
        return j3 == j16 ? 0 : -1;
    }
}
