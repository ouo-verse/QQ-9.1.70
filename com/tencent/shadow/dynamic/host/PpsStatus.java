package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes25.dex */
public final class PpsStatus implements Parcelable {
    public static final Parcelable.Creator<PpsStatus> CREATOR = new Parcelable.Creator<PpsStatus>() { // from class: com.tencent.shadow.dynamic.host.PpsStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PpsStatus createFromParcel(Parcel parcel) {
            return new PpsStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PpsStatus[] newArray(int i3) {
            return new PpsStatus[i3];
        }
    };
    public final boolean loaderLoaded;
    public final boolean runtimeLoaded;
    public final String uuid;
    public final boolean uuidManagerSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PpsStatus(String str, boolean z16, boolean z17, boolean z18) {
        this.uuid = str;
        this.runtimeLoaded = z16;
        this.loaderLoaded = z17;
        this.uuidManagerSet = z18;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.uuid);
        parcel.writeByte(this.runtimeLoaded ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.loaderLoaded ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.uuidManagerSet ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PpsStatus(Parcel parcel) {
        this.uuid = parcel.readString();
        this.runtimeLoaded = parcel.readByte() != 0;
        this.loaderLoaded = parcel.readByte() != 0;
        this.uuidManagerSet = parcel.readByte() != 0;
    }
}
