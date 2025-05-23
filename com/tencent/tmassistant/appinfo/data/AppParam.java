package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes26.dex */
public class AppParam implements Parcelable {
    public static final Parcelable.Creator<AppParam> CREATOR = new a();
    public String channelId;
    public String packageName;

    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<AppParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppParam createFromParcel(Parcel parcel) {
            return new AppParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppParam[] newArray(int i3) {
            return new AppParam[i3];
        }
    }

    public AppParam() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.channelId);
        parcel.writeString(this.packageName);
    }

    protected AppParam(Parcel parcel) {
        this.channelId = parcel.readString();
        this.packageName = parcel.readString();
    }
}
