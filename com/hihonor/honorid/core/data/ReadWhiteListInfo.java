package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ReadWhiteListInfo implements Parcelable {
    public static final Parcelable.Creator<ReadWhiteListInfo> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ReadWhiteListInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadWhiteListInfo createFromParcel(Parcel parcel) {
            return new ReadWhiteListInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadWhiteListInfo[] newArray(int i3) {
            return new ReadWhiteListInfo[i3];
        }
    }

    protected ReadWhiteListInfo(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
