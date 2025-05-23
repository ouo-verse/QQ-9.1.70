package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import java.io.File;
import java.util.Objects;

/* loaded from: classes18.dex */
public class AIOPictureData extends AIOBrowserBaseData {
    public static final int BUSINESS_TYPE_HOT_PIC = 4;
    public static final int BUSINESS_TYPE_NONE = 0;
    public static final int BUSINESS_TYPE_QQCOMIC = 1;
    public static final int BUSINESS_TYPE_SCREEN_SHOT = 2;
    public static final int BUSINESS_TYPE_TROOP_FILE = 3;
    public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new a();
    public static final int TYPE_DISPLAY_TEMP_IMAGE = 8;
    public static final int TYPE_LARGE_IMAGE = 2;
    public static final int TYPE_ORIGINAL_IMAGE = 4;
    public static final int TYPE_SAVE_ORIGINAL_IMAGE = 24;
    public static final int TYPE_THUMB_IMAGE = 1;
    public String anId;
    public String content;
    public String filePath;
    public String friendUin;
    public long groupFileID;
    public int imageBizType;
    public boolean isAnonymousMsg;
    public boolean isSend;
    public boolean mIsPart;
    public String md5;
    public String picServerUrl;
    public String sendUin;
    public String templateId;
    public String templateName;
    public long timestamp;
    public String thumbImageFile = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String largeImageFile = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String originImageFile = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String mDisplayFile = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public boolean mThumbError = false;
    public boolean mLargeError = false;
    public boolean mOriginError = false;
    public String mLargeErrorDesc = null;
    public boolean mHasShownErrorToast = false;
    public String uuid = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public int mBusinessType = 0;
    public boolean isPicFile = false;
    public boolean isFromFile = false;

    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<RichMediaBaseData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData createFromParcel(Parcel parcel) {
            AIOPictureData aIOPictureData = new AIOPictureData();
            aIOPictureData.readFromParcel(parcel);
            return aIOPictureData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData[] newArray(int i3) {
            return new RichMediaBaseData[i3];
        }
    }

    public String getMaxSizeExistFile() {
        if (!Objects.equals(this.originImageFile, AIOBrowserBaseData.MEDIA_FILE_NONE) && new File(this.originImageFile).exists()) {
            return this.originImageFile;
        }
        if (!Objects.equals(this.largeImageFile, AIOBrowserBaseData.MEDIA_FILE_NONE) && new File(this.largeImageFile).exists()) {
            return this.largeImageFile;
        }
        if (!Objects.equals(this.thumbImageFile, AIOBrowserBaseData.MEDIA_FILE_NONE) && new File(this.thumbImageFile).exists()) {
            return this.thumbImageFile;
        }
        return "";
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public int getType() {
        return 100;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData, com.tencent.richmediabrowser.model.RichMediaBaseData
    public void readFromParcel(Parcel parcel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        super.readFromParcel(parcel);
        this.thumbImageFile = parcel.readString();
        this.largeImageFile = parcel.readString();
        this.originImageFile = parcel.readString();
        this.mDisplayFile = parcel.readString();
        this.uuid = parcel.readString();
        this.timestamp = parcel.readLong();
        this.groupFileID = parcel.readLong();
        boolean z26 = false;
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsPart = z16;
        this.mBusinessType = parcel.readInt();
        if (parcel.readByte() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.isPicFile = z17;
        this.filePath = parcel.readString();
        this.md5 = parcel.readString();
        this.picServerUrl = parcel.readString();
        this.sendUin = parcel.readString();
        if (parcel.readInt() == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.isFromFile = z18;
        this.imageBizType = parcel.readInt();
        if (parcel.readInt() == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.isSend = z19;
        this.friendUin = parcel.readString();
        if (parcel.readInt() == 1) {
            z26 = true;
        }
        this.isAnonymousMsg = z26;
        this.anId = parcel.readString();
        this.content = parcel.readString();
        this.templateId = parcel.readString();
        this.templateName = parcel.readString();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData, com.tencent.richmediabrowser.model.RichMediaBaseData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.thumbImageFile);
        parcel.writeString(this.largeImageFile);
        parcel.writeString(this.originImageFile);
        parcel.writeString(this.mDisplayFile);
        parcel.writeString(this.uuid);
        parcel.writeLong(this.timestamp);
        parcel.writeLong(this.groupFileID);
        parcel.writeByte(this.mIsPart ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mBusinessType);
        parcel.writeByte(this.isPicFile ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filePath);
        parcel.writeString(this.md5);
        parcel.writeString(this.picServerUrl);
        parcel.writeString(this.sendUin);
        parcel.writeInt(this.isFromFile ? 1 : 0);
        parcel.writeInt(this.imageBizType);
        parcel.writeInt(this.isSend ? 1 : 0);
        parcel.writeString(this.friendUin);
        parcel.writeInt(this.isAnonymousMsg ? 1 : 0);
        parcel.writeString(this.anId);
        parcel.writeString(this.content);
        parcel.writeString(this.templateId);
        parcel.writeString(this.templateName);
    }
}
