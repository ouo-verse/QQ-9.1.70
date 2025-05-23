package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileMaterialInfo implements Parcelable {
    public static final Parcelable.Creator<FileMaterialInfo> CREATOR = new Parcelable.Creator<FileMaterialInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileMaterialInfo createFromParcel(Parcel parcel) {
            return new FileMaterialInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileMaterialInfo[] newArray(int i3) {
            return new FileMaterialInfo[i3];
        }
    };
    private final String mimeType;
    private final String name;
    private final String path;
    private final long size;
    private String tmpPath;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public String getTmpPath() {
        return this.tmpPath;
    }

    public void setTmpPath(String str) {
        this.tmpPath = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.name);
        parcel.writeString(this.path);
        parcel.writeLong(this.size);
        parcel.writeString(this.tmpPath);
    }

    public FileMaterialInfo(String str, String str2, String str3, long j3) {
        this.mimeType = str;
        this.name = str2;
        this.path = str3;
        this.size = j3;
    }

    FileMaterialInfo(Parcel parcel) {
        this.mimeType = parcel.readString();
        this.name = parcel.readString();
        this.path = parcel.readString();
        this.size = parcel.readLong();
        this.tmpPath = parcel.readString();
    }
}
