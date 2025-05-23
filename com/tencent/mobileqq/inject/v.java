package com.tencent.mobileqq.inject;

import com.tencent.mobileqq.injector.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class v {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQBase/Inject_QQBeaconReport.yml", version = 1)
    private static o f238067a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f238068b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38219);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f238068b = arrayList;
        arrayList.add(z.class);
    }

    private static void a() {
        if (f238067a == null) {
            b();
        }
    }

    @QAutoInitMethod
    static void b() {
        f238067a = (o) com.tencent.mobileqq.qroute.utils.b.a(f238068b);
    }

    public static void c(String str, String str2, Map<String, String> map) {
        a();
        o oVar = f238067a;
        if (oVar == null) {
            return;
        }
        oVar.a(str, str2, map);
    }
}
