package com.tencent.gdt.tangram.ad.qzone.embedded.action;

import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.util.broadcast.APKInstallerReceiver;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* compiled from: P */
/* loaded from: classes31.dex */
public class d extends zl0.a {
    public d(AdClickData adClickData, yl0.a aVar) {
        super(adClickData, aVar);
    }

    @Override // zl0.a
    public void f(yl0.a aVar, AdClickData adClickData) {
        GdtFeedUtilForQZone.w(com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k()), true, com.tencent.gdt.tangram.ad.qzone.embedded.b.i(adClickData.m(), aVar.a()));
        APKInstallerReceiver.getInstance().startInstall(adClickData);
    }

    @Override // zl0.a
    protected void e(AdClickData adClickData, yl0.a aVar) {
        this.f452725a = 4;
    }
}
