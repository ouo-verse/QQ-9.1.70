package com.tencent.luggage.wxa.ic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements Parcelable {

    @NotNull
    public static final C6292a CREATOR = new C6292a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.d6.b f129681a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ic.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6292a implements Parcelable.Creator {
        public C6292a() {
        }

        public /* synthetic */ C6292a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public a(com.tencent.luggage.wxa.d6.b action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.f129681a = action;
    }

    public final com.tencent.luggage.wxa.d6.b a() {
        return this.f129681a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Bundle bundle = new Bundle();
        bundle.putByteArray("action", this.f129681a.b());
        dest.writeBundle(bundle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(Parcel parcel) {
        this((com.tencent.luggage.wxa.d6.b) r3);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
        Bundle readBundle = parcel.readBundle(a.class.getClassLoader());
        Intrinsics.checkNotNull(readBundle);
        com.tencent.luggage.wxa.fn.b a16 = bVar.a(readBundle.getByteArray("action"));
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.struct.LaunchContainerAction");
    }
}
