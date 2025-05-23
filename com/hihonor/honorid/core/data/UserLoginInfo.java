package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UserLoginInfo implements Parcelable {
    public static final Parcelable.Creator<UserLoginInfo> CREATOR = new a();
    private String C;
    private String D;

    /* renamed from: d, reason: collision with root package name */
    private String f36318d;

    /* renamed from: e, reason: collision with root package name */
    private String f36319e;

    /* renamed from: f, reason: collision with root package name */
    private String f36320f;

    /* renamed from: h, reason: collision with root package name */
    private String f36321h;

    /* renamed from: i, reason: collision with root package name */
    private String f36322i;

    /* renamed from: m, reason: collision with root package name */
    private String f36323m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<UserLoginInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserLoginInfo createFromParcel(Parcel parcel) {
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.D = parcel.readString();
            userLoginInfo.f36321h = parcel.readString();
            userLoginInfo.f36323m = parcel.readString();
            userLoginInfo.f36322i = parcel.readString();
            userLoginInfo.C = parcel.readString();
            userLoginInfo.f36319e = parcel.readString();
            userLoginInfo.f36320f = parcel.readString();
            userLoginInfo.f36318d = parcel.readString();
            return userLoginInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UserLoginInfo[] newArray(int i3) {
            return new UserLoginInfo[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.D);
        parcel.writeString(this.f36321h);
        parcel.writeString(this.f36323m);
        parcel.writeString(this.f36322i);
        parcel.writeString(this.C);
        parcel.writeString(this.f36319e);
        parcel.writeString(this.f36320f);
        parcel.writeString(this.f36318d);
    }
}
