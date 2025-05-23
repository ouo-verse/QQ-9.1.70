package com.tencent.luggage.wxa.v4;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.tencent.luggage.wxa.tn.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f143245a;

    /* renamed from: b, reason: collision with root package name */
    public final int f143246b;

    /* renamed from: c, reason: collision with root package name */
    public final Parcelable f143247c;

    /* renamed from: d, reason: collision with root package name */
    public final String f143248d;

    /* renamed from: e, reason: collision with root package name */
    public final String f143249e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new h(parcel.readInt(), parcel.readInt(), parcel.readParcelable(h.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h[] newArray(int i3) {
            return new h[i3];
        }
    }

    public h(int i3, int i16, Parcelable parcelable, String str, String str2) {
        this.f143245a = i3;
        this.f143246b = i16;
        this.f143247c = parcelable;
        this.f143248d = str;
        this.f143249e = str2;
    }

    public final int a() {
        return this.f143246b;
    }

    public final String b() {
        return this.f143249e;
    }

    public final Parcelable c() {
        return this.f143247c;
    }

    public final int d() {
        return this.f143245a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f143248d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f143245a == hVar.f143245a && this.f143246b == hVar.f143246b && Intrinsics.areEqual(this.f143247c, hVar.f143247c) && Intrinsics.areEqual(this.f143248d, hVar.f143248d) && Intrinsics.areEqual(this.f143249e, hVar.f143249e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i3 = ((this.f143245a * 31) + this.f143246b) * 31;
        Parcelable parcelable = this.f143247c;
        int i16 = 0;
        if (parcelable == null) {
            hashCode = 0;
        } else {
            hashCode = parcelable.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str = this.f143248d;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        String str2 = this.f143249e;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i18 + i16;
    }

    public String toString() {
        return "OnWXAppResultXPCMessage(instance=" + this.f143245a + ", action=" + this.f143246b + ", data=" + this.f143247c + ", stacktrace=" + this.f143248d + ", callProcess=" + this.f143249e + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f143245a);
        out.writeInt(this.f143246b);
        out.writeParcelable(this.f143247c, i3);
        out.writeString(this.f143248d);
        out.writeString(this.f143249e);
    }

    public /* synthetic */ h(int i3, int i16, Parcelable parcelable, String str, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, parcelable, (i17 & 8) != 0 ? Log.getStackTraceString(new Throwable()) : str, (i17 & 16) != 0 ? z.i() : str2);
    }
}
