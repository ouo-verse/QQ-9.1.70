package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.Cif;
import com.xiaomi.push.au;
import com.xiaomi.push.cc;
import com.xiaomi.push.cj;
import com.xiaomi.push.ck;
import com.xiaomi.push.db;
import com.xiaomi.push.dc;
import com.xiaomi.push.de;
import com.xiaomi.push.ed;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gz;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hz;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes28.dex */
public abstract class MiPushClient {

    /* renamed from: a, reason: collision with root package name */
    private static Context f387980a;

    /* renamed from: b, reason: collision with root package name */
    private static long f387981b = System.currentTimeMillis();

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$4, reason: invalid class name */
    /* loaded from: classes28.dex */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f387986d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f387987e;

        @Override // java.lang.Runnable
        public void run() {
            PackageInfo packageInfo;
            try {
                for (String str : this.f387986d) {
                    if (!TextUtils.isEmpty(str) && (packageInfo = InstalledAppListMonitor.getPackageInfo(this.f387987e.getPackageManager(), str, 4)) != null) {
                        MiPushClient.l(this.f387987e, packageInfo);
                    }
                }
            } catch (Throwable th5) {
                jz4.c.q(th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public static class a implements de.a {
        a() {
        }

        @Override // com.xiaomi.push.de.a
        public void a(Context context, gj gjVar) {
            MiTinyDataClient.a(context, gjVar);
        }
    }

    /* loaded from: classes28.dex */
    public interface b<R> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean A(Context context) {
        m(context, "context");
        return e.c(context).k(d.ASSEMBLE_PUSH_FCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean B(Context context) {
        m(context, "context");
        return e.c(context).k(d.ASSEMBLE_PUSH_HUAWEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean C(Context context) {
        m(context, "context");
        return e.c(context).k(d.ASSEMBLE_PUSH_COS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean D(Context context) {
        return e.c(context).k(d.ASSEMBLE_PUSH_FTOS);
    }

    public static String E(Context context) {
        if (s.c(context).s()) {
            return s.c(context).q();
        }
        return null;
    }

    private static void F(final Context context) {
        de.o(new a());
        kz4.a f16 = de.f(context);
        com.xiaomi.clientreport.manager.a.c(context).l("5_9_9-C");
        com.xiaomi.clientreport.manager.b.a(context, f16, new db(context), new dc(context));
        r.b(context);
        aa.a(context, f16);
        ah.d(context).j(new ah.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ah.a
            protected void e() {
                de.k(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Context context, String str, String str2, c cVar, String str3, b bVar) {
        boolean z16;
        try {
            jz4.c.k(context.getApplicationContext());
            jz4.c.D("sdk_version = 5_9_9-C");
            com.xiaomi.push.q.a(context).c();
            cc.a(context);
            if (cVar != null) {
                PushMessageHandler.a(cVar);
            }
            if (bVar != null) {
                PushMessageHandler.a(bVar);
            }
            if (ii.g(f387980a)) {
                m.b(f387980a);
            }
            if (s.c(f387980a).a() != com.xiaomi.mipush.sdk.c.a()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !d0(f387980a)) {
                ag.h(f387980a).m();
                jz4.c.m("Could not send  register message within 5s repeatly .");
                return;
            }
            if (!z16 && s.c(f387980a).l(str, str2) && !s.c(f387980a).x()) {
                if (1 == p.c(f387980a)) {
                    m(cVar, "callback");
                    cVar.c(0L, null, s.c(f387980a).q());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(s.c(f387980a).q());
                    p.f(f387980a, p.a(ed.COMMAND_REGISTER.f24710a, arrayList, 0L, null, null, null));
                }
                ag.h(f387980a).m();
                if (s.c(f387980a).k()) {
                    he heVar = new he();
                    heVar.b(s.c(f387980a).d());
                    heVar.c(gp.ClientInfoUpdate.f24750a);
                    heVar.a(com.xiaomi.push.service.m.a());
                    HashMap hashMap = new HashMap();
                    heVar.f24813a = hashMap;
                    Context context2 = f387980a;
                    hashMap.put("app_version", com.xiaomi.push.g.h(context2, context2.getPackageName()));
                    Map<String, String> map = heVar.f24813a;
                    Context context3 = f387980a;
                    map.put("app_version_code", Integer.toString(com.xiaomi.push.g.b(context3, context3.getPackageName())));
                    heVar.f24813a.put("push_sdk_vn", "5_9_9-C");
                    heVar.f24813a.put("push_sdk_vc", Integer.toString(50909));
                    String v3 = s.c(f387980a).v();
                    if (!TextUtils.isEmpty(v3)) {
                        heVar.f24813a.put("deviceid", v3);
                    }
                    ag.h(f387980a).y(heVar, gf.Notification, false, null);
                    ag.h(f387980a).q(f387980a);
                }
                if (!id.d(f387980a, "update_devId", false)) {
                    j0();
                    id.b(f387980a, "update_devId", true);
                }
                if (e0(f387980a) && c0(f387980a)) {
                    he heVar2 = new he();
                    heVar2.b(s.c(f387980a).d());
                    heVar2.c(gp.PullOfflineMessage.f24750a);
                    heVar2.a(com.xiaomi.push.service.m.a());
                    heVar2.a(false);
                    ag.h(f387980a).z(heVar2, gf.Notification, false, null, false);
                    h(f387980a);
                }
            } else {
                String a16 = com.xiaomi.push.ag.a(6);
                s.c(f387980a).e();
                s.c(f387980a).f(com.xiaomi.mipush.sdk.c.a());
                s.c(f387980a).i(str, str2, a16);
                MiTinyDataClient.a.b().h("com.xiaomi.xmpushsdk.tinydataPending.appId");
                n(f387980a);
                q(context);
                hf hfVar = new hf();
                hfVar.a(com.xiaomi.push.service.m.c());
                hfVar.b(str);
                hfVar.e(str2);
                hfVar.d(f387980a.getPackageName());
                hfVar.f(a16);
                Context context4 = f387980a;
                hfVar.c(com.xiaomi.push.g.h(context4, context4.getPackageName()));
                Context context5 = f387980a;
                hfVar.b(com.xiaomi.push.g.b(context5, context5.getPackageName()));
                hfVar.h("5_9_9-C");
                hfVar.a(50909);
                hfVar.a(gt.Init);
                if (!TextUtils.isEmpty(str3)) {
                    hfVar.g(str3);
                }
                if (!hz.t()) {
                    String w3 = ge.w(f387980a);
                    if (!TextUtils.isEmpty(w3)) {
                        hfVar.i(com.xiaomi.push.ag.b(w3) + "," + ge.y(f387980a));
                    }
                }
                int c16 = ge.c();
                if (c16 >= 0) {
                    hfVar.c(c16);
                }
                ag.h(f387980a).u(hfVar, z16);
                f387980a.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            }
            i(f387980a);
            X();
            W(f387980a);
            F(f387980a);
            w.b(f387980a);
            if (!f387980a.getPackageName().equals("com.xiaomi.xmsf")) {
                if (j.a() != null) {
                    j.b(f387980a, j.a());
                }
                jz4.c.g(2);
            }
            H(context);
        } catch (Throwable th5) {
            jz4.c.q(th5);
        }
    }

    private static void H(Context context) {
        if ("syncing".equals(ac.b(f387980a).c(v.DISABLE_PUSH))) {
            t(f387980a);
        }
        if ("syncing".equals(ac.b(f387980a).c(v.ENABLE_PUSH))) {
            u(f387980a);
        }
        ac b16 = ac.b(f387980a);
        v vVar = v.UPLOAD_HUAWEI_TOKEN;
        if ("syncing".equals(b16.c(vVar))) {
            ag.h(f387980a).E(null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(ac.b(f387980a).c(v.UPLOAD_FCM_TOKEN))) {
            g0(f387980a);
        }
        ac b17 = ac.b(f387980a);
        v vVar2 = v.UPLOAD_COS_TOKEN;
        if ("syncing".equals(b17.c(vVar2))) {
            ag.h(f387980a).E(null, vVar2, d.ASSEMBLE_PUSH_COS, "init");
        }
        ac b18 = ac.b(f387980a);
        v vVar3 = v.UPLOAD_FTOS_TOKEN;
        if ("syncing".equals(b18.c(vVar3))) {
            ag.h(context).E(null, vVar3, d.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void I(Context context, gt gtVar) {
        jz4.c.D("re-register reason: " + gtVar);
        String a16 = com.xiaomi.push.ag.a(6);
        String d16 = s.c(context).d();
        String m3 = s.c(context).m();
        s.c(context).e();
        o(context);
        q(context);
        s.c(context).f(com.xiaomi.mipush.sdk.c.a());
        s.c(context).i(d16, m3, a16);
        hf hfVar = new hf();
        hfVar.a(com.xiaomi.push.service.m.c());
        hfVar.b(d16);
        hfVar.e(m3);
        hfVar.f(a16);
        hfVar.d(context.getPackageName());
        hfVar.c(com.xiaomi.push.g.h(context, context.getPackageName()));
        hfVar.b(com.xiaomi.push.g.b(context, context.getPackageName()));
        hfVar.h("5_9_9-C");
        hfVar.a(50909);
        hfVar.a(gtVar);
        int c16 = ge.c();
        if (c16 >= 0) {
            hfVar.c(c16);
        }
        ag.h(context).u(hfVar, false);
    }

    private static void J(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            ie.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th5) {
            jz4.c.m("dynamic register network status receiver failed:" + th5);
        }
        au.i(f387980a);
    }

    public static void K(Context context, String str, String str2) {
        L(context, str, str2, new n());
    }

    public static void L(Context context, String str, String str2, n nVar) {
        M(context, str, str2, nVar, null, null);
    }

    private static void M(Context context, final String str, final String str2, n nVar, final String str3, final b bVar) {
        m(context, "context");
        m(str, "appID");
        m(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        f387980a = applicationContext;
        if (applicationContext == null) {
            f387980a = context;
        }
        Context context2 = f387980a;
        ii.e(context2);
        if (!NetworkStatusReceiver.a()) {
            J(f387980a);
        }
        e.c(f387980a).e(nVar);
        com.xiaomi.push.ae.b(context2).g(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.G(MiPushClient.f387980a, str, str2, null, str3, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void N(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            Cif.a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void O(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void P(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void Q(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = y(context).iterator();
            while (it.hasNext()) {
                O(context, it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void R(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = w(context).iterator();
            while (it.hasNext()) {
                P(context, it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void S(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = x(context).iterator();
            while (it.hasNext()) {
                T(context, it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void T(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void U(Context context, String str, gs gsVar, String str2, String str3) {
        he heVar = new he();
        if (TextUtils.isEmpty(str3)) {
            jz4.c.B("do not report clicked message");
            return;
        }
        heVar.b(str3);
        heVar.c("bar:click");
        heVar.a(str);
        heVar.a(false);
        ag.h(context).B(heVar, gf.Notification, false, true, gsVar, true, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void V(Context context, String str, gs gsVar, String str2) {
        he heVar = new he();
        if (TextUtils.isEmpty(str2)) {
            if (s.c(context).p()) {
                heVar.b(s.c(context).d());
            } else {
                jz4.c.B("do not report clicked message");
                return;
            }
        } else {
            heVar.b(str2);
        }
        heVar.c("bar:click");
        heVar.a(str);
        heVar.a(false);
        ag.h(context).y(heVar, gf.Notification, false, gsVar);
    }

    private static void W(Context context) {
        if (ah.d(f387980a).m(gk.DataCollectionSwitch.a(), z())) {
            cj.b().c(new y(context));
            com.xiaomi.push.ae.b(f387980a).h(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    ck.a(MiPushClient.f387980a);
                }
            }, 10);
        }
    }

    private static void X() {
        com.xiaomi.push.ae.b(f387980a).k(new o(f387980a), ah.d(f387980a).a(gk.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void Y(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Z(context, ed.COMMAND_SET_ALIAS.f24710a, str, str2);
        }
    }

    protected static void Z(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        ed edVar = ed.COMMAND_SET_ALIAS;
        if (edVar.f24710a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - k(context, str2)) < 86400000) {
            if (1 == p.c(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                p.f(context, p.a(edVar.f24710a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (ed.COMMAND_UNSET_ALIAS.f24710a.equalsIgnoreCase(str) && k(context, str2) < 0) {
            jz4.c.m("Don't cancel alias for " + com.xiaomi.push.ag.c(arrayList.toString(), 3) + " is unseted");
            return;
        }
        ed edVar2 = ed.COMMAND_SET_ACCOUNT;
        if (edVar2.f24710a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - d(context, str2)) < 3600000) {
            if (1 == p.c(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                p.f(context, p.a(edVar2.f24710a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (ed.COMMAND_UNSET_ACCOUNT.f24710a.equalsIgnoreCase(str) && d(context, str2) < 0) {
            jz4.c.m("Don't cancel account for " + com.xiaomi.push.ag.c(arrayList.toString(), 3) + " is unseted");
            return;
        }
        a0(context, str, arrayList, str3);
    }

    protected static void a0(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(s.c(context).d())) {
            return;
        }
        gz gzVar = new gz();
        String a16 = com.xiaomi.push.service.m.a();
        gzVar.a(a16);
        gzVar.b(s.c(context).d());
        gzVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            gzVar.m366a(it.next());
        }
        gzVar.e(str2);
        gzVar.d(context.getPackageName());
        jz4.c.D("cmd:" + str + ", " + a16);
        ag.h(context).w(gzVar, gf.Command, null);
    }

    public static void b0(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Z(context, ed.COMMAND_SET_ACCOUNT.f24710a, str, str2);
        }
    }

    private static boolean c0(Context context) {
        if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) <= MiniBoxNoticeInfo.MIN_5) {
            return false;
        }
        return true;
    }

    public static long d(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    private static boolean d0(Context context) {
        if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) <= 5000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void e(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("accept_time", str + "," + str2);
            Cif.a(edit);
        }
    }

    public static boolean e0(Context context) {
        return ag.h(context).J();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void f(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void f0(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(s.c(context).d()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - h0(context, str)) > 86400000) {
                hj hjVar = new hj();
                String a16 = com.xiaomi.push.service.m.a();
                hjVar.a(a16);
                hjVar.b(s.c(context).d());
                hjVar.c(str);
                hjVar.d(context.getPackageName());
                hjVar.e(str2);
                jz4.c.D("cmd:" + ed.COMMAND_SUBSCRIBE_TOPIC + ", " + a16);
                ag.h(context).w(hjVar, gf.Subscription, null);
                return;
            }
            if (1 == p.c(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            p.f(context, p.a(ed.COMMAND_SUBSCRIBE_TOPIC.f24710a, arrayList, 0L, null, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void g(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void g0(Context context) {
        ag.h(context).E(null, v.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM, "");
    }

    private static void h(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        Cif.a(edit);
    }

    public static long h0(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    private static void i(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        Cif.a(edit);
    }

    public static void i0(Context context) {
        f.n(context);
        ah.d(context).h();
        if (!s.c(context).p()) {
            return;
        }
        hl hlVar = new hl();
        hlVar.a(com.xiaomi.push.service.m.a());
        hlVar.b(s.c(context).d());
        hlVar.c(s.c(context).q());
        hlVar.e(s.c(context).m());
        hlVar.d(context.getPackageName());
        ag.h(context).v(hlVar);
        PushMessageHandler.a();
        PushMessageHandler.b();
        s.c(context).n();
        p(context);
        q(context);
        n(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void j(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void j0() {
        new BaseThread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (!hz.t()) {
                    if (ge.t(MiPushClient.f387980a) != null || com.xiaomi.push.q.a(MiPushClient.f387980a).mo299a()) {
                        he heVar = new he();
                        heVar.b(s.c(MiPushClient.f387980a).d());
                        heVar.c(gp.ClientInfoUpdate.f24750a);
                        heVar.a(com.xiaomi.push.service.m.a());
                        heVar.a(new HashMap());
                        String t16 = ge.t(MiPushClient.f387980a);
                        String str = "";
                        if (!TextUtils.isEmpty(t16)) {
                            str = "" + com.xiaomi.push.ag.b(t16);
                        }
                        String x16 = ge.x(MiPushClient.f387980a);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(x16)) {
                            str = str + "," + x16;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            heVar.m391a().put("imei_md5", str);
                        }
                        com.xiaomi.push.q.a(MiPushClient.f387980a).d(heVar.m391a());
                        int c16 = ge.c();
                        if (c16 >= 0) {
                            heVar.m391a().put("space_id", Integer.toString(c16));
                        }
                        ag.h(MiPushClient.f387980a).y(heVar, gf.Notification, false, null);
                    }
                }
            }
        }).start();
    }

    public static long k(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        LockMethodProxy.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void m(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void n(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void o(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = w(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_" + it.next());
        }
        Iterator<String> it5 = y(context).iterator();
        while (it5.hasNext()) {
            edit.remove("account_" + it5.next());
        }
        Iterator<String> it6 = x(context).iterator();
        while (it6.hasNext()) {
            edit.remove("topic_" + it6.next());
        }
        edit.remove("accept_time");
        edit.commit();
    }

    public static void p(Context context) {
        ag.h(context).b0();
    }

    public static void q(Context context) {
        ag.h(context).n(-1);
    }

    public static void r(Context context, int i3) {
        ag.h(context).n(i3);
    }

    public static void s(Context context, String str, String str2) {
        ag.h(context).G(str, str2);
    }

    public static void t(Context context) {
        ag.h(context).H(true);
    }

    public static void u(Context context) {
        ag.h(context).H(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String v(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
    }

    public static List<String> w(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> x(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> y(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    private static boolean z() {
        return hz.p();
    }

    @Deprecated
    /* loaded from: classes28.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        private String f387989a;

        /* JADX INFO: Access modifiers changed from: protected */
        public String a() {
            return this.f387989a;
        }

        public void d(MiPushMessage miPushMessage) {
        }

        public void c(long j3, String str, String str2) {
        }

        public void f(long j3, String str, String str2) {
        }

        public void g(long j3, String str, String str2) {
        }

        public void b(String str, long j3, String str2, List<String> list) {
        }

        public void e(String str, String str2, String str3, boolean z16) {
        }
    }
}
