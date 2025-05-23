package com.tencent.luggage.wxa.i3;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.k6.o;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q extends o {

    @NotNull
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f129350c;

    /* renamed from: d, reason: collision with root package name */
    public final int f129351d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new q(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q[] newArray(int i3) {
            return new q[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(String url, int i3) {
        super(i3);
        Intrinsics.checkNotNullParameter(url, "url");
        this.f129350c = url;
        this.f129351d = i3;
    }

    @Override // com.tencent.luggage.wxa.i3.o
    public int a() {
        return this.f129351d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f129350c);
        out.writeInt(this.f129351d);
    }

    @Override // com.tencent.luggage.wxa.i3.o
    public void a(Activity activity, com.tencent.luggage.wxa.wj.c windowAndroid) {
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        com.tencent.luggage.wxa.tn.w.b("WxaLaunchErrorAction", "showError " + this.f129350c);
        o.Companion companion = com.tencent.luggage.wxa.k6.o.INSTANCE;
        Context context = windowAndroid.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "windowAndroid.context");
        o.Companion.a(companion, context, this.f129350c, null, 4, null);
    }
}
