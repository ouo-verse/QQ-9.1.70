package cm0;

import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* compiled from: P */
/* loaded from: classes39.dex */
class d extends b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(yl0.a aVar, AdClickData adClickData) {
        super(aVar, adClickData);
    }

    @Override // cm0.b
    public void c() {
        this.f31094a.e(new com.tencent.gdt.tangram.ad.qzone.b(this.f31095b.m()).e());
    }

    @Override // cm0.b
    public void g() {
        this.f31094a.a().setId(this.f31095b.i());
    }

    @Override // cm0.b
    public void i() {
        yl0.a aVar = this.f31094a;
        aVar.f450578i = com.tencent.gdt.tangram.ad.qzone.embedded.b.p(aVar, this.f31095b);
    }
}
