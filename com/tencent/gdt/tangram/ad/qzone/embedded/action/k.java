package com.tencent.gdt.tangram.ad.qzone.embedded.action;

import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* compiled from: P */
/* loaded from: classes31.dex */
public class k extends zl0.a {
    public k(AdClickData adClickData, yl0.a aVar) {
        super(adClickData, aVar);
    }

    @Override // zl0.a
    public void f(yl0.a aVar, AdClickData adClickData) {
        GdtFeedUtilForQZone.gotoPanoramaAdvLandingPage(com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k()), adClickData.m());
    }

    @Override // zl0.a
    protected void e(AdClickData adClickData, yl0.a aVar) {
        this.f452726b = false;
    }
}
