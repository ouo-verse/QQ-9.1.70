package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class de {

    /* renamed from: a, reason: collision with root package name */
    private static a f388584a;

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, gp> f388585b;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        void a(Context context, gj gjVar);
    }

    public static int a(int i3) {
        if (i3 > 0) {
            return i3 + 1000;
        }
        return -1;
    }

    public static int b(Enum r16) {
        if (r16 != null) {
            if (r16 instanceof gf) {
                return r16.ordinal() + 1001;
            }
            if (r16 instanceof gp) {
                return r16.ordinal() + 2001;
            }
            if (r16 instanceof ed) {
                return r16.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static gj c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gj gjVar = new gj();
        gjVar.d("category_client_report_data");
        gjVar.a("push_sdk_channel");
        gjVar.a(1L);
        gjVar.b(str);
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(context.getPackageName());
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f(com.xiaomi.push.service.af.b());
        gjVar.c("quality_support");
        return gjVar;
    }

    public static gp d(String str) {
        if (f388585b == null) {
            synchronized (gp.class) {
                if (f388585b == null) {
                    f388585b = new HashMap();
                    for (gp gpVar : gp.values()) {
                        f388585b.put(gpVar.f24750a.toLowerCase(), gpVar);
                    }
                }
            }
        }
        gp gpVar2 = f388585b.get(str.toLowerCase());
        if (gpVar2 == null) {
            return gp.Invalid;
        }
        return gpVar2;
    }

    public static String e(int i3) {
        if (i3 == 1000) {
            return "E100000";
        }
        if (i3 == 3000) {
            return "E100002";
        }
        if (i3 == 2000) {
            return "E100001";
        }
        if (i3 == 6000) {
            return "E100003";
        }
        return "";
    }

    public static kz4.a f(Context context) {
        boolean m3 = com.xiaomi.push.service.ah.d(context).m(gk.PerfUploadSwitch.a(), false);
        boolean m16 = com.xiaomi.push.service.ah.d(context).m(gk.EventUploadNewSwitch.a(), false);
        return kz4.a.b().l(m16).k(com.xiaomi.push.service.ah.d(context).a(gk.EventUploadFrequency.a(), 86400)).o(m3).n(com.xiaomi.push.service.ah.d(context).a(gk.PerfUploadFrequency.a(), 86400)).h(context);
    }

    public static kz4.b g(Context context, String str, String str2, int i3, long j3, String str3) {
        kz4.b h16 = h(str);
        h16.f413522h = str2;
        h16.f413523i = i3;
        h16.f413524j = j3;
        h16.f413525k = str3;
        return h16;
    }

    public static kz4.b h(String str) {
        kz4.b bVar = new kz4.b();
        bVar.f413529a = 1000;
        bVar.f413531c = 1001;
        bVar.f413530b = str;
        return bVar;
    }

    public static kz4.c i() {
        kz4.c cVar = new kz4.c();
        cVar.f413529a = 1000;
        cVar.f413531c = 1000;
        cVar.f413530b = "P100000";
        return cVar;
    }

    public static kz4.c j(Context context, int i3, long j3, long j16) {
        kz4.c i16 = i();
        i16.f413526h = i3;
        i16.f413527i = j3;
        i16.f413528j = j16;
        return i16;
    }

    public static void k(Context context) {
        com.xiaomi.clientreport.manager.b.d(context, f(context));
    }

    private static void l(Context context, gj gjVar) {
        if (p(context.getApplicationContext())) {
            com.xiaomi.push.service.ba.a(context.getApplicationContext(), gjVar);
            return;
        }
        a aVar = f388584a;
        if (aVar != null) {
            aVar.a(context, gjVar);
        }
    }

    public static void m(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                gj c16 = c(context, it.next());
                if (!com.xiaomi.push.service.af.e(c16, false)) {
                    l(context, c16);
                }
            }
        } catch (Throwable th5) {
            jz4.c.B(th5.getMessage());
        }
    }

    public static void n(Context context, kz4.a aVar) {
        com.xiaomi.clientreport.manager.b.a(context, aVar, new db(context), new dc(context));
    }

    public static void o(a aVar) {
        f388584a = aVar;
    }

    public static boolean p(Context context) {
        if (context != null && !TextUtils.isEmpty(context.getPackageName()) && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        return false;
    }
}
