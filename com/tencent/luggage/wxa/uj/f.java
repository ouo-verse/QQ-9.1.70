package com.tencent.luggage.wxa.uj;

import com.tencent.luggage.wxa.hn.u9;
import com.tencent.luggage.wxa.hn.v9;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f142465a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142466b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f142467b;

        public a(Function1 function1) {
            this.f142467b = function1;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Unit call(v9 v9Var) {
            Function1 function1 = this.f142467b;
            if (function1 != null) {
                function1.invoke(v9Var);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f142468a;

        public b(Function1 function1) {
            this.f142468a = function1;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            if (obj instanceof Exception) {
                w.b("Luggage.FULL.CgiPhoneNumber", "CgiSendVerifyCodeWxaPhone " + ((Exception) obj).getMessage());
            }
            Function1 function1 = this.f142468a;
            if (function1 != null) {
                function1.invoke(null);
            }
        }
    }

    public f(String appId, String mobile) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        this.f142465a = appId;
        this.f142466b = mobile;
    }

    public final void a(Function1 function1) {
        u9 u9Var = new u9();
        u9Var.f128833e = this.f142465a;
        u9Var.f128834f = this.f142466b;
        ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", this.f142465a, u9Var, v9.class).b(new a(function1)).a(new b(function1));
    }
}
