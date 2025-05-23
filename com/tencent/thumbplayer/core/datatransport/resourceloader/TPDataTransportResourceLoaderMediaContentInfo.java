package com.tencent.thumbplayer.core.datatransport.resourceloader;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes26.dex */
public class TPDataTransportResourceLoaderMediaContentInfo implements Parcelable {
    public static final Parcelable.Creator<TPDataTransportResourceLoaderMediaContentInfo> CREATOR = new Parcelable.Creator<TPDataTransportResourceLoaderMediaContentInfo>() { // from class: com.tencent.thumbplayer.core.datatransport.resourceloader.TPDataTransportResourceLoaderMediaContentInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDataTransportResourceLoaderMediaContentInfo createFromParcel(Parcel parcel) {
            return new TPDataTransportResourceLoaderMediaContentInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDataTransportResourceLoaderMediaContentInfo[] newArray(int i3) {
            return new TPDataTransportResourceLoaderMediaContentInfo[i3];
        }
    };
    private final long mContentLength;
    private final String mContentType;
    private int mResponseCode;

    public TPDataTransportResourceLoaderMediaContentInfo(String str, long j3, int i3) {
        this.mContentType = str;
        this.mContentLength = j3;
        this.mResponseCode = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mContentType);
        parcel.writeLong(this.mContentLength);
        parcel.writeInt(this.mResponseCode);
    }

    protected TPDataTransportResourceLoaderMediaContentInfo(Parcel parcel) {
        this.mContentType = parcel.readString();
        this.mContentLength = parcel.readLong();
        this.mResponseCode = parcel.readInt();
    }
}
