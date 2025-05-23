package com.tencent.luggage.wxa.mg;

import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.oskplayer.proxy.VideoProxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l implements i {

    /* renamed from: f, reason: collision with root package name */
    public static l f134563f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f134564a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f134565b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f134566c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f134567d = false;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.rg.i f134568e = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.rg.i {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.rg.i
        public void a(int i3) {
            if (i3 < 0) {
                l.this.f134565b = false;
            }
        }

        @Override // com.tencent.luggage.wxa.rg.i
        public void a() {
            l.this.f134565b = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends com.tencent.luggage.wxa.eo.c {
        void a(l lVar);
    }

    public l() {
        ((b) com.tencent.luggage.wxa.eo.g.a(b.class)).a(this);
    }

    public final String b(String str) {
        String e16 = com.tencent.luggage.wxa.db.a.e();
        if (!e16.endsWith("/")) {
            e16 = e16 + "/";
        }
        String str2 = e16 + str + "/";
        try {
            if (!x.m(str2)) {
                w.h("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", str2);
                if (!new v(str2).p()) {
                    w.h("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", str2);
                    x.c(str2);
                    if (!x.m(str2)) {
                        w.h("MicroMsg.SameLayer.VideoCore", "mkdirs fail 3, no space? dir:%s", str2);
                        return null;
                    }
                }
            }
            w.d("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", str, str2);
            return str2;
        } catch (Throwable th5) {
            w.b("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", th5);
            return null;
        }
    }

    public String c(String str) {
        Uri parse = Uri.parse(str);
        String a16 = com.tencent.luggage.wxa.m0.h.a(parse);
        if (str != null) {
            try {
                if (parse.getHost().equals("mpvideo.qpic.cn") && parse.getQueryParameter("vid") != null) {
                    String str2 = parse.getPath() + "_" + parse.getQueryParameter("vid");
                    try {
                        String queryParameter = parse.getQueryParameter("format_id");
                        if (queryParameter != null) {
                            str2 = str2 + "_" + queryParameter;
                        }
                        a16 = str2;
                        w.d("MicroMsg.SameLayer.VideoCore", "[TRACE_VIDEO_PRELOAD] cachekey = %s", a16);
                        return a16;
                    } catch (Exception unused) {
                        return str2;
                    }
                }
                return a16;
            } catch (Exception unused2) {
                return a16;
            }
        }
        return a16;
    }

    public boolean d() {
        return this.f134565b;
    }

    public final boolean e(String str) {
        if (!w0.c(str) && str.startsWith(VideoProxy.PROXY_SERVER)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public String j(String str) {
        if (!this.f134565b) {
            return com.tencent.luggage.wxa.ah.d.h().j(str);
        }
        if (!w0.c(str) && !e(str)) {
            try {
                return com.tencent.luggage.wxa.rg.j.a().b(str);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tg.h.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", e16);
            }
        }
        return str;
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public g.a n() {
        if (!this.f134565b) {
            return com.tencent.luggage.wxa.ah.d.h().d();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public g.a y() {
        if (!this.f134565b) {
            return com.tencent.luggage.wxa.ah.d.h().y();
        }
        return n();
    }

    public static l a() {
        if (f134563f == null) {
            synchronized (l.class) {
                if (f134563f == null) {
                    f134563f = new l();
                }
            }
        }
        return f134563f;
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public void d(String str) {
        if (this.f134565b) {
            return;
        }
        com.tencent.luggage.wxa.ah.d.h().d(str);
    }

    public void a(Context context, boolean z16, boolean z17, com.tencent.luggage.wxa.sg.a aVar, com.tencent.luggage.wxa.rg.d dVar) {
        if (this.f134564a) {
            w.d("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", Boolean.valueOf(this.f134565b));
            return;
        }
        w.d("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", Boolean.valueOf(z16), Boolean.valueOf(z17));
        long c16 = w0.c();
        this.f134564a = true;
        this.f134566c = z17;
        this.f134565b = z16;
        if (z16) {
            String b16 = b("wxvideocache");
            if (w0.c(b16)) {
                this.f134565b = false;
                w.d("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
                aVar.a(-1);
            } else {
                com.tencent.luggage.wxa.og.a.a(context.getApplicationContext());
                com.tencent.luggage.wxa.og.a.a().f(com.tencent.luggage.wxa.tn.e.f141565g || com.tencent.luggage.wxa.tn.e.f141566h);
                com.tencent.luggage.wxa.og.a.a().b(1048576L);
                com.tencent.luggage.wxa.og.a.a().a(536870912L);
                com.tencent.luggage.wxa.og.a.a().d(true);
                com.tencent.luggage.wxa.og.a.a().a(true);
                com.tencent.luggage.wxa.og.a.a().b(true);
                com.tencent.luggage.wxa.og.a.a().c(z17);
                com.tencent.luggage.wxa.og.a.a().e(false);
                com.tencent.luggage.wxa.og.a.a().a(3);
                com.tencent.luggage.wxa.og.a.a().a(new m());
                com.tencent.luggage.wxa.og.a.a().a(new com.tencent.luggage.wxa.pg.g());
                com.tencent.luggage.wxa.og.a.a().a(aVar);
                com.tencent.luggage.wxa.og.a.a().a(dVar);
                com.tencent.luggage.wxa.og.a.a().a(this.f134568e);
                com.tencent.luggage.wxa.og.a.a().b(b16);
                com.tencent.luggage.wxa.og.a.a().c(b("wxvideotmp"));
                com.tencent.luggage.wxa.rg.j.b();
            }
        }
        w.d("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", Long.valueOf(w0.c() - c16));
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public long a(String str, long j3, long j16) {
        if (!this.f134565b) {
            return com.tencent.luggage.wxa.ah.d.h().a(str, j3, j16);
        }
        try {
            return com.tencent.luggage.wxa.rg.j.a().a(str);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tg.h.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", e16);
            return 0L;
        }
    }
}
