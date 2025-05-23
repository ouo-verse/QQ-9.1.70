package com.tencent.luggage.wxa.ef;

import com.tencent.luggage.wxa.xk.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f124713a = new n();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements a.b, com.tencent.luggage.wxa.vo.a {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.ic.g f124714a;

        /* renamed from: b, reason: collision with root package name */
        public a.b f124715b;

        public a(com.tencent.luggage.wxa.ic.g runtime, a.b delegate) {
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f124714a = runtime;
            this.f124715b = delegate;
            runtime.b((com.tencent.luggage.wxa.vo.a) this);
        }

        @Override // com.tencent.luggage.wxa.xk.a.b
        public void a(int i3, String str, a.C6919a c6919a) {
            a.b bVar = this.f124715b;
            if (bVar != null) {
                bVar.a(i3, str, c6919a);
            }
            g();
        }

        @Override // com.tencent.luggage.wxa.vo.a
        public void g() {
            this.f124715b = null;
            com.tencent.luggage.wxa.ic.g gVar = this.f124714a;
            if (gVar != null) {
                gVar.a((com.tencent.luggage.wxa.vo.a) this);
            }
            this.f124714a = null;
        }
    }

    public static final a.b a(com.tencent.luggage.wxa.ic.d env, a.b listener) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.luggage.wxa.ic.g runtime = env.getRuntime();
        Intrinsics.checkNotNullExpressionValue(runtime, "env.runtime");
        return new a(runtime, listener);
    }
}
