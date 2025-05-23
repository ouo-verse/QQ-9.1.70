package com.tencent.luggage.wxa.j4;

import android.os.Parcel;
import com.tencent.luggage.wxa.fd.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n implements Parceler {

    /* renamed from: a, reason: collision with root package name */
    public static final n f130857a = new n();

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j0[] newArray(int i3) {
        return (j0[]) Parceler.DefaultImpls.newArray(this, i3);
    }

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j0 create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return j0.a(parcel);
    }

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(j0 j0Var, Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        j0.a(j0Var, parcel);
    }
}
