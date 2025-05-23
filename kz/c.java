package kz;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final kz.d f413438a = new kz.d();

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.e f413439b;

    /* renamed from: c, reason: collision with root package name */
    private mz.d f413440c;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements jz.c<mz.d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ jz.c f413441d;

        a(jz.c cVar) {
            this.f413441d = cVar;
        }

        @Override // jz.c
        public void d0(List<mz.d> list, boolean z16, boolean z17, Object obj) {
            c.this.f413438a.h(list);
            jz.c cVar = this.f413441d;
            if (cVar != null) {
                cVar.d0(list, z16, z17, obj);
            }
        }

        @Override // jz.c
        public void i(int i3, String str, boolean z16, boolean z17) {
            jz.c cVar = this.f413441d;
            if (cVar != null) {
                cVar.i(i3, str, z16, z17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements jz.c<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f413443d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ jz.c f413444e;

        b(String str, jz.c cVar) {
            this.f413443d = str;
            this.f413444e = cVar;
        }

        @Override // jz.c
        public void d0(List<String> list, boolean z16, boolean z17, Object obj) {
            c.this.f413438a.e(this.f413443d).addAll(list);
            nz.c b16 = c.this.f413438a.b(this.f413443d);
            jz.c cVar = this.f413444e;
            if (cVar != null) {
                cVar.d0(b16.b(), z16, z17, b16.a());
            }
        }

        @Override // jz.c
        public void i(int i3, String str, boolean z16, boolean z17) {
            jz.c cVar = this.f413444e;
            if (cVar != null) {
                cVar.i(i3, str, z16, z17);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: kz.c$c, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10693c implements jz.c<stDramaFeed> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f413446d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kz.a f413447e;

        C10693c(g gVar, kz.a aVar) {
            this.f413446d = gVar;
            this.f413447e = aVar;
        }

        @Override // jz.c
        public void d0(List<stDramaFeed> list, boolean z16, boolean z17, Object obj) {
            x.i("WSDramaDataManager-nel-log", "[WSDramaDataManager.java][getSingleEpisodeFeed] isPreloadData:" + this.f413446d.i());
            c.this.f413438a.i(list, this.f413446d.f());
            if (this.f413446d.i()) {
                return;
            }
            stDramaFeed stdramafeed = c.this.f413438a.d(this.f413446d.f()).get(Integer.valueOf(Math.max(1, this.f413446d.g())));
            kz.a aVar = this.f413447e;
            if (aVar != null) {
                aVar.onSuccess(stdramafeed);
            }
        }

        @Override // jz.c
        public void i(int i3, String str, boolean z16, boolean z17) {
            kz.a aVar = this.f413447e;
            if (aVar != null) {
                aVar.onFailure(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final c f413449a = new c();
    }

    c() {
    }

    public static c d() {
        return d.f413449a;
    }

    public void b(String str, jz.c<nz.f> cVar) {
        if (this.f413438a.e(str).size() > 0) {
            nz.c b16 = this.f413438a.b(str);
            if (cVar != null) {
                cVar.d0(b16.b(), false, false, b16.a());
                return;
            }
            return;
        }
        new mz.a().a(new mz.f(str), new b(str, cVar));
    }

    public void c(String str, boolean z16, boolean z17, String str2, jz.c<mz.d> cVar) {
        new mz.b().a(new mz.e(z16, z17, str), new a(cVar));
    }

    public mz.d e() {
        return this.f413440c;
    }

    public com.tencent.biz.pubaccount.weishi.player.e f() {
        return this.f413439b;
    }

    public void g(g gVar, kz.a<stDramaFeed> aVar) {
        gVar.l(this.f413438a.d(gVar.f()));
        if (gVar.j()) {
            this.f413438a.j(gVar.f(), gVar.g());
        }
        j.a(gVar.d()).a(gVar, new C10693c(gVar, aVar));
    }

    public void i(mz.d dVar) {
        this.f413440c = dVar;
    }

    public void j(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        this.f413439b = eVar;
    }

    public void h() {
        this.f413439b = null;
        this.f413440c = null;
        this.f413438a.g();
    }
}
