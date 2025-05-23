package com.tencent.mobileqq.winkpublish.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smartparcelable.NeedParcel;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes21.dex */
public class MediaWrapper implements com.tencent.smartparcelable.a, Parcelable {
    public static final Parcelable.Creator<MediaWrapper> CREATOR = new a();
    private static final int MEDIA_TYPE_IMAGE = 0;
    private static final int MEDIA_TYPE_VIDEO = 1;

    @NeedParcel
    public String filterId;

    @NeedParcel
    public String mImageCropId;

    @NeedParcel
    public String mImageFrameId;

    @NeedParcel
    private ImageInfo mImageInfo;

    @NeedParcel
    private boolean mIsVideo2Gif;

    @NeedParcel
    public float mKuolieCenterX;

    @NeedParcel
    public float mKuolieCenterY;

    @NeedParcel
    public float mKuolieHeightScale;

    @NeedParcel
    public String mKuolieId;

    @NeedParcel
    public float mKuolieRotate;

    @NeedParcel
    public float mKuolieWidthScale;

    @NeedParcel
    public String mSucaiFilterId;

    @NeedParcel
    public String mSucaiStickerId;

    @NeedParcel
    public String mSucaiTemplateId;

    @NeedParcel
    public String mSucaiTextId;

    @NeedParcel
    private ShuoshuoVideoInfo mVideoInfo;

    @NeedParcel
    public String materialId;

    @NeedParcel
    public int photoOriginHeight;

    @NeedParcel
    public long photoOriginSize;

    @NeedParcel
    public int photoOriginWidth;

    @NeedParcel
    private int quality;

    @NeedParcel
    public int showCircleTakeSame;

    @NeedParcel
    public String simulateName;

    @NeedParcel
    public String simulateSchema;

    @NeedParcel
    private int type;

    @NeedParcel
    public long videoEditBitrate;

