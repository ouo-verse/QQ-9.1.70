package com.tencent.luggage.wxa.uj;

import com.tencent.luggage.wxa.hn.g1;
import com.tencent.luggage.wxa.hn.h1;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f142446a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142447b;

    /* renamed from: c, reason: collision with root package name */
    public final String f142448c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f142449b;

        public a(Function1 function1) {
            this.f142449b = function1;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Unit call(h1 h1Var) {
            Function1 function1 = this.f142449b;
            if (function1 != null) {
                function1.invoke(h1Var);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.uj.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6803b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f142450a;

        public C6803b(Function1 function1) {
            this.f142450a = function1;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            if (obj instanceof Exception) {
                w.b("Luggage.FULL.CgiPhoneNumber", "CgiCheckVerifyCode " + ((Exception) obj).getMessage());
            }
            Function1 function1 = this.f142450a;
            if (function1 != null) {
                function1.invoke(null);
            }
        }
    }

    public b(String appId, String mobile, String code) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(code, "code");
        this.f142446a = appId;
        this.f142447b = mobile;
        this.f142448c = code;
    }

    public final void a(Function1 function1) {
        g1 g1Var = new g1();
        g1Var.f127660e = this.f142446a;
        g1Var.f127661f = this.f142447b;
        g1Var.f127662g = this.f142448c;
        ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", this.f142446a, g1Var, h1.class).b(new a(function1)).a(new C6803b(function1));
    }
}
