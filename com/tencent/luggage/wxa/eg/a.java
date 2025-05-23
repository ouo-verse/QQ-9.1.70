package com.tencent.luggage.wxa.eg;

import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.u8;
import com.tencent.luggage.wxa.hn.v8;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.xo.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.xo.d f124730a;

    /* renamed from: b, reason: collision with root package name */
    public final u8 f124731b = new u8();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eg.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6163a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public static final C6163a f124732b = new C6163a();

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v8 call(Void r56) {
            h.a().a(new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.SEND, 0, null));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f124733a;

        public b(Function2 function2) {
            this.f124733a = function2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(v8 v8Var) {
            this.f124733a.invoke(Boolean.TRUE, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f124734a;

        public c(Function2 function2) {
            this.f124734a = function2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof com.tencent.luggage.wxa.bj.a) {
                this.f124734a.invoke(Boolean.FALSE, obj);
                return;
            }
            if (obj instanceof Throwable) {
                this.f124734a.invoke(Boolean.FALSE, new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.SEND, 0, ((Throwable) obj).getMessage()));
                return;
            }
            Function2 function2 = this.f124734a;
            Boolean bool = Boolean.FALSE;
            a.EnumC6074a enumC6074a = a.EnumC6074a.SEND;
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            function2.invoke(bool, new com.tencent.luggage.wxa.bj.a(enumC6074a, 0, str));
        }
    }

    public final u8 a() {
        return this.f124731b;
    }

    public final void a(com.tencent.luggage.wxa.c5.e eVar, Function2 callback) {
        com.tencent.luggage.wxa.xo.d b16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this) {
            if (this.f124730a == null) {
                com.tencent.luggage.wxa.xo.d dVar = null;
                if (eVar != null) {
                    com.tencent.luggage.wxa.ya.a f16 = eVar.f(com.tencent.luggage.wxa.bj.c.class);
                    Intrinsics.checkNotNull(f16);
                    b16 = ((com.tencent.luggage.wxa.bj.c) f16).b("/cgi-bin/mmbiz-bin/wxartrappsvr/route", eVar.getAppId(), this.f124731b, v8.class);
                    Intrinsics.checkNotNullExpressionValue(b16, "{\n                      \u2026va)\n                    }");
                } else {
                    com.tencent.luggage.wxa.bj.c cVar = (com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class);
                    b16 = cVar != null ? cVar.b("/cgi-bin/mmbiz-bin/wxartrappsvr/route", null, this.f124731b, v8.class) : null;
                    if (b16 == null) {
                        b16 = h.c().c(C6163a.f124732b);
                        Intrinsics.checkNotNullExpressionValue(b16, "pipeline().`$logic` {\n  \u2026                        }");
                    }
                }
                this.f124730a = b16;
                if (b16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pipeline");
                } else {
                    dVar = b16;
                }
                dVar.a(new b(callback)).a(new c(callback));
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
