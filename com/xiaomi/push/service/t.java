package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.xiaomi.push.bb;
import com.xiaomi.push.cn;
import com.xiaomi.push.cp;
import com.xiaomi.push.dy;
import com.xiaomi.push.dz;
import com.xiaomi.push.ei;
import com.xiaomi.push.ep;
import com.xiaomi.push.fm;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.ae;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class t extends ae.b implements bb.c {

    /* renamed from: a, reason: collision with root package name */
    private XMPushService f389809a;

    /* renamed from: b, reason: collision with root package name */
    private long f389810b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements bb.d {
        a() {
        }

        @Override // com.xiaomi.push.bb.d
        public String a(String str) {
            int port;
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter(TPReportKeys.Common.COMMON_OS_VERSION, String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", fm.b(Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(ii.a()));
            String builder = buildUpon.toString();
            jz4.c.z("fetch bucket from : " + builder);
            URL url = new URL(builder);
            if (url.getPort() == -1) {
                port = 80;
            } else {
                port = url.getPort();
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String k3 = com.xiaomi.push.au.k(ii.b(), url);
                dz.g(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return k3;
            } catch (IOException e16) {
                dz.g(url.getHost() + ":" + port, -1, e16);
                throw e16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class b extends com.xiaomi.push.bb {
        protected b(Context context, com.xiaomi.push.ba baVar, bb.d dVar, String str) {
            super(context, baVar, dVar, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaomi.push.bb
        public String f(ArrayList<String> arrayList, String str, String str2, boolean z16) {
            try {
                if (dy.f().k()) {
                    str2 = ae.g();
                }
                return super.f(arrayList, str, str2, z16);
            } catch (IOException e16) {
                dz.d(0, ei.GSLB_ERR.a(), 1, null, com.xiaomi.push.au.v(com.xiaomi.push.bb.f388238j) ? 1 : 0);
                throw e16;
            }
        }
    }

    t(XMPushService xMPushService) {
        this.f389809a = xMPushService;
    }

    public static void d(XMPushService xMPushService) {
        t tVar = new t(xMPushService);
        ae.f().k(tVar);
        synchronized (com.xiaomi.push.bb.class) {
            com.xiaomi.push.bb.k(tVar);
            com.xiaomi.push.bb.j(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.bb.c
    public com.xiaomi.push.bb a(Context context, com.xiaomi.push.ba baVar, bb.d dVar, String str) {
        return new b(context, baVar, dVar, str);
    }

    @Override // com.xiaomi.push.service.ae.b
    public void c(cp cpVar) {
        com.xiaomi.push.ax q16;
        boolean z16;
        if (cpVar.p() && cpVar.n() && System.currentTimeMillis() - this.f389810b > 3600000) {
            jz4.c.m("fetch bucket :" + cpVar.n());
            this.f389810b = System.currentTimeMillis();
            com.xiaomi.push.bb c16 = com.xiaomi.push.bb.c();
            c16.i();
            c16.s();
            ep m454a = this.f389809a.m454a();
            if (m454a != null && (q16 = c16.q(m454a.c().k())) != null) {
                ArrayList<String> c17 = q16.c();
                Iterator<String> it = c17.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().equals(m454a.d())) {
                            z16 = false;
                            break;
                        }
                    } else {
                        z16 = true;
                        break;
                    }
                }
                if (z16 && !c17.isEmpty()) {
                    jz4.c.m("bucket changed, force reconnect");
                    this.f389809a.a(0, (Exception) null);
                    this.f389809a.a(false);
                }
            }
        }
    }

    @Override // com.xiaomi.push.service.ae.b
    public void b(cn cnVar) {
    }
}
