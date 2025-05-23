package com.tencent.msdk.dns;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.a;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f336223a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16481);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ e b() {
        return null;
    }

    private String d(String str, boolean z16) {
        String str2;
        com.tencent.msdk.dns.base.log.c.g("MSDKDnsResolver.getAddrByName() called.", new Object[0]);
        com.tencent.msdk.dns.core.c cVar = com.tencent.msdk.dns.core.c.f336247d;
        try {
            cVar = DnsService.f(str, z16);
        } catch (Exception unused) {
        }
        String str3 = "0";
        if (com.tencent.msdk.dns.c.e.a.i(cVar.f336248a)) {
            str2 = "0";
        } else {
            str2 = cVar.f336248a[0];
        }
        if (!com.tencent.msdk.dns.c.e.a.i(cVar.f336249b)) {
            str3 = cVar.f336249b[0];
        }
        return str2 + ";" + str3;
    }

    private com.tencent.msdk.dns.core.c f(String str, boolean z16) {
        com.tencent.msdk.dns.base.log.c.g("MSDKDnsResolver.getAddrsByName() called.", new Object[0]);
        com.tencent.msdk.dns.core.c cVar = com.tencent.msdk.dns.core.c.f336247d;
        try {
            return DnsService.f(str, z16);
        } catch (Exception unused) {
            return cVar;
        }
    }

    public static c h() {
        if (f336223a == null) {
            synchronized (c.class) {
                if (f336223a == null) {
                    f336223a = new c();
                }
            }
        }
        return f336223a;
    }

    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        com.tencent.msdk.dns.base.log.c.g("MSDKDnsResolver.WGSetDnsOpenId() called.", new Object[0]);
        try {
            DnsService.k(str);
            return true;
        } catch (Exception e16) {
            com.tencent.msdk.dns.base.log.c.j(e16, "WGSetDnsOpenId failed", new Object[0]);
            return false;
        }
    }

    public String c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        return d(str, true);
    }

    public com.tencent.msdk.dns.core.c e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.msdk.dns.core.c) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return f(str, true);
    }

    public String g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        com.tencent.msdk.dns.base.log.c.g("MSDKDnsResolver.getDnsDetail() called.", new Object[0]);
        try {
            return DnsService.g(str);
        } catch (Exception e16) {
            com.tencent.msdk.dns.base.log.c.g("getDnsDetail exception:" + e16, new Object[0]);
            return "";
        }
    }

    public void i(Context context, String str, String str2, String str3, String str4, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, str2, str3, str4, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            j(context, str, str2, str3, str4, z16, i3, "DesHttp", false);
        }
    }

    public void j(Context context, String str, String str2, String str3, String str4, boolean z16, int i3, String str5, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, str2, str3, str4, Boolean.valueOf(z16), Integer.valueOf(i3), str5, Boolean.valueOf(z17));
            return;
        }
        a.C9208a c9208a = new a.C9208a();
        if (z16) {
            i16 = 2;
        }
        a.C9208a j3 = c9208a.i(i16).b(str).j(i3);
        if (str4 != null) {
            j3.f(str4);
        }
        if (str2 != null) {
            j3.e(str2);
        }
        if (str3 != null) {
            j3.g(str3);
        }
        if (str3 != null) {
            j3.g(str3);
        }
        j3.h(z17);
        if ("AesHttp".equals(str5)) {
            j3.a();
        } else {
            j3.d();
        }
        DnsService.h(context, j3.c());
        com.tencent.msdk.dns.base.log.c.c("MSDKDnsResolver.init() called, ver:%s, channel:%s", "3.9.0a", str5);
    }
}
