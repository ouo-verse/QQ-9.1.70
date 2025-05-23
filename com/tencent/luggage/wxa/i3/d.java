package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.hn.h6;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.hn.s8;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends com.tencent.luggage.wxa.n3.h {

    /* renamed from: e, reason: collision with root package name */
    public final String f129215e = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";

    /* renamed from: f, reason: collision with root package name */
    public Class f129216f = i6.class;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h6 f129217b;

        public a(h6 h6Var) {
            this.f129217b = h6Var;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i6 call(i6 response) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.CgiLaunchWxaApp", "publish OnLaunchWxaResponseReceivedEvent(AppId:" + this.f129217b.f127761e + ", WxaUsername:" + this.f129217b.f127771o + ", InstanceId:" + this.f129217b.f127770n + ')');
            h6 h6Var = this.f129217b;
            Intrinsics.checkNotNullExpressionValue(response, "response");
            new i(h6Var, response).c();
            return response;
        }
    }

    @Override // com.tencent.luggage.wxa.n3.h
    public final Class d() {
        return this.f129216f;
    }

    @Override // com.tencent.luggage.wxa.n3.e
    public String a() {
        return this.f129215e;
    }

    @Override // com.tencent.luggage.wxa.n3.e
    public com.tencent.luggage.wxa.xo.d a(String str, h6 request, Class clazz) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        com.tencent.luggage.wxa.xo.d b16 = super.a(str, (s8) request, clazz).b(new a(request));
        Intrinsics.checkNotNullExpressionValue(b16, "request: LaunchWxaAppReq\u2026xt response\n            }");
        return b16;
    }
}
