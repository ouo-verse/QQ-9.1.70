package com.tencent.qimei.am;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.aa.b;
import com.tencent.qimei.ag.h;
import com.tencent.qimei.am.e;
import com.tencent.qimei.as.a;
import com.tencent.qimei.sdk.S.SpreadValue;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements Runnable, com.tencent.qimei.ag.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<String, d> f343066e;

    /* renamed from: a, reason: collision with root package name */
    public final String f343067a;

    /* renamed from: b, reason: collision with root package name */
    public final String f343068b;

    /* renamed from: c, reason: collision with root package name */
    public final String f343069c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f343070d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String str = e.f343072f;
            e eVar = e.a.f343078a;
            d dVar = d.this;
            String str2 = dVar.f343067a;
            String str3 = dVar.f343068b;
            synchronized (eVar) {
                eVar.f343073a = str2;
                eVar.f343074b = str3;
                eVar.f343075c = str2 + str3;
                com.tencent.qimei.s.d dVar2 = eVar.f343076d;
                if (dVar2 != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (dVar2 == null) {
                        com.tencent.qimei.s.d dVar3 = new com.tencent.qimei.s.d(eVar, eVar.f343075c);
                        eVar.f343076d = dVar3;
                        IntentFilter intentFilter = new IntentFilter(com.tencent.qimei.s.a.f343362b);
                        Context context = dVar3.f343366b;
                        if (context != null) {
                            context.registerReceiver(dVar3, intentFilter);
                        }
                    }
                    com.tencent.qimei.f.a.a(com.tencent.qimei.s.a.f343362b, "", eVar.a());
                    com.tencent.qimei.ad.c.b("SpreadQM", "%s-%s | send implicit broadcast", eVar.f343073a, eVar.f343074b);
                }
            }
            com.tencent.qimei.t.a.a().a(10000L, d.this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20022);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343066e = new ConcurrentHashMap();
        }
    }

    public d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f343070d = new AtomicBoolean(false);
        this.f343067a = str;
        String d16 = com.tencent.qimei.u.a.d();
        this.f343068b = d16;
        this.f343069c = str + d16;
    }

    public final boolean a() {
        Boolean valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        com.tencent.qimei.aa.b bVar = b.a.f342891a;
        long j3 = 0;
        if (bVar.a() != null) {
            j3 = bVar.f342889a.getLong("l_u_time", 0L);
        }
        if (!com.tencent.qimei.ab.d.a(j3, a.b.E.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(this.f343067a).f343094b.f343146r)).intValue())) {
            return false;
        }
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(this.f343067a).f343094b;
        aVar.getClass();
        boolean booleanValue = com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343127y, aVar.f343146r).booleanValue();
        if (bVar.a() == null) {
            valueOf = Boolean.TRUE;
        } else {
            valueOf = Boolean.valueOf(bVar.f342889a.getBoolean("sp_need_report", true));
        }
        boolean booleanValue2 = valueOf.booleanValue();
        if (!booleanValue) {
            return true;
        }
        return booleanValue2;
    }

    @Override // java.lang.Runnable
    public void run() {
        SpreadValue spreadValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!a()) {
            return;
        }
        HashMap<String, SpreadValue> a16 = new b().a().a();
        if (a16.size() <= 1) {
            return;
        }
        String str = this.f343067a;
        String str2 = this.f343069c;
        if (a16.containsKey(str2)) {
            spreadValue = a16.remove(str2);
        } else {
            spreadValue = null;
        }
        if (spreadValue != null && !this.f343070d.get()) {
            this.f343070d.set(true);
            JSONArray jSONArray = new JSONArray();
            for (SpreadValue spreadValue2 : a16.values()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("aid", spreadValue2.a());
                    jSONObject.put(com.heytap.mcssdk.a.a.f36102l, spreadValue2.b());
                    jSONObject.put("firstTime", spreadValue2.c());
                    jSONObject.put("oaid", spreadValue2.f());
                    jSONObject.put("q16", spreadValue2.g());
                    jSONObject.put("q36", spreadValue2.h());
                    jSONObject.put("source", spreadValue2.i());
                    jSONObject.put("updateTime", spreadValue2.j());
                    jSONObject.put("fromKey", spreadValue2.d());
                    jSONObject.put("fromSource", spreadValue2.e());
                } catch (JSONException e16) {
                    com.tencent.qimei.ad.c.a(e16);
                }
                jSONArray.mo162put(jSONObject);
            }
            String jSONArray2 = jSONArray.toString();
            if (!TextUtils.isEmpty(jSONArray2)) {
                b.a.f342891a.a("sp_need_report", false);
                String b16 = spreadValue.b();
                long c16 = spreadValue.c();
                String f16 = spreadValue.f();
                String a17 = spreadValue.a();
                long j3 = spreadValue.j();
                int intValue = a.b.E.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(str).f343094b.f343146r)).intValue();
                com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(str).f343094b;
                aVar.getClass();
                boolean booleanValue = com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343127y, aVar.f343146r).booleanValue();
                h a18 = h.a();
                a18.getClass();
                com.tencent.qimei.ag.e eVar = new com.tencent.qimei.ag.e();
                eVar.f342975a.put("6", a17);
                eVar.f342975a.put("7", f16);
                eVar.f342975a.put("8", String.valueOf(c16));
                eVar.f342975a.put("9", String.valueOf(j3));
                eVar.f342975a.put("10", String.valueOf(intValue));
                eVar.f342975a.put("11", String.valueOf(booleanValue ? 1 : 0));
                eVar.f342975a.put("12", jSONArray2);
                eVar.f342976b = this;
                a18.a(eVar, ICustomDataEditor.STRING_PARAM_1, b16);
                com.tencent.qimei.ad.c.b(com.tencent.qimei.ag.d.f342974a, "Spread data has been reported over,appKey = %s", b16);
            }
        }
    }
}
