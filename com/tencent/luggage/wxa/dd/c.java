package com.tencent.luggage.wxa.dd;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f124178a;

    /* renamed from: b, reason: collision with root package name */
    public String f124179b;

    /* renamed from: c, reason: collision with root package name */
    public List f124180c;

    /* renamed from: d, reason: collision with root package name */
    public long f124181d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f124182e;

    /* renamed from: f, reason: collision with root package name */
    public JSONArray f124183f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f124184g = false;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f124185h = false;

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

    public c(Parcel parcel) {
        boolean z16;
        this.f124180c = new ArrayList();
        if (parcel.readInt() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f124178a = z16;
        this.f124179b = parcel.readString();
        this.f124180c = parcel.readArrayList(c.class.getClassLoader());
        this.f124181d = parcel.readLong();
        this.f124182e = parcel.readInt() == 1;
    }

    public List a() {
        return this.f124180c;
    }

    public JSONArray b() {
        return this.f124183f;
    }

    public boolean c() {
        return this.f124182e;
    }

    public boolean d() {
        return this.f124185h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f124178a ? 1 : 0);
        parcel.writeString(this.f124179b);
        parcel.writeList(this.f124180c);
        parcel.writeLong(this.f124181d);
        parcel.writeInt(this.f124182e ? 1 : 0);
    }
}
