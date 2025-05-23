package hynb.i;

import android.content.Context;
import android.text.TextUtils;
import com.huya.huyasdk.service.api.ILoginService;
import hynb.b.l;
import hynb.j.d;
import hynb.o.e;
import hynb.p.g;
import hynb.t.b;
import hynb.t.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f406729d;

    /* renamed from: a, reason: collision with root package name */
    public long f406730a = 0;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f406731b = false;

    /* renamed from: c, reason: collision with root package name */
    public final List<Runnable> f406732c = new CopyOnWriteArrayList();

    /* compiled from: P */
    /* renamed from: hynb.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10485a implements c {
        public C10485a() {
        }

        @Override // hynb.t.c
        public Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put("ayyuid", String.valueOf(a.this.f406730a));
            return hashMap;
        }

        @Override // hynb.t.c
        public long b() {
            return ((ILoginService) d.a(ILoginService.class)).getLoginUid();
        }
    }

    public a() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(long j3) {
        this.f406730a = j3;
        hynb.t.a aVar = new hynb.t.a();
        aVar.a("ayyuid", String.valueOf(j3));
        hynb.r.a.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(long j3) {
        this.f406730a = 0L;
        hynb.r.a.a(j3, 0L);
    }

    public final void b() {
        Context context = hynb.m.a.f406754a;
        if (context == null) {
            g.f406799a.error("HuyaReportModule", "init failed, context is null");
            return;
        }
        hynb.r.a.a(context, new b(hynb.n.a.a().f406767a != null ? hynb.n.a.a().f406767a.f406773f : "", hynb.n.a.a().f406767a != null ? hynb.n.a.a().f406767a.f406769b : "", "1.0.5", "live", "mobile/andriod"), new C10485a());
        String g16 = l.i().g();
        this.f406731b = !TextUtils.isEmpty(g16);
        l.i().a(new hynb.b.c() { // from class: u15.c
            @Override // hynb.b.c
            public final void a(String str) {
                hynb.i.a.this.a(str);
            }
        });
        hynb.r.a.a("app_version", e.a(context));
        String str = hynb.n.a.a().f406767a != null ? hynb.n.a.a().f406767a.f406778k : "";
        hynb.r.a.a("application", str);
        hynb.r.a.a();
        g.f406799a.c("HuyaReportModule", "init success !!! guid: %s, application: %s", g16, str);
    }

    public static a a() {
        if (f406729d == null) {
            synchronized (a.class) {
                if (f406729d == null) {
                    f406729d = new a();
                }
            }
        }
        return f406729d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        hynb.r.a.a("mid", str);
        hynb.r.a.a(str);
        this.f406731b = !TextUtils.isEmpty(str);
        if (this.f406731b) {
            g.f406799a.a("HuyaReportModule", "guid ready !!! try to execute pending task, size: %s", Integer.valueOf(this.f406732c.size()));
            Iterator<Runnable> it = this.f406732c.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.f406732c.clear();
        }
    }

    public void b(final long j3) {
        Runnable runnable = new Runnable() { // from class: u15.a
            @Override // java.lang.Runnable
            public final void run() {
                hynb.i.a.this.d(j3);
            }
        };
        g.f406799a.a("HuyaReportModule", "channelStartUp pid: %s, guidReady: %s", Long.valueOf(j3), Boolean.valueOf(this.f406731b));
        if (this.f406731b) {
            runnable.run();
        } else {
            this.f406732c.add(runnable);
        }
    }

    public void a(String str, Map<String, String> map) {
        hynb.r.a.a(str, "", "", new JSONObject(map).toString(), null);
    }

    public void a(final long j3) {
        Runnable runnable = new Runnable() { // from class: u15.b
            @Override // java.lang.Runnable
            public final void run() {
                hynb.i.a.this.c(j3);
            }
        };
        g.f406799a.a("HuyaReportModule", "channelEndUp pid: %s, guidReady: %s", Long.valueOf(j3), Boolean.valueOf(this.f406731b));
        if (this.f406731b) {
            runnable.run();
        } else {
            this.f406732c.add(runnable);
        }
    }
}
