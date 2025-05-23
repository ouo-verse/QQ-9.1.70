package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UserAccountInfo implements Parcelable {
    public static final Parcelable.Creator<UserAccountInfo> CREATOR = new a();
    private String C;
    private String D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private String f36286d;

    /* renamed from: e, reason: collision with root package name */
    private String f36287e;

    /* renamed from: f, reason: collision with root package name */
    private String f36288f;

    /* renamed from: h, reason: collision with root package name */
    private String f36289h;

    /* renamed from: i, reason: collision with root package name */
    private String f36290i;

    /* renamed from: m, reason: collision with root package name */
    private String f36291m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<UserAccountInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserAccountInfo createFromParcel(Parcel parcel) {
            UserAccountInfo userAccountInfo = new UserAccountInfo();
            userAccountInfo.f36286d = parcel.readString();
            userAccountInfo.f36287e = parcel.readString();
            userAccountInfo.f36288f = parcel.readString();
            userAccountInfo.f36289h = parcel.readString();
            userAccountInfo.f36290i = parcel.readString();
            userAccountInfo.f36291m = parcel.readString();
            userAccountInfo.C = parcel.readString();
            userAccountInfo.D = parcel.readString();
            userAccountInfo.E = parcel.readString();
            return userAccountInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UserAccountInfo[] newArray(int i3) {
            return new UserAccountInfo[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36286d);
        parcel.writeString(this.f36287e);
        parcel.writeString(this.f36288f);
        parcel.writeString(this.f36289h);
        parcel.writeString(this.f36290i);
        parcel.writeString(this.f36291m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
    }
}
