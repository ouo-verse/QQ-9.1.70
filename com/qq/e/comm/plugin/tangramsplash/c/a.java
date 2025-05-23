package com.qq.e.comm.plugin.tangramsplash.c;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.i.f;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.biz.common.util.WebViewConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends b implements com.qq.e.comm.plugin.h.c {
    public a(h hVar, int i3, String str, String str2, String str3, boolean z16, String str4, int i16, boolean z17, boolean z18) {
        super(hVar, i3, str, str2, str3, z16, str4, i16, z17, z18);
    }

    private void b(String str, int i3) {
        GDTLogger.i("PcdnSDKManager startOriginCdnDownload :" + str);
        h hVar = this.f39812a;
        if (hVar == null) {
            return;
        }
        b bVar = new b(hVar, this.f39813b, this.f39814d, this.f39815e, this.f39816f, this.f39817g, this.f39818h, i3, true, false);
        bVar.a(this.f39462c);
        f.a(GDTADManager.getInstance().getAppContext()).a(this.f39812a, str, bVar);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310118, this.f39814d, com.qq.e.comm.plugin.tangramsplash.report.c.a(com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, i3, Integer.MIN_VALUE, 1, this.f39813b, str, this.f39817g, 0, Integer.MIN_VALUE), this.f39816f, null, this.f39812a.h()));
    }

    private void c(String str, int i3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(this.f39814d);
        bVar.c(this.f39818h);
        bVar.b(this.f39816f);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("download_url", str);
        h hVar = this.f39812a;
        if (hVar != null) {
            cVar.a("exp_map", hVar.h());
        }
        StatTracer.trackEvent(1310121, i3, bVar, cVar);
    }

    @Override // com.qq.e.comm.plugin.h.c
    public void a(String str) {
        GDTLogger.i("PcdnSDKManager onPrepareOK :" + str);
        a(false);
        e.a().a(this);
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.c.b, com.qq.e.comm.plugin.i.a
    public int f() {
        return 1310119;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.c.b, com.qq.e.comm.plugin.i.a
    public int g() {
        return 1310120;
    }

    @Override // com.qq.e.comm.plugin.h.c
    public void a(String str, int i3, String str2) {
        GDTLogger.e("PcdnSDKManager onPrepareError url :" + str + " ,errorCode : " + i3 + " , " + str2);
        a(new com.qq.e.comm.plugin.i.d(i3, str2), false);
        e.a().a(this);
        b(str, 0);
    }

    @Override // com.qq.e.comm.plugin.h.c
    public void a(String str, int i3) {
        GDTLogger.e("PcdnSDKManager onTimeout url :" + str + ", timeoutType :" + i3);
        c(str, i3);
        e.a().a(this);
        b(str, i3);
    }
}
