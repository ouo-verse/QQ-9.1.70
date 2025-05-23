package com.tencent.mobileqq.winkpublish.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smartparcelable.NeedParcel;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ImageInfo implements com.tencent.smartparcelable.a, Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = new a();

    @NeedParcel
    public long duration;

    @NeedParcel
    public String mDescription;

    @NeedParcel
    public HashMap<String, byte[]> mExternalData;

    @NeedParcel
    public GpsInfo4LocalImage mGpsInfo;

    @NeedParcel
    public long mModifiedDate;

    @NeedParcel
    public String mName;

    @NeedParcel
    public String mPath;

    @NeedParcel
    public HashMap<String, String> mPhotoTagInfo;

    @NeedParcel
    public long mSize;

    @NeedParcel
    public String mimeType;

    @NeedParcel
    public int panoramaType;

    @NeedParcel
    public int photoHeight;

    @NeedParcel
    public int photoId;

    @NeedParcel
    public int photoOriginHeight;

    @NeedParcel
    public long photoOriginSize;

    @NeedParcel
    public int photoOriginWidth;

    @NeedParcel
    public int photoWidth;

    @NeedParcel
    public double uploadProbability;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class InvalidImageException extends Exception {
        public InvalidImageException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<ImageInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageInfo createFromParcel(Parcel parcel) {
            return new ImageInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ImageInfo[] newArray(int i3) {
            return new ImageInfo[i3];
        }
    }

    public ImageInfo() {
        this.mExternalData = new HashMap<>();
        this.uploadProbability = -1.0d;
        this.duration = 0L;
    }

    private boolean compare(ImageInfo imageInfo) {
        if (this.mName.equals(imageInfo.mName) && this.mSize == imageInfo.mSize && this.mModifiedDate == imageInfo.mModifiedDate && this.mPath.equals(imageInfo.mPath)) {
            return true;
        }
        return false;
    }

    public static ImageInfo create(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new ImageInfo(str, true);
        } catch (InvalidImageException e16) {
            QLog.e("[upload2]ImageInfo", 1, "create ImageInfo from path error.", e16);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ImageInfo)) {
            return compare((ImageInfo) obj);
        }
        return false;
    }

    public int hashCode() {
        return (this.mName + this.mSize + this.mModifiedDate).hashCode();
    }

    public void readFromParcel(Parcel parcel) {
        this.mPath = parcel.readString();
        this.mName = parcel.readString();
        this.mSize = parcel.readLong();
        this.mModifiedDate = parcel.readLong();
        this.mDescription = parcel.readString();
        this.mGpsInfo = (GpsInfo4LocalImage) parcel.readParcelable(GpsInfo4LocalImage.class.getClassLoader());
        this.mPhotoTagInfo = (HashMap) parcel.readSerializable();
        this.mExternalData = (HashMap) parcel.readSerializable();
        this.photoId = parcel.readInt();
        this.uploadProbability = parcel.readDouble();
        this.panoramaType = parcel.readInt();
        this.duration = parcel.readLong();
        this.photoWidth = parcel.readInt();
        this.photoHeight = parcel.readInt();
        this.photoOriginWidth = parcel.readInt();
        this.photoOriginHeight = parcel.readInt();
        this.photoOriginSize = parcel.readLong();
        this.mimeType = parcel.readString();
    }

    public String toString() {
        return "ImageInfo{mPath='" + this.mPath + "', mName='" + this.mName + "', mSize=" + this.mSize + ", mModifiedDate=" + this.mModifiedDate + ", mDescription='" + this.mDescription + "', photoId=" + this.photoId + ", uploadProbability=" + this.uploadProbability + ", panoramaType=" + this.panoramaType + ", duration=" + this.duration + ", photoWidth=" + this.photoWidth + ", photoHeight=" + this.photoHeight + ", mimeType='" + this.mimeType + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mPath);
        parcel.writeString(this.mName);
        parcel.writeLong(this.mSize);
        parcel.writeLong(this.mModifiedDate);
        parcel.writeString(this.mDescription);
        parcel.writeParcelable(this.mGpsInfo, i3);
        parcel.writeSerializable(this.mPhotoTagInfo);
        parcel.writeSerializable(this.mExternalData);
        parcel.writeInt(this.photoId);
        parcel.writeDouble(this.uploadProbability);
        parcel.writeInt(this.panoramaType);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.photoWidth);
        parcel.writeInt(this.photoHeight);
        parcel.writeInt(this.photoOriginWidth);
        parcel.writeInt(this.photoOriginHeight);
        parcel.writeLong(this.photoOriginSize);
        parcel.writeString(this.mimeType);
    }

    public ImageInfo(String str) {
        this.mExternalData = new HashMap<>();
        this.uploadProbability = -1.0d;
        this.duration = 0L;
        File file = new File(str);
        this.mPath = file.getAbsolutePath();
        this.mName = file.getName();
        this.mSize = file.length();
        this.mModifiedDate = file.lastModified();
    }

    public ImageInfo(String str, boolean z16) throws InvalidImageException {
        this.mExternalData = new HashMap<>();
        this.uploadProbability = -1.0d;
        this.duration = 0L;
        File file = new File(str);
        if (z16 && (!file.exists() || file.isDirectory())) {
            throw new InvalidImageException("image file not exist!");
        }
        this.mPath = file.getAbsolutePath();
        this.mName = file.getName();
        this.mSize = file.length();
        this.mModifiedDate = file.lastModified();
    }

    protected ImageInfo(Parcel parcel) {
        this.mExternalData = new HashMap<>();
        this.uploadProbability = -1.0d;
        this.duration = 0L;
        this.mPath = parcel.readString();
        this.mName = parcel.readString();
        this.mSize = parcel.readLong();
        this.mModifiedDate = parcel.readLong();
        this.mDescription = parcel.readString();
        this.mGpsInfo = (GpsInfo4LocalImage) parcel.readParcelable(GpsInfo4LocalImage.class.getClassLoader());
        this.mPhotoTagInfo = (HashMap) parcel.readSerializable();
        this.mExternalData = (HashMap) parcel.readSerializable();
        this.photoId = parcel.readInt();
        this.uploadProbability = parcel.readDouble();
        this.panoramaType = parcel.readInt();
        this.duration = parcel.readLong();
        this.photoWidth = parcel.readInt();
        this.photoHeight = parcel.readInt();
        this.photoOriginWidth = parcel.readInt();
        this.photoOriginHeight = parcel.readInt();
        this.photoOriginSize = parcel.readLong();
        this.mimeType = parcel.readString();
    }
}
