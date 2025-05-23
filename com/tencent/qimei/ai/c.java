package com.tencent.qimei.ai;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.qimei.as.a;
import com.tencent.qimei.uin.U;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final c f343001a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public @interface a {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name */
        public static final com.tencent.qimei.z.d f343002a;

        /* renamed from: b, reason: collision with root package name */
        public static final com.tencent.qimei.z.d f343003b;

        /* renamed from: c, reason: collision with root package name */
        public static final com.tencent.qimei.z.d f343004c;

        /* renamed from: d, reason: collision with root package name */
        public static final com.tencent.qimei.z.d f343005d;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(19949), (Class<?>) a.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
                return;
            }
            f343002a = new com.tencent.qimei.z.d("1", "");
            f343003b = new com.tencent.qimei.z.d("2", "");
            f343004c = new com.tencent.qimei.z.d("q16", "");
            f343005d = new com.tencent.qimei.z.d("q36", "");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343001a = new c();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final String a(com.tencent.qimei.u.c cVar, com.tencent.qimei.ae.a aVar, com.tencent.qimei.ak.a aVar2) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, cVar, aVar, aVar2);
        }
        JSONObject jSONObject = new JSONObject();
        int i3 = 0;
        try {
            String str2 = (String) com.tencent.qimei.f.a.a(null, "com.huawei.system.BuildEx", "getOsBrand", new Class[0], new Object[0]);
            jSONObject.put(HardwareInfoProvider.HARMONY_OS, str2 == null ? false : HardwareInfoProvider.HARMONY_OS.equalsIgnoreCase(str2) ? "1" : "0");
            jSONObject.put("clone", Process.myUid() / 100000 != 0 ? "1" : "0");
            jSONObject.put("containe", cVar.c());
            jSONObject.put("oz", aVar.e());
            com.tencent.qimei.at.a aVar3 = com.tencent.qimei.ar.a.a(aVar.f342945a).f343094b;
            aVar3.getClass();
            jSONObject.put("oz2", !com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343123u, aVar3.f343146r).booleanValue() ? "" : com.tencent.qimei.ae.k.a().a(10, new com.tencent.qimei.ae.b(aVar)));
            com.tencent.qimei.at.a aVar4 = com.tencent.qimei.ar.a.a(aVar.f342945a).f343094b;
            aVar4.getClass();
            jSONObject.put("oo", !com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343124v, aVar4.f343146r).booleanValue() ? "" : com.tencent.qimei.ae.k.a().a(9, new com.tencent.qimei.ae.c(aVar)));
            jSONObject.put("kelong", aVar2.a() ? "1" : "0");
            jSONObject.put("ip", aVar.c());
            jSONObject.put("multiUser", com.tencent.qimei.f.a.c(com.tencent.qimei.ap.d.c().e()));
            jSONObject.put("bod", U.a(com.tencent.qimei.r.a.a(12)));
            jSONObject.put("brd", U.a(com.tencent.qimei.r.a.a(13)));
            jSONObject.put("dv", U.a(com.tencent.qimei.r.a.a(14)));
            jSONObject.put("firstLevel", U.a(com.tencent.qimei.r.a.a(15)));
            jSONObject.put("manufact", U.a(com.tencent.qimei.r.a.a(16)));
            jSONObject.put("name", U.a(com.tencent.qimei.r.a.a(17)));
            jSONObject.put("host", U.a(com.tencent.qimei.r.a.a(18)));
            synchronized (cVar) {
                if (cVar.f343404n == null) {
                    cVar.f343404n = U.c();
                }
                str = cVar.f343404n;
            }
            jSONObject.put("kernel", str);
            Context e16 = com.tencent.qimei.ap.d.c().e();
            if (e16 != null) {
                ApplicationInfo applicationInfo = e16.getApplicationInfo();
                int i16 = applicationInfo != null ? applicationInfo.flags : 0;
                if (i16 >= 0 && (i16 & 1) == 1) {
                    i3 = 2;
                }
                String absolutePath = e16.getFilesDir().getAbsolutePath();
                if (!TextUtils.isEmpty(absolutePath) && absolutePath.startsWith("/system")) {
                    i3 = 1;
                }
            }
            jSONObject.put("pre", String.valueOf(i3));
            jSONObject.put("av", com.tencent.qimei.u.a.e());
            jSONObject.put("ch", com.tencent.qimei.u.a.a());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String a(String str) {
        com.tencent.qimei.u.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        com.tencent.qimei.ap.a aVar = new com.tencent.qimei.ap.a(str);
        com.tencent.qimei.ae.a a16 = com.tencent.qimei.ae.a.a(str);
        synchronized (com.tencent.qimei.u.c.class) {
            cVar = com.tencent.qimei.u.c.f343390p;
        }
        com.tencent.qimei.ak.a a17 = com.tencent.qimei.ak.a.a(str);
        JSONObject jSONObject = new JSONObject();
        String str2 = null;
        try {
            jSONObject.put("1", aVar.a());
            jSONObject.put("2", String.valueOf(com.tencent.qimei.ap.d.c().e().getApplicationInfo().targetSdkVersion));
            com.tencent.qimei.at.a aVar2 = com.tencent.qimei.ar.a.a(str).f343094b;
            aVar2.getClass();
            jSONObject.put("3", !com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343110h, aVar2.f343146r).booleanValue() ? "" : aVar.h());
            jSONObject.put("4", U.a(com.tencent.qimei.r.a.a(13)));
            jSONObject.put("5", "");
            jSONObject.put("6", a16.d());
            com.tencent.qimei.at.a aVar3 = com.tencent.qimei.ar.a.a(a16.f342945a).f343094b;
            boolean z16 = false;
            jSONObject.put("7", !(aVar3.f343130b && aVar3.f343138j && com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343117o, aVar3.f343146r).booleanValue()) ? "" : com.tencent.qimei.ae.k.a().a(1, new com.tencent.qimei.ae.g(a16)));
            com.tencent.qimei.at.a aVar4 = com.tencent.qimei.ar.a.a(a16.f342945a).f343094b;
            jSONObject.put("8", !(aVar4.f343131c && aVar4.f343138j && com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343118p, aVar4.f343146r).booleanValue()) ? "" : com.tencent.qimei.ae.k.a().a(2, new com.tencent.qimei.ae.h(a16)));
            jSONObject.put("9", a16.a());
            com.tencent.qimei.at.a aVar5 = com.tencent.qimei.ar.a.a(a16.f342945a).f343094b;
            jSONObject.put("10", !(aVar5.f343133e && aVar5.f343138j && com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343119q, aVar5.f343146r).booleanValue()) ? "" : com.tencent.qimei.ae.k.a().a(4, new com.tencent.qimei.ae.i(a16)));
            com.tencent.qimei.at.a aVar6 = com.tencent.qimei.ar.a.a(a16.f342945a).f343094b;
            if (aVar6.f343134f && aVar6.f343138j && com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343120r, aVar6.f343146r).booleanValue()) {
                z16 = true;
            }
            jSONObject.put("11", !z16 ? "" : com.tencent.qimei.ae.k.a().a(5, new com.tencent.qimei.ae.j(a16)));
            jSONObject.put("13", aVar.c() == null ? "" : aVar.c().b());
            jSONObject.put("14", cVar.d());
            com.tencent.qimei.ab.e a18 = com.tencent.qimei.ab.e.a();
            String a19 = a18.a(str, "c_f_uptimes");
            String a26 = a18.a(str, "c_f_bootids");
            jSONObject.put("15", a19);
            jSONObject.put("16", a26);
            jSONObject.put("12", a(cVar, a16, a17));
            str2 = jSONObject.toString();
            jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return str2 == null ? "" : str2;
    }
}
