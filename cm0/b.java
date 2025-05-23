package cm0;

import com.tencent.gdt.tangram.ad.AdListScene;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    yl0.a f31094a;

    /* renamed from: b, reason: collision with root package name */
    AdClickData f31095b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(yl0.a aVar, AdClickData adClickData) {
        this.f31094a = aVar;
        this.f31095b = adClickData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f31094a.r(new com.tencent.gdt.tangram.ad.qzone.b(this.f31095b.m()).i());
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventFactoryBaseHelper", "product = " + this.f31094a.n());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f31094a.p(com.tencent.gdt.tangram.ad.qzone.a.a(this.f31095b.p()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f31094a.q(com.tencent.gdt.tangram.ad.qzone.embedded.b.a(new com.tencent.gdt.tangram.ad.qzone.b(this.f31095b.m()).k(this.f31094a.a().getId(), this.f31095b.j()), this.f31094a));
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventFactoryBaseHelper", "canCgiReport = " + this.f31094a.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        String obj;
        this.f31094a.f(new com.tencent.gdt.tangram.ad.qzone.b(this.f31095b.m()).f());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cookie = ");
        if (this.f31094a.d() == null) {
            obj = "null";
        } else {
            obj = this.f31094a.d().toString();
        }
        sb5.append(obj);
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventFactoryBaseHelper", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        zl0.a e16 = com.tencent.gdt.tangram.ad.qzone.embedded.b.e(this.f31095b, this.f31094a);
        this.f31094a.o(e16);
        if (e16 != null) {
            com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventFactoryBaseHelper", "adAction = " + e16.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        int n3 = this.f31095b.n();
        if (this.f31094a.a().getScene().getId() == 3) {
            n3++;
        }
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventFactoryBaseHelper", "feedIndex = " + n3);
        ((AdListScene) this.f31094a.a().getScene()).setIndex(n3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i();
}
