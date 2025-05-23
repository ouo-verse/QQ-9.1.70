package com.tencent.luggage.wxa.x0;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends com.tencent.luggage.wxa.a1.a {
    public static final Parcelable.Creator<c> CREATOR = new a();
    public boolean C;
    public boolean D;
    public com.tencent.luggage.wxa.b1.b E;
    public transient String F;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f144453c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f144454d;

    /* renamed from: e, reason: collision with root package name */
    public String f144455e;

    /* renamed from: f, reason: collision with root package name */
    public String f144456f;

    /* renamed from: g, reason: collision with root package name */
    public String f144457g;

    /* renamed from: h, reason: collision with root package name */
    public int f144458h;

    /* renamed from: i, reason: collision with root package name */
    public int f144459i;

    /* renamed from: j, reason: collision with root package name */
    public int f144460j;

    /* renamed from: k, reason: collision with root package name */
    public int f144461k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f144462l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f144463m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
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
        this.f144458h = -1;
        this.f144463m = true;
    }

    public void a(int i3) {
        this.f144460j = i3;
    }

    public void b(int i3) {
        this.f144459i = i3;
    }

    public int c() {
        return this.f144458h;
    }

    public void d(boolean z16) {
        this.D = z16;
    }

    @Override // com.tencent.luggage.wxa.a1.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList e() {
        return this.f144454d;
    }

    public String f() {
        return this.f144455e;
    }

    public com.tencent.luggage.wxa.b1.b g() {
        return this.E;
    }

    public String h() {
        return this.f144456f;
    }

    public String i() {
        return this.F;
    }

    public int j() {
        return this.f144460j;
    }

    public int k() {
        return this.f144459i;
    }

    public ArrayList l() {
        return this.f144453c;
    }

    public int m() {
        return this.f144461k;
    }

    public boolean n() {
        return this.f144462l;
    }

    public boolean o() {
        return this.f144463m;
    }

    public boolean p() {
        return this.C;
    }

    public boolean q() {
        return this.D;
    }

    @Override // com.tencent.luggage.wxa.a1.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        super.writeToParcel(parcel, i3);
        parcel.writeTypedList(this.f144453c);
        if (this.f144454d != null) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        parcel.writeByte((byte) i16);
        ArrayList arrayList = this.f144454d;
        if (arrayList != null) {
            parcel.writeList(arrayList);
        }
        parcel.writeString(this.f144455e);
        parcel.writeString(this.f144456f);
        parcel.writeString(this.f144457g);
        parcel.writeInt(this.f144458h);
        parcel.writeInt(this.f144459i);
        parcel.writeInt(this.f144460j);
        parcel.writeInt(this.f144461k);
        parcel.writeByte(this.f144462l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f144463m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.E);
    }

    public void a(ArrayList arrayList) {
        this.f144453c = arrayList;
    }

    public void b(boolean z16) {
        this.f144463m = z16;
    }

    public void c(boolean z16) {
        this.C = z16;
    }

    public String d() {
        return this.f144457g;
    }

    public void a(boolean z16) {
        this.f144462l = z16;
    }

    public c(Parcel parcel) {
        super(parcel);
        this.f144458h = -1;
        this.f144463m = true;
        this.f144453c = parcel.createTypedArrayList(com.tencent.luggage.wxa.f1.b.CREATOR);
        if (parcel.readByte() != 0) {
            ArrayList arrayList = new ArrayList();
            this.f144454d = arrayList;
            parcel.readList(arrayList, File.class.getClassLoader());
        }
        this.f144455e = parcel.readString();
        this.f144456f = parcel.readString();
        this.f144457g = parcel.readString();
        this.f144458h = parcel.readInt();
        this.f144459i = parcel.readInt();
        this.f144460j = parcel.readInt();
        this.f144461k = parcel.readInt();
        this.f144462l = parcel.readByte() != 0;
        this.f144463m = parcel.readByte() != 0;
        this.C = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.E = (com.tencent.luggage.wxa.b1.b) parcel.readSerializable();
    }

    public void a(com.tencent.luggage.wxa.b1.b bVar) {
        this.E = bVar;
    }
}
