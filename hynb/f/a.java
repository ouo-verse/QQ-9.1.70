package hynb.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huya.huyasdk.api.HuyaLoginResult;
import com.huya.huyasdk.data.HYNSUserInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import hynb.b.l;
import hynb.p.g;
import hynb.v.c;
import hynb.v.e;
import hynb.v.f;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: h, reason: collision with root package name */
    public static a f406701h = new a();

    /* renamed from: a, reason: collision with root package name */
    public final HandlerThread f406702a = new BaseHandlerThread("HuyaSDK-loginHandlerThread");

    /* renamed from: b, reason: collision with root package name */
    public long f406703b = 0;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f406704c = false;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f406705d = false;

    /* renamed from: e, reason: collision with root package name */
    public long f406706e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f406707f = 0;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f406708g = false;

    /* compiled from: P */
    /* renamed from: hynb.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10483a extends f<hynb.v.b> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f406709a;

        public C10483a(f fVar) {
            this.f406709a = fVar;
        }

        @Override // hynb.v.f
        public void onResponse(hynb.v.b bVar) {
            if (!a.this.f406705d) {
                g.f406799a.info("HYLoginImpl", "udb login fail, doLogin is false");
                return;
            }
            a.this.f406705d = false;
            a.this.a(bVar);
            this.f406709a.onResponse(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b extends f<hynb.v.b> {
        public b() {
        }

        @Override // hynb.v.f
        public void onResponse(hynb.v.b bVar) {
            a.this.a(bVar);
        }
    }

    public static HuyaLoginResult b(hynb.v.b bVar) {
        long j3;
        if (bVar == null) {
            return HuyaLoginResult.failWithResCode(-2);
        }
        if (bVar.a() != 1) {
            return HuyaLoginResult.failWithResCode(-4);
        }
        if (!(bVar instanceof c)) {
            return HuyaLoginResult.failWithResCode(-3);
        }
        c cVar = (c) bVar;
        int i3 = cVar.f406891e;
        Map<String, String> map = cVar.f406892f;
        if (map == null) {
            return HuyaLoginResult.failWithResCode(i3);
        }
        try {
            j3 = Long.parseLong(cVar.f406890d);
        } catch (Throwable th5) {
            g.f406799a.a("HYLoginImpl", "parseLoginResult: parse uid error", th5);
            j3 = 0;
        }
        return new HuyaLoginResult(i3 == 0, i3, map.get("openid"), map.get(CommonConstant.KEY_ACCESS_TOKEN), j3);
    }

    public String c() {
        if (!this.f406708g) {
            g.f406799a.info("HYLoginImpl", "udb is not init, can't call getToken");
            return "";
        }
        return e.a().a(d());
    }

    public long d() {
        if (this.f406704c) {
            return this.f406706e;
        }
        return this.f406703b;
    }

    public boolean e() {
        return this.f406704c;
    }

    public synchronized void f() {
        if (!this.f406708g) {
            g.f406799a.info("HYLoginImpl", "udb is not init, can't call logout");
            return;
        }
        e.a().b();
        this.f406704c = false;
        this.f406705d = false;
        l.i().a(hynb.o.e.a(this.f406706e));
        this.f406706e = 0L;
        l.i().c(this.f406703b);
    }

    public synchronized void a(final hynb.n.b bVar) {
        if (this.f406708g) {
            return;
        }
        this.f406702a.start();
        new Handler(this.f406702a.getLooper()).post(new Runnable() { // from class: s15.a
            @Override // java.lang.Runnable
            public final void run() {
                hynb.f.a.this.b(bVar);
            }
        });
        this.f406708g = true;
    }

    public synchronized void a(hynb.n.b bVar, String str, hynb.v.g gVar, String str2, f<hynb.v.b> fVar) {
        if (!this.f406708g) {
            g.f406799a.info("HYLoginImpl", "udb is not init, can't call thirdLogin");
            fVar.onResponse(null);
        } else if (this.f406705d) {
            g.f406799a.info("HYLoginImpl", "udb is logging in, please wait");
        } else {
            this.f406705d = true;
            e.a().a(bVar.f406777j, str, gVar, str2, new C10483a(fVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(hynb.n.b bVar) {
        e.a().a(bVar.f406775h);
        e.a().a(bVar.f406774g);
        e.a().a(hynb.m.a.f406754a, bVar.f406770c, bVar.f406771d);
        a();
    }

    public final void a() {
        e.a().a(new b());
    }

    public final void a(hynb.v.b bVar) {
        if (bVar == null) {
            g.f406799a.error("HYLoginImpl", "udb login fail, opCmd is null");
            return;
        }
        int a16 = bVar.a();
        if (a16 == 1) {
            c cVar = bVar instanceof c ? (c) bVar : null;
            if (cVar != null) {
                if (cVar.f406891e == 0) {
                    this.f406704c = true;
                    this.f406706e = TextUtils.isEmpty(cVar.f406890d) ? 0L : Long.parseLong(cVar.f406890d);
                    g.f406799a.a("HYLoginImpl", "login success, get uid: " + this.f406706e);
                    l.i().c(this.f406706e);
                    HYNSUserInfo hYNSUserInfo = new HYNSUserInfo();
                    hYNSUserInfo.uid = this.f406706e;
                    hYNSUserInfo.guid = l.i().g();
                    hYNSUserInfo.udbToken = c();
                    l.i().b(hynb.o.e.a(this.f406706e));
                    l.i().a(hYNSUserInfo);
                    l.i().c();
                    return;
                }
                this.f406706e = 0L;
                g.f406799a.a("HYLoginImpl", "login fail, description: " + cVar.f406889c);
                return;
            }
            return;
        }
        if (a16 != 2) {
            if (a16 != 3) {
                g.f406799a.error("HYLoginImpl", "udb anonymous login unknown opCmd: " + a16);
                return;
            }
            g.f406799a.error("HYLoginImpl", "udb login time out");
            return;
        }
        hynb.v.a aVar = bVar instanceof hynb.v.a ? (hynb.v.a) bVar : null;
        if (aVar != null) {
            if (aVar.f406886d == 0) {
                this.f406703b = TextUtils.isEmpty(aVar.f406885c) ? 0L : Long.parseLong(aVar.f406885c);
                g.f406799a.a("HYLoginImpl", "anonymous login success, get anonymousUid: " + this.f406703b);
                l.i().c(this.f406703b);
                return;
            }
            this.f406703b = 0L;
            hynb.p.e eVar = g.f406799a;
            eVar.a("HYLoginImpl", "anonymous login fail, description: " + aVar.f406884b);
            int i3 = this.f406707f;
            if (i3 < 3) {
                this.f406707f = i3 + 1;
                eVar.info("HYLoginImpl", "retry anonymous login, count: " + this.f406707f);
                new Handler(this.f406702a.getLooper()).postDelayed(new Runnable() { // from class: s15.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        hynb.f.a.this.a();
                    }
                }, 30000L);
                return;
            }
            eVar.error("HYLoginImpl", "anonymous login fail, retry count: " + this.f406707f);
        }
    }

    public long b() {
        return this.f406706e;
    }
}
