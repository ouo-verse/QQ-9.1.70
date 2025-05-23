package com.tencent.luggage.wxa.uc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f142260a;

    /* renamed from: b, reason: collision with root package name */
    public int f142261b;

    /* renamed from: c, reason: collision with root package name */
    public int f142262c;

    /* renamed from: d, reason: collision with root package name */
    public int f142263d;

    /* renamed from: e, reason: collision with root package name */
    public String f142264e;

    /* renamed from: f, reason: collision with root package name */
    public String f142265f;

    /* renamed from: g, reason: collision with root package name */
    public String f142266g;

    /* renamed from: h, reason: collision with root package name */
    public String f142267h;

    /* renamed from: i, reason: collision with root package name */
    public String f142268i;

    /* renamed from: j, reason: collision with root package name */
    public int f142269j;

    /* renamed from: k, reason: collision with root package name */
    public String f142270k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f142271l;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c() {
        this.f142269j = -1;
        this.f142271l = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "operation{appId='" + this.f142260a + "', versionType=" + this.f142261b + ", usage=" + this.f142262c + ", operation=" + this.f142263d + ", uiclass='" + this.f142264e + "', name='" + this.f142265f + "', icon='" + this.f142266g + "', username='" + this.f142267h + "', process='" + this.f142268i + "', customNotificationLogicClassName='" + this.f142270k + "', justNotify=" + this.f142271l + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f142260a);
        parcel.writeInt(this.f142261b);
        parcel.writeInt(this.f142262c);
        parcel.writeInt(this.f142263d);
        parcel.writeString(this.f142264e);
        parcel.writeString(this.f142265f);
        parcel.writeString(this.f142266g);
        parcel.writeString(this.f142267h);
        parcel.writeString(this.f142268i);
        parcel.writeString(this.f142270k);
        parcel.writeInt(this.f142269j);
    }

    public c(Parcel parcel) {
        this.f142269j = -1;
        this.f142271l = false;
        this.f142260a = parcel.readString();
        this.f142261b = parcel.readInt();
        this.f142262c = parcel.readInt();
        this.f142263d = parcel.readInt();
        this.f142264e = parcel.readString();
        this.f142265f = parcel.readString();
        this.f142266g = parcel.readString();
        this.f142267h = parcel.readString();
        this.f142268i = parcel.readString();
        this.f142270k = parcel.readString();
        this.f142269j = parcel.readInt();
    }
}
