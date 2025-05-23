package ot0;

import com.tencent.icgame.api.strategy.impl.a;
import ot0.c;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends com.tencent.icgame.api.strategy.impl.a {

    /* renamed from: d, reason: collision with root package name */
    private sf4.a f423986d = new sf4.a();

    /* renamed from: e, reason: collision with root package name */
    private boolean f423987e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f423988f = 0;

    /* renamed from: g, reason: collision with root package name */
    private c f423989g = null;

    /* renamed from: h, reason: collision with root package name */
    private long f423990h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f423991i = -1;

    /* renamed from: j, reason: collision with root package name */
    private final c.b f423992j = new C10958a();

    /* compiled from: P */
    /* renamed from: ot0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C10958a implements c.b {
        C10958a() {
        }

        @Override // ot0.c.b
        public void a(int i3, long j3) {
            a.this.e("\u5b8c\u6210\u7f51\u7edc\u6d4b\u901f retCode:" + i3 + " speedKB:" + j3 + "KB/s");
            if (i3 < 0) {
                a.this.e("networkSpeedListener.onFinish retCode:" + i3);
                return;
            }
            if (!a.this.f423987e) {
                a.this.d("isInit is false");
                return;
            }
            a.this.f423991i = j3;
            a aVar = a.this;
            aVar.s(aVar.f423991i);
        }

        @Override // ot0.c.b
        public void onStart() {
            a.this.e("\u5f00\u59cb\u7f51\u7edc\u6d4b\u901f");
        }
    }

    public a() {
        this.f114818a = "PlayerStrategy|SlowDownload";
    }

    private boolean r(long j3) {
        sf4.a aVar = this.f423986d;
        if (j3 <= aVar.slowDownloadBitrateSD) {
            return aVar.slowDownloadPreloadSD;
        }
        if (j3 <= aVar.slowDownloadBitrateHD) {
            return aVar.slowDownloadPreloadHD;
        }
        if (j3 <= aVar.slowDownloadBitrateSHD) {
            return aVar.slowDownloadPreloadSHD;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j3) {
        boolean t16 = t(j3);
        boolean r16 = r(j3);
        e("\u7f51\u7edc\u8bc4\u4f30\u7ed3\u679c \u7f51\u901f:" + j3 + "KB/s \u662f\u5426\u5f31\u7f51:" + t16 + " \u662f\u5426\u9884\u52a0\u8f7d:" + r16);
        if (!this.f423986d.slowDownloadEnable) {
            e("\u7b56\u7565\u4e0d\u542f\u7528\uff0c\u4e0d\u505a\u81ea\u52a8\u5207\u6362\uff01");
            a.InterfaceC5826a interfaceC5826a = this.f114820c;
            if (interfaceC5826a != null) {
                interfaceC5826a.slowDownloadNetworkChange(false, true);
                return;
            }
            return;
        }
        a.InterfaceC5826a interfaceC5826a2 = this.f114820c;
        if (interfaceC5826a2 != null) {
            interfaceC5826a2.slowDownloadNetworkChange(t16, r16);
        }
    }

    private boolean t(long j3) {
        if (j3 < this.f423986d.slowDownloadBitrateHD) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.icgame.api.strategy.impl.a
    public void a() {
        this.f423987e = false;
        this.f114820c = null;
    }

    @Override // com.tencent.icgame.api.strategy.impl.a
    public void c(a.InterfaceC5826a interfaceC5826a) {
        this.f114820c = interfaceC5826a;
        this.f423986d = b();
        this.f423987e = true;
    }

    @Override // com.tencent.icgame.api.strategy.impl.a
    public void f() {
        e("\u79bb\u5f00\u5927\u5385\u9875");
        c cVar = this.f423989g;
        if (cVar != null) {
            cVar.o();
            this.f423989g = null;
        }
    }

    @Override // com.tencent.icgame.api.strategy.impl.a
    public void g() {
        e("\u8fdb\u5165\u5927\u5385\u9875 \u4e4b\u524d\u6d4b\u7684\u7f51\u901f:" + this.f423991i + "KB/s");
        sf4.a b16 = b();
        this.f423986d = b16;
        if (b16.slowDownloadEnable && b16.testSpeedEnable) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f423990h > this.f423986d.testSpeedDuration && this.f423989g == null) {
                e("\u542f\u52a8\u7f51\u7edc\u6d4b\u901f");
                this.f423990h = currentTimeMillis;
                c cVar = new c();
                this.f423989g = cVar;
                cVar.n(this.f423986d.testSpeedUrl, this.f423992j);
                return;
            }
            return;
        }
        d("\u4e0d\u542f\u52a8\u81ea\u52a8\u6d4b\u901f! \u56de\u8c03\u4e00\u4e2a\u9ed8\u8ba4\u503c");
        a.InterfaceC5826a interfaceC5826a = this.f114820c;
        if (interfaceC5826a != null) {
            interfaceC5826a.slowDownloadNetworkChange(false, true);
        }
    }

    @Override // com.tencent.icgame.api.strategy.impl.a
    public void h(long j3) {
        e("onPageIn:" + j3);
        this.f423988f = j3;
    }

    @Override // com.tencent.icgame.api.strategy.impl.a
    public void i(long j3) {
        e("onPageOut:" + j3);
        if (this.f423988f == j3) {
            this.f423988f = 0L;
        }
    }
}
