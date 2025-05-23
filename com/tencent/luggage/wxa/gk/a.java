package com.tencent.luggage.wxa.gk;

import com.tencent.luggage.wxa.gk.b;
import com.tencent.luggage.wxa.hn.c1;
import com.tencent.luggage.wxa.hn.d1;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6246a f126776a = new C6246a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.gk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6246a {
        public C6246a() {
        }

        public /* synthetic */ C6246a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        BusinessTypeNone,
        BusinessTypeWxaBase,
        BusinessTypeOpenSdk,
        BusinessTypeVideoAct
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f126782b;

        public c(Function2 function2) {
            this.f126782b = function2;
        }

        public final void a(d1 resp) {
            if (resp.f128743d.f127731d != 0) {
                w.b("MicroMsg.CgiCheckWxaShortLink", "checkAsync cig fail. Ret[" + resp.f128743d.f127731d + "]  ErrMsg[" + resp.f128743d.f127732e + ']');
                this.f126782b.invoke(Boolean.FALSE, null);
                return;
            }
            w.d("MicroMsg.CgiCheckWxaShortLink", "checkAsync cig success.");
            Function2 function2 = this.f126782b;
            Boolean bool = Boolean.TRUE;
            b.a aVar = com.tencent.luggage.wxa.gk.b.f126784h;
            Intrinsics.checkNotNullExpressionValue(resp, "resp");
            function2.invoke(bool, aVar.a(resp));
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((d1) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f126783a;

        public d(Function2 function2) {
            this.f126783a = function2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            if (obj instanceof Exception) {
                w.b("MicroMsg.CgiCheckWxaShortLink", "checkAsync exception" + ((Exception) obj).getMessage());
            }
            this.f126783a.invoke(Boolean.FALSE, null);
        }
    }

    public final void a(String shortLink, b businessType, Function2 callback) {
        Intrinsics.checkNotNullParameter(shortLink, "shortLink");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        c1 c1Var = new c1();
        c1Var.f127375f = businessType.ordinal();
        c1Var.f127374e = shortLink;
        com.tencent.luggage.wxa.h1.b a16 = com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class);
        Intrinsics.checkNotNull(a16);
        ((com.tencent.luggage.wxa.bj.c) a16).b("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", "", c1Var, d1.class).b(new c(callback)).a(new d(callback));
    }
}
