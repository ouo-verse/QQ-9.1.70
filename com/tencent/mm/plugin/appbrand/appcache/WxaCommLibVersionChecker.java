package com.tencent.mm.plugin.appbrand.appcache;

import android.app.Application;
import android.widget.Toast;
import com.tencent.luggage.wxa.hn.be;
import com.tencent.luggage.wxa.hn.ce;
import com.tencent.luggage.wxa.hn.z7;
import com.tencent.luggage.wxa.mc.WxaCommLibFileReader;
import com.tencent.luggage.wxa.mc.g;
import com.tencent.luggage.wxa.mc.h0;
import com.tencent.luggage.wxa.mc.k;
import com.tencent.luggage.wxa.mc.l0;
import com.tencent.luggage.wxa.mc.x;
import com.tencent.luggage.wxa.mc.y;
import com.tencent.luggage.wxa.n3.e;
import com.tencent.luggage.wxa.n3.m0;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.o3.j;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.q7.a0;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.IOException;
import java.util.concurrent.Future;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class WxaCommLibVersionChecker extends a0 {

    /* renamed from: e, reason: collision with root package name */
    public static final WxaCommLibVersionChecker f151845e = new WxaCommLibVersionChecker();

    /* renamed from: f, reason: collision with root package name */
    public static final String f151846f = "Luggage.WxaCommLibVersionChecker";

    /* renamed from: g, reason: collision with root package name */
    public static Future f151847g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends e {

        /* renamed from: b, reason: collision with root package name */
        public static final a f151848b = new a();

        /* renamed from: c, reason: collision with root package name */
        public static final String f151849c = "/cgi-bin/mmbiz-bin/wxaapp/getpubliclibinfo";

        /* compiled from: P */
        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibVersionChecker$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C7051a implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public static final C7051a f151850a = new C7051a();

            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(ce ceVar) {
                if (ceVar != null) {
                    WxaCommLibVersionChecker.f151845e.a(ceVar);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class b implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public static final b f151851a = new b();

            @Override // com.tencent.luggage.wxa.xo.e.a
            public final void a(Object obj) {
                w.b(WxaCommLibVersionChecker.f151845e.h(), "CgiGetPublicInfo interrupted: " + obj);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.e
        public String a() {
            return f151849c;
        }

        public final void b() {
            if (!l.f136139a.c()) {
                return;
            }
            be beVar = new be();
            k a16 = x.a(x.f134407a, null, null, 0, false, 11, null);
            if (a16 == null) {
                a16 = com.tencent.luggage.wxa.mc.c.f134270g;
            }
            beVar.f127358e = a16.w();
            a(null, beVar, ce.class).a(C7051a.f151850a).a(b.f151851a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f151852a = new b();

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h0 f151853a;

            public a(h0 h0Var) {
                this.f151853a = h0Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                if (y.f134408a.a(this.f151853a)) {
                    return;
                }
                h0 h0Var = this.f151853a;
                int i3 = h0Var.f138307d;
                com.tencent.luggage.wxa.mc.c cVar = com.tencent.luggage.wxa.mc.c.f134270g;
                if (i3 <= cVar.w()) {
                    w.d("Luggage.WxaCommLibPkgDownloader", "checkIfDownload, skip by version, record(" + h0Var.f138307d + ") <= asset(" + cVar.w() + ')');
                    return;
                }
                String finalPkgPath = m0.a(RFixConstants.SO_PATH, "", h0Var.f138307d, h0Var.f138309f, 0);
                try {
                    com.tencent.luggage.wxa.h6.e eVar = com.tencent.luggage.wxa.h6.e.f126875a;
                    String str2 = h0Var.f138321r;
                    Intrinsics.checkNotNullExpressionValue(str2, "record.field_downloadURL");
                    Intrinsics.checkNotNullExpressionValue(finalPkgPath, "finalPkgPath");
                    com.tencent.luggage.wxa.h6.e.a(eVar, str2, finalPkgPath, null, 4, null);
                    try {
                        str = com.tencent.mm.plugin.appbrand.appcache.a.b(finalPkgPath);
                    } catch (IOException unused) {
                        str = null;
                    }
                    if (!StringUtils.equals(str, h0Var.f138309f)) {
                        w.b("Luggage.WxaCommLibPkgDownloader", "checkIfDownload, download completed but md5 check failed, version(" + h0Var.f138307d + ") file(" + str + ")!=record(" + h0Var.f138309f + ')');
                        return;
                    }
                    try {
                        h0Var.f138315l = finalPkgPath;
                        l0 l0Var = (l0) com.tencent.luggage.wxa.c6.b.a(l0.class);
                        if (l0Var != null) {
                            l0Var.d(h0Var);
                        }
                    } catch (Throwable th5) {
                        w.b("Luggage.WxaCommLibPkgDownloader", "checkIfDownload, download completed but update record version(" + h0Var.f138307d + ") md5(" + h0Var.f138309f + ") failed by " + th5);
                    }
                } catch (IOException e16) {
                    w.b("Luggage.WxaCommLibPkgDownloader", "checkIfDownload, download with version(" + h0Var.f138307d + ") md5(" + h0Var.f138309f + ") url(" + h0Var.f138321r + "), failed by " + e16);
                }
            }
        }

        public final void a(h0 record) {
            Intrinsics.checkNotNullParameter(record, "record");
            h.f146825d.a(new a(record), "Luggage.WxaCommLibPkgDownloader");
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements e.a {
        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a(j jVar) {
            WxaCommLibVersionChecker.f151845e.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f151854a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f151855b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f151856a;

            public a(String str) {
                this.f151856a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(z.c(), "\u6d4b\u8bd5\u7248\u5c0f\u7a0b\u5e8f\u57fa\u7840\u5e93\n(" + this.f151856a + ")\n\u4e0b\u8f7d\u5b8c\u6210", 0).show();
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public static final b f151857a = new b();

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(z.c(), "\u6d4b\u8bd5\u7248\u5c0f\u7a0b\u5e8f\u57fa\u7840\u5e93 \u5f00\u59cb\u4e0b\u8f7d", 0).show();
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f151858a;

            public c(String str) {
                this.f151858a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(z.c(), "\u6d4b\u8bd5\u7248\u5c0f\u7a0b\u5e8f\u57fa\u7840\u5e93\n(" + this.f151858a + ")\n\u4e0b\u8f7d\u5b8c\u6210", 0).show();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibVersionChecker$d$d, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class RunnableC7052d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public static final RunnableC7052d f151859a = new RunnableC7052d();

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(z.c(), "\u6d4b\u8bd5\u7248\u5c0f\u7a0b\u5e8f\u57fa\u7840\u5e93 \u4e0b\u8f7d\u5931\u8d25", 0).show();
            }
        }

        public d(String str, String str2) {
            this.f151854a = str;
            this.f151855b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            try {
                q a16 = x.a(x.f134407a, null, null, 999, false, 11, null);
                if (a16 != null) {
                    try {
                        a16.init();
                        String u16 = a16.u();
                        CloseableKt.closeFinally(a16, null);
                        Intrinsics.checkNotNullExpressionValue(u16, "it.use {\n               \u2026                        }");
                        h.f146825d.a(new a(u16));
                        return;
                    } finally {
                    }
                } else {
                    h.f146825d.a(b.f151857a);
                    String finalPkgPath = m0.a(RFixConstants.SO_PATH, "", 1, this.f151854a, 999);
                    com.tencent.luggage.wxa.cp.x.c(finalPkgPath);
                    com.tencent.luggage.wxa.h6.e eVar = com.tencent.luggage.wxa.h6.e.f126875a;
                    String str2 = this.f151855b;
                    Intrinsics.checkNotNullExpressionValue(finalPkgPath, "finalPkgPath");
                    com.tencent.luggage.wxa.h6.e.a(eVar, str2, finalPkgPath, null, 4, null);
                    try {
                        str = com.tencent.mm.plugin.appbrand.appcache.a.b(finalPkgPath);
                    } catch (IOException unused) {
                        str = null;
                    }
                    if (StringUtils.equals(str, this.f151854a)) {
                        h0 h0Var = new h0();
                        String str3 = this.f151854a;
                        h0Var.f138305b = "@LibraryAppId";
                        h0Var.f138319p = 999;
                        h0Var.f138307d = 1;
                        h0Var.f138309f = str3;
                        h0Var.f138311h = str3;
                        h0Var.f138315l = finalPkgPath;
                        l0 l0Var = (l0) com.tencent.luggage.wxa.c6.b.a(l0.class);
                        if (l0Var != null) {
                            l0Var.c(h0Var);
                        }
                        WxaCommLibFileReader wxaCommLibFileReader = new WxaCommLibFileReader(finalPkgPath, 0, this.f151854a);
                        try {
                            wxaCommLibFileReader.init();
                            String u17 = wxaCommLibFileReader.u();
                            CloseableKt.closeFinally(wxaCommLibFileReader, null);
                            Intrinsics.checkNotNullExpressionValue(u17, "WxaCommLibFileReader(fin\u2026                        }");
                            h.f146825d.a(new c(u17));
                        } finally {
                        }
                    } else {
                        h.f146825d.a(RunnableC7052d.f151859a);
                    }
                    return;
                }
            } finally {
            }
            WxaCommLibVersionChecker.f151847g = null;
        }
    }

    @Override // com.tencent.luggage.wxa.q7.a0
    public void b() {
        try {
            a.f151848b.b();
        } catch (Exception e16) {
            w.b(h(), "doCheck get exception:" + e16);
        }
    }

    @Override // com.tencent.luggage.wxa.q7.a0
    public String h() {
        return f151846f;
    }

    public final void a(String reason, String url, String md5) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        w.d(h(), "saveTestCommLibInfo, reason:" + reason + ", url:" + url + ", md5:" + md5);
        l0 l0Var = (l0) com.tencent.luggage.wxa.c6.b.a(l0.class);
        if (l0Var != null) {
            if (l0Var.a("@LibraryAppId", 999, url, md5, w0.d(), w0.d() + 7200)) {
                Future future = f151847g;
                if (future != null) {
                    future.cancel(true);
                }
                a(md5, url);
                return;
            }
            if (f151847g == null) {
                a(md5, url);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.q7.a0
    public void b(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        super.b(application);
        l.f136139a.b(new c());
        final com.tencent.luggage.wxa.z8.b bVar = com.tencent.luggage.wxa.z8.b.f146383a;
        new IListener<g>(bVar) { // from class: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibVersionChecker$onInstalled$2
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(g event) {
                Intrinsics.checkNotNullParameter(event, "event");
                WxaCommLibVersionChecker.f151845e.a(event.e(), event.f(), event.d());
                return true;
            }
        }.alive();
    }

    public static final void a(String str, String str2) {
        f151847g = h.f146825d.d(new d(str, str2));
    }

    public final void a(int i3, z7 z7Var) {
        if (z7Var != null) {
            String h16 = h();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateByLaunchWxaApp, reqVersion:");
            sb5.append(i3);
            sb5.append(", respVersion:");
            sb5.append(z7Var.f129138g);
            sb5.append(", force_update:");
            int i16 = 1;
            sb5.append(z7Var.f129139h > 0);
            sb5.append(", rely_update:");
            sb5.append(z7Var.f129141j);
            sb5.append(", need_update:");
            sb5.append(z7Var);
            sb5.append(".need_update");
            w.d(h16, sb5.toString());
            ce ceVar = new ce();
            ceVar.f127420e = z7Var.f129136e;
            ceVar.f127421f = z7Var.f129137f;
            ceVar.f127422g = z7Var.f129138g;
            ceVar.f127424i = z7Var.f129139h;
            if (!z7Var.f129135d && !z7Var.f129141j) {
                i16 = 0;
            }
            ceVar.f127425j = i16;
            ceVar.f127426k = z7Var.f129140i;
            a(ceVar);
        }
    }

    public final void a(ce resp) {
        Intrinsics.checkNotNullParameter(resp, "resp");
        l0 l0Var = (l0) com.tencent.luggage.wxa.c6.b.a(l0.class);
        if (l0Var == null) {
            w.b(h(), "CgiGetPublicInfo fail, wxaPkgStorage is null");
            return;
        }
        boolean a16 = l0Var.a(resp, (com.tencent.luggage.wxa.dn.c) null);
        w.d(h(), "updateByNewXml get resp: version:" + resp.f127422g + ", md5:" + resp.f127421f + ",  url:" + resp.f127420e + ", patch_url:" + resp.f127426k + ", dbUpdated:" + a16);
        h0 a17 = l0Var.a("@LibraryAppId", resp.f127422g, 0, new String[0]);
        if (a17 != null) {
            b.f151852a.a(a17);
        }
    }
}
