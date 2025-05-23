package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.x0;
import com.tencent.luggage.wxa.hn.y0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends e {

    /* renamed from: b, reason: collision with root package name */
    public static final f f135165b = new f();

    /* renamed from: c, reason: collision with root package name */
    public static final String f135166c = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0 f135167b;

        public a(x0 x0Var) {
            this.f135167b = x0Var;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y0 call(y0 y0Var) {
            if (y0Var != null) {
                new x(this.f135167b, y0Var).c();
            }
            return y0Var;
        }
    }

    @Override // com.tencent.luggage.wxa.n3.e
    public String a() {
        return f135166c;
    }

    public com.tencent.luggage.wxa.xo.d a(String str, x0 request, Class clazz) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        com.tencent.luggage.wxa.xo.d b16 = super.a(str, (s8) request, clazz).b(new a(request));
        Intrinsics.checkNotNullExpressionValue(b16, "request: CheckDemoInfoRe\u2026xt response\n            }");
        return b16;
    }
}
