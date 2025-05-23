package com.tencent.luggage.wxa.ic;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f129946a = new n0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f129947a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.j4.d f129948b;

        public a(g gVar, com.tencent.luggage.wxa.j4.d dVar) {
            this.f129947a = gVar;
            this.f129948b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f129947a.a((com.tencent.luggage.wxa.fd.i) this.f129948b, "updateApp");
        }
    }

    public static final void a(g gVar, com.tencent.luggage.wxa.j4.d newConfig) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        gVar.e(new a(gVar, newConfig));
    }
}
