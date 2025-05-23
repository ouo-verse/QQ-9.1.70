package com.tencent.luggage.wxa.fd;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f125835a;

    /* renamed from: b, reason: collision with root package name */
    public int f125836b;

    /* renamed from: c, reason: collision with root package name */
    public int f125837c;

    /* renamed from: d, reason: collision with root package name */
    public String f125838d;

    /* renamed from: e, reason: collision with root package name */
    public String f125839e;

    /* renamed from: f, reason: collision with root package name */
    public int f125840f;

    /* renamed from: g, reason: collision with root package name */
    public String f125841g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i3) {
            return new l[i3];
        }
    }

    public /* synthetic */ l(Parcel parcel, a aVar) {
        this(parcel);
    }

    public void a(Parcel parcel) {
        this.f125835a = parcel.readString();
        this.f125836b = parcel.readInt();
        this.f125837c = parcel.readInt();
        this.f125838d = parcel.readString();
        this.f125839e = parcel.readString();
        this.f125840f = parcel.readInt();
        this.f125841g = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppBrandLaunchFromNotifyReferrer{appId=" + this.f125835a + ", uin='" + this.f125836b + "', readscene='" + this.f125837c + "', appbrandPushMsgId='" + this.f125838d + "', content='" + this.f125839e + "', opLocation='" + this.f125840f + "', reportSessionId='" + this.f125841g + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f125835a);
        parcel.writeInt(this.f125836b);
        parcel.writeInt(this.f125837c);
        parcel.writeString(this.f125838d);
        parcel.writeString(this.f125839e);
        parcel.writeInt(this.f125840f);
        parcel.writeString(this.f125841g);
    }

    public l(Parcel parcel) {
        a(parcel);
    }
}
