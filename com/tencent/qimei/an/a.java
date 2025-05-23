package com.tencent.qimei.an;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.aa.f;
import com.tencent.qimei.ad.c;
import com.tencent.qimei.ai.c;
import com.tencent.qimei.al.a;
import com.tencent.qimei.ap.d;
import com.tencent.qimei.as.a;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.uin.U;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f343079a;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.an.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C9308a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f343080a;

        /* renamed from: b, reason: collision with root package name */
        public int f343081b;

        /* renamed from: c, reason: collision with root package name */
        public int f343082c;

        /* renamed from: d, reason: collision with root package name */
        public int f343083d;

        /* renamed from: e, reason: collision with root package name */
        public int f343084e;

        public C9308a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f343080a = 23;
            this.f343081b = 50;
            this.f343082c = 0;
            this.f343083d = 10;
            this.f343084e = 60;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16721);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f343079a = new ConcurrentHashMap<>();
        }
    }

    public static Qimei a(String str) {
        if (c(str)) {
            return null;
        }
        return com.tencent.qimei.ai.b.a(str).f342995b;
    }

    public static boolean b(String str) {
        long c16 = f.b(str).c("q_s_t");
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeInMillis(c16);
        Calendar calendar2 = Calendar.getInstance();
        boolean z16 = true;
        if (calendar2.get(1) == calendar.get(1) && calendar2.get(6) == calendar.get(6)) {
            z16 = false;
        }
        if (z16) {
            c.b("SDK_INIT \uff5c QM", "cross day since last QM request", new Object[0]);
        }
        return z16;
    }

    public static boolean c(String str) {
        if (str != null && !str.isEmpty() && d.c().e() != null) {
            return false;
        }
        return true;
    }

    public static boolean d(String str) {
        boolean a16 = com.tencent.qimei.ab.d.a(f.b(str).c("q_s_t"), 24L);
        if (a16) {
            c.b("SDK_INIT \uff5c QM", "more than 24 hours since last QM request", new Object[0]);
        }
        return a16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (r3 != 100) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Qimei e(String str) {
        String str2;
        byte[] b16;
        if (a.C9307a.f343059a.f343058a && (b16 = U.b(str)) != null && b16.length > 1) {
            byte b17 = b16[0];
            if (b17 != 0 && b17 != 104 && b17 != 101) {
                if (b17 == 100) {
                    com.tencent.qimei.ak.a.a(str).f343051c = true;
                } else {
                    com.tencent.qimei.f.a.a(str, b17);
                }
            }
            str2 = new String(Arrays.copyOfRange(b16, 1, b16.length));
            if (b17 != 0) {
            }
            c.b("SDK_INIT \uff5c LOCAL_ENC", "get the storage QM:%s (appKey: %s)", str2, str);
            if (str2.isEmpty()) {
                return a(str, str2);
            }
            return null;
        }
        str2 = "";
        c.b("SDK_INIT \uff5c LOCAL_ENC", "get the storage QM:%s (appKey: %s)", str2, str);
        if (str2.isEmpty()) {
        }
    }

    public static boolean a(String str, Context context) {
        int i3 = Calendar.getInstance().get(11);
        int i16 = Calendar.getInstance().get(12);
        C9308a c9308a = new C9308a();
        String a16 = a.c.L.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(str).f343094b.f343146r));
        if (a16.length() == 14) {
            try {
                c9308a.f343080a = Integer.parseInt(a16.substring(0, 2));
                c9308a.f343081b = Integer.parseInt(a16.substring(3, 5));
                c9308a.f343082c = Integer.parseInt(a16.substring(6, 8));
                c9308a.f343083d = Integer.parseInt(a16.substring(9, 11));
                c9308a.f343084e = Integer.parseInt(a16.substring(12));
            } catch (Exception unused) {
                c9308a = new C9308a();
            }
        }
        if ((i3 == c9308a.f343080a && i16 >= c9308a.f343081b) || (i3 == c9308a.f343082c && i16 <= c9308a.f343083d)) {
            com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(str).f343094b;
            r8 = !(aVar.f343135g && aVar.f343138j && com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343121s, aVar.f343146r).booleanValue() ? com.tencent.qimei.u.a.a(context) : false);
        }
        if (r8) {
            int i17 = c9308a.f343080a;
            int i18 = c9308a.f343082c;
            com.tencent.qimei.ai.b.a(str).f342998e = ((i17 > i18 ? (1440 - ((i17 * 60) + c9308a.f343081b)) + (i18 * 60) + c9308a.f343083d : i17 < i18 ? ((i18 * 60) + c9308a.f343083d) - ((i17 * 60) + c9308a.f343081b) : c9308a.f343083d - c9308a.f343081b) * 60 * 1000) + new Random(System.identityHashCode(new Object())).nextInt(c9308a.f343084e * 60 * 1000) + 1;
        }
        return r8;
    }

    public static Qimei a(String str, String str2) {
        Qimei qimei = new Qimei(c.a.f343002a.a(str2), c.a.f343003b.a(str2), str);
        return qimei.isEmpty() ? new Qimei(c.a.f343004c.a(str2), c.a.f343005d.a(str2), str) : qimei;
    }
}
