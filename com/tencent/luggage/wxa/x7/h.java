package com.tencent.luggage.wxa.x7;

import com.tencent.luggage.wxa.n3.ai;
import com.tencent.luggage.wxa.n3.aj;
import com.tencent.luggage.wxa.n3.l;
import com.tencent.luggage.wxa.n3.o;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.n3.y;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class h {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements t.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.s3.c f144640a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f144641b;

        public a(com.tencent.luggage.wxa.s3.c cVar, Function1 function1) {
            this.f144640a = cVar;
            this.f144641b = function1;
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, int i16, com.tencent.luggage.wxa.n3.a aVar) {
            ai.a(this, i3, i16, aVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void onLoginComplete(int i3) {
            this.f144640a.b(this);
            this.f144641b.invoke(Integer.valueOf(i3));
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void onLogoutComplete(int i3) {
            ai.h(this, i3);
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public /* synthetic */ void a(int i3, int i16, byte[] bArr) {
            aj.a(this, i3, i16, bArr);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.c cVar) {
            ai.b(this, i3, cVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.d dVar) {
            ai.c(this, i3, dVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, l lVar) {
            ai.d(this, i3, lVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, o oVar) {
            ai.e(this, i3, oVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(y yVar) {
            ai.f(this, yVar);
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public /* synthetic */ void a(byte[] bArr) {
            aj.b(this, bArr);
        }
    }

    public static final void b(com.tencent.luggage.wxa.s3.c cVar, Function1 function1, Function1 function12) {
        cVar.a(new a(cVar, function12));
        t k3 = cVar.k();
        Intrinsics.checkNotNull(k3);
        function1.invoke(k3);
    }
}
