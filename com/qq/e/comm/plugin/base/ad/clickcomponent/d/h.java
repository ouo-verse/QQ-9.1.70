package com.qq.e.comm.plugin.base.ad.clickcomponent.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.k.al;
import com.qq.e.comm.plugin.k.i;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static JSONObject f38593a;

    /* renamed from: b, reason: collision with root package name */
    private static String f38594b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f38595c;

    /* renamed from: d, reason: collision with root package name */
    private static c f38596d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(Method method, Object[] objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private a f38604a;

        public b(a aVar) {
            this.f38604a = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            this.f38604a.a(method, objArr);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {
        void a(int i3, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i3, int i16, int i17, long j3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        if (y.a(f38593a)) {
            bVar.c(f38593a.optString("traceid"));
            bVar.b(f38593a.optString("cl"));
            bVar.c(f38593a.optInt("producttype"));
        }
        bVar.a(f38594b);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("cost_time", Long.valueOf(j3));
        cVar.a("error_code", Integer.valueOf(i16));
        cVar.a("subErrorCode", Integer.valueOf(i17));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void c() {
        a(54023);
        final long currentTimeMillis = System.currentTimeMillis();
        Class a16 = al.a("com.tencent.luggage.wxaapi.TdiAuthListener");
        Method a17 = al.a(f38595c.getClass(), "sendAuth", a16);
        if (a16 != null && a17 != null) {
            b bVar = new b(new a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.3
                /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:6:0x0047  */
                @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a(Method method, Object[] objArr) {
                    Method a18;
                    int intValue;
                    int i3;
                    int i16 = 5003;
                    boolean z16 = false;
                    if (objArr.length != 0) {
                        Object obj = objArr[0];
                        Class a19 = al.a("com.tencent.luggage.wxaapi.TdiAuthErrCode");
                        if (a19 == null || (a18 = al.a(a19, "ordinal", new Class[0])) == null) {
                            intValue = 0;
                            i16 = 5001;
                        } else {
                            Object a26 = al.a(obj, a18, new Object[0]);
                            if (a26 instanceof Integer) {
                                Integer num = (Integer) a26;
                                if (num.intValue() == 0) {
                                    intValue = 0;
                                    i16 = 0;
                                    z16 = true;
                                } else {
                                    intValue = num.intValue();
                                    i16 = 5002;
                                }
                            }
                        }
                        if (h.f38596d == null) {
                            if (z16) {
                                i3 = 54024;
                            } else {
                                i3 = 54025;
                            }
                            h.b(i3, i16, intValue, System.currentTimeMillis() - currentTimeMillis);
                            h.f38596d.a(1, z16);
                            return;
                        }
                        return;
                    }
                    intValue = 0;
                    if (h.f38596d == null) {
                    }
                }
            });
            ClassLoader classLoader = h.class.getClassLoader();
            if (classLoader == null) {
                return;
            }
            al.a(f38595c, a17, Proxy.newProxyInstance(classLoader, new Class[]{a16}, bVar));
            return;
        }
        if (f38596d != null) {
            b(54024, 5001, 0, System.currentTimeMillis() - currentTimeMillis);
            f38596d.a(1, false);
        }
    }

    public static void d() {
        a(54005);
        final long currentTimeMillis = System.currentTimeMillis();
        if (f38595c == null) {
            b(54007, 1000, 0, System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        Class a16 = al.a("com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResultListener");
        Method a17 = al.a(f38595c.getClass(), "preloadWxaProcessEnv", Integer.TYPE, a16);
        if (a16 != null && a17 != null) {
            b bVar = new b(new a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.4
                /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
                /* JADX WARN: Removed duplicated region for block: B:6:0x0043  */
                @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a(Method method, Object[] objArr) {
                    Method a18;
                    int i3;
                    boolean z16;
                    int i16;
                    Class a19 = al.a("com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult");
                    int i17 = 1001;
                    if (a19 != null && (a18 = al.a(a19, "ordinal", new Class[0])) != null) {
                        i3 = 1003;
                        if (objArr.length != 0) {
                            Object a26 = al.a(objArr[0], a18, new Object[0]);
                            if (a26 instanceof Integer) {
                                Integer num = (Integer) a26;
                                z16 = true;
                                if (num.intValue() != 0 && num.intValue() != 1) {
                                    i17 = 1002;
                                } else {
                                    i3 = 0;
                                    if (z16) {
                                        i16 = 54006;
                                    } else {
                                        i16 = 54007;
                                    }
                                    h.b(i16, i3, 0, System.currentTimeMillis() - currentTimeMillis);
                                }
                            }
                        }
                        z16 = false;
                        if (z16) {
                        }
                        h.b(i16, i3, 0, System.currentTimeMillis() - currentTimeMillis);
                    }
                    i3 = i17;
                    z16 = false;
                    if (z16) {
                    }
                    h.b(i16, i3, 0, System.currentTimeMillis() - currentTimeMillis);
                }
            });
            ClassLoader classLoader = h.class.getClassLoader();
            if (classLoader == null) {
                return;
            }
            al.a(f38595c, a17, 1, Proxy.newProxyInstance(classLoader, new Class[]{a16}, bVar));
            return;
        }
        b(54007, 1001, 0, System.currentTimeMillis() - currentTimeMillis);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean f() {
        int i3;
        boolean z16;
        int i16;
        a(54014);
        long currentTimeMillis = System.currentTimeMillis();
        Method a16 = al.a(f38595c.getClass(), "isDynamicPkgLoaded", new Class[0]);
        if (a16 == null) {
            i3 = 2003;
        } else {
            Object a17 = al.a(f38595c, a16, new Object[0]);
            if (a17 instanceof Boolean) {
                if (((Boolean) a17).booleanValue()) {
                    z16 = true;
                    i3 = 0;
                    if (!z16) {
                        i16 = 54015;
                    } else {
                        i16 = 54016;
                    }
                    b(i16, i3, 0, System.currentTimeMillis() - currentTimeMillis);
                    if (z16 && !g()) {
                        return false;
                    }
                    return true;
                }
                i3 = 2006;
            } else {
                i3 = 2004;
            }
        }
        z16 = false;
        if (!z16) {
        }
        b(i16, i3, 0, System.currentTimeMillis() - currentTimeMillis);
        if (z16) {
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean g() {
        Method a16;
        int intValue;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        Pair<Boolean, String> initDynamicPkg = com.qq.e.comm.plugin.base.a.a.a().d().initDynamicPkg();
        boolean z16 = false;
        if (!((Boolean) initDynamicPkg.first).booleanValue()) {
            b(54016, 2001, 0, System.currentTimeMillis() - currentTimeMillis);
            return false;
        }
        if (TextUtils.isEmpty((CharSequence) initDynamicPkg.second)) {
            b(54016, 2002, 0, System.currentTimeMillis() - currentTimeMillis);
            return false;
        }
        a(54017);
        Method a17 = al.a(f38595c.getClass(), "initDynamicPkg", String.class);
        int i16 = 2003;
        if (a17 != null) {
            Object a18 = al.a(f38595c, a17, initDynamicPkg.second);
            Class a19 = al.a("com.tencent.luggage.wxaapi.InitDynamicPkgResult");
            if (a19 != null && (a16 = al.a(a19, "ordinal", new Class[0])) != null) {
                Object a26 = al.a(a18, a16, new Object[0]);
                if (a26 instanceof Integer) {
                    Integer num = (Integer) a26;
                    if (num.intValue() == 0) {
                        intValue = 0;
                        i16 = 0;
                        z16 = true;
                    } else {
                        intValue = num.intValue();
                        i16 = 2006;
                    }
                    if (!z16) {
                        i3 = 54018;
                    } else {
                        i3 = 54019;
                    }
                    b(i3, i16, intValue, System.currentTimeMillis() - currentTimeMillis);
                    return z16;
                }
                i16 = 2004;
            }
        }
        intValue = 0;
        if (!z16) {
        }
        b(i3, i16, intValue, System.currentTimeMillis() - currentTimeMillis);
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean h() {
        int i3;
        boolean z16;
        int i16;
        int i17;
        a(54011);
        long currentTimeMillis = System.currentTimeMillis();
        Method a16 = al.a(f38595c.getClass(), "checkIfWechatSupportWxaApi", new Class[0]);
        if (a16 == null) {
            i3 = 3001;
        } else {
            Object a17 = al.a(f38595c, a16, new Object[0]);
            if (a17 instanceof Boolean) {
                if (((Boolean) a17).booleanValue()) {
                    z16 = true;
                    i16 = 0;
                    if (!z16) {
                        i17 = 54012;
                    } else {
                        i17 = 54013;
                    }
                    b(i17, i16, 0, System.currentTimeMillis() - currentTimeMillis);
                    return z16;
                }
                i3 = 3002;
            } else {
                i3 = 3003;
            }
        }
        i16 = i3;
        z16 = false;
        if (!z16) {
        }
        b(i17, i16, 0, System.currentTimeMillis() - currentTimeMillis);
        return z16;
    }

    public static void a(int i3) {
        b(i3, 0, 0, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(JSONObject jSONObject, String str, ClickInfo.a aVar) {
        boolean z16;
        f38593a = jSONObject;
        f38594b = str;
        b(54001, 0, 0, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        final String optString = jSONObject.optString("mini_program_app_id");
        final String b16 = i.b(jSONObject, aVar);
        if (TextUtils.isEmpty(optString)) {
            b(54008, 0, 0, 0L);
            b(54003, 0, 0, System.currentTimeMillis() - currentTimeMillis);
            return false;
        }
        if (a() && h() && f()) {
            final Exchanger exchanger = new Exchanger();
            f38596d = new c() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.1
                @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.c
                public void a(int i3, boolean z17) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                h.a(54004);
                                try {
                                    exchanger.exchange(Boolean.FALSE);
                                    return;
                                } catch (Exception e16) {
                                    GDTLogger.e(e16.getMessage());
                                    return;
                                }
                            }
                            try {
                                exchanger.exchange(Boolean.valueOf(z17));
                                return;
                            } catch (Exception e17) {
                                GDTLogger.e(e17.getMessage());
                                return;
                            }
                        }
                        if (z17) {
                            h.a(optString, b16);
                            return;
                        }
                        try {
                            exchanger.exchange(Boolean.FALSE);
                            return;
                        } catch (Exception e18) {
                            GDTLogger.d(e18.getMessage());
                            return;
                        }
                    }
                    if (z17) {
                        h.a(optString, b16);
                    } else {
                        h.c();
                    }
                }
            };
            b();
            try {
                z16 = ((Boolean) exchanger.exchange(null, com.qq.e.comm.plugin.j.c.a(f38594b, "wxLuggageTimeOut", 30000), TimeUnit.MILLISECONDS)).booleanValue();
            } catch (TimeoutException e16) {
                GDTLogger.e(e16.getMessage());
                z16 = false;
                b(z16 ? 54002 : 54003, 0, 0, System.currentTimeMillis() - currentTimeMillis);
                return z16;
            } catch (Exception e17) {
                GDTLogger.e(e17.getMessage());
                z16 = false;
                b(z16 ? 54002 : 54003, 0, 0, System.currentTimeMillis() - currentTimeMillis);
                return z16;
            }
            b(z16 ? 54002 : 54003, 0, 0, System.currentTimeMillis() - currentTimeMillis);
            return z16;
        }
        b(54003, 0, 0, System.currentTimeMillis() - currentTimeMillis);
        return false;
    }

    public static void b() {
        b(54020, 0, 0, 0L);
        final long currentTimeMillis = System.currentTimeMillis();
        Class a16 = al.a("com.tencent.luggage.wxaapi.TdiAuthCheckStateListener");
        Method a17 = al.a(f38595c.getClass(), "checkAuthState", a16);
        if (a16 != null && a17 != null) {
            al.a(f38595c, a17, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{a16}, new b(new a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.2
                /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:6:0x004a  */
                @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a(Method method, Object[] objArr) {
                    Method a18;
                    int intValue;
                    boolean z16;
                    int i3;
                    int i16 = 4003;
                    if (objArr.length != 0) {
                        Object obj = objArr[0];
                        Class a19 = al.a("com.tencent.luggage.wxaapi.TdiAuthState");
                        if (a19 == null || (a18 = al.a(a19, "ordinal", new Class[0])) == null) {
                            z16 = false;
                            intValue = 0;
                            i16 = 4001;
                        } else {
                            Object a26 = al.a(obj, a18, new Object[0]);
                            if (a26 instanceof Integer) {
                                Integer num = (Integer) a26;
                                if (num.intValue() == 0) {
                                    z16 = true;
                                    intValue = 0;
                                    i16 = 0;
                                } else {
                                    i16 = 4002;
                                    intValue = num.intValue();
                                    z16 = false;
                                }
                            }
                        }
                        if (h.f38596d == null) {
                            if (z16) {
                                i3 = 54021;
                            } else {
                                i3 = 54022;
                            }
                            h.b(i3, i16, intValue, System.currentTimeMillis() - currentTimeMillis);
                            h.f38596d.a(0, z16);
                            return;
                        }
                        return;
                    }
                    z16 = false;
                    intValue = 0;
                    if (h.f38596d == null) {
                    }
                }
            })));
        } else if (f38596d != null) {
            b(54022, 4001, 0, System.currentTimeMillis() - currentTimeMillis);
            f38596d.a(0, false);
        }
    }

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.qq.e.comm.plugin.base.a.a.a().d() != null) {
            f38595c = com.qq.e.comm.plugin.base.a.a.a().d().initWxLuggageSDK();
        }
        boolean z16 = f38595c != null;
        b(z16 ? 54009 : 54010, 0, 0, System.currentTimeMillis() - currentTimeMillis);
        return z16;
    }

    public static void a(String str, String str2) {
        a(54026);
        final long currentTimeMillis = System.currentTimeMillis();
        Class a16 = al.a("com.tencent.luggage.wxaapi.LaunchWxaAppResultListener");
        Method a17 = al.a(f38595c.getClass(), "launchWxaApp", Context.class, String.class, Integer.TYPE, String.class, a16);
        if (a16 != null && a17 != null) {
            al.a(f38595c, a17, GDTADManager.getInstance().getAppContext(), str, 0, str2, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{a16}, new b(new a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.5
                @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.d.h.a
                public void a(Method method, Object[] objArr) {
                    Method a18;
                    int intValue;
                    int i3;
                    Class a19 = al.a("com.tencent.luggage.wxaapi.LaunchWxaAppResult");
                    int i16 = 6001;
                    boolean z16 = false;
                    if (a19 == null || (a18 = al.a(a19, "ordinal", new Class[0])) == null) {
                        intValue = 0;
                    } else {
                        if (objArr.length >= 4) {
                            Object a26 = al.a(objArr[3], a18, new Object[0]);
                            if (a26 instanceof Integer) {
                                Integer num = (Integer) a26;
                                if (num.intValue() == 0) {
                                    i16 = 0;
                                    z16 = true;
                                    intValue = 0;
                                } else {
                                    intValue = num.intValue();
                                    i16 = 6002;
                                }
                            }
                        }
                        intValue = 0;
                        i16 = 6003;
                    }
                    if (h.f38596d != null) {
                        if (z16) {
                            i3 = 54027;
                        } else {
                            i3 = 54028;
                        }
                        h.b(i3, i16, intValue, System.currentTimeMillis() - currentTimeMillis);
                        h.f38596d.a(2, z16);
                    }
                }
            })));
        } else if (f38596d != null) {
            b(54028, 6001, 0, System.currentTimeMillis() - currentTimeMillis);
            f38596d.a(2, false);
        }
    }
}
