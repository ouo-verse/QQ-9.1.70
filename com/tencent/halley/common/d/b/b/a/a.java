package com.tencent.halley.common.d.b.b.a;

import com.tencent.halley.common.a.h;
import com.tencent.halley.common.d.b.a.a.e;
import com.tencent.halley.common.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends com.tencent.halley.common.d.b.b.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f113477a;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f113478c;

    /* renamed from: b, reason: collision with root package name */
    public e f113479b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14115);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f113477a = null;
            f113478c = true;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final void a(com.tencent.halley.common.d.b.b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        if (h.a("detect_use_http_platform_on", 0, 1, 1) == 0) {
            d.b("halley-cloud-HttpDetectHandler", "ignore detect when K_detect_use_http_platform_on is 0..");
            return;
        }
        if (h.a("detect_when_start", 0, 1, 1) == 0 && f113478c) {
            f113478c = false;
            d.b("halley-cloud-HttpDetectHandler", "ignore detect when init..");
            return;
        }
        String str = f113477a;
        if (str != null && str.equals(com.tencent.halley.common.a.c.b())) {
            d.b("halley-cloud-HttpDetectHandler", "lastApn is the same as the last.. just ignore detect");
            return;
        }
        f113477a = com.tencent.halley.common.a.c.b();
        if (h.a("detect_only_in_ipv6_on", 0, 1, 1) != 1) {
            aVar.a("detectflag", 1);
        } else if (com.tencent.halley.common.a.c.i() != 3 && com.tencent.halley.common.a.c.i() != 2) {
            d.b("halley-cloud-HttpDetectHandler", "Not in ipv6 network, just ignore detect pull");
        } else {
            d.b("halley-cloud-HttpDetectHandler", "In ipv6 network, just trigger detect pull");
            aVar.a("detectflag", 1);
        }
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "detector";
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final void a(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("NetmonTask");
            if (optJSONObject != null) {
                c cVar = new c(optJSONObject);
                ArrayList<b> arrayList = cVar.f113484a;
                if (arrayList != null && arrayList.size() != 0) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<b> it = cVar.f113484a.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        com.tencent.halley.common.d.b.a.a.a a16 = com.tencent.halley.common.d.b.a.a.a.a(cVar.f113485b, next.f113480a, next.f113481b);
                        if (a16 != null) {
                            a16.a(cVar.f113488e, cVar.f113486c, next.f113483d, next.f113482c);
                            arrayList2.add(a16);
                        }
                    }
                    e eVar = this.f113479b;
                    if (eVar != null) {
                        eVar.a(arrayList2);
                        return;
                    }
                    com.tencent.halley.common.d.b.a.a.c a17 = com.tencent.halley.common.d.b.a.a.c.a();
                    this.f113479b = a17;
                    a17.a(arrayList2);
                    return;
                }
                d.e("HttpDetectorHandler", "httpNetmonTask is empty");
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
