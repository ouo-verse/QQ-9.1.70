package com.tencent.luggage.wxa.q7;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f137970a;

    /* renamed from: b, reason: collision with root package name */
    public final String f137971b;

    /* renamed from: c, reason: collision with root package name */
    public final String f137972c;

    /* renamed from: d, reason: collision with root package name */
    public final String f137973d;

    /* renamed from: e, reason: collision with root package name */
    public final String f137974e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new g(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g[] newArray(int i3) {
            return new g[i3];
        }
    }

    public g(String str, String str2, String str3, String str4, String str5) {
        this.f137970a = str;
        this.f137971b = str2;
        this.f137972c = str3;
        this.f137973d = str4;
        this.f137974e = str5;
    }

    public final String a() {
        return this.f137970a;
    }

    public final String b() {
        return this.f137971b;
    }

    public final String c() {
        return this.f137972c;
    }

    public final String d() {
        return this.f137973d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f137974e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (Intrinsics.areEqual(this.f137970a, gVar.f137970a) && Intrinsics.areEqual(this.f137971b, gVar.f137971b) && Intrinsics.areEqual(this.f137972c, gVar.f137972c) && Intrinsics.areEqual(this.f137973d, gVar.f137973d) && Intrinsics.areEqual(this.f137974e, gVar.f137974e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.f137970a;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.f137971b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.f137972c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.f137973d;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.f137974e;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        return i19 + i3;
    }

    public String toString() {
        return "ParcelizedInvokeData(wxaAppID=" + this.f137970a + ", apiName=" + this.f137971b + ", data=" + this.f137972c + ", callbackKey=" + this.f137973d + ", hostProcess=" + this.f137974e + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f137970a);
        out.writeString(this.f137971b);
        out.writeString(this.f137972c);
        out.writeString(this.f137973d);
        out.writeString(this.f137974e);
    }
}
