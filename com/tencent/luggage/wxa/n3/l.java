package com.tencent.luggage.wxa.n3;

import com.google.protobuf.ByteString;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final s f135209a;

    /* renamed from: b, reason: collision with root package name */
    public final long f135210b;

    /* renamed from: c, reason: collision with root package name */
    public final String f135211c;

    /* renamed from: d, reason: collision with root package name */
    public final String f135212d;

    /* renamed from: e, reason: collision with root package name */
    public final ByteString f135213e;

    public l(s status, long j3, String str, String str2, ByteString businessConfirmRespBuffer) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(businessConfirmRespBuffer, "businessConfirmRespBuffer");
        this.f135209a = status;
        this.f135210b = j3;
        this.f135211c = str;
        this.f135212d = str2;
        this.f135213e = businessConfirmRespBuffer;
    }
}
