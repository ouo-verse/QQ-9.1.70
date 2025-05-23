package com.tencent.luggage.wxa.b4;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f121845a;

    /* renamed from: b, reason: collision with root package name */
    public int f121846b;

    /* renamed from: c, reason: collision with root package name */
    public int f121847c;

    /* renamed from: d, reason: collision with root package name */
    public int f121848d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f121844e = new b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(byte[] bArr, int i3, int i16, int i17) {
        this.f121845a = bArr;
        this.f121847c = i3;
        this.f121848d = i16;
        this.f121846b = i17;
    }

    public final int a() {
        return this.f121846b;
    }

    public final int b() {
        return this.f121848d;
    }

    public final byte[] c() {
        return this.f121845a;
    }

    public final int d() {
        return this.f121847c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByteArray(this.f121845a);
        parcel.writeInt(this.f121846b);
        parcel.writeInt(this.f121847c);
        parcel.writeInt(this.f121848d);
    }

    public e(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f121845a = parcel.createByteArray();
        this.f121846b = parcel.readInt();
        this.f121847c = parcel.readInt();
        this.f121848d = parcel.readInt();
    }
}
