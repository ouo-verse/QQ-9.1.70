package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class PermissionInfo implements Parcelable {
    public static final Parcelable.Creator<PermissionInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f36224d;

    /* renamed from: e, reason: collision with root package name */
    private String f36225e;

    /* renamed from: f, reason: collision with root package name */
    private String f36226f;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PermissionInfo createFromParcel(Parcel parcel) {
            return new PermissionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PermissionInfo[] newArray(int i3) {
            return new PermissionInfo[i3];
        }
    }

    public PermissionInfo() {
    }

    public PermissionInfo a(String str) {
        this.f36226f = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36224d);
        parcel.writeString(this.f36225e);
        parcel.writeString(this.f36226f);
    }

    public PermissionInfo(Parcel parcel) {
        this.f36224d = parcel.readString();
        this.f36225e = parcel.readString();
        this.f36226f = parcel.readString();
    }
}
