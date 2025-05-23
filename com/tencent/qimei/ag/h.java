package com.tencent.qimei.ag;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.aa.b;
import com.tencent.qimei.as.a;
import com.tencent.qimei.foundation.net.protocol.CMD;
import com.tencent.qimei.uin.U;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static volatile h f342983b;

    /* renamed from: a, reason: collision with root package name */
    public final f f342984a;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342984a = new f();
        }
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f342983b == null) {
                synchronized (h.class) {
                    if (f342983b == null) {
                        f342983b = new h();
                    }
                }
            }
            hVar = f342983b;
        }
        return hVar;
    }

    public static void a(h hVar, e eVar, String str, String str2) {
        String str3;
        String str4;
        String str5;
        hVar.getClass();
        Map<String, Object> map = eVar.f342975a;
        if (U.e()) {
            str3 = "";
            str4 = str3;
        } else {
            com.tencent.qimei.ae.a a16 = com.tencent.qimei.ae.a.a(str2);
            str4 = a16.a();
            str3 = a16.c();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("1", str);
            jSONObject.put("2", str3);
            jSONObject.put("5", str4);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            str5 = jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            str5 = null;
        }
        String str6 = str5 != null ? str5 : "";
        CMD cmd = CMD.APM;
        String a17 = U.a(str2, cmd.b(), str6, cmd.a());
        a aVar = eVar.f342976b;
        if (!new com.tencent.qimei.x.c(a17).c()) {
            com.tencent.qimei.ad.c.b("IsolateRequest", "(appKey: %s) Report failed. type = %s", str2, str);
            if (aVar != null) {
                b.a.f342891a.a("sp_need_report", true);
                ((com.tencent.qimei.am.d) aVar).f343070d.set(false);
                return;
            }
            return;
        }
        if (aVar != null) {
            com.tencent.qimei.am.d dVar = (com.tencent.qimei.am.d) aVar;
            com.tencent.qimei.aa.b bVar = b.a.f342891a;
            long currentTimeMillis = System.currentTimeMillis();
            if (bVar.a() != null) {
                bVar.f342889a.edit().putLong("l_u_time", currentTimeMillis).apply();
            }
            dVar.f343070d.set(false);
            com.tencent.qimei.ad.c.b("SpreadQM", "spread data upload success.", new Object[0]);
        }
    }

    public void a(e eVar, String str, String str2) {
        boolean a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, eVar, str, str2);
            return;
        }
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(str2).f343094b;
        aVar.getClass();
        if (com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343113k, aVar.f343146r).booleanValue() && com.tencent.qimei.u.a.f()) {
            f fVar = this.f342984a;
            Map<String, Object> map = eVar.f342975a;
            if (fVar.f342977a.contains(str)) {
                a16 = false;
            } else {
                StringBuilder sb5 = new StringBuilder();
                if (!map.isEmpty()) {
                    Iterator<Object> it = map.values().iterator();
                    while (it.hasNext()) {
                        sb5.append(it.next().toString());
                    }
                }
                a16 = fVar.a(str2 + str + sb5.toString());
            }
            if (a16) {
                return;
            }
            com.tencent.qimei.t.a.a().a(new g(this, eVar, str, str2));
        }
    }
}
