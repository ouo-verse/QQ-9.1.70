package com.tencent.luggage.wxa.xb;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b implements Parcelable {

    @NotNull
    public static final a CREATOR = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f144659a;

    /* renamed from: b, reason: collision with root package name */
    public final String f144660b;

    /* renamed from: c, reason: collision with root package name */
    public final int f144661c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(long j3, String url, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f144659a = j3;
        this.f144660b = url;
        this.f144661c = i3;
    }

    public final int a() {
        return this.f144661c;
    }

    public final long b() {
        return this.f144659a;
    }

    public final String c() {
        return this.f144660b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f144659a == bVar.f144659a && Intrinsics.areEqual(this.f144660b, bVar.f144660b) && this.f144661c == bVar.f144661c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.f144659a) * 31) + this.f144660b.hashCode()) * 31) + this.f144661c;
    }

    public String toString() {
        return "PlayVoiceData(id=" + this.f144659a + ", url=" + this.f144660b + ", action=" + this.f144661c + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.f144659a);
        parcel.writeString(this.f144660b);
        parcel.writeInt(this.f144661c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Parcel parcel) {
        this(r0, r2, parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        long readLong = parcel.readLong();
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
    }
}
