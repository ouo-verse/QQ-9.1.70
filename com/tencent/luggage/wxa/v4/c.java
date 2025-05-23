package com.tencent.luggage.wxa.v4;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f143227a;

    /* renamed from: b, reason: collision with root package name */
    public final String f143228b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new c(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(int i3, String str) {
        this.f143227a = i3;
        this.f143228b = str;
    }

    public final int a() {
        return this.f143227a;
    }

    public final String b() {
        return this.f143228b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f143227a == cVar.f143227a && Intrinsics.areEqual(this.f143228b, cVar.f143228b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.f143227a * 31;
        String str = this.f143228b;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return i3 + hashCode;
    }

    public String toString() {
        return "OnWXAppResultEventBinder(instance=" + this.f143227a + ", processName=" + this.f143228b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f143227a);
        out.writeString(this.f143228b);
    }
}
