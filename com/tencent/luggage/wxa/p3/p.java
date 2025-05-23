package com.tencent.luggage.wxa.p3;

import com.tencent.luggage.wxa.n3.aj;
import com.tencent.luggage.wxa.n3.r;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p implements b {

    /* renamed from: a, reason: collision with root package name */
    public final r f137222a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements r.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f137223a;

        public a(c cVar) {
            this.f137223a = cVar;
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public /* synthetic */ void a(byte[] bArr) {
            aj.b(this, bArr);
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public void a(int i3, int i16, byte[] resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            this.f137223a.a(i3, i16, resp);
        }
    }

    public p(r tdiCloneSession) {
        Intrinsics.checkNotNullParameter(tdiCloneSession, "tdiCloneSession");
        this.f137222a = tdiCloneSession;
    }

    public final r a() {
        return this.f137222a;
    }

    @Override // com.tencent.luggage.wxa.p3.b
    public boolean c() {
        return this.f137222a.c();
    }

    @Override // com.tencent.luggage.wxa.p3.b
    public void destroy() {
        this.f137222a.close();
    }

    @Override // com.tencent.luggage.wxa.p3.b
    public void a(c tdiCgiCallback) {
        Intrinsics.checkNotNullParameter(tdiCgiCallback, "tdiCgiCallback");
        this.f137222a.a(new a(tdiCgiCallback));
    }

    @Override // com.tencent.luggage.wxa.p3.b
    public int a(com.tencent.luggage.wxa.n3.b req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return this.f137222a.a(req);
    }
}
