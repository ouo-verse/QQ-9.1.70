package com.tencent.luggage.wxa.ph;

import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        HIDE(e.d.HIDE, 1),
        LAUNCH_NATIVE_PAGE(e.d.LAUNCH_NATIVE_PAGE, 2),
        BACK(e.d.BACK, 3),
        CLOSE(e.d.CLOSE, 4),
        LAUNCH_MINI_PROGRAM(e.d.LAUNCH_MINI_PROGRAM, 5),
        HOME_PRESSED(e.d.HOME_PRESSED, 6),
        RECENT_APPS_PRESSED(e.d.RECENT_APPS_PRESSED, 7),
        HANG(e.d.HANG, 8);


        /* renamed from: k, reason: collision with root package name */
        public static Map f137596k = null;

        /* renamed from: l, reason: collision with root package name */
        public static Map f137597l = null;

        /* renamed from: a, reason: collision with root package name */
        public final e.d f137599a;

        /* renamed from: b, reason: collision with root package name */
        public final int f137600b;

        a(e.d dVar, int i3) {
            this.f137599a = dVar;
            this.f137600b = i3;
        }

        public static void b() {
            a[] values = values();
            f137596k = new HashMap(values.length * 2);
            f137597l = new HashMap(values.length * 2);
            for (a aVar : values) {
                f137596k.put(aVar.f137599a, Integer.valueOf(aVar.f137600b));
                f137597l.put(Integer.valueOf(aVar.f137600b), aVar.f137599a);
            }
        }

        public static synchronized Map c() {
            synchronized (a.class) {
                Map map = f137597l;
                if (map != null) {
                    return map;
                }
                b();
                return f137597l;
            }
        }

        public static synchronized Map d() {
            synchronized (a.class) {
                Map map = f137596k;
                if (map != null) {
                    return map;
                }
                b();
                return f137596k;
            }
        }

        public static int a(e.d dVar) {
            return ((Integer) d().get(dVar)).intValue();
        }

        public static e.d a(int i3) {
            return (e.d) c().get(Integer.valueOf(i3));
        }
    }

    public static int a(String str) {
        return a.a(e.d(str));
    }

    public static e.d a(int i3) {
        e.d a16 = a.a(i3);
        return a16 == null ? e.d.HIDE : a16;
    }

    public static g a(com.tencent.luggage.wxa.z7.c cVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            return a(cVar.e());
        }
        return null;
    }

    public static g a(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar instanceof v) {
            return ((v) dVar).getRuntime();
        }
        if (dVar instanceof l) {
            return ((l) dVar).getRuntime();
        }
        return null;
    }
}
