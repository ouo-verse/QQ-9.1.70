package com.tencent.gdt.tangram.ad.qzone.embedded.action;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.broadcast.APKInstallerReceiver;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes31.dex */
public class i extends zl0.a {
    public i(AdClickData adClickData, yl0.a aVar) {
        super(adClickData, aVar);
    }

    @Override // zl0.a
    public void f(yl0.a aVar, AdClickData adClickData) {
        int o16;
        String c16;
        BusinessFeedData m3 = adClickData.m();
        Context e16 = com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k());
        String k3 = new com.tencent.gdt.tangram.ad.qzone.b(m3).k(aVar.a().getId(), adClickData.j());
        if (adClickData.o() == -1) {
            o16 = com.tencent.gdt.tangram.ad.qzone.embedded.b.g(adClickData.k());
        } else {
            o16 = adClickData.o();
        }
        if (m3.isAppAd() && o16 == 2) {
            k3 = k3 + "&_autodownload=1";
        }
        if (com.tencent.gdt.tangram.ad.qzone.embedded.b.a(k3, aVar)) {
            String g16 = new com.tencent.gdt.tangram.ad.qzone.b(m3).g();
            if (TextUtils.isEmpty(g16)) {
                c16 = com.tencent.gdt.tangram.ad.qzone.c.b(k3, aVar);
            } else {
                c16 = com.tencent.gdt.tangram.ad.qzone.c.c(com.tencent.gdt.tangram.ad.qzone.c.b(k3, aVar), g16);
            }
            k3 = c16;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("businessFeedData", m3);
        hashMap.put("needGdtLandingPageReport", Boolean.TRUE);
        String str = (m3.getOperationInfoV2().userPost != 1 || TextUtils.isEmpty(m3.getOperationInfo().postParams)) ? null : m3.getOperationInfoV2().postParams;
        APKInstallerReceiver.getInstance().startInstall(adClickData);
        yo.g gVar = new yo.g(k3, str);
        gVar.f450714g = hashMap;
        yo.d.b(e16, gVar);
        com.tencent.gdt.tangram.ad.qzone.d.b("AdActionUrl", "url =" + k3);
    }

    @Override // zl0.a
    protected void e(AdClickData adClickData, yl0.a aVar) {
        this.f452726b = true;
    }
}
