package com.tencent.ams.fusion.a;

import android.text.TextUtils;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i {
    public static synchronized int a(SplashOrder splashOrder) {
        synchronized (i.class) {
            if (splashOrder == null) {
                return 0;
            }
            String bn5 = splashOrder.bn();
            if (TextUtils.isEmpty(bn5)) {
                return 0;
            }
            String c16 = c.c("com.tencent.ams.sp.ad_status", "uoidsLimitList", "");
            if (TextUtils.isEmpty(c16)) {
                return 0;
            }
            int e16 = e.e(e.b(c16), bn5, 0);
            f.b("OrderUtil", "[getAdShowTimes] uoid = " + bn5 + ", limit =" + e16);
            return e16;
        }
    }

    public static synchronized void b() {
        synchronized (i.class) {
            c.a("com.tencent.ams.sp.ad_status", "uoidsLimitList");
        }
    }

    private static void c(SplashOrder splashOrder, List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        if (splashOrder != null && list != null) {
            if (!j.b(splashOrder.aM())) {
                list.addAll(splashOrder.aM());
            }
            if (!j.b(splashOrder.aN())) {
                list.addAll(splashOrder.aN());
            }
            com.tencent.ams.fusion.service.splash.data.d aQ = splashOrder.aQ();
            if (aQ != null) {
                if (!j.b(aQ.a())) {
                    list.addAll(aQ.a());
                }
                if (!j.b(aQ.c())) {
                    list.addAll(aQ.c());
                }
                if (!j.b(aQ.m())) {
                    list.addAll(aQ.m());
                }
            }
        }
    }

    public static synchronized void d(SplashOrder splashOrder) {
        JSONObject b16;
        synchronized (i.class) {
            if (splashOrder == null) {
                return;
            }
            String bn5 = splashOrder.bn();
            if (TextUtils.isEmpty(bn5)) {
                return;
            }
            String c16 = c.c("com.tencent.ams.sp.ad_status", "uoidsLimitList", "");
            f.b("OrderUtil", "[addAdShowTimes] uoidsLimitJsonStr = " + c16);
            int i3 = 0;
            if (TextUtils.isEmpty(c16)) {
                b16 = e.a();
            } else {
                b16 = e.b(c16);
                i3 = e.e(b16, bn5, 0);
            }
            f.b("OrderUtil", "[addAdShowTimes] uoid = " + bn5 + ", limit =" + i3);
            e.c(b16, bn5, i3 + 1);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[addAdShowTimes] uoid limit json = ");
            sb5.append(b16.toString());
            f.b("OrderUtil", sb5.toString());
            c.b("com.tencent.ams.sp.ad_status", "uoidsLimitList", b16.toString());
        }
    }

    private static void e(SplashOrder splashOrder, List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        if (splashOrder != null && list != null) {
            if (!j.b(splashOrder.aL())) {
                list.addAll(splashOrder.aL());
            }
            if (!j.b(splashOrder.aO())) {
                list.addAll(splashOrder.aO());
            }
            if (!j.b(splashOrder.aP())) {
                list.addAll(splashOrder.aP());
            }
            com.tencent.ams.fusion.service.splash.data.d aQ = splashOrder.aQ();
            if (aQ != null) {
                if (!j.b(aQ.g())) {
                    list.addAll(aQ.g());
                }
                if (!j.b(aQ.i())) {
                    list.addAll(aQ.i());
                }
                if (!j.b(aQ.k())) {
                    list.addAll(aQ.k());
                }
                if (!j.b(aQ.e())) {
                    list.addAll(aQ.e());
                }
            }
            com.tencent.ams.fusion.service.splash.data.c aR = splashOrder.aR();
            if (aR != null && !j.b(aR.a())) {
                list.addAll(aR.a());
            }
        }
    }

    public static List<com.tencent.ams.fusion.service.splash.b.a.a> f(SplashOrder splashOrder) {
        ArrayList arrayList = new ArrayList();
        List<com.tencent.ams.fusion.service.splash.b.a.a> h16 = h(splashOrder);
        List<com.tencent.ams.fusion.service.splash.b.a.a> j3 = j(splashOrder);
        if (!j.b(h16)) {
            arrayList.addAll(h16);
        }
        if (!j.b(j3)) {
            arrayList.addAll(j3);
        }
        return arrayList;
    }

    public static List<com.tencent.ams.fusion.service.splash.b.a.a> g(SplashOrder splashOrder) {
        if (splashOrder == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!j.b(splashOrder.aE())) {
            arrayList.addAll(splashOrder.aE());
        }
        c(splashOrder, arrayList);
        return arrayList;
    }

    public static List<com.tencent.ams.fusion.service.splash.b.a.a> h(SplashOrder splashOrder) {
        if (splashOrder == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!j.b(splashOrder.aD())) {
            arrayList.addAll(splashOrder.aD());
        }
        c(splashOrder, arrayList);
        return arrayList;
    }

    public static List<com.tencent.ams.fusion.service.splash.b.a.a> i(SplashOrder splashOrder) {
        if (splashOrder == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!j.b(splashOrder.aG())) {
            arrayList.addAll(splashOrder.aG());
        }
        e(splashOrder, arrayList);
        return arrayList;
    }

    public static List<com.tencent.ams.fusion.service.splash.b.a.a> j(SplashOrder splashOrder) {
        if (splashOrder == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!j.b(splashOrder.aF())) {
            arrayList.addAll(splashOrder.aF());
        }
        e(splashOrder, arrayList);
        return arrayList;
    }
}
