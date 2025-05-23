package com.tencent.msdk.dns.base.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.base.report.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f336219a;

    /* renamed from: b, reason: collision with root package name */
    private static List<a> f336220b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18890);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f336219a = Collections.emptyList();
            f336220b = Collections.emptyList();
        }
    }

    public static void a(int i3) {
        f336219a = f.b(i3);
    }

    public static <InitParameters extends a.InterfaceC9209a> void b(int i3, InitParameters initparameters) {
        a a16 = f.a(i3);
        if (a16 == null) {
            com.tencent.msdk.dns.base.log.c.c("Get builtIn reporter from channel: %d failed", Integer.valueOf(i3));
        } else if (!a16.b(initparameters)) {
            com.tencent.msdk.dns.base.log.c.c("%s init failed", a16.getName());
        }
    }

    public static void c(int i3, String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            com.tencent.msdk.dns.base.log.c.c("HTTPDNS_SDK_VER:3.9.0a, Try to report %s", str);
            if (com.tencent.msdk.dns.base.log.c.e(2)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    com.tencent.msdk.dns.base.log.c.c("%s: %s", entry.getKey(), entry.getValue());
                }
            }
            if (!f.f336222b) {
                return;
            }
            for (a aVar : f336219a) {
                if (!aVar.c(i3, str, map)) {
                    com.tencent.msdk.dns.base.log.c.c("%s report failed", aVar.getName());
                }
            }
            for (a aVar2 : f336220b) {
                if (!aVar2.c(i3, str, map)) {
                    com.tencent.msdk.dns.base.log.c.c("%s report failed", aVar2.getName());
                }
            }
        }
    }

    public static synchronized void d(a aVar) {
        synchronized (e.class) {
            if (aVar != null) {
                if (aVar.a()) {
                    if (f336220b.isEmpty()) {
                        f336220b = new ArrayList();
                    }
                    f336220b.add(aVar);
                }
            }
        }
    }

    public static boolean e() {
        if (f336219a.isEmpty() && f336220b.isEmpty()) {
            return false;
        }
        return true;
    }
}
