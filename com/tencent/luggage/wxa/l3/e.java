package com.tencent.luggage.wxa.l3;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.a5.d {

    @NotNull
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f132987b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new e(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e[] newArray(int i3) {
            return new e[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String appId) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f132987b = appId;
    }

    @Override // com.tencent.luggage.wxa.a5.b
    public String b() {
        return this.f132987b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WxaCloseMessage(appId='" + b() + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f132987b);
    }

    @Override // com.tencent.luggage.wxa.a5.b
    public void a(com.tencent.luggage.wxa.p5.f runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        runtime.o();
    }

    @Override // com.tencent.luggage.wxa.a5.d
    public void a(com.tencent.luggage.wxa.c5.b runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        runtime.close();
    }
}
