package com.tencent.luggage.wxa.va;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public static final e f143316a = new e();
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
