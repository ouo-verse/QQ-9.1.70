package cm0;

import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* compiled from: P */
/* loaded from: classes39.dex */
class c extends b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(yl0.a aVar, AdClickData adClickData) {
        super(aVar, adClickData);
    }

    @Override // cm0.b
    public void c() {
        this.f31094a.e(null);
    }

    @Override // cm0.b
    public void g() {
        if (this.f31095b.i() != 0) {
            this.f31094a.a().setId(this.f31095b.i());
            com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventFactoryFeedsHelper", "areaId = " + this.f31095b.i());
            return;
        }
        int d16 = com.tencent.gdt.tangram.ad.qzone.c.d(this.f31095b.l(), this.f31095b.m(), this.f31094a.a().getScene().getId());
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventFactoryFeedsHelper", "areaId = " + d16);
        this.f31094a.a().setId(d16);
    }

    @Override // cm0.b
    public void i() {
        yl0.a aVar = this.f31094a;
        aVar.f450578i = com.tencent.gdt.tangram.ad.qzone.embedded.b.o(aVar, this.f31095b);
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventFactoryFeedsHelper", "needReport = " + this.f31094a.f450578i);
    }
}
