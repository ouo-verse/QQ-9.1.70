package com.tencent.luggage.wxa.o3;

import com.tencent.luggage.wxa.n3.p;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.o3.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.e;
import cooperation.qzone.remote.ServiceConst;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f136098a = new f();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.c f136099a;

        public a(e.c cVar) {
            this.f136099a = cVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(j jVar) {
            w.a("Luggage.LoginByRefresh", "authorized succedeed, oauthCode=%s", jVar.d());
            e.c cVar = this.f136099a;
            if (cVar != null) {
                j jVar2 = new j();
                jVar2.e(jVar.f());
                jVar2.b(jVar.h());
                jVar2.f(jVar.g());
                jVar2.c(jVar.d());
                jVar2.a(jVar.b());
                cVar.a(jVar2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.c f136100a;

        public b(e.c cVar) {
            this.f136100a = cVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            if (obj instanceof g) {
                this.f136100a.a((g) obj);
                return;
            }
            e.c cVar = this.f136100a;
            if (cVar != null) {
                cVar.a(g.d.f136117j);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Request f136101b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f136102c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Callback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f136103a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j f136104b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Request f136105c;

            public a(com.tencent.luggage.wxa.xo.b bVar, j jVar, Request request) {
                this.f136103a = bVar;
                this.f136104b = jVar;
                this.f136105c = request;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e16) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e16, "e");
                this.f136103a.a(e16);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                ResponseBody body = response.body();
                Intrinsics.checkNotNull(body);
                String string = body.string();
                w.g("Luggage.LoginByRefresh", "refresh session response json: %s", string);
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    int optInt = jSONObject.optInt("ErrCode", 0);
                    w.d("Luggage.LoginByRefresh", "refresh :" + optInt);
                    if (optInt != 0) {
                        w.b("Luggage.LoginByRefresh", "refresh session failed: %s", Integer.valueOf(optInt));
                        com.tencent.luggage.wxa.xo.b bVar = this.f136103a;
                        g.a aVar = g.f136106d;
                        bVar.a(new g(aVar.e(), aVar.a(), "errCode:" + optInt));
                    } else {
                        j jVar = this.f136104b;
                        String string2 = jSONObject.getString(ServiceConst.PARA_SESSION_ID);
                        Intrinsics.checkNotNullExpressionValue(string2, "obj.getString(\"session_id\")");
                        jVar.f(string2);
                        this.f136104b.a(jSONObject.optInt("expiretime"));
                        this.f136103a.a(this.f136104b);
                    }
                } catch (JSONException e16) {
                    w.b("Luggage.LoginByRefresh", "request failed: %s => %s", this.f136105c.url(), string);
                    this.f136103a.a(e16);
                }
            }
        }

        public c(Request request, j jVar) {
            this.f136101b = request;
            this.f136102c = jVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j call(Void r56) {
            p.get().newCall(this.f136101b).enqueue(new a(com.tencent.luggage.wxa.xo.h.b(), this.f136102c, this.f136101b));
            return new j();
        }
    }

    public final void a(j sessionInfo, e.c callback) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(sessionInfo).a(new a(callback)).a(new b(callback));
    }

    public final j b(j sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        try {
            ResponseBody body = p.get().newCall(a(sessionInfo.g())).execute().body();
            Intrinsics.checkNotNull(body);
            JSONObject jSONObject = new JSONObject(body.string());
            int optInt = jSONObject.optInt("ErrCode", 0);
            if (optInt != 0) {
                w.b("Luggage.LoginByRefresh", "refresh session failed: %s", Integer.valueOf(optInt));
                return null;
            }
            String string = jSONObject.getString(ServiceConst.PARA_SESSION_ID);
            Intrinsics.checkNotNullExpressionValue(string, "obj.getString(\"session_id\")");
            sessionInfo.f(string);
            sessionInfo.a(jSONObject.optInt("expiretime"));
            return sessionInfo;
        } catch (IOException e16) {
            w.a("Luggage.LoginByRefresh", e16, "", new Object[0]);
            return null;
        } catch (JSONException e17) {
            w.a("Luggage.LoginByRefresh", e17, "", new Object[0]);
            return null;
        }
    }

    public final com.tencent.luggage.wxa.xo.d a(j jVar) {
        com.tencent.luggage.wxa.xo.d c16 = com.tencent.luggage.wxa.xo.h.c().c(new c(a(jVar.g()), jVar));
        Intrinsics.checkNotNullExpressionValue(c16, "sessionInfo: SessionInfo\u2026  SessionInfo()\n        }");
        return c16;
    }

    public final Request a(String str) {
        HttpUrl parse = HttpUrl.parse("https://servicewechat.com/wxaruntime/refresh_session");
        Intrinsics.checkNotNull(parse);
        HttpUrl.Builder newBuilder = parse.newBuilder();
        newBuilder.addQueryParameter(ServiceConst.PARA_SESSION_ID, str);
        String url = newBuilder.build().getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "urlBuilder.build().toString()");
        Request build = new Request.Builder().url(url).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().url(url).build()");
        return build;
    }
}
