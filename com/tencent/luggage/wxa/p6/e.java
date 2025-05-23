package com.tencent.luggage.wxa.p6;

import android.os.Parcel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements d {
    @Override // com.tencent.luggage.wxa.p6.d
    public /* synthetic */ com.tencent.luggage.wxa.r5.a a(Parcel parcel, com.tencent.luggage.wxa.d6.b bVar, com.tencent.luggage.wxa.bk.e eVar) {
        return t31.a.a(this, parcel, bVar, eVar);
    }

    @Override // com.tencent.luggage.wxa.p6.d
    public void a(com.tencent.luggage.wxa.j4.d config, com.tencent.luggage.wxa.d6.b action, com.tencent.luggage.wxa.bk.e eVar) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    @Override // com.tencent.luggage.wxa.p6.d
    public com.tencent.luggage.wxa.r5.a a(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new com.tencent.luggage.wxa.r5.a(parcel);
    }
}
