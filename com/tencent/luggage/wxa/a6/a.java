package com.tencent.luggage.wxa.a6;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.eclipsesource.mmv8.V8;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.a6.e;
import com.tencent.luggage.wxa.fd.t;
import com.tencent.luggage.wxa.h6.o;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.r4.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.ConstValue;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.r4.d {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C5986a extends com.tencent.luggage.wxa.em.a {
        public C5986a(l lVar) {
            super(lVar);
        }

        @Override // com.tencent.luggage.wxa.em.a
        public com.tencent.luggage.wxa.fj.a i() {
            return new d();
        }
    }

    static {
        String str;
        try {
            str = t.a();
        } catch (Error unused) {
            str = "";
        }
        if (!w0.c("--min_semi_space_size=4 --max_semi_space_size=8 --wasm_tier_up --wasm_lazy_compilation")) {
            if (w0.c(str)) {
                str = "--min_semi_space_size=4 --max_semi_space_size=8 --wasm_tier_up --wasm_lazy_compilation";
            } else {
                str = "--min_semi_space_size=4 --max_semi_space_size=8 --wasm_tier_up --wasm_lazy_compilation " + str;
            }
        }
        w.d("Luggage.AppService", "set v8 flag:%s", str);
        V8.setFlags(str);
    }

    public a() {
        this((Function<com.tencent.luggage.wxa.r4.d, ? extends com.tencent.luggage.wxa.r4.f>) new Function() { // from class: a21.a
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return new e((d) obj);
            }
        });
    }

    @Override // com.tencent.luggage.wxa.r4.d, com.tencent.luggage.wxa.ic.l
    public JSONObject I() {
        JSONObject I = super.I();
        a(I, "debug", Boolean.valueOf(getRuntime().j0().F));
        JSONObject jSONObject = new JSONObject();
        a(I, "appLaunchInfo", jSONObject);
        String O = getRuntime().O();
        String trim = o.b(O).trim();
        if (TextUtils.isEmpty(trim)) {
            trim = getRuntime().E().c();
        }
        a(jSONObject, "path", trim);
        a(jSONObject, "query", new JSONObject(o.d(O)));
        a(jSONObject, "referrerInfo", getRuntime().S().c());
        if (!TextUtils.isEmpty(getRuntime().S().f130806r0)) {
            a(jSONObject, "shortLink", getRuntime().S().f130806r0);
        }
        com.tencent.luggage.wxa.ck.d.e(getRuntime(), jSONObject);
        com.tencent.luggage.wxa.ck.d.d(getRuntime(), jSONObject);
        com.tencent.luggage.wxa.ck.d.a((com.tencent.luggage.wxa.c5.e) getRuntime(), I);
        com.tencent.luggage.wxa.j4.g j06 = getRuntime().j0();
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, "maxRequestConcurrent", Integer.valueOf(j06.O));
        a(jSONObject2, "maxUploadConcurrent", Integer.valueOf(j06.P));
        a(jSONObject2, "maxDownloadConcurrent", Integer.valueOf(j06.Q));
        a(jSONObject2, "maxWebsocketConnect", Integer.valueOf(j06.R));
        a(jSONObject2, "maxWorkerConcurrent", Integer.valueOf(j06.S));
        try {
            JSONObject optJSONObject = I.optJSONObject(MosaicConstants$JsProperty.PROP_ENV);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                I.put(MosaicConstants$JsProperty.PROP_ENV, optJSONObject);
            }
            optJSONObject.put("USER_DATA_PATH", MiniAppFileManager.WXFILE_PREFIX_USR);
            optJSONObject.put("OPEN_DATA_PATH", "wxfile://opendata");
            optJSONObject.put("CLIENT_DATA_PATH", "wxfile://clientdata");
            optJSONObject.put("HAS_SPLASHSCREEN", 0);
        } catch (Exception unused) {
        }
        a(I, "appLaunchInfo", jSONObject);
        a(I, "wxAppInfo", jSONObject2);
        a(I, "isPluginMiniProgram", Boolean.FALSE);
        a(I, "envVersion", com.tencent.luggage.wxa.jf.b.a(getRuntime().S().f125811d).name().toLowerCase());
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3 = new JSONObject(getRuntime().S().g());
        } catch (Exception unused2) {
        }
        try {
            if (!w0.c(j06.M)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("jsonInfo", new JSONObject(j06.M));
                a(jSONObject3, "operationInfo", jSONObject4);
            }
        } catch (Exception e16) {
            w.b("Luggage.AppService", "postProcessConfig, put operationInfo to appContactInfo fail", e16);
        }
        a(I, "appContactInfo", jSONObject3);
        a(I, "accountInfo", getRuntime().S().e());
        a(I, "supportAsyncAudio", Boolean.TRUE);
        return I;
    }

    @Override // com.tencent.luggage.wxa.r4.d, com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.j
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(jSONObject, ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, Integer.valueOf(com.tencent.luggage.wxa.tn.e.f141563e));
        com.tencent.luggage.wxa.sd.a.d(true, jSONObject);
        com.tencent.luggage.wxa.sd.a.a(com.tencent.luggage.wxa.pq.a.b(getContext()), jSONObject);
        com.tencent.luggage.wxa.sd.a.e(com.tencent.luggage.wxa.pq.a.b(getContext()), jSONObject);
        com.tencent.luggage.wxa.sd.a.g(true, jSONObject);
        com.tencent.luggage.wxa.sd.a.b(true, jSONObject);
        com.tencent.luggage.wxa.sd.a.f(true, jSONObject);
        com.tencent.luggage.wxa.sd.a.h(false, jSONObject);
        com.tencent.luggage.wxa.sd.a.c(XWebSdk.isCurrentVersionSupportCustomTextAreaForAppbrand() && XWebSdk.isXWebView(), jSONObject);
    }

    @Override // com.tencent.luggage.wxa.r4.d, com.tencent.luggage.wxa.ic.l
    /* renamed from: c0 */
    public com.tencent.luggage.wxa.em.a G() {
        return new C5986a(this);
    }

    @Override // com.tencent.luggage.wxa.r4.d
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.p5.f getRuntime() {
        return (com.tencent.luggage.wxa.p5.f) super.getRuntime();
    }

    public a(@NonNull Function<com.tencent.luggage.wxa.r4.d, ? extends com.tencent.luggage.wxa.r4.f> function) {
        super(function);
        a(com.tencent.luggage.wxa.mc.w.a());
    }

    public a(@NonNull Class<? extends com.tencent.luggage.wxa.r4.f> cls) {
        super(cls);
        a(com.tencent.luggage.wxa.mc.w.a());
    }

    @Override // com.tencent.luggage.wxa.ic.l
    public final void a(String str, long j3, long j16, Object obj) {
        if (isRunning()) {
            super.a(str, j3, j16, obj);
            com.tencent.luggage.wxa.gi.b.a(getRuntime().getAppId(), com.tencent.luggage.wxa.ik.a.D, "wxConfig", j3, j16);
        }
    }
}
