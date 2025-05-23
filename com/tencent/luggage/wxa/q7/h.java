package com.tencent.luggage.wxa.q7;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f137978a;

    /* renamed from: b, reason: collision with root package name */
    public final String f137979b;

    /* renamed from: c, reason: collision with root package name */
    public final String f137980c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new h(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h[] newArray(int i3) {
            return new h[i3];
        }
    }

    public h(String str, String str2, String str3) {
        this.f137978a = str;
        this.f137979b = str2;
        this.f137980c = str3;
    }

    public final String a() {
        return this.f137978a;
    }

    public final String b() {
        return this.f137979b;
    }

    public final String c() {
        return this.f137980c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (Intrinsics.areEqual(this.f137978a, hVar.f137978a) && Intrinsics.areEqual(this.f137979b, hVar.f137979b) && Intrinsics.areEqual(this.f137980c, hVar.f137980c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.f137978a;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.f137979b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.f137980c;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    public String toString() {
        return "ParcelizedJSEvent(wxaAppID=" + this.f137978a + ", eventName=" + this.f137979b + ", data=" + this.f137980c + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f137978a);
        out.writeString(this.f137979b);
        out.writeString(this.f137980c);
    }
}
