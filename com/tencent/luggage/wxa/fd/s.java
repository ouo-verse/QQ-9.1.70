package com.tencent.luggage.wxa.fd;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s implements Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f125972a;

    /* renamed from: b, reason: collision with root package name */
    public String f125973b;

    /* renamed from: c, reason: collision with root package name */
    public String f125974c;

    /* renamed from: d, reason: collision with root package name */
    public String f125975d;

    /* renamed from: e, reason: collision with root package name */
    public String f125976e;

    /* renamed from: f, reason: collision with root package name */
    public String f125977f;

    /* renamed from: g, reason: collision with root package name */
    public String f125978g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createFromParcel(Parcel parcel) {
            return new s(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s[] newArray(int i3) {
            return new s[i3];
        }
    }

    public s() {
    }

    public void a(Parcel parcel) {
        this.f125972a = parcel.readInt();
        this.f125973b = parcel.readString();
        this.f125974c = parcel.readString();
        this.f125975d = parcel.readString();
        this.f125976e = parcel.readString();
        this.f125977f = parcel.readString();
        this.f125978g = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppBrandWeishiParams{fromOpenSdk=" + this.f125972a + ", thumbUrl='" + this.f125973b + "', thumbFullPath='" + this.f125974c + "', msgImgPath='" + this.f125975d + "', appId='" + this.f125976e + "', appName='" + this.f125977f + "', sourceUserName='" + this.f125978g + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f125972a);
        parcel.writeString(this.f125973b);
        parcel.writeString(this.f125974c);
        parcel.writeString(this.f125975d);
        parcel.writeString(this.f125976e);
        parcel.writeString(this.f125977f);
        parcel.writeString(this.f125978g);
    }

    public s(Parcel parcel) {
        a(parcel);
    }

    public void a(s sVar) {
        if (sVar == null) {
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        sVar.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        a(obtain);
        OaidMonitor.parcelRecycle(obtain);
    }
}
