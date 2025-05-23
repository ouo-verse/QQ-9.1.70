package com.tencent.gdt.tangram.ad.qzone.embedded.action;

import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* compiled from: P */
/* loaded from: classes31.dex */
public class h extends zl0.a {
    public h(AdClickData adClickData, yl0.a aVar) {
        super(adClickData, aVar);
    }

    @Override // zl0.a
    public void f(yl0.a aVar, AdClickData adClickData) {
        GdtFeedUtilForQZone.t(com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k()), adClickData.m(), com.tencent.gdt.tangram.ad.qzone.c.b(new com.tencent.gdt.tangram.ad.qzone.b(adClickData.m()).k(aVar.a().getId(), adClickData.j()), aVar));
    }

    @Override // zl0.a
    protected void e(AdClickData adClickData, yl0.a aVar) {
        this.f452726b = true;
    }
}
