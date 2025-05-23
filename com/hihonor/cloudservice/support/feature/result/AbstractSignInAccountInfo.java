package com.hihonor.cloudservice.support.feature.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class AbstractSignInAccountInfo implements Parcelable {
    public Set<Scope> C = new HashSet();
    public String D;
    public long E;
    public String F;

    /* renamed from: d, reason: collision with root package name */
    public String f36234d;

    /* renamed from: e, reason: collision with root package name */
    public String f36235e;

    /* renamed from: f, reason: collision with root package name */
    public Set<Scope> f36236f;

    /* renamed from: h, reason: collision with root package name */
    public String f36237h;

    /* renamed from: i, reason: collision with root package name */
    public String f36238i;

    /* renamed from: m, reason: collision with root package name */
    public String f36239m;

    public AbstractSignInAccountInfo(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        this.f36234d = str;
        this.f36235e = str2;
        this.f36236f = set;
        this.f36237h = str3;
        this.f36238i = str4;
        this.D = str5;
    }

    public String a() {
        return this.f36237h;
    }

    public Set<Scope> b() {
        return this.f36236f;
    }

    public Set<Scope> c() {
        return new HashSet(this.C);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(Parcel parcel) {
        this.f36234d = parcel.readString();
        this.f36235e = parcel.readString();
        this.f36237h = parcel.readString();
        this.f36236f = new HashSet();
        this.f36238i = parcel.readString();
        this.f36239m = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readLong();
        this.F = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractSignInAccountInfo)) {
            return false;
        }
        return b().equals(((AbstractSignInAccountInfo) obj).b());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return "{displayName: photoUriString: " + this.f36235e + ",serviceCountryCode: countryCode: ";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36234d);
        parcel.writeString(this.f36235e);
        parcel.writeString(this.f36237h);
        parcel.writeList(new ArrayList(this.f36236f));
        parcel.writeString(this.f36238i);
        parcel.writeString(this.f36239m);
        parcel.writeString(this.D);
        parcel.writeLong(this.E);
        parcel.writeString(this.F);
    }

    public AbstractSignInAccountInfo() {
    }
}
