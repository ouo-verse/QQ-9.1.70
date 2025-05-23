package com.hihonor.honorid.core.helper.handler;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ErrorStatus implements Parcelable {
    public static final Parcelable.Creator<ErrorStatus> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private int f36324d;

    /* renamed from: e, reason: collision with root package name */
    private String f36325e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ErrorStatus> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ErrorStatus createFromParcel(Parcel parcel) {
            ErrorStatus errorStatus = new ErrorStatus();
            errorStatus.f36324d = parcel.readInt();
            errorStatus.f36325e = parcel.readString();
            return errorStatus;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ErrorStatus[] newArray(int i3) {
            return new ErrorStatus[i3];
        }
    }

    public ErrorStatus() {
    }

    public int c() {
        return this.f36324d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[ErrorCode]:" + this.f36324d + "[DES]:" + this.f36325e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36324d);
        parcel.writeString(this.f36325e);
    }

    public ErrorStatus(int i3, String str) {
        this.f36324d = i3;
        this.f36325e = str;
    }
}
