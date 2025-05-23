package com.tencent.luggage.wxa.q3;

import android.os.Parcel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parceler {

    /* renamed from: a, reason: collision with root package name */
    public static final b f137818a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final a f137819b = new a();

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.fn.b[] newArray(int i3) {
        return (com.tencent.luggage.wxa.fn.b[]) Parceler.DefaultImpls.newArray(this, i3);
    }

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.fn.b create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Object a16 = f137819b.a(parcel);
        if (a16 instanceof com.tencent.luggage.wxa.fn.b) {
            return (com.tencent.luggage.wxa.fn.b) a16;
        }
        return null;
    }

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.tencent.luggage.wxa.fn.b bVar, Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (bVar == null) {
            parcel.writeString(null);
        } else {
            f137819b.a(bVar, parcel);
        }
    }
}
