package com.tencent.luggage.wxa.ah;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.l0.p;
import com.tencent.luggage.wxa.m0.d;
import com.tencent.luggage.wxa.m0.f;
import com.tencent.luggage.wxa.m0.h;
import com.tencent.luggage.wxa.m0.k;
import com.tencent.luggage.wxa.m0.m;
import com.tencent.luggage.wxa.mg.i;
import com.tencent.luggage.wxa.mg.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.io.File;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements i, com.tencent.luggage.wxa.ya.b {

    /* renamed from: e, reason: collision with root package name */
    public static d f121416e;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.m0.a f121417a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.m0.e f121418b;

    /* renamed from: c, reason: collision with root package name */
    public c f121419c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f121420d = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements d.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.m0.d.a
        public void a(long j3, long j16) {
            w.a("MicroMsg.SameLayer.ExoVideoCacheHandler", "onCachedBytesRead, cacheSpace:%s, totalCachedBytesRead:%s", Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public d() {
        l();
    }

    public static d h() {
        if (f121416e == null) {
            synchronized (d.class) {
                if (f121416e == null) {
                    f121416e = new d();
                }
            }
        }
        return f121416e;
    }

    @Override // com.tencent.luggage.wxa.ya.b
    public void G() {
        w.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
    }

    public com.tencent.luggage.wxa.m0.a a(File file, f fVar) {
        return new m(file, fVar);
    }

    public g.a d() {
        return this.f121418b;
    }

    @Override // com.tencent.luggage.wxa.ya.b
    public void e() {
        w.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public String j(String str) {
        return str;
    }

    public final void l() {
        String j3 = j();
        a();
        String e16 = com.tencent.luggage.wxa.db.a.e();
        if (!e16.endsWith("/")) {
            e16 = e16 + "/";
        }
        String str = e16 + "videocache/" + j3 + "/";
        try {
            if (!x.m(str)) {
                w.f("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 1, maybe file exist");
                if (!new v(str).p()) {
                    w.f("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail, not dir");
                    x.c(str);
                    if (!x.m(str)) {
                        w.f("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 2, no space?");
                        return;
                    }
                }
            }
            v vVar = new v(str);
            this.f121417a = a(new File(x.b(vVar.g(), true)), new k(536870912L));
            w.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cacheFolder:%s", vVar.g());
            this.f121418b = new com.tencent.luggage.wxa.m0.e(this.f121417a, com.tencent.luggage.wxa.zg.k.a(z.c()), new p(), new com.tencent.luggage.wxa.m0.c(this.f121417a, 10485760L), 2, new a());
            w.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cache:%s", this.f121417a);
        } catch (Throwable th5) {
            w.b("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs exception:%s", th5);
        }
    }

    public final synchronized void m() {
        com.tencent.luggage.wxa.m0.e eVar;
        if (!this.f121420d) {
            com.tencent.luggage.wxa.m0.a aVar = this.f121417a;
            if (aVar != null && (eVar = this.f121418b) != null) {
                this.f121419c = new c(aVar, eVar);
            }
            this.f121420d = true;
        }
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public g.a n() {
        return d();
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public g.a y() {
        m();
        c cVar = this.f121419c;
        if (cVar != null) {
            return cVar.a();
        }
        return n();
    }

    public final void a() {
        String e16 = com.tencent.luggage.wxa.db.a.e();
        if (!e16.endsWith("/")) {
            e16 = e16 + "/";
        }
        try {
            x.b(e16 + "wxavideocache/");
        } catch (Throwable th5) {
            w.b("MicroMsg.SameLayer.ExoVideoCacheHandler", "cleanOldVideoCacheFolder exception:%s", th5);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public void d(String str) {
        w.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "removeCache, url: %s", str);
        if (str == null) {
            return;
        }
        if (this.f121417a == null) {
            w.f("MicroMsg.SameLayer.ExoVideoCacheHandler", "removeCache, cache is null");
        } else {
            h.a(this.f121417a, l.a().c(str));
        }
    }

    public String j() {
        int indexOf;
        int i3;
        String i16 = z.i();
        return (w0.c(i16) || (indexOf = i16.indexOf(":")) < 0 || i16.length() < (i3 = indexOf + 1)) ? "main" : i16.substring(i3);
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public long a(String str, long j3, long j16) {
        if (this.f121417a == null) {
            w.f("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cache is null");
            return 0L;
        }
        long a16 = this.f121417a.a(l.a().c(str), j3, j16);
        w.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cachedSize:%s, position:%s, length:%s, url:%s", Long.valueOf(a16), Long.valueOf(j3), Long.valueOf(j16), str);
        return a16;
    }
}
