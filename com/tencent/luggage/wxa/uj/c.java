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
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f142451a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142452b;

    /* renamed from: c, reason: collision with root package name */
    public final String f142453c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f142454b;

        public a(Function1 function1) {
            this.f142454b = function1;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Unit call(h1 h1Var) {
            Function1 function1 = this.f142454b;
            if (function1 != null) {
                function1.invoke(h1Var);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f142455a;

        public b(Function1 function1) {
            this.f142455a = function1;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            if (obj instanceof Exception) {
                w.b("Luggage.FULL.CgiPhoneNumber", "CgiCheckVerifyCodeWxaPhone " + ((Exception) obj).getMessage());
            }
            Function1 function1 = this.f142455a;
            if (function1 != null) {
                function1.invoke(null);
            }
        }
    }

    public c(String appId, String mobile, String code) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(code, "code");
        this.f142451a = appId;
        this.f142452b = mobile;
        this.f142453c = code;
    }

    public final void a(Function1 function1) {
        g1 g1Var = new g1();
        g1Var.f127660e = this.f142451a;
        g1Var.f127661f = this.f142452b;
        g1Var.f127662g = this.f142453c;
        ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", this.f142451a, g1Var, h1.class).b(new a(function1)).a(new b(function1));
    }
}
