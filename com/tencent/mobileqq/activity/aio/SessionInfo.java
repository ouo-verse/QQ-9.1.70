package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SessionInfo extends p implements Parcelable, Cloneable {
    public static final Parcelable.Creator<SessionInfo> CREATOR = new a();

    /* renamed from: h0, reason: collision with root package name */
    public t f178171h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f178172i0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<SessionInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SessionInfo createFromParcel(Parcel parcel) {
            return new SessionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SessionInfo[] newArray(int i3) {
            return new SessionInfo[i3];
        }
    }

    public SessionInfo() {
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f179555d);
        parcel.writeString(this.f179557e);
        parcel.writeString(this.f179559f);
        parcel.writeString(this.f179563i);
        parcel.writeString(this.f179564m);
        parcel.writeInt(this.Q);
        parcel.writeString(c());
        parcel.writeString(e());
        parcel.writeBundle(b());
        parcel.writeString(this.f178172i0);
    }

    protected SessionInfo(Parcel parcel) {
        this.f179555d = parcel.readInt();
        this.f179557e = parcel.readString();
        this.f179559f = parcel.readString();
        this.f179563i = parcel.readString();
        this.f179564m = parcel.readString();
        this.Q = parcel.readInt();
        j(parcel.readString());
        k(parcel.readString());
        f(parcel.readBundle(getClass().getClassLoader()));
        this.f178172i0 = parcel.readString();
    }
}
