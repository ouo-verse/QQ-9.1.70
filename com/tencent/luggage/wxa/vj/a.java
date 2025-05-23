package com.tencent.luggage.wxa.vj;

import com.tencent.luggage.wxa.ag.b;
import com.tencent.luggage.wxa.ag.h;
import com.tencent.luggage.wxa.ag.i;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f143508a;

    /* renamed from: b, reason: collision with root package name */
    public final v f143509b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143510c;

    /* renamed from: d, reason: collision with root package name */
    public j.a f143511d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean[] f143512e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedList f143513f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedList f143514g;

    /* renamed from: h, reason: collision with root package name */
    public final LinkedList f143515h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f143516i;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6850a implements g.d {
        public C6850a() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public void onForeground() {
            a.this.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements g.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public void onBackground() {
            a.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f143519a;

        static {
            int[] iArr = new int[j.b.values().length];
            f143519a = iArr;
            try {
                iArr[j.b.Video.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f143519a[j.b.LivePlayer.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f143519a[j.b.LivePusher.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f143520a;

        /* renamed from: b, reason: collision with root package name */
        public b.EnumC6005b f143521b = b.EnumC6005b.NONE;

        /* renamed from: c, reason: collision with root package name */
        public boolean f143522c = false;

        /* renamed from: d, reason: collision with root package name */
        public b.a f143523d = null;

        /* renamed from: e, reason: collision with root package name */
        public final i.a f143524e;

        /* renamed from: f, reason: collision with root package name */
        public final com.tencent.luggage.wxa.ag.d f143525f;

        /* renamed from: g, reason: collision with root package name */
        public final h f143526g;

        /* renamed from: h, reason: collision with root package name */
        public final j f143527h;

        /* renamed from: i, reason: collision with root package name */
        public com.tencent.luggage.wxa.vj.c f143528i;

        public d(int i3, com.tencent.luggage.wxa.ag.b bVar, h hVar, i.a aVar, com.tencent.luggage.wxa.ag.d dVar, com.tencent.luggage.wxa.vj.c cVar, j.a aVar2) {
            this.f143520a = i3;
            this.f143526g = hVar;
            this.f143524e = aVar;
            this.f143525f = dVar;
            this.f143528i = cVar;
            a(bVar);
            j h16 = hVar.h();
            this.f143527h = h16;
            h16.a(aVar2);
        }

        public void a() {
            j jVar = this.f143527h;
            if (jVar != null) {
                jVar.a(null);
            }
        }

        public final void a(com.tencent.luggage.wxa.ag.b bVar) {
            b.EnumC6005b c16 = bVar.c();
            if (c16 != null) {
                this.f143521b = c16;
            }
            Boolean a16 = bVar.a();
            if (a16 != null) {
                this.f143522c = a16.booleanValue();
            }
            b.a b16 = bVar.b();
            if (b16 != null) {
                this.f143523d = b16;
            }
        }
    }

    public a(v vVar) {
        String str = "MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode();
        this.f143508a = str;
        this.f143511d = null;
        this.f143512e = new boolean[0];
        this.f143513f = new LinkedList();
        this.f143514g = new LinkedList();
        this.f143515h = new LinkedList();
        this.f143516i = new ConcurrentHashMap();
        this.f143509b = vVar;
        this.f143510c = vVar.M0();
        w.d(str, "mIsCurPageForeground: " + this.f143510c);
        vVar.b(new C6850a());
        vVar.a(new b());
    }

    public void a(j.a aVar) {
        this.f143511d = aVar;
    }

    public void b(j.b bVar, String str) {
        w.d(this.f143508a, "removePipRelatedKey, type: %s, key: %s", bVar, str);
        synchronized (this.f143512e) {
            int i3 = c.f143519a[bVar.ordinal()];
            if (i3 == 1) {
                this.f143513f.remove(str);
            } else if (i3 == 2) {
                this.f143514g.remove(str);
            } else if (i3 == 3) {
                this.f143515h.remove(str);
            }
        }
    }

    public String c() {
        synchronized (this.f143512e) {
            if (!this.f143514g.isEmpty()) {
                return (String) this.f143514g.getFirst();
            }
            if (!this.f143515h.isEmpty()) {
                return (String) this.f143515h.getFirst();
            }
            if (!this.f143513f.isEmpty()) {
                return (String) this.f143513f.getFirst();
            }
            return null;
        }
    }

    public boolean d() {
        return this.f143510c;
    }

    public void e() {
        w.d(this.f143508a, "markCurPageBackground");
        this.f143510c = false;
    }

    public void f() {
        w.d(this.f143508a, "markCurPageDestroy");
        synchronized (this.f143512e) {
            this.f143513f.clear();
            this.f143514g.clear();
            this.f143515h.clear();
        }
        this.f143516i.clear();
    }

    public void g() {
        w.d(this.f143508a, "markCurPageForeground");
        this.f143510c = true;
    }

    public void a(j.b bVar, String str) {
        w.d(this.f143508a, "addPipRelatedKey, type: %s, key: %s", bVar, str);
        synchronized (this.f143512e) {
            int i3 = c.f143519a[bVar.ordinal()];
            if (i3 == 1) {
                this.f143513f.remove(str);
                this.f143513f.addFirst(str);
            } else if (i3 == 2) {
                this.f143514g.remove(str);
                this.f143514g.addFirst(str);
            } else if (i3 == 3) {
                this.f143515h.remove(str);
                this.f143515h.addFirst(str);
            }
        }
    }

    public d b() {
        String c16 = c();
        if (c16 == null) {
            return null;
        }
        return (d) this.f143516i.get(c16);
    }

    public void a(String str, int i3, com.tencent.luggage.wxa.ag.b bVar, h hVar, i.a aVar, com.tencent.luggage.wxa.ag.d dVar, com.tencent.luggage.wxa.vj.c cVar) {
        w.a(this.f143508a, "processPipInfo, key: " + str);
        d dVar2 = (d) this.f143516i.get(str);
        if (dVar2 == null) {
            w.d(this.f143508a, "processPipInfo, create PipVideoSession for key: " + str);
            this.f143516i.put(str, new d(i3, bVar, hVar, aVar, dVar, cVar, this.f143511d));
        } else {
            w.d(this.f143508a, "processPipInfo, pipVideoSession for key: " + str + " exists");
            dVar2.a(bVar);
            dVar2.f143528i = cVar;
        }
        if (b.EnumC6005b.a(bVar.c()) && hVar.isPlaying()) {
            a(hVar.h().getType(), str);
        }
    }

    public n a() {
        return this.f143509b.b0();
    }

    public d a(String str) {
        return (d) this.f143516i.get(str);
    }
}
