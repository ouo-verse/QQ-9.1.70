package com.tencent.luggage.wxa.ge;

import com.tencent.luggage.wxa.ge.j;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f126695b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static volatile i f126696c = new e(g.f126698a);

    /* renamed from: a, reason: collision with root package name */
    public final j.a f126697a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements i {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.luggage.wxa.ge.i
        public j a(com.tencent.luggage.wxa.ic.g runtime) {
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            w.d("MicroMsg.AppBrand.BluetoothBackgroundSupportAccessible", "getClient, runtime: " + b(runtime));
            e.f126696c.a(runtime);
            return null;
        }

        public final String b(com.tencent.luggage.wxa.ic.g runtime) {
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            com.tencent.luggage.wxa.fd.i S = runtime.S();
            if (S == null) {
                return String.valueOf(runtime.hashCode());
            }
            return S.f125808a + '#' + S.f125811d;
        }
    }

    public e(j.a clientFactory) {
        Intrinsics.checkNotNullParameter(clientFactory, "clientFactory");
        this.f126697a = clientFactory;
    }

    @Override // com.tencent.luggage.wxa.ge.i
    public j a(com.tencent.luggage.wxa.ic.g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        com.tencent.luggage.wxa.k0.d.a(runtime.c(j.class));
        return null;
    }
}
