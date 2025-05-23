package com.tencent.luggage.wxa.bk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();
    public String C;
    public String D;
    public int E;

    /* renamed from: a, reason: collision with root package name */
    public int f122982a;

    /* renamed from: b, reason: collision with root package name */
    public String f122983b;

    /* renamed from: c, reason: collision with root package name */
    public int f122984c;

    /* renamed from: d, reason: collision with root package name */
    public String f122985d;

    /* renamed from: e, reason: collision with root package name */
    public int f122986e;

    /* renamed from: f, reason: collision with root package name */
    public int f122987f;

    /* renamed from: g, reason: collision with root package name */
    public String f122988g;

    /* renamed from: h, reason: collision with root package name */
    public String f122989h;

    /* renamed from: i, reason: collision with root package name */
    public c f122990i;

    /* renamed from: j, reason: collision with root package name */
    public Bundle f122991j;

    /* renamed from: k, reason: collision with root package name */
    public int f122992k;

    /* renamed from: l, reason: collision with root package name */
    public int f122993l;

    /* renamed from: m, reason: collision with root package name */
    public String f122994m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public e() {
        this.f122992k = -1;
        this.f122993l = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppBrandStatObject{preScene=" + this.f122982a + ", preSceneNote='" + this.f122983b + "', scene=" + this.f122984c + ", sceneNote='" + this.f122985d + "', usedState=" + this.f122986e + "', codeScene=" + this.f122993l + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f122982a);
        parcel.writeString(this.f122983b);
        parcel.writeInt(this.f122984c);
        parcel.writeString(this.f122985d);
        parcel.writeInt(this.f122986e);
        parcel.writeInt(this.f122987f);
        parcel.writeString(this.f122988g);
        parcel.writeParcelable(this.f122990i, i3);
        parcel.writeString(this.f122989h);
        parcel.writeBundle(this.f122991j);
        parcel.writeInt(this.f122992k);
        parcel.writeInt(this.f122993l);
        parcel.writeString(this.f122994m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeInt(this.E);
    }

    public e(Parcel parcel) {
        this.f122992k = -1;
        this.f122993l = 0;
        this.f122982a = parcel.readInt();
        this.f122983b = parcel.readString();
        this.f122984c = parcel.readInt();
        this.f122985d = parcel.readString();
        this.f122986e = parcel.readInt();
        this.f122987f = parcel.readInt();
        this.f122988g = parcel.readString();
        this.f122990i = (c) parcel.readParcelable(c.class.getClassLoader());
        this.f122989h = parcel.readString();
        this.f122991j = parcel.readBundle(e.class.getClassLoader());
        this.f122992k = parcel.readInt();
        this.f122993l = parcel.readInt();
        this.f122994m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readInt();
    }
}
