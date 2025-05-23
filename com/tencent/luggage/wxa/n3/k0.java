package com.tencent.luggage.wxa.n3;

import android.os.Build;
import android.util.Base64;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.h6;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.t8;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f135205b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f135206c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ s8 f135207d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Class f135208e;

        public a(String str, String str2, s8 s8Var, Class cls) {
            this.f135205b = str;
            this.f135206c = str2;
            this.f135207d = s8Var;
            this.f135208e = cls;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public t8 call(com.tencent.luggage.wxa.ap.b bVar) {
            Boolean bool = (Boolean) bVar.b();
            com.tencent.luggage.wxa.tn.w.g("Luggage.WxaRuntimeCgiProxy", "isActivate:%b isAuthorize:%b", bool, (Boolean) bVar.c());
            com.tencent.luggage.wxa.xo.b a16 = com.tencent.luggage.wxa.xo.h.a();
            if (bool.booleanValue()) {
                try {
                    return k0.b(this.f135205b, this.f135206c, this.f135207d, this.f135208e);
                } catch (Exception e16) {
                    a16.a(e16);
                    return null;
                }
            }
            a16.a("device not activate");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.uo.b {
        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Void r16) {
            if (!com.tencent.luggage.wxa.s3.f.f140021a.i()) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.uo.b {
        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Void r16) {
            return Boolean.valueOf(com.tencent.luggage.wxa.o3.l.f136139a.f());
        }
    }

    public static t8 b(String str, String str2, s8 s8Var, Class cls) {
        String str3;
        com.tencent.luggage.wxa.tn.w.a("Luggage.WxaRuntimeCgiProxy", "runSyncImpl url=%s, class=%s", str, s8Var.getClass());
        s8Var.f128671d = a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put("WxaAppId", str2);
            jSONObject.put("ReqData", Base64.encodeToString(s8Var.b(), 2));
            if ("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp".equals(str)) {
                jSONObject.put("appid", ((h6) s8Var).f127761e);
            }
            if (n0.a(str)) {
                str3 = "https://servicewechat.com/wxaruntime/basetransfer";
            } else {
                str3 = "https://servicewechat.com/wxaruntime/transfer";
            }
            Response execute = p.cgiClient().newCall(new Request.Builder().url(str3).post(RequestBody.create(p.f135236e, jSONObject.toString())).build()).execute();
            try {
                try {
                    JSONObject jSONObject2 = new JSONObject(execute.body().string());
                    execute.close();
                    int optInt = jSONObject2.optInt("ErrCode", -1);
                    String optString = jSONObject2.optString("ErrMsg");
                    if (optInt != 0) {
                        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaRuntimeCgiProxy", "wxaruntime/proxy runSync::error %s, url=%s", jSONObject2.toString(), str);
                        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaRuntimeCgiProxy", "wxaruntime/proxy runSync::error %s, transferUrl=%s", jSONObject2.toString(), str3);
                        if (optInt == -6 || optInt == -5 || optInt == -4) {
                            com.tencent.luggage.wxa.o3.l.f136139a.b();
                        }
                        throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.TRANSFER, optInt, optString);
                    }
                    t8 a16 = a(cls, jSONObject2.optString("RespData", ""));
                    if (a16 != null) {
                        return a16;
                    }
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaRuntimeCgiProxy", "wxaruntime/proxy runSync::decode failed");
                    throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.DECODE, 0, null);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.a("Luggage.WxaRuntimeCgiProxy", e16, "wxaruntime/proxy runSync::recv failed", new Object[0]);
                    throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.RECV, 0, null);
                }
            } catch (Throwable th5) {
                if (execute != null) {
                    execute.close();
                }
                throw th5;
            }
        } catch (Exception e17) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.WxaRuntimeCgiProxy", e17, "wxaruntime/proxy runSync::encode failed", new Object[0]);
            throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.ENCODE, 0, null);
        }
    }

    public static com.tencent.luggage.wxa.xo.d c(String str, String str2, s8 s8Var, Class cls) {
        return com.tencent.luggage.wxa.xo.h.c().c(com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.uo.b) new b(), (com.tencent.luggage.wxa.uo.b) new c())).d(new a(str, str2, s8Var, cls));
    }

    public static void a(String str, String str2, s8 s8Var, Class cls, i0 i0Var) {
        try {
            if (!com.tencent.luggage.wxa.s3.f.f140021a.i()) {
                a.EnumC6074a enumC6074a = a.EnumC6074a.NOT_ACTIVATE_DEVICE;
                i0Var.a(enumC6074a, enumC6074a.f122912a, enumC6074a.f122914c);
            } else {
                com.tencent.luggage.wxa.o3.l.f136139a.f();
                i0Var.a(b(str, str2, s8Var, cls));
            }
        } catch (com.tencent.luggage.wxa.bj.a e16) {
            i0Var.a(e16.f122898a, e16.f122899b, e16.f122900c);
            throw e16;
        } catch (IOException e17) {
            i0Var.a(a.EnumC6074a.NETWORK, -1, e17.getMessage());
            throw e17;
        }
    }

    public static t8 a(Class cls, String str) {
        try {
            byte[] decode = Base64.decode(str, 2);
            t8 t8Var = (t8) cls.newInstance();
            t8Var.a(decode);
            com.tencent.luggage.wxa.tn.w.a("Luggage.WxaRuntimeCgiProxy", "RespData decode done for response class %s", cls);
            return t8Var;
        } catch (Exception unused) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaRuntimeCgiProxy", "RespData decode failed for response class %s", cls);
            return null;
        }
    }

    public static com.tencent.luggage.wxa.hn.g0 a() {
        com.tencent.luggage.wxa.hn.g0 g0Var = new com.tencent.luggage.wxa.hn.g0();
        com.tencent.luggage.wxa.o3.l lVar = com.tencent.luggage.wxa.o3.l.f136139a;
        g0Var.f127655e = lVar.c() ? lVar.a().h() : 0;
        g0Var.f127657g = com.tencent.luggage.wxa.tn.e.f141563e;
        g0Var.f127654d = new com.tencent.luggage.wxa.fn.c("xx".getBytes());
        g0Var.f127656f = new com.tencent.luggage.wxa.fn.c(lVar.h().getBytes());
        g0Var.f127658h = new com.tencent.luggage.wxa.fn.c(("android-" + Build.VERSION.SDK_INT).getBytes());
        return g0Var;
    }
}