    @NeedParcel
    public long videoOriginBitrate;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<MediaWrapper> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaWrapper createFromParcel(Parcel parcel) {
            return new MediaWrapper(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaWrapper[] newArray(int i3) {
            return new MediaWrapper[i3];
        }
    }

    public MediaWrapper() {
        this.mIsVideo2Gif = false;
        this.mKuolieId = "";
        this.mKuolieCenterX = 0.0f;
        this.mKuolieCenterY = 0.0f;
        this.mKuolieRotate = 0.0f;
        this.mKuolieWidthScale = 0.0f;
        this.mKuolieHeightScale = 0.0f;
        this.mSucaiTemplateId = "";
        this.mSucaiFilterId = "";
        this.mSucaiStickerId = "";
        this.mSucaiTextId = "";
        this.mImageFrameId = "";
        this.mImageCropId = "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
    
        if (r11.isClosed() == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getVideoShootTime(Context context, String str) {
        long j3;
        long j16 = 0;
        if (TextUtils.isEmpty(str) || context == null) {
            return 0L;
        }
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"latitude", "longitude", "datetaken", "date_added"}, "_data = ?", strArr, "_id DESC LIMIT 1");
            if (cursor == null) {
                QLog.i("getVideoShootTime", 1, "MediaStore query error, cursor is null.");
            } else if (cursor.moveToNext()) {
                if (!cursor.isNull(0)) {
                    cursor.getDouble(0);
                }
                if (!cursor.isNull(1)) {
                    cursor.getDouble(1);
                }
                if (!cursor.isNull(2)) {
                    j3 = cursor.getLong(2);
                } else if (!cursor.isNull(3)) {
                    j3 = cursor.getLong(3);
                }
                j16 = j3;
            }
        } catch (Throwable th5) {
            try {
                QLog.e("getVideoShootTime", 1, th5.getMessage());
                if (0 != 0) {
                }
            } finally {
                if (0 != 0 && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return j16;
    }

    public static VideoInfo toVideoInfo(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return null;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.videoUrl = new VideoUrl(shuoshuoVideoInfo.mVideoPath);
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = shuoshuoVideoInfo.mVideoPath;
        pictureUrl.width = shuoshuoVideoInfo.mVideoWidth;
        pictureUrl.height = shuoshuoVideoInfo.mVideoHeight;
        String str = shuoshuoVideoInfo.mCoverUrl;
        if (str != null) {
            pictureUrl.url = str;
        }
        videoInfo.bigUrl = pictureUrl;
        videoInfo.originUrl = pictureUrl;
        videoInfo.currentUrl = pictureUrl;
        videoInfo.coverUrl = pictureUrl;
        long j3 = shuoshuoVideoInfo.mDuration;
        videoInfo.videoTime = j3;
        videoInfo.validVideoTime = j3;
        videoInfo.showVideoTime = VideoInfo.getShownTimeFromNumeric(j3);
        videoInfo.videoType = 2;
        videoInfo.actionType = 3;
        videoInfo.playType = (byte) 1;
        videoInfo.isFakeFeed = shuoshuoVideoInfo.mIsFakeFeed;
        videoInfo.desc = shuoshuoVideoInfo.mDescription;
        videoInfo.shootTime = shuoshuoVideoInfo.mShootTime;
        videoInfo.perfKey = shuoshuoVideoInfo.perfKey;
        return videoInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public int getQuality() {
        return this.quality;
    }

    public ShuoshuoVideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public boolean isImage() {
        if (this.type == 0) {
            return true;
        }
        return false;
    }

    public boolean isVideo() {
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    public boolean isVideo2Gif() {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        if (isVideo() && (shuoshuoVideoInfo = this.mVideoInfo) != null && shuoshuoVideoInfo.mNeedProcess && this.mIsVideo2Gif) {
            return true;
        }
        return false;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z16;
        this.type = parcel.readInt();
        this.quality = parcel.readInt();
        this.mImageInfo = (ImageInfo) parcel.readParcelable(ImageInfo.class.getClassLoader());
        this.mVideoInfo = (ShuoshuoVideoInfo) parcel.readParcelable(ShuoshuoVideoInfo.class.getClassLoader());
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsVideo2Gif = z16;
        this.materialId = parcel.readString();
        this.filterId = parcel.readString();
        this.simulateName = parcel.readString();
        this.simulateSchema = parcel.readString();
        this.showCircleTakeSame = parcel.readInt();
        this.photoOriginWidth = parcel.readInt();
        this.photoOriginHeight = parcel.readInt();
        this.photoOriginSize = parcel.readLong();
        this.videoOriginBitrate = parcel.readLong();
        this.videoEditBitrate = parcel.readLong();
        this.mKuolieId = parcel.readString();
        this.mKuolieCenterX = parcel.readFloat();
        this.mKuolieCenterY = parcel.readFloat();
        this.mKuolieRotate = parcel.readFloat();
        this.mKuolieWidthScale = parcel.readFloat();
        this.mKuolieHeightScale = parcel.readFloat();
        this.mSucaiTemplateId = parcel.readString();
        this.mSucaiFilterId = parcel.readString();
        this.mSucaiStickerId = parcel.readString();
        this.mSucaiTextId = parcel.readString();
        this.mImageFrameId = parcel.readString();
        this.mImageCropId = parcel.readString();
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.mImageInfo = imageInfo;
    }

    public void setQuality(int i3) {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        this.quality = i3;
        if (isVideo() && this.quality == 3 && (shuoshuoVideoInfo = this.mVideoInfo) != null) {
            shuoshuoVideoInfo.mNeedProcess = false;
        }
    }

    public void setShuoShuoVideoInfo(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return;
        }
        this.mVideoInfo = shuoshuoVideoInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("MediaWrapper{\n");
        stringBuffer.append("materialID='");
        stringBuffer.append(this.materialId);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", filterId='");
        stringBuffer.append(this.filterId);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", materialName='");
        stringBuffer.append(this.simulateName);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", scheme='");
        stringBuffer.append(this.simulateSchema);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", mKuolieId='");
        stringBuffer.append(this.mKuolieId);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", mKuolieCenterX=");
        stringBuffer.append(this.mKuolieCenterX);
        stringBuffer.append('\n');
        stringBuffer.append(", mKuolieCenterY=");
        stringBuffer.append(this.mKuolieCenterY);
        stringBuffer.append('\n');
        stringBuffer.append(", mKuolieRotate=");
        stringBuffer.append(this.mKuolieRotate);
        stringBuffer.append('\n');
        stringBuffer.append(", mKuolieWidthScale=");
        stringBuffer.append(this.mKuolieWidthScale);
        stringBuffer.append('\n');
        stringBuffer.append(", mKuolieHeightScale=");
        stringBuffer.append(this.mKuolieHeightScale);
        stringBuffer.append('\n');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.quality);
        parcel.writeParcelable(this.mImageInfo, i3);
        parcel.writeParcelable(this.mVideoInfo, i3);
        parcel.writeByte(this.mIsVideo2Gif ? (byte) 1 : (byte) 0);
        parcel.writeString(this.materialId);
        parcel.writeString(this.filterId);
        parcel.writeString(this.simulateName);
        parcel.writeString(this.simulateSchema);
        parcel.writeInt(this.showCircleTakeSame);
        parcel.writeInt(this.photoOriginWidth);
        parcel.writeInt(this.photoOriginHeight);
        parcel.writeLong(this.photoOriginSize);
        parcel.writeLong(this.videoOriginBitrate);
        parcel.writeLong(this.videoEditBitrate);
        parcel.writeString(this.mKuolieId);
        parcel.writeFloat(this.mKuolieCenterX);
        parcel.writeFloat(this.mKuolieCenterY);
        parcel.writeFloat(this.mKuolieRotate);
        parcel.writeFloat(this.mKuolieWidthScale);
        parcel.writeFloat(this.mKuolieHeightScale);
        parcel.writeString(this.mSucaiTemplateId);
        parcel.writeString(this.mSucaiFilterId);
        parcel.writeString(this.mSucaiStickerId);
        parcel.writeString(this.mSucaiTextId);
        parcel.writeString(this.mImageFrameId);
        parcel.writeString(this.mImageCropId);
    }

    public MediaWrapper(ImageInfo imageInfo) {
        this.mIsVideo2Gif = false;
        this.mKuolieId = "";
        this.mKuolieCenterX = 0.0f;
        this.mKuolieCenterY = 0.0f;
        this.mKuolieRotate = 0.0f;
        this.mKuolieWidthScale = 0.0f;
        this.mKuolieHeightScale = 0.0f;
        this.mSucaiTemplateId = "";
        this.mSucaiFilterId = "";
        this.mSucaiStickerId = "";
        this.mSucaiTextId = "";
        this.mImageFrameId = "";
        this.mImageCropId = "";
        this.type = 0;
        this.mImageInfo = imageInfo;
    }

    public MediaWrapper(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        this.mIsVideo2Gif = false;
        this.mKuolieId = "";
        this.mKuolieCenterX = 0.0f;
        this.mKuolieCenterY = 0.0f;
        this.mKuolieRotate = 0.0f;
        this.mKuolieWidthScale = 0.0f;
        this.mKuolieHeightScale = 0.0f;
        this.mSucaiTemplateId = "";
        this.mSucaiFilterId = "";
        this.mSucaiStickerId = "";
        this.mSucaiTextId = "";
        this.mImageFrameId = "";
        this.mImageCropId = "";
        this.type = 1;
        this.mVideoInfo = shuoshuoVideoInfo;
        int videoCanCompressLimitMs = QZoneHelper.getVideoCanCompressLimitMs();
        this.mVideoInfo.mNeedProcess = shuoshuoVideoInfo.mTotalDuration < ((long) videoCanCompressLimitMs);
    }

    public MediaWrapper(ShuoshuoVideoInfo shuoshuoVideoInfo, boolean z16) {
        this(shuoshuoVideoInfo, z16, false);
    }

    public MediaWrapper(ShuoshuoVideoInfo shuoshuoVideoInfo, boolean z16, boolean z17) {
        this.mIsVideo2Gif = false;
        this.mKuolieId = "";
        this.mKuolieCenterX = 0.0f;
        this.mKuolieCenterY = 0.0f;
        this.mKuolieRotate = 0.0f;
        this.mKuolieWidthScale = 0.0f;
        this.mKuolieHeightScale = 0.0f;
        this.mSucaiTemplateId = "";
        this.mSucaiFilterId = "";
        this.mSucaiStickerId = "";
        this.mSucaiTextId = "";
        this.mImageFrameId = "";
        this.mImageCropId = "";
        this.type = 1;
        this.mVideoInfo = shuoshuoVideoInfo;
        shuoshuoVideoInfo.mNeedProcess = z16;
        this.mIsVideo2Gif = z17;
    }

    protected MediaWrapper(Parcel parcel) {
        this.mIsVideo2Gif = false;
        this.mKuolieId = "";
        this.mKuolieCenterX = 0.0f;
        this.mKuolieCenterY = 0.0f;
        this.mKuolieRotate = 0.0f;
        this.mKuolieWidthScale = 0.0f;
        this.mKuolieHeightScale = 0.0f;
        this.mSucaiTemplateId = "";
        this.mSucaiFilterId = "";
        this.mSucaiStickerId = "";
        this.mSucaiTextId = "";
        this.mImageFrameId = "";
        this.mImageCropId = "";
        this.type = parcel.readInt();
        this.quality = parcel.readInt();
        this.mImageInfo = (ImageInfo) parcel.readParcelable(ImageInfo.class.getClassLoader());
        this.mVideoInfo = (ShuoshuoVideoInfo) parcel.readParcelable(ShuoshuoVideoInfo.class.getClassLoader());
        this.mIsVideo2Gif = parcel.readByte() != 0;
        this.materialId = parcel.readString();
        this.filterId = parcel.readString();
        this.simulateName = parcel.readString();
        this.simulateSchema = parcel.readString();
        this.showCircleTakeSame = parcel.readInt();
        this.photoOriginWidth = parcel.readInt();
        this.photoOriginHeight = parcel.readInt();
        this.photoOriginSize = parcel.readLong();
        this.videoOriginBitrate = parcel.readLong();
        this.videoEditBitrate = parcel.readLong();
        this.mKuolieId = parcel.readString();
        this.mKuolieCenterX = parcel.readFloat();
        this.mKuolieCenterY = parcel.readFloat();
        this.mKuolieRotate = parcel.readFloat();
        this.mKuolieWidthScale = parcel.readFloat();
        this.mKuolieHeightScale = parcel.readFloat();
        this.mSucaiTemplateId = parcel.readString();
        this.mSucaiFilterId = parcel.readString();
        this.mSucaiStickerId = parcel.readString();
        this.mSucaiTextId = parcel.readString();
        this.mImageFrameId = parcel.readString();
        this.mImageCropId = parcel.readString();
    }
}
