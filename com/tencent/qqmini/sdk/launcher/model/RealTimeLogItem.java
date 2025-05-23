package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RealTimeLogItem implements Parcelable {
    public static final Parcelable.Creator<RealTimeLogItem> CREATOR = new Parcelable.Creator<RealTimeLogItem>() { // from class: com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLogItem createFromParcel(Parcel parcel) {
            return new RealTimeLogItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLogItem[] newArray(int i3) {
            return new RealTimeLogItem[i3];
        }
    };
    public int level;

    /* renamed from: msg, reason: collision with root package name */
    public String f348089msg;
    public long time;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.time);
        parcel.writeInt(this.level);
        parcel.writeString(this.f348089msg);
    }

    public RealTimeLogItem(long j3, int i3, String str) {
        this.time = j3;
        this.level = i3;
        this.f348089msg = str;
    }

    RealTimeLogItem(Parcel parcel) {
        this.time = parcel.readLong();
        this.level = parcel.readInt();
        this.f348089msg = parcel.readString();
    }
}
