package hynb.r;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huya.statistics.bean.SDKReport;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import cooperation.qzone.remote.ServiceConst;
import hynb.p.g;
import hynb.u.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public hynb.t.d f406814a;

    /* renamed from: c, reason: collision with root package name */
    public volatile String f406816c;

    /* renamed from: d, reason: collision with root package name */
    public hynb.t.b f406817d;

    /* renamed from: e, reason: collision with root package name */
    public Context f406818e;

    /* renamed from: f, reason: collision with root package name */
    public Long f406819f;

    /* renamed from: l, reason: collision with root package name */
    public boolean f406825l;

    /* renamed from: n, reason: collision with root package name */
    public hynb.t.c f406827n;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f406815b = false;

    /* renamed from: g, reason: collision with root package name */
    public String f406820g = null;

    /* renamed from: h, reason: collision with root package name */
    public volatile String f406821h = null;

    /* renamed from: i, reason: collision with root package name */
    public volatile String f406822i = null;

    /* renamed from: j, reason: collision with root package name */
    public String f406823j = "";

    /* renamed from: k, reason: collision with root package name */
    public String f406824k = "";

    /* renamed from: m, reason: collision with root package name */
    public final Runnable f406826m = new a();

    /* renamed from: o, reason: collision with root package name */
    public final HashMap<String, String> f406828o = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.c();
            c.this.f406825l = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f406830a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f406831b;

        public b(Context context, String str) {
            this.f406830a = context;
            this.f406831b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String string = hynb.u.d.a(this.f406830a).getString("statistics_sdk_install_channel", null);
            if (!TextUtils.isEmpty(string)) {
                c.this.f406821h = string;
            } else {
                c.this.f406821h = this.f406831b;
                hynb.u.d.a(this.f406830a).edit().putString("statistics_sdk_install_channel", this.f406831b).apply();
            }
            c.this.f406822i = this.f406831b;
        }
    }

    /* compiled from: P */
    /* renamed from: hynb.r.c$c, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class RunnableC10489c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f406833a;

        public RunnableC10489c(String str) {
            this.f406833a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.f406823j = this.f406833a;
                c.this.h();
                c.this.a();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f406835a;

        public d(String str) {
            this.f406835a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.f406824k = this.f406835a;
                c.this.f();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public final void e() {
        g.f406799a.debug("StatsCompat", "startAppReport");
        hynb.t.a aVar = new hynb.t.a();
        a(aVar);
        c(aVar);
        aVar.a("eid", "app_start");
        aVar.a(EventKey.ACT, "hyevent");
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        a(arrayList);
    }

    public synchronized void f() {
        hynb.u.c.a().removeCallbacks(this.f406826m);
        hynb.u.c.a().postDelayed(this.f406826m, 30000L);
    }

    public final void g() {
        this.f406819f = Long.valueOf(System.currentTimeMillis());
        hynb.t.a aVar = new hynb.t.a();
        a(aVar);
        c(aVar);
        aVar.a("eid", "startup");
        aVar.a(EventKey.ACT, "hyevent");
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        a(arrayList);
    }

    public final void h() {
        if (this.f406825l) {
            return;
        }
        g.f406799a.info("StatsCompat", "startup report");
        g();
        e();
    }

    public final void c() {
        if (g.f406801c.a()) {
            return;
        }
        b();
        this.f406824k = null;
        this.f406819f = null;
    }

    public final void d(hynb.t.a aVar) {
        if (aVar.f406848a.get("traceid") != null) {
            aVar.a("extra", String.format(Locale.getDefault(), "[{\"traceid\":\"%s\"}]", aVar.f406848a.get("traceid")));
            aVar.f406848a.remove("traceid");
        }
    }

    public synchronized void b(String str) {
        hynb.u.c.a(new RunnableC10489c(str));
    }

    public synchronized void a(Context context, hynb.t.b bVar, hynb.t.c cVar) {
        if (this.f406815b) {
            return;
        }
        bVar.f406853d = "https://ylog.huya.com/j.gif";
        if (!TextUtils.isEmpty(bVar.f406851b)) {
            if (!TextUtils.isEmpty(bVar.f406850a)) {
                if (!TextUtils.isEmpty(bVar.f406851b)) {
                    if (!TextUtils.isEmpty(bVar.f406854e)) {
                        this.f406817d = bVar;
                        this.f406818e = context;
                        this.f406827n = cVar;
                        this.f406815b = true;
                        this.f406814a = new hynb.t.d(context.getApplicationContext(), bVar.f406853d);
                        a(context, bVar.f406850a);
                        this.f406816c = hynb.u.d.a();
                        return;
                    }
                    throw new IllegalStateException("You have Dty");
                }
                throw new IllegalStateException("You have ver");
            }
            throw new IllegalStateException("You have from");
        }
        throw new IllegalStateException("You have ver");
    }

    public void b(hynb.t.a aVar) {
        hynb.t.c cVar = this.f406827n;
        if (cVar == null || cVar.a() == null || this.f406827n.a().isEmpty()) {
            return;
        }
        aVar.f406848a.putAll(this.f406827n.a());
    }

    public final void b() {
        if (this.f406819f == null) {
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f406819f.longValue());
        hynb.t.a aVar = new hynb.t.a();
        a(aVar);
        c(aVar);
        a("endup", null, valueOf, aVar);
        this.f406819f = 0L;
    }

    public final void c(hynb.t.a aVar) {
        aVar.a("furl", this.f406824k);
        aVar.a("curl", this.f406823j);
    }

    public void d() {
        ((Application) this.f406818e.getApplicationContext()).registerActivityLifecycleCallbacks(new e());
    }

    public void a(String str, String str2) {
        synchronized (this.f406828o) {
            this.f406828o.put(str, str2);
        }
    }

    public final void a(Context context, String str) {
        hynb.u.c.a(new b(context, str));
    }

    public void a(List<hynb.t.a> list) {
        ArrayList arrayList = new ArrayList();
        for (hynb.t.a aVar : list) {
            d(aVar);
            aVar.a();
            a(aVar, this.f406818e);
            synchronized (this.f406828o) {
                if (this.f406828o.size() > 0) {
                    aVar.f406848a.putAll(this.f406828o);
                }
            }
            arrayList.add(new SDKReport.DataInfo(aVar.f406848a));
        }
        SDKReport sDKReport = new SDKReport();
        sDKReport.vBody = arrayList;
        sDKReport.tHeader = new SDKReport.DataInfo();
        String json = new Gson().toJson(sDKReport);
        byte[] bytes = json.getBytes();
        a.b a16 = new a.b().a(true);
        Map<String, String> b16 = hynb.u.d.b();
        int nextInt = new Random().nextInt();
        String a17 = hynb.u.d.a(nextInt);
        if (a17 != null && a17.length() == 16) {
            a16.a(a17);
            b16.put("Huya-Salt", String.valueOf(nextInt));
        }
        hynb.u.b.a("https://ylog.huya.com/j.gif", b16, bytes, a16.a());
        g.f406799a.a("StatsCompat", "reportDirectly body content: " + json);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e implements Application.ActivityLifecycleCallbacks {
        public e() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            c.this.a(activity.getClass().getName());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            c.this.b(activity.getClass().getName());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    public void a(String str, String str2, Long l3, hynb.t.a aVar) {
        if (aVar == null) {
            aVar = new hynb.t.a();
        }
        d(aVar);
        a(aVar, this.f406818e);
        aVar.a("eid", str.trim());
        if (!TextUtils.isEmpty(str2)) {
            aVar.a("eid_desc", str2);
        }
        if (l3 != null) {
            aVar.a("dur", String.valueOf(l3));
        }
        aVar.a(EventKey.ACT, "hyevent");
        aVar.c();
        aVar.a();
        synchronized (this.f406828o) {
            if (this.f406828o.size() > 0) {
                aVar.f406848a.putAll(this.f406828o);
            }
        }
        g.f406799a.a("StatsCompat", "report async eid: " + str + " content: " + aVar);
        this.f406814a.a(aVar);
    }

    public synchronized void a(String str) {
        hynb.u.c.a(new d(str));
    }

    public final void a(hynb.t.a aVar, Context context) {
        if (this.f406817d == null) {
            return;
        }
        if (!a(aVar, WadlResult.WEB_KEY_PROGRESS)) {
            aVar.a(WadlResult.WEB_KEY_PROGRESS, this.f406817d.f406852c);
        }
        if (!a(aVar, "dty")) {
            aVar.a("dty", this.f406817d.f406854e);
        }
        if (!a(aVar, ServiceConst.PARA_SESSION_ID)) {
            aVar.a(ServiceConst.PARA_SESSION_ID, this.f406816c);
        }
        hynb.t.c cVar = this.f406827n;
        if (cVar != null && cVar.b() != 0) {
            aVar.a("yyuid", String.valueOf(this.f406827n.b()));
        }
        if (!TextUtils.isEmpty(this.f406820g)) {
            aVar.a("sguid", this.f406820g);
        }
        aVar.a("rid", "ods_action_log");
        aVar.a("cha", this.f406821h);
        aVar.a("up_channel", this.f406822i);
        aVar.a("ive", this.f406817d.f406851b);
        aVar.a("uve", this.f406817d.f406851b);
        aVar.a(HiAnalyticsConstant.BI_KEY_SDK_VER, this.f406817d.f406851b);
        aVar.a("sco", "32");
        aVar.a("platform", this.f406817d.f406855f);
        aVar.a("ati", hynb.u.d.c());
        String packageName = context.getPackageName();
        if (packageName != null) {
            aVar.a("pkgname", packageName);
        }
        aVar.a("machine", hynb.u.d.f());
        aVar.a("os", hynb.u.d.e());
        aVar.a("sjp", hynb.u.d.g());
        aVar.a("lla", hynb.u.d.d());
    }

    public final void a(hynb.t.a aVar) {
        aVar.a("isactive", g.f406801c.a() ? "1" : "0");
    }

    public final boolean a(hynb.t.a aVar, String str) {
        return aVar.f406848a.containsKey(str) && !TextUtils.isEmpty(aVar.f406848a.get(str));
    }

    public synchronized void a() {
        this.f406825l = true;
        hynb.u.c.a().removeCallbacks(this.f406826m);
    }
}
