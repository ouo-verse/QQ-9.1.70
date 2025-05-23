package com.tencent.gdt.tangram.ad.qzone.embedded.action;

import android.content.Context;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* compiled from: P */
/* loaded from: classes31.dex */
public class j extends zl0.a {
    public j(AdClickData adClickData, yl0.a aVar) {
        super(adClickData, aVar);
        this.f452726b = true;
    }

    @Override // zl0.a
    public void f(yl0.a aVar, AdClickData adClickData) {
        BusinessFeedData m3 = adClickData.m();
        Context e16 = com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k());
        if (m3 != null && m3.cellOperationInfo != null) {
            yo.a aVar2 = new yo.a(m3.cellOperationInfo.actionUrl, null);
            aVar2.f450698j = com.tencent.gdt.tangram.ad.qzone.c.b(m3.cellOperationInfo.downloadUrl, aVar);
            yo.d.b(e16, aVar2);
            com.tencent.gdt.tangram.ad.qzone.d.b("AdMiniAppActionUrl", "jump url = " + m3.cellOperationInfo.actionUrl);
            return;
        }
        com.tencent.gdt.tangram.ad.qzone.d.c("AdMiniAppActionUrl", "data = null");
    }
}
