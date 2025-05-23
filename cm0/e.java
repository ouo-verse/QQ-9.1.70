package cm0;

import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.gdt.tangram.statistics.qzone.embedded.AdReporter;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends yl0.d {

    /* renamed from: a, reason: collision with root package name */
    private AdClickData f31096a;

    /* renamed from: b, reason: collision with root package name */
    private yl0.a f31097b;

    public e(AdClickData adClickData) {
        this.f31096a = adClickData;
    }

    @Override // yl0.d
    protected void a() {
        if (this.f31097b.h() != null) {
            com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventProcessor", "action = " + this.f31097b.h().getClass().getSimpleName());
            this.f31097b.h().f(this.f31097b, this.f31096a);
        }
    }

    @Override // yl0.d
    protected void b() {
        if (this.f31097b.f450578i) {
            com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventProcessor", "clickInfo = " + this.f31097b.k());
            AdReporter.c(this.f31097b);
            if (this.f31096a.o() != 0) {
                vo.b.m(true, this.f31096a.m());
                return;
            }
            return;
        }
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventProcessor", "do not need report");
    }

    @Override // yl0.d
    protected void c() {
        this.f31097b = new a().a(this.f31096a);
    }

    @Override // yl0.d
    protected boolean e() {
        return this.f31096a.r();
    }
}
