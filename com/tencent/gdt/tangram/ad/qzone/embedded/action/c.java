package com.tencent.gdt.tangram.ad.qzone.embedded.action;

import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.gdt.tangram.statistics.qzone.embedded.AdReporter;

/* compiled from: P */
/* loaded from: classes31.dex */
public class c extends zl0.a {

    /* renamed from: e, reason: collision with root package name */
    private boolean f108427e;

    public c(AdClickData adClickData, yl0.a aVar, boolean z16) {
        super(adClickData, aVar);
        this.f108427e = z16;
        if (z16) {
            AdReporter.d(adClickData.m().getGdtEffectCGIUrl(), adClickData.m().getOperationInfoV2().cookie.get(3), bm0.a.f28647a);
        }
    }

    @Override // zl0.a
    public void f(yl0.a aVar, AdClickData adClickData) {
        if (this.f108427e) {
            AdReporter.d(adClickData.m().getGdtEffectCGIUrl(), adClickData.m().getOperationInfoV2().cookie.get(3), bm0.a.f28649c);
        }
        if (dm0.a.f(GdtFeedUtilForQZone.l(), adClickData.m().getOperationInfo().appid, adClickData.m().getOperationInfo().schemaPageUrl, com.tencent.gdt.tangram.ad.qzone.embedded.b.h(adClickData))) {
            AdReporter.d(adClickData.m().getGdtEffectCGIUrl(), adClickData.m().getOperationInfoV2().cookie.get(3), bm0.a.f28648b);
        }
    }

    @Override // zl0.a
    protected void e(AdClickData adClickData, yl0.a aVar) {
        this.f452725a = 3;
    }
}
