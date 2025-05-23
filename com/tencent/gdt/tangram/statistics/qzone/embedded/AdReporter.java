package com.tencent.gdt.tangram.statistics.qzone.embedded;

import am0.b;
import am0.c;
import android.net.http.Headers;
import android.text.TextUtils;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.gdt.tangram.net.qzone.embedded.msf.AdMSFSessionManager;
import java.net.HttpURLConnection;
import java.net.URL;
import wl0.d;
import yl0.a;
import yl0.e;
import yl0.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public class AdReporter {

    /* renamed from: a, reason: collision with root package name */
    private static d f108437a;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static class EffectCgiRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f108438d;

        /* renamed from: e, reason: collision with root package name */
        boolean f108439e;

        public EffectCgiRunnable(String str, String str2, String str3) {
            this.f108438d = str;
            if (str != null) {
                if (!TextUtils.isEmpty(str2)) {
                    this.f108438d = this.f108438d.replaceAll("__CLICK_ID__", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.f108438d = this.f108438d.replaceAll("__ACTION_ID__", str3);
                }
            }
            com.tencent.gdt.tangram.ad.qzone.d.b("GDT_CGI_EFFECT_REPORT", this.f108438d);
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb5;
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.f108438d).openConnection();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "Keep-Alive");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    this.f108439e = true;
                }
                httpURLConnection.disconnect();
                sb5 = new StringBuilder();
            } catch (Throwable unused2) {
                httpURLConnection2 = httpURLConnection;
                try {
                    com.tencent.gdt.tangram.ad.qzone.d.b("AdReporter", String.format("run %s", this.f108438d));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    sb5 = new StringBuilder();
                    sb5.append("is success ? ");
                    sb5.append(this.f108439e);
                    com.tencent.gdt.tangram.ad.qzone.d.b("AdReporter", sb5.toString());
                } catch (Throwable th5) {
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    com.tencent.gdt.tangram.ad.qzone.d.b("AdReporter", "is success ? " + this.f108439e);
                    throw th5;
                }
            }
            sb5.append("is success ? ");
            sb5.append(this.f108439e);
            com.tencent.gdt.tangram.ad.qzone.d.b("AdReporter", sb5.toString());
        }
    }

    private static d a() {
        if (f108437a == null) {
            synchronized (AdReporter.class) {
                if (f108437a == null) {
                    f108437a = new AdMSFSessionManager();
                }
            }
        }
        return f108437a;
    }

    public static void b(b bVar) {
        com.tencent.gdt.tangram.ad.qzone.d.b("AdReporter", "send reportAsyncEvent request data");
        a().s(new c(bVar).b(), null);
    }

    public static String c(a aVar) {
        a().s(new yl0.b(aVar).b(), null);
        com.tencent.gdt.tangram.ad.qzone.d.b("AdReporter", "send reportClickEvent request data");
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    public static void d(String str, String str2, String str3) {
        GdtFeedUtilForQZone.z(new EffectCgiRunnable(str, str2, str3));
        com.tencent.gdt.tangram.ad.qzone.d.b("GDT_CGI_EFFECT_REPORT", str3);
    }

    public static void e(BusinessFeedData businessFeedData, e eVar) {
        wl0.a b16 = new f(eVar).b();
        com.tencent.gdt.tangram.ad.qzone.d.b("AdReporter", "send reportImpressionEvent request data");
        a().s(b16, null);
    }
}
