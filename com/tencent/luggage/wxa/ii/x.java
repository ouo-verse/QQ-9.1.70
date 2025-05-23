package com.tencent.luggage.wxa.ii;

import android.os.Parcel;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x implements Parceler {

    /* renamed from: a, reason: collision with root package name */
    public static final x f130597a = new x();

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.lg.b[] newArray(int i3) {
        return (com.tencent.luggage.wxa.lg.b[]) Parceler.DefaultImpls.newArray(this, i3);
    }

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.lg.b create(Parcel parcel) {
        Object orNull;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        orNull = ArraysKt___ArraysKt.getOrNull(com.tencent.luggage.wxa.lg.b.values(), parcel.readInt());
        com.tencent.luggage.wxa.lg.b bVar = (com.tencent.luggage.wxa.lg.b) orNull;
        return bVar == null ? com.tencent.luggage.wxa.lg.b.NO_UPDATE : bVar;
    }

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.tencent.luggage.wxa.lg.b bVar, Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(bVar.ordinal());
    }
}
