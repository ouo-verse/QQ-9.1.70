package com.tencent.luggage.wxa.r1;

import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.e4;
import com.tencent.luggage.wxa.hn.f4;
import com.tencent.luggage.wxa.xo.e;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final C6658a f139048c = new C6658a(null);

    /* renamed from: a, reason: collision with root package name */
    public final e4 f139049a = new e4();

    /* renamed from: b, reason: collision with root package name */
    public f4 f139050b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6658a {
        public C6658a() {
        }

        public /* synthetic */ C6658a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f139052b;

        public b(Function2 function2) {
            this.f139052b = function2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(f4 it) {
            a aVar = a.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            aVar.a(it);
            this.f139052b.invoke(Boolean.TRUE, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f139053a;

        public c(Function2 function2) {
            this.f139053a = function2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof com.tencent.luggage.wxa.bj.a) {
                this.f139053a.invoke(Boolean.FALSE, obj);
                return;
            }
            if (obj instanceof Throwable) {
                this.f139053a.invoke(Boolean.FALSE, new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.SEND, 0, ((Throwable) obj).getMessage()));
                return;
            }
            Function2 function2 = this.f139053a;
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

    public final e4 a() {
        return this.f139049a;
    }

    public final f4 b() {
        f4 f4Var = this.f139050b;
        if (f4Var != null) {
            return f4Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    public final void a(f4 f4Var) {
        Intrinsics.checkNotNullParameter(f4Var, "<set-?>");
        this.f139050b = f4Var;
    }

    public final void a(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.luggage.wxa.h1.b a16 = com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class);
        Intrinsics.checkNotNull(a16);
        ((com.tencent.luggage.wxa.bj.c) a16).b("/cgi-bin/mmgame-bin/getwxagameconfig", null, this.f139049a, f4.class).a(new b(callback)).a(new c(callback));
    }
}
