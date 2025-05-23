package com.tencent.thumbplayer.core.datatransport.resourceloader;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public class TPDataTransportResourceLoaderData implements Parcelable {
    public static final Parcelable.Creator<TPDataTransportResourceLoaderData> CREATOR = new Parcelable.Creator<TPDataTransportResourceLoaderData>() { // from class: com.tencent.thumbplayer.core.datatransport.resourceloader.TPDataTransportResourceLoaderData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDataTransportResourceLoaderData createFromParcel(Parcel parcel) {
            return new TPDataTransportResourceLoaderData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDataTransportResourceLoaderData[] newArray(int i3) {
            return new TPDataTransportResourceLoaderData[i3];
        }
    };
    private byte[] mData;
    private int mResponseCode;

    public TPDataTransportResourceLoaderData(@Nullable byte[] bArr, int i3) {
        this.mData = bArr;
        this.mResponseCode = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    protected TPDataTransportResourceLoaderData(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
