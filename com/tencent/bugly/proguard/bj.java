package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.agent.GameAgent;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bj {

    /* renamed from: a, reason: collision with root package name */
    private static bj f98273a;

    /* renamed from: b, reason: collision with root package name */
    private ak f98274b;

    /* renamed from: c, reason: collision with root package name */
    private ai f98275c;

    /* renamed from: d, reason: collision with root package name */
    private bd f98276d;

    /* renamed from: e, reason: collision with root package name */
    private Context f98277e;

    bj(Context context) {
        be a16 = be.a();
        if (a16 == null) {
            return;
        }
        this.f98274b = ak.a();
        this.f98275c = ai.a(context);
        this.f98276d = a16.f98229w;
        this.f98277e = context;
        at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.bj.1
            @Override // java.lang.Runnable
            public final void run() {
                bj.a(bj.this);
            }
        });
    }

    public static bj a(Context context) {
        if (f98273a == null) {
            f98273a = new bj(context);
        }
        return f98273a;
    }

    public static void a(final Thread thread, final int i3, final String str, final String str2, final String str3, final Map<String, String> map) {
        if (!z.a("error_portal_ratio")) {
            av.d("extra error report is disabled, please modify your project's setting", new Object[0]);
        } else {
            at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.bj.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (bj.f98273a == null) {
                            av.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                        } else {
                            bj.a(bj.f98273a, thread, i3, str, str2, str3, map);
                        }
                    } catch (Throwable th5) {
                        if (!av.b(th5)) {
                            th5.printStackTrace();
                        }
                        av.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(bj bjVar) {
        av.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            int i3 = GameAgent.GAME_TYPE_UNKNOWN;
            bjVar.f98275c.getClass();
            ba.a((Class<?>) GameAgent.class, "sdkPackageName", "com.tencent.bugly");
            av.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            av.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    static /* synthetic */ void a(bj bjVar, Thread thread, int i3, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i3 == 4) {
            str4 = "Unity";
        } else if (i3 == 5 || i3 == 6) {
            str4 = "Cocos";
        } else {
            if (i3 != 8) {
                av.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i3));
                return;
            }
            str4 = "H5";
        }
        av.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!bjVar.f98274b.b()) {
                av.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c16 = bjVar.f98274b.c();
            if (!c16.f97841f && bjVar.f98274b.b()) {
                av.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                bd.a(str4, ba.a(), bjVar.f98275c.f98016d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                av.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i3 != 5 && i3 != 6) {
                if (i3 == 8 && !c16.f97847l) {
                    av.e("[ExtraCrashManager] %s report is disabled.", str4);
                    av.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!c16.f97846k) {
                av.e("[ExtraCrashManager] %s report is disabled.", str4);
                av.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i16 = i3 != 8 ? i3 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.K = aj.l();
            crashDetailBean.L = aj.f();
            crashDetailBean.M = aj.n();
            crashDetailBean.N = bjVar.f98275c.l();
            crashDetailBean.O = bjVar.f98275c.k();
            crashDetailBean.P = bjVar.f98275c.m();
            crashDetailBean.Q = aj.a(bjVar.f98277e);
            crashDetailBean.R = aj.g();
            crashDetailBean.S = aj.h();
            crashDetailBean.T = aj.i();
            crashDetailBean.U = aj.j();
            crashDetailBean.f97876b = i16;
            crashDetailBean.f97882h = bjVar.f98275c.h();
            ai aiVar = bjVar.f98275c;
            crashDetailBean.f97881g = aiVar.R;
            crashDetailBean.f97883i = aiVar.i();
            ai aiVar2 = bjVar.f98275c;
            crashDetailBean.f97884j = aiVar2.f98020h;
            crashDetailBean.f97885k = aiVar2.f98032t;
            crashDetailBean.f97888n = aiVar2.r();
            ai aiVar3 = bjVar.f98275c;
            crashDetailBean.f97886l = aiVar3.O;
            crashDetailBean.f97887m = aiVar3.f98035w;
            crashDetailBean.f97895u = aiVar3.g();
            crashDetailBean.f97889o = LifecycleCallback.G.h();
            crashDetailBean.f97896v = String.valueOf(str);
            crashDetailBean.f97897w = String.valueOf(str2);
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.f97898x = str5;
            crashDetailBean.f97899y = str6;
            crashDetailBean.f97900z = System.currentTimeMillis();
            crashDetailBean.C = ba.c(crashDetailBean.f97899y.getBytes());
            crashDetailBean.H = ba.a(bjVar.f98275c.X, be.f98215i, false);
            crashDetailBean.I = bjVar.f98275c.f98016d;
            crashDetailBean.J = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.V = bjVar.f98275c.t();
            crashDetailBean.f97890p = bjVar.f98275c.q();
            ai aiVar4 = bjVar.f98275c;
            crashDetailBean.f97860aa = aiVar4.f97991a;
            crashDetailBean.f97861ab = aiVar4.b();
            crashDetailBean.f97864ae = bjVar.f98275c.A();
            ai aiVar5 = bjVar.f98275c;
            crashDetailBean.f97865af = aiVar5.F;
            crashDetailBean.f97866ag = aiVar5.u();
            crashDetailBean.f97867ah = bjVar.f98275c.z();
            crashDetailBean.G = ay.a();
            crashDetailBean.f97871al = HotPatchWrapper.getInstance().getAppHotPatchNum();
            crashDetailBean.f97872am = HotPatchWrapper.getInstance().getBaseInHotfixRFix();
            if (crashDetailBean.f97862ac == null) {
                crashDetailBean.f97862ac = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.f97862ac.putAll(map);
            }
            bi.a(crashDetailBean);
            bd.a(str4, ba.a(), bjVar.f98275c.f98016d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!bjVar.f98276d.a(crashDetailBean, !be.a().D)) {
                bjVar.f98276d.b(crashDetailBean, false);
            }
            av.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th5) {
            try {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
                av.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th6) {
                av.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th6;
            }
        }
    }
}
