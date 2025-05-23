package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    public static int f98042a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static long f98043b = 259200000;

    /* renamed from: d, reason: collision with root package name */
    private static ak f98044d;

    /* renamed from: i, reason: collision with root package name */
    private static String f98045i;

    /* renamed from: c, reason: collision with root package name */
    public final at f98046c;

    /* renamed from: e, reason: collision with root package name */
    private final List<o> f98047e;

    /* renamed from: f, reason: collision with root package name */
    private final StrategyBean f98048f;

    /* renamed from: g, reason: collision with root package name */
    private StrategyBean f98049g = null;

    /* renamed from: h, reason: collision with root package name */
    private Context f98050h;

    ak(Context context, List<o> list) {
        this.f98050h = context;
        if (ai.a(context) != null) {
            String str = ai.a(context).P;
            if ("oversea".equals(str)) {
                StrategyBean.f97836a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f97837b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f97836a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f97837b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f98048f = new StrategyBean();
        this.f98047e = list;
        this.f98046c = at.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<ag> a16 = ae.a().a(2);
        if (a16 != null && a16.size() > 0 && (bArr = a16.get(0).f97984g) != null) {
            return (StrategyBean) ba.a(bArr, StrategyBean.CREATOR);
        }
        return null;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f98049g;
        if (strategyBean != null) {
            if (!ba.c(strategyBean.f97852q)) {
                this.f98049g.f97852q = StrategyBean.f97836a;
            }
            if (!ba.c(this.f98049g.f97853r)) {
                this.f98049g.f97853r = StrategyBean.f97837b;
            }
            return this.f98049g;
        }
        if (!ba.b(f98045i) && ba.c(f98045i)) {
            StrategyBean strategyBean2 = this.f98048f;
            String str = f98045i;
            strategyBean2.f97852q = str;
            strategyBean2.f97853r = str;
        }
        return this.f98048f;
    }

    public final synchronized boolean b() {
        return this.f98049g != null;
    }

    public static synchronized ak a(Context context, List<o> list) {
        ak akVar;
        synchronized (ak.class) {
            if (f98044d == null) {
                f98044d = new ak(context, list);
            }
            akVar = f98044d;
        }
        return akVar;
    }

    public static synchronized ak a() {
        ak akVar;
        synchronized (ak.class) {
            akVar = f98044d;
        }
        return akVar;
    }

    protected final void a(StrategyBean strategyBean, boolean z16) {
        av.c("[Strategy] Notify %s", t.class.getName());
        t.a(strategyBean, z16);
        for (o oVar : this.f98047e) {
            try {
                av.c("[Strategy] Notify %s", oVar.getClass().getName());
                oVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ba.b(str) && ba.c(str)) {
            f98045i = str;
        } else {
            av.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(cm cmVar) {
        if (cmVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f98049g;
        if (strategyBean == null || cmVar.f98473h != strategyBean.f97850o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f97841f = cmVar.f98466a;
            strategyBean2.f97843h = cmVar.f98468c;
            strategyBean2.f97842g = cmVar.f98467b;
            if (ba.b(f98045i) || !ba.c(f98045i)) {
                if (ba.c(cmVar.f98469d)) {
                    av.c("[Strategy] Upload url changes to %s", cmVar.f98469d);
                    strategyBean2.f97852q = cmVar.f98469d;
                }
                if (ba.c(cmVar.f98470e)) {
                    av.c("[Strategy] Exception upload url changes to %s", cmVar.f98470e);
                    strategyBean2.f97853r = cmVar.f98470e;
                }
            }
            cl clVar = cmVar.f98471f;
            if (clVar != null && !ba.b(clVar.f98461a)) {
                strategyBean2.f97854s = cmVar.f98471f.f98461a;
            }
            long j3 = cmVar.f98473h;
            if (j3 != 0) {
                strategyBean2.f97850o = j3;
            }
            Map<String, String> map = cmVar.f98472g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = cmVar.f98472g;
                strategyBean2.f97855t = map2;
                String str = map2.get("B11");
                strategyBean2.f97844i = str != null && str.equals("1");
                String str2 = cmVar.f98472g.get("B3");
                if (str2 != null) {
                    strategyBean2.f97858w = Long.parseLong(str2);
                }
                int i3 = cmVar.f98477l;
                strategyBean2.f97851p = i3;
                strategyBean2.f97857v = i3;
                String str3 = cmVar.f98472g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.f97856u = parseInt;
                        }
                    } catch (Exception e16) {
                        if (!av.a(e16)) {
                            e16.printStackTrace();
                        }
                    }
                }
                String str4 = cmVar.f98472g.get("B25");
                strategyBean2.f97846k = str4 != null && str4.equals("1");
            }
            av.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f97841f), Boolean.valueOf(strategyBean2.f97843h), Boolean.valueOf(strategyBean2.f97842g), Boolean.valueOf(strategyBean2.f97844i), Boolean.valueOf(strategyBean2.f97845j), Boolean.valueOf(strategyBean2.f97848m), Boolean.valueOf(strategyBean2.f97849n), Long.valueOf(strategyBean2.f97851p), Boolean.valueOf(strategyBean2.f97846k), Long.valueOf(strategyBean2.f97850o));
            this.f98049g = strategyBean2;
            if (!ba.c(cmVar.f98469d)) {
                av.c("[Strategy] download url is null", new Object[0]);
                this.f98049g.f97852q = "";
            }
            if (!ba.c(cmVar.f98470e)) {
                av.c("[Strategy] download crashurl is null", new Object[0]);
                this.f98049g.f97853r = "";
            }
            ae.a().b(2);
            ag agVar = new ag();
            agVar.f97979b = 2;
            agVar.f97978a = strategyBean2.f97839d;
            agVar.f97982e = strategyBean2.f97840e;
            agVar.f97984g = ba.a(strategyBean2);
            ae.a().a(agVar);
            a(strategyBean2, true);
        }
    }
}
