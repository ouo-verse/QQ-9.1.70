package com.qq.e.comm.plugin.tangramsplash.d;

import android.text.TextUtils;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    public static void a(String str, int i3, com.qq.e.comm.plugin.base.ad.model.f fVar) {
        a(str, i3, fVar, false);
    }

    public static void a(String str, int i3, final com.qq.e.comm.plugin.base.ad.model.f fVar, final boolean z16) {
        if (fVar == null) {
            return;
        }
        String z17 = fVar.z();
        if (TextUtils.isEmpty(z17)) {
            return;
        }
        String c16 = com.qq.e.comm.plugin.k.b.c(com.qq.e.comm.plugin.k.b.b(com.qq.e.comm.plugin.k.b.d(z17)));
        GDTLogger.d("append mu_p key and value, modified url( ccr )  = " + c16);
        final long currentTimeMillis = System.currentTimeMillis();
        if (com.qq.e.comm.plugin.j.c.a("splashOnExposureCallback", 1, 1)) {
            if (c16.length() <= 0 || !(fVar instanceof r)) {
                return;
            }
            NetworkClientImpl.getInstance().submit(new PlainRequest(c16, 1, (byte[]) null), 1, new NetworkCallBack() { // from class: com.qq.e.comm.plugin.tangramsplash.d.d.1
                @Override // com.qq.e.comm.net.NetworkCallBack
                public void onException(Exception exc) {
                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310322, com.qq.e.comm.plugin.base.ad.model.f.this.s(), (r) com.qq.e.comm.plugin.base.ad.model.f.this, z16, -26);
                    au.a(new com.qq.e.comm.plugin.base.ad.model.a(com.qq.e.comm.plugin.base.ad.model.f.this.u(), com.qq.e.comm.plugin.base.ad.model.f.this.t(), com.qq.e.comm.plugin.base.ad.model.f.this.s()), System.currentTimeMillis() - currentTimeMillis, 4001, Integer.MIN_VALUE);
                    GDTLogger.e("splash exposure exception: " + exc.getMessage());
                }

                @Override // com.qq.e.comm.net.NetworkCallBack
                public void onResponse(Request request, Response response) {
                    if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310327, com.qq.e.comm.plugin.base.ad.model.f.this.s(), (r) com.qq.e.comm.plugin.base.ad.model.f.this, z16, response.getStatusCode());
                        au.a(new com.qq.e.comm.plugin.base.ad.model.a(com.qq.e.comm.plugin.base.ad.model.f.this.u(), com.qq.e.comm.plugin.base.ad.model.f.this.t(), com.qq.e.comm.plugin.base.ad.model.f.this.s()), System.currentTimeMillis() - currentTimeMillis, 4000, Integer.MIN_VALUE);
                        GDTLogger.i("splash exposure success");
                    } else {
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310322, com.qq.e.comm.plugin.base.ad.model.f.this.s(), (r) com.qq.e.comm.plugin.base.ad.model.f.this, z16, response.getStatusCode());
                        au.a(new com.qq.e.comm.plugin.base.ad.model.a(com.qq.e.comm.plugin.base.ad.model.f.this.u(), com.qq.e.comm.plugin.base.ad.model.f.this.t(), com.qq.e.comm.plugin.base.ad.model.f.this.s()), System.currentTimeMillis() - currentTimeMillis, 4001, response.getStatusCode());
                        GDTLogger.i("splash exposure failed: " + response.getStatusCode());
                    }
                }
            });
            return;
        }
        af.a(c16);
    }
}
