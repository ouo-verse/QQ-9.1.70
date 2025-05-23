package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.fj.b;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.tk.c;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.dj.b f126193a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6219a implements b.a {
        @Override // com.tencent.luggage.wxa.fj.b.a
        public void a(g gVar, JSONObject jSONObject) {
            try {
                jSONObject.put("switchFs", 1);
            } catch (JSONException unused) {
            }
        }
    }

    static {
        c();
    }

    public static void c() {
        b.a(new C6219a());
    }

    public void a(l lVar, j jVar, e.a aVar) {
        w.d("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime, serviceId:%d, type:%s", Integer.valueOf(lVar.getComponentId()), aVar);
        com.tencent.luggage.wxa.dj.b bVar = new com.tencent.luggage.wxa.dj.b(lVar, jVar, aVar);
        this.f126193a = bVar;
        jVar.addJavascriptInterface(bVar, "gJavaBroker");
    }

    public String b() {
        return c.b("wxa_library/node_jsapi.js");
    }

    public void d() {
        com.tencent.luggage.wxa.dj.b bVar = this.f126193a;
        if (bVar != null) {
            bVar.b();
            return;
        }
        throw new IllegalStateException("You had not called whenCreateJsRuntime!");
    }

    public void e() {
        w.d("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
        com.tencent.luggage.wxa.dj.b bVar = this.f126193a;
        if (bVar != null) {
            bVar.c();
            return;
        }
        throw new IllegalStateException("You had not called whenCreateJsRuntime!");
    }

    public String a() {
        if (this.f126193a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            a(stringBuffer);
            stringBuffer.append(b());
            return stringBuffer.toString();
        }
        throw new IllegalStateException("You had not called whenCreateJsRuntime!");
    }

    public void a(StringBuffer stringBuffer) {
        stringBuffer.append(";const _switchTimer = true;");
    }
}
