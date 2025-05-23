package com.tencent.luggage.wxa.s3;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new a();
    public LinkedList C;

    /* renamed from: a, reason: collision with root package name */
    public final int f140022a;

    /* renamed from: b, reason: collision with root package name */
    public final int f140023b;

    /* renamed from: c, reason: collision with root package name */
    public final String f140024c;

    /* renamed from: d, reason: collision with root package name */
    public final String f140025d;

    /* renamed from: e, reason: collision with root package name */
    public final String f140026e;

    /* renamed from: f, reason: collision with root package name */
    public final String f140027f;

    /* renamed from: g, reason: collision with root package name */
    public int f140028g;

    /* renamed from: h, reason: collision with root package name */
    public int f140029h;

    /* renamed from: i, reason: collision with root package name */
    public int f140030i;

    /* renamed from: j, reason: collision with root package name */
    public String f140031j;

    /* renamed from: k, reason: collision with root package name */
    public String f140032k;

    /* renamed from: l, reason: collision with root package name */
    public String f140033l;

    /* renamed from: m, reason: collision with root package name */
    public long f140034m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i3) {
            return new g[i3];
        }
    }

    public g(int i3, int i16, String str, String str2, String str3, String str4) {
        this.f140022a = i3;
        this.f140023b = i16;
        this.f140024c = str;
        this.f140025d = str2;
        this.f140026e = str3;
        this.f140027f = str4;
    }

    public int a() {
        return this.f140029h;
    }

    public String b() {
        return this.f140031j;
    }

    public int c() {
        return this.f140030i;
    }

    public String d() {
        return this.f140024c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List e() {
        return this.C;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f140022a == gVar.f140022a && this.f140023b == gVar.f140023b && Objects.equals(this.f140024c, gVar.f140024c) && Objects.equals(this.f140026e, gVar.f140026e)) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f140026e;
    }

    public String g() {
        return this.f140027f;
    }

    public int h() {
        return this.f140023b;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f140022a), Integer.valueOf(this.f140023b), this.f140024c, this.f140025d, this.f140026e);
    }

    public int i() {
        return this.f140022a;
    }

    public String j() {
        return this.f140025d;
    }

    public int k() {
        return this.f140028g;
    }

    public String l() {
        return this.f140032k;
    }

    public String m() {
        return this.f140033l;
    }

    public boolean n() {
        if (this.f140022a != -1 && this.f140023b != -1 && !TextUtils.isEmpty(this.f140024c) && !TextUtils.isEmpty(this.f140025d) && !TextUtils.isEmpty(this.f140026e)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "WxaIlinkDeviceInfo{productId=" + this.f140022a + ", keyVersion=" + this.f140023b + ", deviceId='" + this.f140024c + "', signature='" + this.f140025d + "', hostAppId='" + this.f140026e + "', ilinkAppId='" + this.f140027f + "', timestamp=" + this.f140028g + ", authType=" + this.f140029h + ", debugType=" + this.f140030i + ", debugNetIP=" + this.f140031j + ", token='" + this.f140032k + "', userName='" + this.f140033l + "', ilinkUin=" + this.f140034m + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f140022a);
        parcel.writeInt(this.f140023b);
        parcel.writeString(this.f140024c);
        parcel.writeString(this.f140025d);
        parcel.writeString(this.f140026e);
        parcel.writeString(this.f140027f);
        parcel.writeInt(this.f140028g);
        parcel.writeInt(this.f140029h);
        parcel.writeInt(this.f140030i);
        parcel.writeString(this.f140032k);
        parcel.writeString(this.f140033l);
        parcel.writeLong(this.f140034m);
        parcel.writeStringList(this.C);
        parcel.writeString(this.f140031j);
    }

    public void a(int i3) {
        this.f140030i = i3;
    }

    public void b(String str) {
        com.tencent.luggage.wxa.er.a.a((Object) str);
        this.f140032k = str;
    }

    public void c(String str) {
        com.tencent.luggage.wxa.er.a.a((Object) str);
        this.f140033l = str;
    }

    public void a(String str) {
        this.f140031j = str;
    }

    public void a(long j3) {
        this.f140034m = j3;
    }

    public g(Parcel parcel) {
        this.f140022a = parcel.readInt();
        this.f140023b = parcel.readInt();
        this.f140024c = parcel.readString();
        this.f140025d = parcel.readString();
        this.f140026e = parcel.readString();
        this.f140027f = parcel.readString();
        this.f140028g = parcel.readInt();
        this.f140029h = parcel.readInt();
        this.f140030i = parcel.readInt();
        this.f140032k = parcel.readString();
        this.f140033l = parcel.readString();
        this.f140034m = parcel.readLong();
        LinkedList linkedList = new LinkedList();
        this.C = linkedList;
        parcel.readStringList(linkedList);
        this.f140031j = parcel.readString();
    }
}
