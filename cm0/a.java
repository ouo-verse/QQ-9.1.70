package cm0;

import com.tencent.gdt.tangram.ad.AdArea;
import com.tencent.gdt.tangram.ad.AdListScene;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* compiled from: P */
/* loaded from: classes39.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public yl0.a a(AdClickData adClickData) {
        int o16;
        yl0.a aVar = new yl0.a();
        if (adClickData.o() == -1) {
            o16 = com.tencent.gdt.tangram.ad.qzone.embedded.b.g(adClickData.k());
        } else {
            o16 = adClickData.o();
        }
        aVar.b(new AdArea(new AdListScene(o16, 0)));
        b b16 = b(o16, aVar, adClickData);
        if (b16 == null) {
            return aVar;
        }
        b16.a();
        b16.h();
        b16.g();
        b16.f();
        b16.c();
        b16.e();
        b16.i();
        b16.d();
        b16.b();
        return aVar;
    }

    private static b b(int i3, yl0.a aVar, AdClickData adClickData) {
        if (i3 == 0 || i3 == 3 || i3 == 2) {
            return new c(aVar, adClickData);
        }
        if (i3 == 6 || i3 == 1 || i3 == 7 || i3 == 8) {
            return new d(aVar, adClickData);
        }
        return null;
    }
}
